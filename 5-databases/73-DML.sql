-- Curso
insert into curso 
          ( nome )
     values
          ( 'Banco de Dados');
-- Aluno         
insert into aluno 
          ( nome, data_nascimento, endereco, telefone)
     values
          ( 'Dick Vigarista', '1970-08-01', 'Rua Não Sei', '999999999'), 
          ( 'Medinho', '1971-05-01', 'Rua Talvez', '88888888'),
          ( 'Penélope Charmosa', '1973-09-01', 'Rua ABC', '66666666');
-- Professor
insert into professor 
          ( professor_id, nome, cpf, data_nascimento, titulacao)
     values
          ( 1, 'Siclano', '12342143214', '1960-10-13', 'Bacharel Informática'), 
          ( 2, 'Beltrano', '57834905546', '1963-11-18', 'Mestre em Computação'),
          ( 3, 'Fulano', '85940376834', '1969-10-15', 'Especialista em Web');
-- Turma 
insert into turma 
          ( professor_id, aluno_monitor_id, qtde_alunos, 
            horario, duracao, data_inicial, data_final )
     values
          ( 1, 1, 30, '09:00', 3, '2020-05-01', '2020-06-30'), 
          ( 2, 2, 20, '10:00', 2, '2020-05-15', '2020-07-15');
-- Matricula 
insert into matricula 
          ( turma_id, aluno_id, data_matricula)
     values
          ( 1, 1, '2020-04-20'), (1, 2, '2020-04-17'), (1, 3, '2020-04-25'), 
          ( 2, 2, '2020-05-10');
-- Turma_Curso
insert into turma_curso 
          ( turma_curso_id, turma_id, curso_id )
     values 
          ( 1, 1, 1), (2, 2, 1);          
-- Ausencia 
insert into ausencia 
          ( matricula_id, data)
     values
          ( 1, '2020-05-01');
         
          