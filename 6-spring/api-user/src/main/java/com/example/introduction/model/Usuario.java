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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
// Marca a classe como uma entidade JPA, indicando que será mapeada para uma tabela no banco de dados.
public class Usuario {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como identificador único para cada usuário, do tipo `Long`.

    private String nome;
    // Define o campo `nome` para armazenar o nome do usuário, do tipo `String`.

    @OneToOne(cascade = CascadeType.ALL)
    // Marca o campo `profile` como um relacionamento "um para um" com a entidade `Profile`.
    // A propriedade `cascade = CascadeType.ALL` indica que todas as operações realizadas na entidade `Usuario`
    // (como salvar ou deletar) serão automaticamente propagadas para a entidade associada `Profile`.

    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    // Especifica que a coluna `profile_id` na tabela `Usuario` será usada como chave estrangeira para referenciar
    // o campo `id` da tabela `Profile`.
    // `name` define o nome da coluna na tabela `Usuario`.
    // `referencedColumnName` define o nome da coluna na tabela referenciada (`Profile`).

    private Profile profile;
    // Define o campo `profile` como um objeto do tipo `Profile`, representando o perfil associado ao usuário.
}