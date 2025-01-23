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

import java.util.List;
// Importa a classe `List` da API Java, usada para definir uma coleção de objetos (neste caso, uma lista de livros).

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
// A classe é marcada como uma entidade JPA, indicando que ela será mapeada para uma tabela no banco de dados.
public class Author {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como um identificador único para cada autor, do tipo `Long`.

    private String name;
    // Define o campo `name` para armazenar o nome do autor, do tipo `String`.

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    // Marca o campo `books` como um relacionamento de "um para muitos" com a entidade `Book`.
    // O atributo `mappedBy` especifica que o campo `author` na classe `Book` é o lado responsável pelo mapeamento do relacionamento.
    // O atributo `cascade = CascadeType.ALL` indica que todas as operações (persistência, exclusão, etc.) realizadas em `Author`
    // também serão propagadas para os objetos relacionados na lista `books`.

    private List<Book> books;
    // Define o campo `books` como uma lista de objetos do tipo `Book`, representando os livros associados ao autor.

}