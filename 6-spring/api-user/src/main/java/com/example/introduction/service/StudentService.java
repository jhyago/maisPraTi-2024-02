package com.example.introduction.service;
// Define o pacote onde a classe está localizada, organizando o projeto.

// Importa o DTO `CourseDTO`, usado para representar dados simplificados de cursos.

import com.example.introduction.dto.StudentDTO;
// Importa o DTO `StudentDTO`, usado para representar dados simplificados de estudantes.

import com.example.introduction.model.Course;
// Importa a entidade `Course`, que representa o modelo de dados de um curso.

import com.example.introduction.model.Student;
// Importa a entidade `Student`, que representa o modelo de dados de um estudante.

import com.example.introduction.repository.CourseRepository;
// Importa o repositório `CourseRepository`, que gerencia operações de banco de dados para a entidade `Course`.

import com.example.introduction.repository.StudentRepository;
// Importa o repositório `StudentRepository`, que gerencia operações de banco de dados para a entidade `Student`.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.stereotype.Service;
// Importa a anotação `@Service`, usada para marcar a classe como um componente de serviço do Spring.

import java.util.List;
// Importa a classe `List`, usada para coleções ordenadas de objetos.

import java.util.Optional;
// Importa a classe `Optional`, usada para lidar com valores que podem ou não estar presentes.

import java.util.stream.Collectors;
// Importa a classe `Collectors`, usada para transformar fluxos de dados (`Stream`) em coleções ou outros tipos.

@Service
// Marca a classe como um serviço do Spring, indicando que contém lógica de negócios.
public class StudentService {

    @Autowired
    // Injeta automaticamente uma instância de `StudentRepository` para operações relacionadas a estudantes.
    private StudentRepository studentRepository;

    @Autowired
    // Injeta automaticamente uma instância de `CourseRepository` para operações relacionadas a cursos.
    private CourseRepository courseRepository;

    public List<StudentDTO> getAllStudents() {
        // Retorna uma lista de todos os estudantes no banco de dados como uma lista de `StudentDTO`.

        return studentRepository.findAll().stream()
                // Obtém todos os estudantes do repositório e os transforma em um fluxo de dados.

                .map(student -> new StudentDTO(
                        // Mapeia cada entidade `Student` para um objeto `StudentDTO`.
                        student.getId(),
                        student.getName(),
                        student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                        // Converte a lista de cursos do estudante para um conjunto de IDs dos cursos.
                ))
                .collect(Collectors.toList());
        // Coleta os objetos `StudentDTO` gerados no fluxo em uma lista.
    }

    public Optional<StudentDTO> getStudentById(Long id) {
        // Retorna um estudante pelo ID como um `Optional<StudentDTO>`.

        return studentRepository.findById(id)
                // Busca o estudante pelo ID no repositório, retornando um `Optional<Student>`.

                .map(student -> new StudentDTO(
                        // Se o estudante for encontrado, mapeia-o para um objeto `StudentDTO`.
                        student.getId(),
                        student.getName(),
                        student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                        // Converte a lista de cursos do estudante para um conjunto de IDs dos cursos.
                ));
    }

    public Student saveStudent(Student student) {
        // Salva um estudante no banco de dados e retorna a entidade salva.

        return studentRepository.save(student);
    }

    public Optional<StudentDTO> updateStudentName(Long id, String newName) {
        // Atualiza o nome de um estudante existente com base no ID.

        return studentRepository.findById(id)
                // Busca o estudante pelo ID no repositório.

                .map(student -> {
                    // Se o estudante for encontrado, executa a atualização.

                    student.setName(newName);
                    // Atualiza o nome do estudante.

                    studentRepository.save(student);
                    // Salva o estudante atualizado no repositório.

                    return new StudentDTO(
                            // Retorna um novo objeto `StudentDTO` representando o estudante atualizado.
                            student.getId(),
                            student.getName(),
                            student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                            // Converte a lista de cursos do estudante para um conjunto de IDs dos cursos.
                    );
                });
    }

    public void deleteStudent(Long id) {
        // Deleta um estudante do banco de dados com base no ID fornecido.

        studentRepository.deleteById(id);
    }

    public void enrollStudentToCourse(Long studentId, Long courseId) {
        // Inscreve um estudante em um curso específico.

        Student student = studentRepository.findById(studentId)
                // Busca o estudante pelo ID.
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Lança uma exceção se o estudante não for encontrado.

        Course course = courseRepository.findById(courseId)
                // Busca o curso pelo ID.
                .orElseThrow(() -> new RuntimeException("Course not found"));
        // Lança uma exceção se o curso não for encontrado.

        student.addCourse(course);
        // Adiciona o curso à lista de cursos do estudante.

        studentRepository.save(student);
        // Salva as alterações no repositório.
    }
}