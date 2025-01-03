-- ===============================================================
-- EXEMPLOS DE COMANDOS DDL PARA MYSQL E POSTGRESQL
-- ===============================================================

-- ===============================================================
-- COMANDOS DE TERMINAL BÁSICOS PARA MYSQL E POSTGRESQL
-- ===============================================================
-- Abaixo estão comandos básicos para trabalhar com os bancos de dados MySQL e PostgreSQL via terminal.

-- ---------------------------------------------------------------
-- COMANDOS BÁSICOS PARA MYSQL
-- ---------------------------------------------------------------
-- 1. Conectar ao servidor MySQL:
--    mysql -u <usuario> -p
--    (Será solicitado que você insira a senha do usuário)

-- 2. Listar bancos de dados:
--    SHOW DATABASES;

-- 3. Selecionar um banco de dados:
--    USE <nome_do_banco>;

-- 4. Listar tabelas em um banco de dados:
--    SHOW TABLES;

-- 5. Exibir a estrutura de uma tabela:
--    DESCRIBE <nome_da_tabela>;

-- 6. Criar um novo banco de dados:
--    CREATE DATABASE <nome_do_banco>;

-- 7. Excluir um banco de dados:
--    DROP DATABASE <nome_do_banco>;

-- 8. Sair do cliente MySQL:
--    EXIT;


-- ---------------------------------------------------------------
-- COMANDOS BÁSICOS PARA POSTGRESQL
-- ---------------------------------------------------------------
-- 1. Conectar ao servidor PostgreSQL:
--    psql -U <usuario> -d <nome_do_banco>
--    (Será solicitado que você insira a senha do usuário)

-- 2. Listar bancos de dados:
--    \l

-- 3. Selecionar um banco de dados:
--    \c <nome_do_banco>

-- 4. Listar tabelas em um banco de dados:
--    \dt

-- 5. Exibir a estrutura de uma tabela:
--    \d <nome_da_tabela>

-- 6. Criar um novo banco de dados:
--    CREATE DATABASE <nome_do_banco>;

-- 7. Excluir um banco de dados:
--    DROP DATABASE <nome_do_banco>;

-- 8. Sair do cliente PostgreSQL:
--    \q