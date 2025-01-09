-- Cria uma tabela 'clientes' com as colunas id, nome, email, telefone e idade
CREATE TABLE clientes (
	id SERIAL PRIMARY KEY, -- id é uma chave primária gerada automaticamente
	nome TEXT, -- nome do cliente
	email VARCHAR(100) UNIQUE, -- email é único para cada cliente
	telefone VARCHAR(100), -- telefone do cliente
	idade INT -- idade do cliente
);

-- Remove a tabela 'clientes' caso ela exista
DROP TABLE clientes;

-- Cria ou substitui uma procedure chamada 'inserir_cliente'
CREATE OR REPLACE PROCEDURE inserir_cliente(
	p_nome VARCHAR, -- Parâmetro de entrada para o nome
	p_email VARCHAR, -- Parâmetro de entrada para o email
	p_idade INT -- Parâmetro de entrada para a idade
)
LANGUAGE plpgsql -- Define a linguagem da procedure como PL/pgSQL
AS $$
BEGIN
	-- Insere um novo cliente na tabela 'clientes'
	INSERT INTO clientes(nome, email, idade)
	VALUES(p_nome, p_email, p_idade);
END;
$$;

-- Chama a procedure 'inserir_cliente' para inserir um cliente chamado João
CALL inserir_cliente('João', 'joao@teste.com', 10);

-- Seleciona todos os registros da tabela 'clientes'
SELECT * FROM clientes;

-- Cria ou substitui uma procedure chamada 'atualizar_idade'
CREATE OR REPLACE PROCEDURE atualizar_idade()
LANGUAGE plpgsql
AS $$
DECLARE r RECORD; -- Declara uma variável de tipo registro
BEGIN
	-- Percorre todos os registros da tabela 'clientes'
	FOR r IN SELECT id, idade FROM clientes LOOP
		-- Verifica se a idade do cliente é menor que 18
		IF r.idade < 18 THEN
			-- Atualiza a idade para 18 caso seja menor
			UPDATE clientes
			SET idade = 18
			WHERE id = r.id;
		END IF;
	END LOOP;
END;
$$;

-- Chama a procedure 'atualizar_idade' para atualizar as idades dos clientes
CALL atualizar_idade();

-- Cria ou substitui uma procedure chamada 'buscar_cliente'
CREATE OR REPLACE PROCEDURE buscar_cliente(p_id INT)
LANGUAGE plpgsql
AS $$
DECLARE
	r RECORD; -- Declara uma variável do tipo registro para armazenar o resultado da consulta
BEGIN
	-- Seleciona o cliente com o ID especificado
	SELECT id, nome, idade INTO r FROM clientes
	WHERE id = p_id;

	-- Verifica se o cliente foi encontrado
	IF r.id IS NOT NULL THEN
		RAISE NOTICE 'Cliente encontrado: ID: %, Nome: %, idade: %', r.id, r.nome, r.idade;
	ELSE
		RAISE NOTICE 'Cliente com ID % não encontrado.', p_id;
	END IF;
END;
$$;

-- Chama a procedure 'buscar_cliente' para buscar o cliente com ID 1
CALL buscar_cliente(1);

-- Cria ou substitui uma procedure chamada 'total_clientes1'
CREATE OR REPLACE PROCEDURE total_clientes1()
LANGUAGE plpgsql
AS $$
DECLARE total INT; -- Declara uma variável para armazenar o total de clientes
BEGIN
	-- Conta o número total de clientes
	SELECT COUNT(*) INTO total FROM clientes;
	RETURN total; -- Retorna o total de clientes
END;
$$;

-- Chama a procedure 'total_clientes1' para contar o total de clientes
SELECT total_clientes1();

