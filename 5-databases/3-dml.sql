-- ===============================================================
-- EXEMPLOS DE COMANDOS DML PARA MYSQL E POSTGRESQL (SEM SELECTS)
-- ===============================================================

-- ===============================================================
-- INSERINDO DADOS EM UMA TABELA
-- ===============================================================
-- O comando INSERT INTO é utilizado para adicionar novas linhas a uma tabela.
-- Vamos inserir dados na tabela "clientes" criada anteriormente.

-- Exemplo para MySQL:
INSERT INTO clientes_mysql (nome, email, data_criacao)
VALUES ('João Silva', 'joao@email.com', CURRENT_TIMESTAMP);

-- Exemplo para PostgreSQL:
INSERT INTO clientes_pg (nome, email, data_criacao)
VALUES ('João Silva', 'joao@email.com', CURRENT_TIMESTAMP);


-- Inserindo várias linhas de uma vez:
-- Exemplo para MySQL:
INSERT INTO clientes_mysql (nome, email, data_criacao)
VALUES 
  ('Maria Souza', 'maria@email.com', CURRENT_TIMESTAMP),
  ('Pedro Santos', 'pedro@email.com', CURRENT_TIMESTAMP);

-- Exemplo para PostgreSQL:
INSERT INTO clientes_pg (nome, email, data_criacao)
VALUES 
  ('Maria Souza', 'maria@email.com', CURRENT_TIMESTAMP),
  ('Pedro Santos', 'pedro@email.com', CURRENT_TIMESTAMP);


-- ===============================================================
-- ATUALIZANDO DADOS EM UMA TABELA
-- ===============================================================
-- O comando UPDATE é utilizado para modificar valores existentes em uma tabela.
-- Vamos atualizar o email de um cliente com base no seu nome.

-- Exemplo para MySQL:
UPDATE clientes_mysql
SET email = 'joao_novo@email.com'
WHERE nome = 'João Silva';

-- Exemplo para PostgreSQL:
UPDATE clientes_pg
SET email = 'joao_novo@email.com'
WHERE nome = 'João Silva';

-- Atualizando múltiplas colunas:
-- Exemplo para MySQL:
UPDATE clientes_mysql
SET nome = 'João da Silva', email = 'joao.dasilva@email.com'
WHERE id = 1;

-- Exemplo para PostgreSQL:
UPDATE clientes_pg
SET nome = 'João da Silva', email = 'joao.dasilva@email.com'
WHERE id = 1;

-- Atualizando todos os registros (cuidado ao usar):
-- Exemplo para MySQL:
UPDATE clientes_mysql
SET data_criacao = CURRENT_TIMESTAMP;

-- Exemplo para PostgreSQL:
UPDATE clientes_pg
SET data_criacao = CURRENT_TIMESTAMP;


-- ===============================================================
-- EXCLUINDO DADOS DE UMA TABELA
-- ===============================================================
-- O comando DELETE é utilizado para remover linhas de uma tabela.
-- Vamos excluir um cliente com base no seu nome.

-- Exemplo para MySQL:
DELETE FROM clientes_mysql
WHERE nome = 'Pedro Santos';

-- Exemplo para PostgreSQL:
DELETE FROM clientes_pg
WHERE nome = 'Pedro Santos';

-- Excluindo com base em uma condição composta:
-- Exemplo para MySQL:
DELETE FROM clientes_mysql
WHERE nome = 'Maria Souza' AND email = 'maria@email.com';

-- Exemplo para PostgreSQL:
DELETE FROM clientes_pg
WHERE nome = 'Maria Souza' AND email = 'maria@email.com';

-- Excluindo todas as linhas de uma tabela:
-- Exemplo para MySQL:
DELETE FROM clientes_mysql;

-- Exemplo para PostgreSQL:
DELETE FROM clientes_pg;


