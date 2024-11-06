import { useState, useContext } from 'react' // Importa useState para gerenciar o estado do novo input de tarefa e useContext para acessar o contexto TodoContext
import { TodoContext } from '../context/TodoContext' // Importa TodoContext para acessar o contexto criado em TodoProvider

// Define o componente AddTodo que permite adicionar uma nova tarefa
const AddTodo = () => {
    const { addTodo } = useContext(TodoContext) // Utiliza useContext para acessar a função addTodo do contexto
    const [newTask, setNewTask] = useState('') // Define o estado newTask para armazenar o valor do input, inicializado como uma string vazia

    // Função que chama addTodo com o valor de newTask e depois redefine newTask para uma string vazia
    const handleAdd = () => {
        addTodo(newTask) // Adiciona a nova tarefa chamando addTodo
        setNewTask('') // Limpa o campo de input para o próximo uso
    }

    // Retorna o JSX que renderiza o input para a nova tarefa e o botão para adicionar a tarefa
    return (
        <div>
            <input 
                type="text" // Define o tipo do input como texto
                value={newTask} // Define o valor do input como o estado newTask
                onChange={(event) => setNewTask(event.target.value)} // Atualiza newTask com o valor digitado no input
                placeholder='Nova Tarefa' // Exibe um texto de exemplo no campo de input
            />

            <button onClick={handleAdd}>Adicionar</button> 
        </div>
    )
}

export default AddTodo // Exporta o componente AddTodo para uso em outras partes da aplicação