-- ===============================================================
-- EXEMPLOS DE COMANDOS DDL PARA MYSQL E POSTGRESQL
-- ===============================================================

-- ===============================================================
-- TIPOS DE DADOS COMUNS EM MYSQL E POSTGRESQL
-- ===============================================================
-- 
-- MySQL:
-- 1. Tipos Numéricos:
--    INT, BIGINT, SMALLINT, TINYINT, DECIMAL, FLOAT, DOUBLE
-- 2. Tipos de Texto:
--    CHAR, VARCHAR, TEXT, ENUM
-- 3. Tipos de Data e Hora:
--    DATE, DATETIME, TIMESTAMP, TIME, YEAR
-- 4. Tipos Lógicos:
--    BOOLEAN (representado como TINYINT em MySQL)
--
-- PostgreSQL:
-- 1. Tipos Numéricos:
--    SMALLINT, INTEGER, BIGINT, NUMERIC, REAL, DOUBLE PRECISION
-- 2. Tipos de Texto:
--    CHAR, VARCHAR, TEXT
-- 3. Tipos de Data e Hora:
--    DATE, TIMESTAMP, TIME, INTERVAL
-- 4. Tipos Lógicos:
--    BOOLEAN (representa valores TRUE e FALSE diretamente)


-- ===============================================================
-- CRIANDO UMA TABELA SIMPLES EM MYSQL E POSTGRESQL
-- ===============================================================
-- O comando CREATE TABLE cria uma nova tabela no banco de dados.
-- Vamos criar uma tabela chamada "clientes" com colunas que armazenam
-- informações básicas de um cliente, como id, nome, email e data de criação.

-- Exemplo para MySQL:
CREATE TABLE clientes_mysql (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- id único para cada cliente (chave primária)
    nome VARCHAR(100) NOT NULL,          -- nome do cliente, campo obrigatório
    email VARCHAR(100) UNIQUE,           -- email único para cada cliente
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- data de criação automática
);

-- Exemplo para PostgreSQL:
CREATE TABLE clientes_pg (
    id SERIAL PRIMARY KEY,               -- id único gerado automaticamente (chave primária)
    nome VARCHAR(100) NOT NULL,          -- nome do cliente, campo obrigatório
    email VARCHAR(100) UNIQUE,           -- email único para cada cliente
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- data de criação automática
);


-- ===============================================================
-- ALTERANDO UMA TABELA EXISTENTE
-- ===============================================================
-- O comando ALTER TABLE é usado para modificar a estrutura de uma tabela.
-- Vamos adicionar uma nova coluna chamada "telefone" à tabela "clientes".

-- Exemplo para MySQL:
ALTER TABLE clientes_mysql ADD COLUMN telefone VARCHAR(15);

-- Exemplo para PostgreSQL:
ALTER TABLE clientes_pg ADD COLUMN telefone VARCHAR(15);

-- ===============================================================
-- MODIFICANDO O TIPO DE UMA COLUNA EXISTENTE
-- ===============================================================
-- Podemos alterar o tipo de dados de uma coluna já criada usando o comando ALTER TABLE.
-- Vamos modificar o tipo da coluna "telefone" para VARCHAR(20).

-- Exemplo para MySQL:
ALTER TABLE clientes_mysql MODIFY COLUMN telefone VARCHAR(20);

-- Exemplo para PostgreSQL:
ALTER TABLE clientes_pg ALTER COLUMN telefone TYPE VARCHAR(20);

-- ===============================================================
-- RENOMEANDO UMA COLUNA EXISTENTE
-- ===============================================================
-- O comando ALTER TABLE também permite renomear colunas existentes.
-- Vamos renomear a coluna "telefone" para "celular".

-- Exemplo para MySQL:
ALTER TABLE clientes_mysql CHANGE COLUMN telefone celular VARCHAR(20);

-- Exemplo para PostgreSQL:
ALTER TABLE clientes_pg RENAME COLUMN telefone TO celular;

-- ===============================================================
-- EXCLUINDO UMA COLUNA EXISTENTE
-- ===============================================================
-- O comando ALTER TABLE DROP COLUMN permite excluir uma coluna de uma tabela.
-- Vamos excluir a coluna "celular" das tabelas.

-- Exemplo para MySQL:
ALTER TABLE clientes_mysql DROP COLUMN celular;

-- Exemplo para PostgreSQL:
ALTER TABLE clientes_pg DROP COLUMN celular;

-- ===============================================================
-- CRIANDO UMA CHAVE ESTRANGEIRA (FOREIGN KEY)
-- ===============================================================
-- O comando CREATE TABLE pode incluir chaves estrangeiras para manter a integridade referencial.
-- Vamos criar uma tabela "pedidos" que faz referência à tabela "clientes".

