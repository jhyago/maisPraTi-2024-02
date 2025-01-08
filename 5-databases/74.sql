-- Cenário: Otimizando banco de dados de uma loja online
-- Tabelas principais: products, customers, orders

-- Parte 1: Criando as tabelas e populando com dados
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10, 2)
);

INSERT INTO products (name, category, price)
SELECT
    'Product ' || i,
    CASE WHEN i % 5 = 0 THEN 'Electronics'
         WHEN i % 5 = 1 THEN 'Clothing'
         WHEN i % 5 = 2 THEN 'Books'
         WHEN i % 5 = 3 THEN 'Toys'
         ELSE 'Home'
    END,
    (random() * 100)::DECIMAL(10, 2)
FROM generate_series(1, 100000) AS i;

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    city VARCHAR(50)
);

INSERT INTO customers (name, email, city)
SELECT
    'Customer ' || i,
    'customer' || i || '@example.com',
    CASE WHEN i % 4 = 0 THEN 'New York'
         WHEN i % 4 = 1 THEN 'Los Angeles'
         WHEN i % 4 = 2 THEN 'Chicago'
         ELSE 'Houston'
    END
FROM generate_series(1, 50000) AS i;

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    product_id INT REFERENCES products(product_id),
    order_date TIMESTAMP DEFAULT now()
);

INSERT INTO orders (customer_id, product_id, order_date)
SELECT
    customer_id,
    (random() * 100000)::INT + 1,
    NOW() - (random() * interval '365 days')
FROM (
    SELECT customer_id FROM customers ORDER BY random() LIMIT 10000
) AS subquery;

-- Parte 2: Analisando o desempenho de consultas sem índices
-- Consulta 1: Buscar todos os pedidos feitos por um cliente específico
EXPLAIN ANALYZE SELECT * FROM orders WHERE customer_id = 3744;

-- Consulta 2: Buscar todos os pedidos de uma determinada categoria de produtos
EXPLAIN ANALYZE
SELECT o.*
FROM orders o
JOIN products p ON o.product_id = p.product_id
WHERE p.category = 'Electronics';

-- Consulta 3: Contar quantos pedidos foram feitos por cidade
EXPLAIN ANALYZE
SELECT c.city, COUNT(*) AS total_orders
FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
GROUP BY c.city;

-- Parte 3: Criando índices para melhorar o desempenho
-- Índice 1: Para a coluna customer_id na tabela orders
CREATE INDEX idx_orders_customer_id ON orders (customer_id);

-- Índice 2: Para a coluna category na tabela products
CREATE INDEX idx_products_category ON products (category);

-- Índice 3: Para a coluna city na tabela customers
CREATE INDEX idx_customers_city ON customers (city);

-- Reexecutando as consultas com índices
-- Consulta 1 com índice
EXPLAIN ANALYZE SELECT * FROM orders WHERE customer_id = 3744;

-- Consulta 2 com índice
EXPLAIN ANALYZE
SELECT o.*
FROM orders o
JOIN products p ON o.product_id = p.product_id
WHERE p.category = 'Electronics';

-- Consulta 3 com índice
EXPLAIN ANALYZE
SELECT c.city, COUNT(*) AS total_orders
FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
GROUP BY c.city;

-- Parte 4: Analisando índices redundantes e impacto no desempenho de escrita
-- Pergunta: O PostgreSQL permite a criação desse índice redundante? 
-- Resposta: Não, pois já existe um índice na coluna customer_id.
-- Tentando criar um índice redundante
CREATE INDEX idx_orders_customer_id_redundant ON orders (customer_id);

-- Inserindo 10.000 novos registros
INSERT INTO orders (customer_id, product_id, order_date)
SELECT
    (random() * 50000)::INT + 1,
    (random() * 100000)::INT + 1,
    NOW() - (random() * interval '30 days')
FROM generate_series(1, 10000) AS i;

-- Pergunta: Quanto tempo levou para inserir os novos registros?
-- Pergunta: O tempo de inserção aumentou significativamente após a criação dos índices? Explique por que isso aconteceu.

-- Parte 5: Criando índices parciais e baseados em expressão
-- Pergunta: Como esse índice parcial afeta o desempenho de consultas que buscam pedidos recentes?
-- Índice parcial para pedidos feitos no último ano
CREATE INDEX idx_orders_recent ON orders (order_date) WHERE order_date >= NOW() - interval '1 year';

-- Executando consulta otimizada com índice parcial
EXPLAIN ANALYZE
SELECT * FROM orders WHERE order_date >= NOW() - interval '1 year';

-- Pergunta: Como o índice baseado em expressão afeta o desempenho de consultas que buscam clientes por e-mail ignorando maiúsculas e minúsculas?
-- Índice baseado em expressão para consultas por e-mail ignorando maiúsculas e minúsculas
CREATE INDEX idx_customers_lower_email ON customers (LOWER(email));

-- Executando consulta com índice baseado em expressão
EXPLAIN ANALYZE
SELECT * FROM customers WHERE LOWER(email) = 'customer1234@example.com';

-- Parte 6: Relatório Final
-- Pergunta: Qual foi o impacto dos índices no desempenho das consultas?
-- Resposta: Os índices reduziram significativamente o tempo de execução das consultas.

-- Pergunta: Quais índices foram mais úteis?
-- Resposta: idx_orders_customer_id, idx_products_category e idx_orders_recent.

-- Pergunta: Quais índices poderiam ser removidos?
-- Resposta: idx_customers_city, pois a consulta correspondente não foi tão frequente.

-- Pergunta: Como os índices impactaram o desempenho de inserções e atualizações?
-- Resposta: O tempo de inserção aumentou devido à necessidade de atualizar os índices.

-- Pergunta: O que você faria de diferente ao projetar índices para este banco de dados?
-- Resposta: Avaliar a necessidade de índices antes de criá-los e usar mais índices parciais para consultas específicas.