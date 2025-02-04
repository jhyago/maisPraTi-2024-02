import { useEffect, useState } from "react"
import axios from "axios"
import { Button, Container, Form, ListGroup } from 'react-bootstrap'

const API_URL = "http://localhost:8080/api/tasks"

const TaskList = () => {
    const [tasks, setTasks] = useState([])
    const [newTask, setNewTask] = useState("")

    useEffect(() => {
        axios.get(API_URL).then(response => setTasks(response.data)).catch(error => console.error("Erro ao buscar tarefas: ", error))
    }, [])

    const addTask = () => {
        if(newTask.trim() === "") return;

        axios.post(API_URL, {title: newTask, completed: false}).then(response => {
            setTasks([...tasks, response.data])
            setNewTask("")
        }).catch(error => console.error("Erro ao adicionar a tarefa", error))
    }

    const deleteTask = (id) => {
        axios.delete(`${API_URL}/${id}`).then(() => {
            setTasks(tasks.filter(task => task.id !== id))
        }).catch(error => console.error("Erro aoo remover tarefa: ", error))
    }

    return (
        <Container className="mt-5">
            <h2>Lista de Tarefas</h2>

            <Form className="d-flex mb-3">
                <Form.control
                    type="text"
                    placeholder="Nova tarefa"
                    value={newTask}
                    onChange={(event) => setNewTask(event.target.value)}
                />
                <Button variant="primary" onClick={addTask} className="ms-2">Adicionar</Button>
            </Form>

            <ListGroup>
                {tasks.map(task => (
                    <ListGroup.Item key={task.id} className="d-flex justify-content-between align-items-center">
                        {task.title}
                        <Button variant="danger" onClick={() => deleteTask(task.id)}>Deletar</Button>
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </Container>
    )
}

export default TaskList