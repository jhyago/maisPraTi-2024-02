package com.example.introduction.dto;
// Define o pacote onde a classe está localizada, organizando o projeto.

import lombok.AllArgsConstructor;
// Importa a anotação de Lombok para gerar automaticamente um construtor com todos os argumentos.

import lombok.Getter;
// Importa a anotação de Lombok para gerar automaticamente os métodos "getter" para todos os campos.

import lombok.Setter;
// Importa a anotação de Lombok para gerar automaticamente os métodos "setter" para todos os campos.

import java.util.List;
// Importa a classe `List` da API Java, usada para definir uma coleção ordenada de objetos.

@Getter
@Setter
@AllArgsConstructor
// Marca a classe com as anotações de Lombok para gerar automaticamente os métodos `getter` e `setter` para todos os campos,
// além de um construtor que aceita argumentos para todos os campos.
public class AuthorDTO {
    private Long id;
    // Define o campo `id` como o identificador único do autor, do tipo `Long`.

    private String name;
    // Define o campo `name` para armazenar o nome do autor, do tipo `String`.

    private List<Long> bookIds;
    // Define o campo `bookIds` como uma lista de IDs (`Long`) que representam os livros associados ao autor.
    // Esse campo é útil para transferir informações relacionadas aos livros sem incluir objetos completos no DTO.
}