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
public class Profile {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como identificador único para cada perfil, do tipo `Long`.

    private String bio;
    // Define o campo `bio` para armazenar informações biográficas do perfil, do tipo `String`.

    @OneToOne(mappedBy = "profile")
    // Marca o campo `user` como parte de um relacionamento "um para um" com a entidade `Usuario`.
    // O atributo `mappedBy` indica que o campo `profile` na classe `Usuario` é o lado proprietário do relacionamento.

    private Usuario user;
    // Define o campo `user` como um objeto do tipo `Usuario`, representando o usuário associado ao perfil.
}