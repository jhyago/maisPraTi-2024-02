-- Criação da tabela Professor com a chave primária professor_id
CREATE TABLE escolainformatica.Professor (
    professor_id INTEGER NOT NULL,      -- ID único do professor
    cpf VARCHAR NOT NULL,               -- CPF do professor (obrigatório)
    nome VARCHAR NOT NULL,              -- Nome do professor (obrigatório)
    data_nascimento DATE NOT NULL,      -- Data de nascimento do professor
    titulacao VARCHAR NOT NULL,         -- Titulação acadêmica do professor
    CONSTRAINT professor_pk PRIMARY KEY (professor_id) -- Definição da chave primária
);

-- Criação da tabela Telefone com a chave primária telefone_id
CREATE TABLE escolainformatica.Telefone (
    telefone_id INTEGER NOT NULL,       -- ID único do telefone
    professor_id INTEGER NOT NULL,      -- Relacionamento com o professor
    telefone VARCHAR NOT NULL,          -- Número de telefone
    CONSTRAINT telefone_pk PRIMARY KEY (telefone_id) -- Chave primária
);

-- Criação de uma sequência para gerar valores automáticos para curso_id
CREATE SEQUENCE escolainformatica.curso_curso_id_seq_1;

-- Criação da tabela Curso com curso_id gerado automaticamente
CREATE TABLE escolainformatica.Curso (
    curso_id INTEGER NOT NULL DEFAULT nextval('escolainformatica.curso_curso_id_seq_1'), 
                                          -- ID único do curso com valor padrão da sequência
    nome VARCHAR NOT NULL,               -- Nome do curso
    CONSTRAINT curso_pk PRIMARY KEY (curso_id) -- Chave primária
);

-- Vincula a sequência ao campo curso_id da tabela Curso
ALTER SEQUENCE escolainformatica.curso_curso_id_seq_1 OWNED BY escolainformatica.Curso.curso_id;

-- Criação de uma sequência para gerar valores automáticos para aluno_id
CREATE SEQUENCE escolainformatica.aluno_aluno_id_seq;

-- Criação da tabela Aluno com aluno_id gerado automaticamente
CREATE TABLE escolainformatica.Aluno (
    aluno_id INTEGER NOT NULL DEFAULT nextval('escolainformatica.aluno_aluno_id_seq'), 
                                       -- ID único do aluno com valor padrão da sequência
    nome VARCHAR NOT NULL,             -- Nome do aluno
    endereco VARCHAR NOT NULL,         -- Endereço do aluno
    telefone VARCHAR NOT NULL,         -- Telefone do aluno
    data_nascimento DATE NOT NULL,     -- Data de nascimento do aluno
    altura NUMERIC,                    -- Altura do aluno (opcional)
    peso NUMERIC,                      -- Peso do aluno (opcional)
    CONSTRAINT aluno_pk PRIMARY KEY (aluno_id) -- Chave primária
);

-- Vincula a sequência ao campo aluno_id da tabela Aluno
ALTER SEQUENCE escolainformatica.aluno_aluno_id_seq OWNED BY escolainformatica.Aluno.aluno_id;

-- Criação de uma sequência para gerar valores automáticos para turma_id
CREATE SEQUENCE escolainformatica.turma_turma_id_seq;

-- Criação da tabela Turma com turma_id gerado automaticamente
CREATE TABLE escolainformatica.Turma (
    turma_id INTEGER NOT NULL DEFAULT nextval('escolainformatica.turma_turma_id_seq'), 
                                       -- ID único da turma com valor padrão da sequência
    aluno_monitor_id INTEGER,           -- ID do aluno monitor (opcional)
    professor_id INTEGER NOT NULL,      -- ID do professor responsável pela turma
    qtde_alunos INTEGER NOT NULL,       -- Quantidade de alunos na turma
    horario TIME NOT NULL,              -- Horário das aulas
    duracao NUMERIC NOT NULL,           -- Duração da turma em horas
    data_inicial DATE NOT NULL,         -- Data de início da turma
    data_final DATE NOT NULL,           -- Data final da turma
    CONSTRAINT turma_pk PRIMARY KEY (turma_id) -- Chave primária
);

-- Comentário sobre o campo aluno_monitor_id
COMMENT ON COLUMN escolainformatica.Turma.aluno_monitor_id IS 'Aluno Monitor';

