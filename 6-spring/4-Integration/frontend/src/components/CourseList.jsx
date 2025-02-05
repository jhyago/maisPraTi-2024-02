import React, { useEffect, useState } from "react"; // Importa o React e os hooks useEffect e useState para gerenciar o estado e os efeitos colaterais do componente
import api from "../services/api"; // Importa a instância configurada do axios para realizar chamadas à API

// Declaração do componente funcional CourseList
const CourseList = () => {
  // Cria o estado 'courses' para armazenar a lista de cursos e 'setCourses' para atualizá-lo, iniciando com um array vazio
  const [courses, setCourses] = useState([]);

  // useEffect é executado quando o componente é montado
  useEffect(() => {
    // Realiza uma requisição GET para o endpoint "/cursos" da API
    api.get("/cursos").then((response) => {
      // Atualiza o estado 'courses' com os dados retornados pela API
      setCourses(response.data);
    });
  }, []); // O array vazio [] garante que o efeito seja executado apenas uma vez, na montagem do componente

  // Retorna o JSX que define a interface do componente
  return (
    <div className="container"> {/* Container principal com classe do Bootstrap para centralização e espaçamento */}
      <h2>Lista de Cursos</h2> {/* Título da página */}
      <ul className="list-group"> {/* Lista não ordenada com classe 'list-group' para estilização */}
        {courses.map((course) => ( // Mapeia cada curso presente no array 'courses'
          <li key={course.id} className="list-group-item"> {/* Cada item da lista recebe uma chave única baseada no 'id' do curso e é estilizado com a classe 'list-group-item' */}
            {course.nome} {/* Exibe o nome do curso */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList; // Exporta o componente CourseList para ser utilizado em outras partes da aplicação