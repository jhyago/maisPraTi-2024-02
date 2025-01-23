package com.example.introduction.model;
// Define o pacote onde a classe está localizada. Serve para organizar o projeto.

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
public class Course {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como um identificador único para cada curso, do tipo `Long`.

    private String title;
    // Define o campo `title` para armazenar o título do curso, do tipo `String`.

    @ManyToMany(mappedBy = "courses")
    // Marca o campo `students` como um relacionamento de "muitos para muitos" com a entidade `Student`.
    // A propriedade `mappedBy` indica que o lado inverso do relacionamento (na classe `Student`) é responsável pelo mapeamento.

    private Set<Student> students;
    // Define o campo `students` como um conjunto de objetos do tipo `Student`, representando os estudantes associados ao curso.
    // O uso de `Set` garante que não haverá estudantes duplicados no relacionamento.
}