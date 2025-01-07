-- Query 4.1: Listar todos os alunos com seus respectivos telefones ordenados por nome
-- A lógica aqui é simples: queremos listar todos os alunos e ordenar o resultado pelo nome.
select a.aluno_id, a.nome, a.telefone
  from aluno a 
 order by 2; -- Ordena o resultado pela segunda coluna (nome)

-- Query 4.2: Listar alunos, turmas e detalhes das turmas em que estão matriculados
-- Neste caso, queremos combinar as tabelas aluno, matricula e turma para trazer as informações completas de cada aluno e a respectiva turma.

-- Usando join implícito (estilo mais antigo)
select a.aluno_id, a.nome, t.turma_id, 
       t.data_inicial, t.data_final, t.horario 
  from aluno a, 
       matricula m, 
       turma t 
 where m.aluno_id = a.aluno_id 
   and t.turma_id = m.turma_id; 

-- Usando inner join explícito (preferível por ser mais legível e moderno)
-- A lógica aqui é a mesma: unir as tabelas aluno, matricula e turma para exibir as informações relevantes.
select a.aluno_id, a.nome, t.turma_id, 
       t.data_inicial, t.data_final, t.horario 
  from aluno a inner join matricula m 
                       on (m.aluno_id = a.aluno_id)
               inner join turma t
                       on (t.turma_id = m.turma_id);

-- Invertendo a ordem das tabelas no inner join
-- O resultado é idêntico, mas a ordem das tabelas foi alterada.
select a.aluno_id, a.nome, t.turma_id, 
       t.data_inicial, t.data_final, t.horario 
  from matricula m inner join turma t
                           on (t.turma_id = m.turma_id)
                   inner join aluno a   
                           on (m.aluno_id = a.aluno_id);

-- Query 4.3: Encontrar alunos que não possuem ausências registradas
-- Queremos listar apenas os alunos que não possuem ausências registradas. Usamos um LEFT JOIN entre matricula e ausencia e verificamos se o campo ausencia_id é nulo.
select distinct a.aluno_id, a.nome
  from aluno a inner join matricula m
                       on (m.aluno_id = a.aluno_id)
               left join ausencia au 
                       on (au.matricula_id = m.matricula_id)
 where au.ausencia_id is null; -- Garante que apenas alunos sem ausências sejam retornados

-- Usando group by para garantir que não haja duplicatas
-- Aqui usamos GROUP BY para agrupar os resultados por aluno_id e nome, garantindo que cada aluno apareça apenas uma vez.
select a.aluno_id, a.nome
  from aluno a inner join matricula m
                       on (m.aluno_id = a.aluno_id)
               left join ausencia au 
                       on (au.matricula_id = m.matricula_id)
 where au.ausencia_id is null
 group by 1, 2; -- Agrupa pelos campos aluno_id e nome

-- Contar a quantidade de ausências por aluno
-- Esta query traz a quantidade total de ausências para cada aluno usando uma subquery correlacionada.
select a.aluno_id, a.nome, 
     ( select count(au.ausencia_id)
         from matricula m, 
              ausencia au
        where au.matricula_id = m.matricula_id 
          and m.aluno_id = a.aluno_id 
     ) as qtde_ausencias
  from aluno a;

-- Retornar apenas alunos sem ausências
-- Esta consulta retorna apenas os alunos que não possuem ausências. A subquery conta as ausências e a condição é que a contagem seja igual a zero.
select a.aluno_id, a.nome
  from aluno a
 where ( select count(au.ausencia_id)
           from matricula m, 
                ausencia au
          where au.matricula_id = m.matricula_id 
            and m.aluno_id = a.aluno_id 
       ) = 0;

-- Usando having com group by para garantir que apenas alunos sem ausências sejam listados
-- Esta query é similar à anterior, mas aqui usamos GROUP BY e HAVING para filtrar os resultados.
select a.aluno_id, a.nome
  from aluno a 
 group by a.aluno_id, a.nome
having ( select count(au.ausencia_id)
           from matricula m, 
                ausencia au
          where au.matricula_id = m.matricula_id 
            and m.aluno_id = a.aluno_id 
       ) = 0;

-- Usando not exists para retornar alunos sem ausências
-- Aqui usamos NOT EXISTS, que verifica se não existe nenhuma ausência para o aluno em questão.
select a.aluno_id, a.nome
  from aluno a
 where not exists 
     ( select 1
         from matricula m, 
              ausencia au
        where au.matricula_id = m.matricula_id 
          and m.aluno_id = a.aluno_id 
     );

-- Query 4.4: Contar a quantidade de turmas atribuídas a cada professor
-- Esta query conta quantas turmas cada professor ministra.
select p.professor_id, p.nome, count(1) as qtde_turmas
  from professor p, 
       turma t 
 where t.professor_id = p.professor_id 
 group by 1, 2;

