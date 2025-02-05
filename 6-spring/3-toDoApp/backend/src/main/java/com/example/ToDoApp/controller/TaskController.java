package com.example.ToDoApp.controller; // Define o pacote onde a classe está localizada

import com.example.ToDoApp.model.Task; // Importa a classe Task do pacote model
import com.example.ToDoApp.service.TaskService; // Importa a classe TaskService do pacote service
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação Autowired para injeção de dependências do Spring
import org.springframework.web.bind.annotation.*; // Importa todas as anotações de mapeamento de requisição do Spring

import java.util.List; // Importa a interface List da biblioteca Java

@CrossOrigin(origins = "http://localhost:5173") // Permite requisições CORS apenas da origem especificada (neste caso, http://localhost:5173)
@RestController // Indica que esta classe é um controlador REST, ou seja, retorna dados diretamente em formato JSON/XML
@RequestMapping("/api/tasks") // Define a rota base para todas as requisições deste controlador como "/api/tasks"
public class TaskController { // Declaração da classe TaskController que gerencia as operações relacionadas a tarefas

    @Autowired // Injeção automática do TaskService, permitindo o uso dos seus métodos sem instanciá-lo manualmente
    private TaskService taskService; // Declaração do atributo taskService que contém a lógica de negócios para tarefas

    @GetMapping // Mapeia requisições HTTP GET para o método abaixo
    public List<Task> getAllTasks() { // Método que retorna uma lista de todas as tarefas
        return taskService.getAllTasks(); // Chama o método do serviço para obter e retornar todas as tarefas
    }

    @PostMapping // Mapeia requisições HTTP POST para o método abaixo
    public Task createTask(@RequestBody Task task) { // Método que cria uma nova tarefa a partir dos dados enviados no corpo da requisição
        return taskService.createTask(task); // Chama o método do serviço para criar a tarefa e retorna a tarefa criada
    }

    @DeleteMapping("/{id}") // Mapeia requisições HTTP DELETE para o método abaixo, utilizando o parâmetro "id" na URL
    public void deleteTask(@PathVariable Long id) { // Método que deleta uma tarefa com base no id fornecido na URL
        taskService.deleteTask(id); // Chama o método do serviço para excluir a tarefa com o id especificado
    }
}
