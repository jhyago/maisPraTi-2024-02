import React, { useState, useEffect } from "react"; // Importa o React e os hooks useState e useEffect para gerenciar o estado e os efeitos colaterais do componente
import api from "../services/api"; // Importa a instância do axios configurada para realizar chamadas à API

// Declaração do componente funcional Enroll, responsável por matricular um usuário em um curso
const Enroll = () => {
  // Declaração dos estados do componente:
  const [usuarios, setUsuarios] = useState([]); // Estado que armazena a lista de usuários, iniciado como um array vazio
  const [cursos, setCursos] = useState([]); // Estado que armazena a lista de cursos, iniciado como um array vazio
  const [selectedUser, setSelectedUser] = useState(""); // Estado que guarda o ID do usuário selecionado; inicia como uma string vazia
  const [selectedCourse, setSelectedCourse] = useState(""); // Estado que guarda o ID do curso selecionado; inicia como uma string vazia
  const [success, setSuccess] = useState(false); // Estado que indica se a matrícula foi bem-sucedida; inicia como false

  // useEffect para buscar a lista de usuários e cursos assim que o componente for montado
  useEffect(() => {
    // Faz uma requisição GET para o endpoint "/usuarios" e atualiza o estado 'usuarios' com os dados recebidos
    api.get("/usuarios").then((response) => setUsuarios(response.data));
    // Faz uma requisição GET para o endpoint "/cursos" e atualiza o estado 'cursos' com os dados recebidos
    api.get("/cursos").then((response) => setCursos(response.data));
  }, []); // O array vazio garante que este efeito seja executado apenas uma vez, na montagem do componente

  // Função que trata o envio do formulário para matricular o usuário em um curso
  const handleEnroll = async (e) => {
    e.preventDefault(); // Previne o comportamento padrão do formulário (recarregar a página)
    try {
      // Envia uma requisição POST para o endpoint de matrícula, utilizando os IDs do usuário e do curso selecionados
      await api.post(`/usuarios/${selectedUser}/matricular/${selectedCourse}`);
      setSuccess(true); // Se a matrícula for bem-sucedida, atualiza o estado 'success' para true
    } catch (error) {
      console.error("Erro ao matricular usuário", error); // Em caso de erro, exibe uma mensagem no console
    }
  };

  // Retorna o JSX que define a interface do componente
  return (
    <div className="container"> {/* Container principal com a classe Bootstrap para centralização e espaçamento */}
      <h2>Matrícula em Curso</h2> {/* Cabeçalho da seção */}
      {success && <p className="text-success">Usuário matriculado com sucesso!</p>} {/* Se 'success' for true, exibe uma mensagem de sucesso */}
      <form onSubmit={handleEnroll}> {/* Formulário que, ao ser enviado, chama a função handleEnroll */}
        <div className="mb-3"> {/* Div com margem inferior para o campo de seleção de usuário */}
          <label>Usuário</label> {/* Rótulo para o campo de seleção de usuário */}
          <select
            className="form-control" // Aplica a estilização do Bootstrap para inputs
            onChange={(e) => setSelectedUser(e.target.value)} // Atualiza o estado 'selectedUser' com o valor selecionado
          >
            <option value="">Selecione</option> {/* Opção padrão que indica para o usuário selecionar um valor */}
            {usuarios.map((user) => ( // Mapeia o array de usuários para criar opções no select
              <option key={user.id} value={user.id}>
                {user.nome} {/* Exibe o nome do usuário */}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-3"> {/* Div com margem inferior para o campo de seleção de curso */}
          <label>Curso</label> {/* Rótulo para o campo de seleção de curso */}
          <select
            className="form-control" // Aplica a estilização do Bootstrap para inputs
            onChange={(e) => setSelectedCourse(e.target.value)} // Atualiza o estado 'selectedCourse' com o valor selecionado
          >
            <option value="">Selecione</option> {/* Opção padrão que indica para o usuário selecionar um valor */}
            {cursos.map((course) => ( // Mapeia o array de cursos para criar opções no select
              <option key={course.id} value={course.id}>
                {course.nome} {/* Exibe o nome do curso */}
              </option>
            ))}
          </select>
        </div>
        <button className="btn btn-primary">Matricular</button> {/* Botão para submeter o formulário e realizar a matrícula */}
      </form>
    </div>
  );
};

export default Enroll; // Exporta o componente Enroll para que possa ser utilizado em outras partes da aplicação