-- Trazendo também os professores que não possuem turmas
-- Usamos LEFT JOIN para garantir que todos os professores apareçam, mesmo os que não possuem turmas.
select p.professor_id, p.nome, count(t.turma_id) as qtde_turmas
  from professor p left join turma t 
                          on (t.professor_id = p.professor_id)
 group by 1, 2;

-- Usando subquery para contar as turmas de cada professor
-- Aqui usamos uma subquery correlacionada que conta as turmas para cada professor.
select p.professor_id, p.nome, 
     ( select count(1)
         from turma t
        where t.professor_id = p.professor_id
     ) as qtde_turmas 
  from professor p;

-- Query 4.5: Listar detalhes dos professores, suas turmas e respectivos alunos
-- Esta consulta exibe informações detalhadas sobre os professores, incluindo as turmas e os alunos matriculados em cada turma.
select p.nome, 
     ( select t.telefone 
         from telefone t
        where t.professor_id = p.professor_id 
        limit 1 
     ) as fone, -- Retorna o primeiro telefone do professor
     tu.turma_id, tu.data_inicial, tu.data_final, 
     tu.horario, c.nome as nome_curso, 
     a.aluno_id, a.nome as nome_aluno
  from professor p, 
       turma tu, 
       turma_curso tc, 
       curso c, 
       matricula m, 
       aluno a
 where tu.professor_id = p.professor_id
   and tc.turma_id = tu.turma_id 
   and tc.curso_id = c.curso_id 
   and m.turma_id = tu.turma_id 
   and a.aluno_id = m.aluno_id  
 order by p.nome, tu.turma_id, a.nome;

-- Inserção de telefones para os professores
-- Aqui inserimos dois registros na tabela telefone, associando cada telefone a um professor.
insert into telefone
          (telefone_id, professor_id, telefone)
     values
          (1, 1, '89540385'), (2, 2, '850435433');

-- Query 4.6: Encontrar a turma com maior número de alunos para cada professor
-- Esta consulta usa subqueries aninhadas para identificar a turma com mais alunos atribuída a cada professor.
select p.nome,  
     ( select t.turma_id
         from
            ( select t2.*
                from
                   ( select t1.turma_id, count(1) as qtde_alunos
                       from turma t1, 
                            matricula m 
                      where t1.professor_id = p.professor_id
                        and m.turma_id = t1.turma_id 
                      group by t1.turma_id 
                      order by 2 desc ) as t2
               limit 1 ) as t ) as turma_id
  from professor p;

-- Query 4.8: Calcular a média de alunos por curso
-- Queremos calcular a média de alunos matriculados em cada curso. 
-- A query junta as tabelas curso, turma_curso, turma e matricula e usa a função AVG para calcular a média.
select c.nome, avg(m.aluno_id) as media_curso 
  from curso c, 
       turma_curso tc, 
       turma t, 
       matricula m 
 where tc.curso_id = c.curso_id 
   and t.turma_id = tc.turma_id 
   and m.turma_id = t.turma_id 
 group by c.nome;

-- Query 5.1: Atualizar o nome dos professores para maiúsculo
-- Atualiza todos os registros da tabela professor, transformando os nomes em maiúsculas usando a função UPPER.
update professor 
   set nome = upper(nome);

-- Query 6: Deletar ausências de alunos que são monitores na turma
-- Esta query deleta os registros de ausência para os alunos que são monitores da turma.
delete from ausencia 
 where exists 
     ( select 1
         from matricula m, 
              turma t
        where m.matricula_id = ausencia.matricula_id 
          and t.turma_id = m.turma_id 
          and t.aluno_monitor_id = m.aluno_id
     );

-- Query final: Listar cursos, turmas, professores e a quantidade de alunos com nomes contendo a letra 'a'
-- Queremos listar as turmas em cada curso com a quantidade de alunos cujo nome contenha a letra 'a'.
select c.curso_id, c.nome as nome_curso, t.turma_id, 
       p.nome as nome_professor, t.data_inicial, t.data_final, 
       t.horario,
     ( select count(1)
         from matricula m
        where m.turma_id = t.turma_id 
     ) as total_alunos
  from turma t 
       inner join turma_curso tc on t.turma_id = tc.turma_id
       inner join curso c on tc.curso_id = c.curso_id
       inner join professor p on t.professor_id = p.professor_id
 where ( select count(1) 
          from matricula m1 
               inner join aluno a1 on m1.aluno_id = a1.aluno_id
         where t.turma_id = m1.turma_id
           and lower(a1.nome) like '%a%') >= 2 -- Apenas turmas com pelo menos 2 alunos cujo nome contenha 'a'
 order by t.data_inicial;