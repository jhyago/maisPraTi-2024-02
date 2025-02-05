import { useEffect, useState } from "react" // Importa os hooks useEffect e useState da biblioteca React para gerenciar efeitos colaterais e estado no componente
import axios from "axios" // Importa o axios, que é utilizado para fazer requisições HTTP
import { Button, Container, Form, ListGroup } from 'react-bootstrap' // Importa componentes do react-bootstrap para estilização e estruturação da interface

const API_URL = "http://localhost:8080/api/tasks" // Define a URL base da API para as tarefas

const TaskList = () => { // Declaração do componente funcional TaskList
    const [tasks, setTasks] = useState([]) // Cria uma variável de estado 'tasks' inicializada como um array vazio, para armazenar a lista de tarefas
    const [newTask, setNewTask] = useState("") // Cria uma variável de estado 'newTask' inicializada como uma string vazia, para armazenar o título da nova tarefa

    useEffect(() => { // Hook useEffect que executa a função ao montar o componente
        axios.get(API_URL) // Realiza uma requisição GET para a API para buscar todas as tarefas
            .then(response => setTasks(response.data)) // Atualiza o estado 'tasks' com os dados retornados da API
            .catch(error => console.error("Erro ao buscar tarefas: ", error)) // Em caso de erro, exibe uma mensagem de erro no console
    }, []) // Array de dependências vazio garante que o efeito seja executado apenas uma vez, na montagem do componente

    const addTask = () => { // Declaração da função addTask, responsável por adicionar uma nova tarefa
        if (newTask.trim() === "") return; // Verifica se o campo da nova tarefa está vazio (ou contém apenas espaços); se sim, não faz nada

        axios.post(API_URL, { title: newTask, completed: false }) // Realiza uma requisição POST para a API para criar uma nova tarefa com o título e o status 'completed' como false
            .then(response => { // Se a requisição for bem-sucedida:
                setTasks([...tasks, response.data]) // Adiciona a nova tarefa (retornada pela API) à lista de tarefas existente
                setNewTask("") // Limpa o campo de entrada definindo newTask como uma string vazia
            })
            .catch(error => console.error("Erro ao adicionar a tarefa", error)) // Em caso de erro, exibe uma mensagem de erro no console
    }

    const deleteTask = (id) => { // Declaração da função deleteTask, que deleta uma tarefa baseada no id fornecido
        axios.delete(`${API_URL}/${id}`) // Realiza uma requisição DELETE para a API, passando o id da tarefa na URL
            .then(() => { // Se a requisição for bem-sucedida:
                setTasks(tasks.filter(task => task.id !== id)) // Atualiza o estado 'tasks' removendo a tarefa com o id correspondente
            })
            .catch(error => console.error("Erro aoo remover tarefa: ", error)) // Em caso de erro, exibe uma mensagem de erro no console (note o erro de digitação "aoo")
    }

    return ( // Retorna o JSX que define a interface do componente
        <Container className="mt-5"> {/* Componente Container do react-bootstrap com margem superior */}
            <h2>Lista de Tarefas</h2> {/* Título da lista de tarefas */}

            <Form className="d-flex mb-3"> {/* Componente Form do react-bootstrap com classes de layout para exibição em linha e margem inferior */}
                <Form.Control
                    type="text" // Define o tipo do input como texto
                    placeholder="Nova tarefa" // Define o placeholder do input
                    value={newTask} // Define o valor do input de acordo com o estado newTask
                    onChange={(event) => setNewTask(event.target.value)} // Atualiza o estado newTask com o valor digitado pelo usuário
                />
                <Button variant="primary" onClick={addTask} className="ms-2">Adicionar</Button> {/* Botão que, ao ser clicado, chama a função addTask para adicionar uma nova tarefa */}
            </Form>

            <ListGroup> {/* Componente ListGroup do react-bootstrap que agrupa os itens da lista */}
                {tasks.map(task => ( // Mapeia cada tarefa presente no array 'tasks'
                    <ListGroup.Item key={task.id} className="d-flex justify-content-between align-items-center"> {/* Item da lista com chave única e classes para layout */}
                        {task.title} {/* Exibe o título da tarefa */}
                        <Button variant="danger" onClick={() => deleteTask(task.id)}>Deletar</Button> {/* Botão que, ao ser clicado, chama a função deleteTask para remover a tarefa */}
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </Container>
    )
}

export default TaskList // Exporta o componente TaskList para que ele possa ser utilizado em outras partes da aplicação