-- ===============================================================
-- EXEMPLOS DE COMANDOS SELECT E JOINS PARA MYSQL E POSTGRESQL
-- ===============================================================

-- ===============================================================
-- COMANDOS SELECT BÁSICOS
-- ===============================================================
-- O comando SELECT é utilizado para buscar dados em uma tabela.
-- Vamos realizar exemplos básicos de SELECT na tabela "clientes".

-- Exemplo para MySQL e PostgreSQL:
SELECT * FROM clientes_mysql;
SELECT * FROM clientes_pg;

-- Selecionando colunas específicas:
SELECT nome, email FROM clientes_mysql;
SELECT nome, email FROM clientes_pg;

-- Usando alias para colunas:
SELECT nome AS "Nome do Cliente", email AS "E-mail" FROM clientes_mysql;
SELECT nome AS "Nome do Cliente", email AS "E-mail" FROM clientes_pg;

-- Selecionando colunas calculadas:
SELECT nome, data_criacao, YEAR(CURDATE()) - YEAR(data_criacao) AS "Anos de Cadastro" FROM clientes_mysql;
SELECT nome, data_criacao, EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM data_criacao) AS "Anos de Cadastro" FROM clientes_pg;

-- ===============================================================
-- FILTRANDO RESULTADOS COM WHERE
-- ===============================================================
-- O comando WHERE é utilizado para filtrar resultados com base em condições.

-- Exemplo para MySQL e PostgreSQL:
SELECT * FROM clientes_mysql WHERE nome = 'João Silva';
SELECT * FROM clientes_pg WHERE nome = 'João Silva';

-- Usando operadores lógicos:
SELECT * FROM clientes_mysql WHERE nome = 'João Silva' AND email LIKE '%@email.com';
SELECT * FROM clientes_pg WHERE nome = 'João Silva' AND email LIKE '%@email.com';

-- Usando operador IN:
SELECT * FROM clientes_mysql WHERE nome IN ('João Silva', 'Maria Souza');
SELECT * FROM clientes_pg WHERE nome IN ('João Silva', 'Maria Souza');

-- Usando operador BETWEEN:
SELECT * FROM clientes_mysql WHERE data_criacao BETWEEN '2023-01-01' AND '2023-12-31';
SELECT * FROM clientes_pg WHERE data_criacao BETWEEN '2023-01-01' AND '2023-12-31';

-- Usando operador IS NULL:
SELECT * FROM clientes_mysql WHERE email IS NULL;
SELECT * FROM clientes_pg WHERE email IS NULL;

-- ===============================================================
-- ORDENANDO RESULTADOS COM ORDER BY
-- ===============================================================
-- O comando ORDER BY é utilizado para ordenar os resultados.

-- Exemplo para MySQL e PostgreSQL:
SELECT * FROM clientes_mysql ORDER BY nome ASC;
SELECT * FROM clientes_pg ORDER BY nome ASC;

-- Ordenando de forma decrescente:
SELECT * FROM clientes_mysql ORDER BY data_criacao DESC;
SELECT * FROM clientes_pg ORDER BY data_criacao DESC;

-- Ordenando com multiplas colunas:
SELECT * FROM clientes_mysql ORDER BY nome ASC, data_criacao DESC;
SELECT * FROM clientes_pg ORDER BY nome ASC, data_criacao DESC;

-- ===============================================================
-- LIMITANDO RESULTADOS COM LIMIT (MySQL) E LIMIT/OFFSET (PostgreSQL)
-- ===============================================================
-- Podemos limitar o número de registros retornados.

-- Exemplo para MySQL:
SELECT * FROM clientes_mysql LIMIT 5;

-- Exemplo para PostgreSQL:
SELECT * FROM clientes_pg LIMIT 5;

-- Usando OFFSET para paginar resultados (PostgreSQL):
SELECT * FROM clientes_pg LIMIT 5 OFFSET 10;

-- Usando LIMIT com OFFSET em MySQL:
SELECT * FROM clientes_mysql LIMIT 10, 5;

-- ===============================================================
-- AGREGANDO DADOS COM FUNÇÕES DE AGREGAÇÃO
-- ===============================================================
-- Podemos usar funções de agregação como COUNT, AVG, SUM, MIN e MAX.

-- Exemplo para MySQL e PostgreSQL:
SELECT COUNT(*) AS total_clientes FROM clientes_mysql;
SELECT COUNT(*) AS total_clientes FROM clientes_pg;

SELECT AVG(valor) AS valor_medio FROM pedidos_mysql;
SELECT AVG(valor) AS valor_medio FROM pedidos_pg;

SELECT SUM(valor) AS total_vendas FROM pedidos_mysql;
SELECT SUM(valor) AS total_vendas FROM pedidos_pg;

SELECT MIN(valor) AS menor_venda, MAX(valor) AS maior_venda FROM pedidos_mysql;
SELECT MIN(valor) AS menor_venda, MAX(valor) AS maior_venda FROM pedidos_pg;

-- ===============================================================
-- AGRUPANDO RESULTADOS COM GROUP BY
-- ===============================================================
-- O comando GROUP BY é utilizado para agrupar resultados com base em uma ou mais colunas.

-- Exemplo para MySQL e PostgreSQL:
SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_mysql GROUP BY cliente_id;
SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_pg GROUP BY cliente_id;

-- Agrupando e ordenando:
SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_mysql GROUP BY cliente_id ORDER BY total_pedidos DESC;
SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_pg GROUP BY cliente_id ORDER BY total_pedidos DESC;

-- ===============================================================
-- FILTRANDO GRUPOS COM HAVING
-- ===============================================================
-- O comando HAVING é utilizado para filtrar os resultados de um GROUP BY.

