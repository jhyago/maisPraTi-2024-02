package com.example.introduction.controller;
// Define o pacote onde a classe está localizada, organizando o projeto.

import com.example.introduction.dto.CourseDTO;
// Importa a classe `CourseDTO`, usada para transferir dados sobre cursos na API.

import com.example.introduction.dto.UpdateCourseRequest;
// Importa a classe `UpdateCourseRequest`, usada para receber dados de atualização de um curso.

import com.example.introduction.model.Course;
// Importa a entidade `Course`, representando o modelo de dados do curso.

import com.example.introduction.service.CourseService;
// Importa o serviço `CourseService`, que contém a lógica de negócio relacionada a cursos.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.http.ResponseEntity;
// Importa a classe `ResponseEntity`, usada para construir respostas HTTP completas.

import org.springframework.web.bind.annotation.*;
// Importa as anotações do Spring para definir um controlador REST e os mapeamentos de endpoints.

import java.util.List;
// Importa a classe `List`, usada para retornar coleções de objetos.

import java.util.Optional;
// Importa a classe `Optional`, usada para representar valores que podem ou não estar presentes.

@RestController
// Marca a classe como um controlador REST, indicando que os métodos retornarão respostas HTTP diretamente.

@RequestMapping("/courses")
// Define a rota base `/courses` para todos os endpoints desta classe.
public class CourseController {
    @Autowired
    // Injeta automaticamente uma instância de `CourseService` para ser usada na classe.
    private CourseService courseService;

    @GetMapping
    // Mapeia requisições HTTP GET para a rota `/courses`.
    public List<CourseDTO> getAllCourses() {
        // Chama o serviço para obter todos os cursos e os retorna como uma lista de `CourseDTO`.
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    // Mapeia requisições HTTP GET para a rota `/courses/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        // Chama o serviço para buscar um curso pelo ID.
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                // Retorna um `ResponseEntity` com status 200 (OK) se o curso for encontrado.
                .orElse(ResponseEntity.notFound().build());
        // Retorna um `ResponseEntity` com status 404 (Not Found) se o curso não for encontrado.
    }

    @PostMapping
    // Mapeia requisições HTTP POST para a rota `/courses`.
    public Course saveCourse(@RequestBody Course course) {
        // Chama o serviço para salvar um novo curso. O objeto `course` é recebido do corpo da requisição.
        return courseService.saveCourse(course);
    }

    @PutMapping
    // Mapeia requisições HTTP PUT para a rota `/courses`.
    public Optional<CourseDTO> updateName(@RequestBody UpdateCourseRequest request) {
        // Chama o serviço para atualizar o título de um curso com base no ID e no título fornecidos no corpo da requisição.
        return courseService.updateCourseTitle(request.getId(), request.getTitle());
        // Retorna um `Optional<CourseDTO>` que pode conter o curso atualizado ou estar vazio se o curso não for encontrado.
    }

    @DeleteMapping("/{id}")
    // Mapeia requisições HTTP DELETE para a rota `/courses/{id}`, onde `{id}` é um parâmetro de caminho.
    public void deleteCourse(@PathVariable Long id) {
        // Chama o serviço para deletar o curso com base no ID fornecido.
        courseService.deleteCourse(id);
    }
}