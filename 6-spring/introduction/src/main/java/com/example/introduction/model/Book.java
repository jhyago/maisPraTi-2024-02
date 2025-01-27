package com.example.introduction.model;
// Define o pacote onde essa classe está localizada. Serve para organizar o projeto.

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
// A classe é marcada como uma entidade JPA, indicando que será mapeada para uma tabela no banco de dados.
public class Book {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como um identificador único para cada livro, do tipo `Long`.

    private String title;
    // Define o campo `title` para armazenar o título do livro, do tipo `String`.

    @ManyToOne
    // Marca o campo `author` como um relacionamento de "muitos para um" com a entidade `Author`.
    // Isso significa que vários livros podem estar associados a um único autor.

    @JoinColumn(name = "author_id")
    // Especifica a coluna `author_id` no banco de dados que será usada como chave estrangeira para referenciar o autor associado.
    // Indica que a tabela correspondente à classe `Book` terá uma coluna chamada `author_id` para mapear o relacionamento.

    private Author author;
    // Define o campo `author` como um objeto do tipo `Author`, representando o autor associado ao livro.
}