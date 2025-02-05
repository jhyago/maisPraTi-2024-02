import React, { useState } from "react"; // Importa o React e o hook useState para gerenciar o estado do componente
import api from "../services/api"; // Importa a instância do axios configurada para realizar requisições HTTP

// Define o componente funcional AddCourse para cadastrar um novo curso
const AddCourse = () => {
  const [nome, setNome] = useState(""); // Declara o estado 'nome' para armazenar o nome do curso, iniciando com uma string vazia
  const [success, setSuccess] = useState(false); // Declara o estado 'success' para controlar se o cadastro foi bem-sucedido, iniciando com 'false'

  // Função assíncrona que lida com o envio do formulário para adicionar um curso
  const handleAddCourse = async (e) => {
    e.preventDefault(); // Previne o comportamento padrão do formulário (recarregar a página)
    try {
      await api.post("/cursos", { nome }); // Envia uma requisição POST para o endpoint "/cursos" com o nome do curso no corpo da requisição
      setSuccess(true); // Define o estado 'success' como true para indicar que o curso foi cadastrado com sucesso
      setNome(""); // Limpa o campo de entrada, resetando o estado 'nome' para uma string vazia
    } catch (error) {
      console.error("Erro ao cadastrar curso", error); // Em caso de erro, imprime uma mensagem de erro no console
    }
  };

  // Retorna o JSX que define a interface do componente
  return (
    <div className="container"> {/* Div principal com a classe 'container' do Bootstrap para centralização e espaçamento */}
      <h2>Cadastro de Curso</h2> {/* Cabeçalho exibindo o título da seção */}
      {success && <p className="text-success">Curso cadastrado com sucesso!</p>} {/* Exibe uma mensagem de sucesso se o estado 'success' for true */}
      <form onSubmit={handleAddCourse}> {/* Formulário que dispara a função handleAddCourse ao ser submetido */}
        <div className="mb-3"> {/* Div com margem inferior para espaçamento, de acordo com as classes do Bootstrap */}
          <label>Nome do Curso</label> {/* Rótulo para o campo de entrada */}
          <input
            type="text" // Define o tipo do input como texto
            className="form-control" // Aplica a classe 'form-control' do Bootstrap para estilizar o input
            value={nome} // Vincula o valor do input ao estado 'nome'
            onChange={(e) => setNome(e.target.value)} // Atualiza o estado 'nome' com o valor digitado pelo usuário
            required // Torna o campo obrigatório, impedindo o envio do formulário vazio
          />
        </div>
        <button className="btn btn-primary">Adicionar Curso</button> {/* Botão estilizado com as classes do Bootstrap que submete o formulário */}
      </form>
    </div>
  );
};

export default AddCourse; // Exporta o componente AddCourse para que possa ser importado e utilizado em outras partes da aplicação