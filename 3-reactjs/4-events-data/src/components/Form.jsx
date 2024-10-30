import { useState } from 'react'  // Importa o hook useState do React para gerenciar o estado do componente

function Form() {  // Define o componente funcional Form
    const [tarefas, setTarefas] = useState([])  // Declara o estado 'tarefas', inicializado como uma lista vazia, para armazenar as tarefas

    const [novaTarefa, setNovaTarefa] = useState('')  // Declara o estado 'novaTarefa' para capturar o valor da nova tarefa a ser adicionada

    const handleInputChange = (event) => {  // Define uma função que lida com mudanças no campo de input
        setNovaTarefa(event.target.value)  // Atualiza o estado 'novaTarefa' com o valor do input
    }

    const handleAddTask = () => {  // Define uma função para adicionar uma nova tarefa à lista
        if(novaTarefa.trim() === ''){  // Verifica se 'novaTarefa' não está vazia após remover espaços
            return  // Se estiver vazia, interrompe a função para evitar adicionar uma tarefa vazia
        }

        setTarefas([...tarefas, novaTarefa])  // Adiciona 'novaTarefa' à lista de 'tarefas' usando o spread operator para manter as tarefas anteriores
        setNovaTarefa('')  // Limpa o campo de input após a adição da tarefa
    }

    const handleRemoveTask = (index) => {  // Define uma função para remover uma tarefa específica
        const updatedTasks = tarefas.filter((_, i) => i !== index)  // Filtra a lista 'tarefas' removendo o item pelo índice fornecido
        setTarefas(updatedTasks)  // Atualiza o estado 'tarefas' com a lista filtrada
    }

    return (  // Renderiza o componente na tela
        <div>
            <h1>Lista de Tarefas</h1>  
            <input 
                type="text"
                value={novaTarefa}  // Define o valor do input como o estado 'novaTarefa'
                onChange={handleInputChange}  // Chama 'handleInputChange' quando o valor do input muda
                placeholder='Digite uma nova tarefa'  // Define um placeholder para o campo de input
            />
            <button onClick={handleAddTask}>Adicionar Tarefa</button>  

            <ul>
                {tarefas.map((tarefa, index) => (  
                    <li key={index}>  
                        {tarefa}  
                        <button onClick={() => handleRemoveTask(index)}>Remover</button>  
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default Form  // Exporta o componente Form para ser usado em outros arquivos