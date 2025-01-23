package com.example.introduction.model;
// Define o pacote onde a classe está localizada, organizando o projeto.

import jakarta.persistence.*;
// Importa as anotações e classes do pacote JPA (Java Persistence API) para mapeamento objeto-relacional (ORM).

import lombok.AllArgsConstructor;
// Importa a anotação de Lombok para gerar automaticamente um construtor com todos os argumentos.

import lombok.Getter;
// Importa a anotação de Lombok para gerar automaticamente os métodos "getter" para todos os campos.

import lombok.NoArgsConstructor;
// Importa a anotação de Lombok para gerar automaticamente um construtor sem argumentos.

import lombok.Setter;
// Importa a anotação de Lombok para gerar automaticamente os métodos "setter" para todos os campos.

import java.util.Set;
// Importa a interface `Set` da API Java, usada para definir uma coleção que não permite elementos duplicados.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
// Marca a classe como uma entidade JPA, indicando que será mapeada para uma tabela no banco de dados.
public class Student {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como identificador único para cada estudante, do tipo `Long`.

    private String name;
    // Define o campo `name` para armazenar o nome do estudante, do tipo `String`.

    @ManyToMany
    // Marca o campo `courses` como um relacionamento "muitos para muitos" com a entidade `Course`.

    @JoinTable(
            name = "student_course",
            // Define o nome da tabela intermediária no banco de dados para mapear o relacionamento "muitos para muitos".

            joinColumns = @JoinColumn(name = "student_id"),
            // Especifica a coluna `student_id` como a chave estrangeira que referencia a tabela `Student`.

            inverseJoinColumns = @JoinColumn(name = "course_id")
            // Especifica a coluna `course_id` como a chave estrangeira que referencia a tabela `Course`.
    )
    private Set<Course> courses;
    // Define o campo `courses` como um conjunto de objetos do tipo `Course`, representando os cursos associados ao estudante.
    // O uso de `Set` garante que não haverá cursos duplicados no relacionamento.

    public void addCourse(Course course) {
        // Método público para adicionar um curso ao conjunto de cursos do estudante.

        courses.add(course);
        // Adiciona o curso ao conjunto `courses`.

        course.getStudents().add(this);
        // Adiciona o estudante ao conjunto de estudantes do curso, garantindo a sincronização bidirecional do relacionamento.
    }
}