-- ===============================================================
-- TRUNCANDO UMA TABELA (REMOVER TODOS OS DADOS)
-- ===============================================================
-- O comando TRUNCATE TABLE remove todas as linhas de uma tabela de forma mais eficiente que o DELETE.

-- Exemplo para MySQL:
TRUNCATE TABLE clientes_mysql;

-- Exemplo para PostgreSQL:
TRUNCATE TABLE clientes_pg;


-- ===============================================================
-- INSERINDO DADOS COM RETORNO AUTOMÁTICO DE ID (POSTGRESQL)
-- ===============================================================
-- No PostgreSQL, podemos inserir dados e retornar automaticamente o ID gerado.
-- Exemplo para PostgreSQL:
INSERT INTO clientes_pg (nome, email, data_criacao)
VALUES ('Ana Paula', 'ana@email.com', CURRENT_TIMESTAMP)
RETURNING id;


-- ===============================================================
-- INSERINDO DADOS COM IGNORAR DUPLICADOS (MYSQL)
-- ===============================================================
-- No MySQL, podemos usar o IGNORE para evitar erros em caso de duplicatas.
-- Exemplo para MySQL:
INSERT IGNORE INTO clientes_mysql (id, nome, email, data_criacao)
VALUES (1, 'João Silva', 'joao@email.com', CURRENT_TIMESTAMP);


-- ===============================================================
-- USANDO UPSERT (INSERIR OU ATUALIZAR)
-- ===============================================================
-- UPSERT permite inserir um novo registro ou atualizar caso ele já exista.
-- Exemplo para PostgreSQL:
INSERT INTO clientes_pg (id, nome, email, data_criacao)
VALUES (1, 'João Silva', 'joao@email.com', CURRENT_TIMESTAMP)
ON CONFLICT (id) DO UPDATE
SET nome = EXCLUDED.nome, email = EXCLUDED.email;

-- Exemplo para MySQL:
INSERT INTO clientes_mysql (id, nome, email, data_criacao)
VALUES (1, 'João Silva', 'joao@email.com', CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nome = VALUES(nome), email = VALUES(email);


-- ===============================================================
-- INSERINDO DADOS COM DEFAULT
-- ===============================================================
-- Podemos inserir registros sem especificar todas as colunas, usando valores padrão definidos na tabela.
-- Exemplo para MySQL:
INSERT INTO clientes_mysql (nome, email)
VALUES ('Carlos Lima', 'carlos@email.com');

-- Exemplo para PostgreSQL:
INSERT INTO clientes_pg (nome, email)
VALUES ('Carlos Lima', 'carlos@email.com');


-- ===============================================================
-- COMANDOS DE TRANSACAO
-- ===============================================================
-- Transações permitem agrupar várias operações DML em uma única unidade de trabalho.
-- Uma transação pode ser confirmada (COMMIT) ou desfeita (ROLLBACK).

-- Iniciando uma transação:
-- Exemplo para MySQL:
START TRANSACTION;

-- Exemplo para PostgreSQL:
BEGIN;

-- Inserindo dados dentro da transação:
INSERT INTO clientes_mysql (nome, email) VALUES ('Lucas Costa', 'lucas@email.com');
INSERT INTO clientes_pg (nome, email) VALUES ('Lucas Costa', 'lucas@email.com');

-- Confirmando a transação:
-- Exemplo para MySQL e PostgreSQL:
COMMIT;

-- Desfazendo a transação:
-- Exemplo para MySQL e PostgreSQL:
ROLLBACK;

-- ===============================================================
-- BLOQUEANDO LINHAS PARA ATUALIZAÇÃO (POSTGRESQL)
-- ===============================================================
-- O comando FOR UPDATE é usado para bloquear linhas selecionadas durante uma transação.
-- Exemplo para PostgreSQL:
BEGIN;
SELECT * FROM clientes_pg WHERE id = 1 FOR UPDATE;
UPDATE clientes_pg SET email = 'novo@email.com' WHERE id = 1;
COMMIT;