-- Exemplo para MySQL:
CREATE TABLE pedidos_mysql (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- id único do pedido
    cliente_id INT,                      -- id do cliente (chave estrangeira)
    valor DECIMAL(10, 2),                -- valor do pedido
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- data do pedido
    FOREIGN KEY (cliente_id) REFERENCES clientes_mysql(id) ON DELETE CASCADE -- chave estrangeira com exclusão em cascata
);

-- Exemplo para PostgreSQL:
CREATE TABLE pedidos_pg (
    id SERIAL PRIMARY KEY,               -- id único do pedido
    cliente_id INT,                      -- id do cliente (chave estrangeira)
    valor NUMERIC(10, 2),                -- valor do pedido
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- data do pedido
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes_pg(id) ON DELETE CASCADE -- chave estrangeira com exclusão em cascata
);

-- ===============================================================
-- CRIANDO UM ÍNDICE EM UMA COLUNA
-- ===============================================================
-- O comando CREATE INDEX é usado para criar índices que aceleram a busca por valores em colunas.
-- Vamos criar um índice na coluna "email" da tabela "clientes".

-- Exemplo para MySQL:
CREATE INDEX idx_email_mysql ON clientes_mysql(email);

-- Exemplo para PostgreSQL:
CREATE INDEX idx_email_pg ON clientes_pg(email);

-- ===============================================================
-- EXCLUINDO UMA TABELA
-- ===============================================================
-- O comando DROP TABLE é usado para excluir uma tabela do banco de dados.
-- Vamos excluir as tabelas "pedidos" criadas anteriormente.

-- Exemplo para MySQL:
DROP TABLE IF EXISTS pedidos_mysql;

-- Exemplo para PostgreSQL:
DROP TABLE IF EXISTS pedidos_pg;

-- ===============================================================
-- RENOMEANDO UMA TABELA EXISTENTE
-- ===============================================================
-- O comando ALTER TABLE ou RENAME TABLE pode ser usado para renomear tabelas.
-- Vamos renomear a tabela "clientes" para "clientes_arquivados".

-- Exemplo para MySQL:
RENAME TABLE clientes_mysql TO clientes_arquivados_mysql;

-- Exemplo para PostgreSQL:
ALTER TABLE clientes_pg RENAME TO clientes_arquivados_pg;

-- ===============================================================
-- ADICIONANDO UMA CONSTRAINT DE NOT NULL
-- ===============================================================
-- Podemos adicionar uma restrição para que uma coluna não permita valores nulos.
-- Vamos adicionar a restrição NOT NULL à coluna "valor" da tabela "pedidos".

-- Exemplo para MySQL:
ALTER TABLE pedidos_mysql MODIFY COLUMN valor DECIMAL(10, 2) NOT NULL;

-- Exemplo para PostgreSQL:
ALTER TABLE pedidos_pg ALTER COLUMN valor SET NOT NULL;

-- ===============================================================
-- REMOVENDO UMA CONSTRAINT DE NOT NULL
-- ===============================================================
-- Se quisermos permitir valores nulos em uma coluna, podemos remover a restrição NOT NULL.
-- Vamos remover a restrição NOT NULL da coluna "valor" da tabela "pedidos".

-- Exemplo para MySQL:
ALTER TABLE pedidos_mysql MODIFY COLUMN valor DECIMAL(10, 2) NULL;

-- Exemplo para PostgreSQL:
ALTER TABLE pedidos_pg ALTER COLUMN valor DROP NOT NULL;

-- ===============================================================
-- ADICIONANDO UMA CONSTRAINT DE CHECK
-- ===============================================================
-- O comando CHECK permite definir uma regra que os valores de uma coluna devem obedecer.
-- Vamos adicionar uma restrição CHECK para que o "valor" dos pedidos seja sempre positivo.

-- Exemplo para MySQL:
ALTER TABLE pedidos_mysql ADD CONSTRAINT chk_valor CHECK (valor > 0);

-- Exemplo para PostgreSQL:
ALTER TABLE pedidos_pg ADD CONSTRAINT chk_valor CHECK (valor > 0);

-- ===============================================================
-- EXCLUINDO UMA CONSTRAINT DE CHECK
-- ===============================================================
-- Podemos excluir uma restrição CHECK utilizando o comando DROP CONSTRAINT.
-- Vamos excluir a restrição CHECK criada anteriormente.

-- Exemplo para MySQL:
ALTER TABLE pedidos_mysql DROP CHECK chk_valor;

-- Exemplo para PostgreSQL:
ALTER TABLE pedidos_pg DROP CONSTRAINT chk_valor;