-- Cria uma procedure que tenta inserir um cliente e captura erros caso o email já exista
CREATE OR REPLACE PROCEDURE inserir_cliente(
    p_nome VARCHAR, 
    p_email VARCHAR, 
    p_telefone VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Tenta inserir um novo cliente na tabela 'clientes'
    INSERT INTO clientes (nome, email, telefone)
    VALUES (p_nome, p_email, p_telefone);
EXCEPTION
    -- Captura a exceção de violação de unicidade e exibe uma mensagem de erro
    WHEN unique_violation THEN
        RAISE NOTICE 'Erro: O email "%" já está cadastrado.', p_email;
END;
$$;

-- Chama a procedure 'inserir_cliente' para inserir um cliente
CALL inserir_cliente('Jake Harper', 'jake.peralta@examplo.com', '5553999971344');

-- Seleciona todos os registros da tabela 'clientes'
SELECT * FROM clientes;

-- Cria uma tabela 'historico_clientes' para armazenar o histórico de modificações nos clientes
CREATE TABLE historico_clientes (
	id SERIAL PRIMARY KEY, -- Chave primária gerada automaticamente
	cliente_id INT, -- ID do cliente modificado
	nome_antigo TEXT, -- Nome antigo do cliente
	nome_novo TEXT, -- Novo nome do cliente
	data_modificacao TIMESTAMP DEFAULT current_timestamp -- Data da modificação com valor padrão como timestamp atual
);

-- Cria ou substitui uma função para auditar atualizações na tabela 'clientes'
CREATE OR REPLACE FUNCTION auditar_atualizacao_clientes()
RETURNS trigger AS $$
BEGIN
	-- Insere um registro no histórico de clientes sempre que houver uma atualização
	INSERT INTO historico_clientes(cliente_id, nome_antigo, nome_novo)
	VALUES (OLD.id, OLD.nome, NEW.nome);
	RETURN NEW; -- Retorna o novo registro atualizado
END;
$$ LANGUAGE plpgsql;

-- Cria um trigger que executa a função de auditoria após cada atualização na tabela 'clientes'
CREATE TRIGGER trigger_auditoria_clientes
AFTER UPDATE
ON clientes
FOR EACH ROW
EXECUTE FUNCTION auditar_atualizacao_clientes();

-- Seleciona todos os registros da tabela 'clientes'
SELECT * FROM clientes;

-- Atualiza o nome do cliente com ID 1 para 'Geromel'
UPDATE clientes SET nome = 'Geromel' WHERE id = 1;

-- Seleciona todos os registros da tabela 'historico_clientes'
SELECT * FROM historico_clientes;

-- Cria uma tabela 'produtos' com as colunas id, nome e quantidade
CREATE TABLE produtos(
	id SERIAL PRIMARY KEY, -- Chave primária gerada automaticamente
	nome TEXT NOT NULL, -- Nome do produto (obrigatório)
	quantidade INT NOT NULL -- Quantidade do produto em estoque (obrigatória)
);

-- Insere alguns produtos na tabela 'produtos'
INSERT INTO produtos (nome, quantidade)
VALUES('Bicicleta', 10);

INSERT INTO produtos (nome, quantidade)
VALUES('Microfone', 5);

INSERT INTO produtos (nome, quantidade)
VALUES('Caneleiras', 12);

-- Cria uma tabela 'auditoria_estoque' para armazenar o histórico de alterações no estoque
CREATE TABLE auditoria_estoque(
	id SERIAL PRIMARY KEY, -- Chave primária gerada automaticamente
	produto_id INT NOT NULL, -- ID do produto modificado
	quantidade_antiga INT NOT NULL, -- Quantidade antiga do produto
	quantidade_nova INT NOT NULL, -- Nova quantidade do produto
	data_alteracao TIMESTAMP DEFAULT current_timestamp -- Data da alteração com valor padrão como timestamp atual
);

-- Cria ou substitui uma função para registrar a auditoria de estoque
CREATE OR REPLACE FUNCTION registrar_auditoria_estoque()
RETURNS trigger AS $$
BEGIN 
	-- Insere um registro na tabela 'auditoria_estoque' após cada atualização no estoque
	INSERT INTO auditoria_estoque(produto_id, quantidade_antiga, quantidade_nova)
	VALUES(OLD.id, OLD.quantidade, NEW.quantidade);
	RETURN NEW; -- Retorna o novo registro atualizado
END;
$$ LANGUAGE plpgsql;

-- Cria um trigger que executa a função de auditoria após cada atualização na tabela 'produtos'
CREATE TRIGGER trigger_auditoria_estoque
AFTER UPDATE ON produtos
FOR EACH ROW
EXECUTE FUNCTION registrar_auditoria_estoque();

-- Seleciona todos os registros da tabela 'produtos'
SELECT * FROM produtos;

-- Atualiza a quantidade do produto com ID 1 para 15
UPDATE produtos SET quantidade = 15 WHERE id = 1;

-- Seleciona todos os registros da tabela 'auditoria_estoque'
SELECT * FROM auditoria_estoque;