-- Exemplo para MySQL e PostgreSQL:
SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_mysql
GROUP BY cliente_id HAVING COUNT(*) > 5;

SELECT cliente_id, COUNT(*) AS total_pedidos FROM pedidos_pg
GROUP BY cliente_id HAVING COUNT(*) > 5;

-- ===============================================================
-- SUBCONSULTAS (SUBQUERIES)
-- ===============================================================
-- Subconsultas são consultas aninhadas dentro de outra consulta.

-- Subconsulta no SELECT:
SELECT nome, (SELECT COUNT(*) FROM pedidos_mysql WHERE cliente_id = c.id) AS total_pedidos
FROM clientes_mysql c;

SELECT nome, (SELECT COUNT(*) FROM pedidos_pg WHERE cliente_id = c.id) AS total_pedidos
FROM clientes_pg c;

-- Subconsulta no WHERE:
SELECT * FROM clientes_mysql WHERE id IN (SELECT cliente_id FROM pedidos_mysql WHERE valor > 100);
SELECT * FROM clientes_pg WHERE id IN (SELECT cliente_id FROM pedidos_pg WHERE valor > 100);

-- ===============================================================
-- USANDO JOINS PARA CONSULTAR DADOS EM MÚLTIPLAS TABELAS
-- ===============================================================
-- JOINS são utilizados para combinar dados de múltiplas tabelas com base em condições relacionadas.

-- INNER JOIN: Retorna registros que possuem correspondência em ambas as tabelas.
-- Exemplo para MySQL e PostgreSQL:
SELECT c.nome, p.valor FROM clientes_mysql c
INNER JOIN pedidos_mysql p ON c.id = p.cliente_id;

SELECT c.nome, p.valor FROM clientes_pg c
INNER JOIN pedidos_pg p ON c.id = p.cliente_id;


-- LEFT JOIN: Retorna todos os registros da tabela à esquerda, e os correspondentes da tabela à direita.
-- Exemplo para MySQL e PostgreSQL:
SELECT c.nome, p.valor FROM clientes_mysql c
LEFT JOIN pedidos_mysql p ON c.id = p.cliente_id;

SELECT c.nome, p.valor FROM clientes_pg c
LEFT JOIN pedidos_pg p ON c.id = p.cliente_id;


-- RIGHT JOIN: Retorna todos os registros da tabela à direita, e os correspondentes da tabela à esquerda.
-- Exemplo para MySQL e PostgreSQL:
SELECT c.nome, p.valor FROM clientes_mysql c
RIGHT JOIN pedidos_mysql p ON c.id = p.cliente_id;

SELECT c.nome, p.valor FROM clientes_pg c
RIGHT JOIN pedidos_pg p ON c.id = p.cliente_id;


-- FULL OUTER JOIN: Retorna todos os registros quando há correspondência em uma das tabelas.
-- Exemplo para PostgreSQL:
SELECT c.nome, p.valor FROM clientes_pg c
FULL OUTER JOIN pedidos_pg p ON c.id = p.cliente_id;

-- MySQL não suporta FULL OUTER JOIN diretamente. Podemos simular com UNION:
SELECT c.nome, p.valor FROM clientes_mysql c
LEFT JOIN pedidos_mysql p ON c.id = p.cliente_id
UNION
SELECT c.nome, p.valor FROM clientes_mysql c
RIGHT JOIN pedidos_mysql p ON c.id = p.cliente_id;


-- ===============================================================
-- JOINS COM MÚLTIPLAS TABELAS
-- ===============================================================
-- Podemos usar múltiplos JOINS para combinar dados de mais de duas tabelas.

-- Exemplo para MySQL e PostgreSQL:
SELECT c.nome, p.valor, f.nome AS "Funcionario" FROM clientes_mysql c
INNER JOIN pedidos_mysql p ON c.id = p.cliente_id
INNER JOIN funcionarios_mysql f ON p.funcionario_id = f.id;

SELECT c.nome, p.valor, f.nome AS "Funcionario" FROM clientes_pg c
INNER JOIN pedidos_pg p ON c.id = p.cliente_id
INNER JOIN funcionarios_pg f ON p.funcionario_id = f.id;

-- ===============================================================
-- JOINS AUTO-RELACIONADOS (SELF JOIN)
-- ===============================================================
-- Um SELF JOIN é um JOIN de uma tabela com ela mesma.
-- Vamos encontrar clientes que possuem o mesmo email (duplicados).

-- Exemplo para MySQL e PostgreSQL:
SELECT a.nome AS cliente1, b.nome AS cliente2, a.email FROM clientes_mysql a
INNER JOIN clientes_mysql b ON a.email = b.email AND a.id <> b.id;

SELECT a.nome AS cliente1, b.nome AS cliente2, a.email FROM clientes_pg a
INNER JOIN clientes_pg b ON a.email = b.email AND a.id <> b.id;

-- ===============================================================
-- JOINS COM FUNÇÕES DE AGREGAÇÃO
-- ===============================================================
-- Podemos combinar JOINS com funções de agregação para obter resultados consolidados.

-- Exemplo para MySQL e PostgreSQL:
SELECT c.nome, COUNT(p.id) AS total_pedidos, SUM(p.valor) AS total_gasto
FROM clientes_mysql c
INNER JOIN pedidos_mysql p ON c.id = p.cliente_id
GROUP BY c.nome;

SELECT c.nome, COUNT(p.id) AS total_pedidos, SUM(p.valor) AS total_gasto
FROM clientes_pg c
INNER JOIN pedidos_pg p ON c.id = p.cliente_id
GROUP BY c.nome;