-- Vincula a sequência ao campo turma_id da tabela Turma
ALTER SEQUENCE escolainformatica.turma_turma_id_seq OWNED BY escolainformatica.Turma.turma_id;

-- Criação da tabela intermediária Turma_Curso com chave primária turma_curso_id
CREATE TABLE escolainformatica.Turma_Curso (
    turma_curso_id INTEGER NOT NULL,    -- ID único da relação Turma-Curso
    curso_id INTEGER NOT NULL,          -- ID do curso
    turma_id INTEGER NOT NULL,          -- ID da turma
    CONSTRAINT turma_curso_pk PRIMARY KEY (turma_curso_id) -- Chave primária
);

-- Criação de uma sequência para gerar valores automáticos para matricula_id
CREATE SEQUENCE escolainformatica.matricula_matricula_id_seq;

-- Criação da tabela Matricula com matricula_id gerado automaticamente
CREATE TABLE escolainformatica.Matricula (
    matricula_id INTEGER NOT NULL DEFAULT nextval('escolainformatica.matricula_matricula_id_seq'), 
                                           -- ID único da matrícula
    data_matricula DATE NOT NULL,           -- Data de realização da matrícula
    turma_id INTEGER NOT NULL,              -- ID da turma
    aluno_id INTEGER NOT NULL,              -- ID do aluno
    CONSTRAINT matricula_pk PRIMARY KEY (matricula_id) -- Chave primária
);

-- Vincula a sequência ao campo matricula_id da tabela Matricula
ALTER SEQUENCE escolainformatica.matricula_matricula_id_seq OWNED BY escolainformatica.Matricula.matricula_id;

-- Criação de uma sequência para gerar valores automáticos para ausencia_id
CREATE SEQUENCE escolainformatica.ausencia_ausencia_id_seq;

-- Criação da tabela Ausencia com ausencia_id gerado automaticamente
CREATE TABLE escolainformatica.Ausencia (
    ausencia_id INTEGER NOT NULL DEFAULT nextval('escolainformatica.ausencia_ausencia_id_seq'), 
                                         -- ID único da ausência
    matricula_id INTEGER NOT NULL,       -- ID da matrícula relacionada à ausência
    data DATE NOT NULL,                  -- Data da ausência
    CONSTRAINT ausencia_pk PRIMARY KEY (ausencia_id) -- Chave primária
);

-- Vincula a sequência ao campo ausencia_id da tabela Ausencia
ALTER SEQUENCE escolainformatica.ausencia_ausencia_id_seq OWNED BY escolainformatica.Ausencia.ausencia_id;

-- Criação de chaves estrangeiras para manter integridade referencial
-- Relação entre Turma e Professor
ALTER TABLE escolainformatica.Turma ADD CONSTRAINT professor_turma_fk
FOREIGN KEY (professor_id)
REFERENCES escolainformatica.Professor (professor_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Telefone e Professor
ALTER TABLE escolainformatica.Telefone ADD CONSTRAINT professor_telefone_fk
FOREIGN KEY (professor_id)
REFERENCES escolainformatica.Professor (professor_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Turma_Curso e Curso
ALTER TABLE escolainformatica.Turma_Curso ADD CONSTRAINT curso_turma_curso_fk
FOREIGN KEY (curso_id)
REFERENCES escolainformatica.Curso (curso_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Matricula e Aluno
ALTER TABLE escolainformatica.Matricula ADD CONSTRAINT aluno_aluno_turma_fk
FOREIGN KEY (aluno_id)
REFERENCES escolainformatica.Aluno (aluno_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Turma e Aluno (monitor)
ALTER TABLE escolainformatica.Turma ADD CONSTRAINT aluno_turma_fk
FOREIGN KEY (aluno_monitor_id)
REFERENCES escolainformatica.Aluno (aluno_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Matricula e Turma
ALTER TABLE escolainformatica.Matricula ADD CONSTRAINT turma_aluno_turma_fk
FOREIGN KEY (turma_id)
REFERENCES escolainformatica.Turma (turma_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Turma_Curso e Turma
ALTER TABLE escolainformatica.Turma_Curso ADD CONSTRAINT turma_turma_curso_fk
FOREIGN KEY (turma_id)
REFERENCES escolainformatica.Turma (turma_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Relação entre Ausencia e Matricula
ALTER TABLE escolainformatica.Ausencia ADD CONSTRAINT matricula_ausencia_fk
FOREIGN KEY (matricula_id)
REFERENCES escolainformatica.Matricula (matricula_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


