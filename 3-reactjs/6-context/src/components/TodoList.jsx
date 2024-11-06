import { useContext } from 'react' // Importa useContext para acessar o contexto TodoContext
import { TodoContext } from '../context/TodoContext' // Importa o contexto TodoContext para acessar a lista de tarefas (todos)

// Define o componente TodoList que exibe a lista de tarefas
const TodoList = () => {
    const { todos } = useContext(TodoContext) // Utiliza useContext para acessar o array 'todos' do contexto

    // Retorna o JSX que renderiza a lista de tarefas em uma lista não ordenada (ul)
    return (
        <ul>
            {todos.map(todo => ( // Itera sobre o array 'todos' para renderizar cada tarefa
                <li key={todo.id}> 
                    {todo.task} 
                </li>
            ))}
        </ul>
    )
}

export default TodoList // Exporta o componente TodoList para uso em outras partes da aplicação