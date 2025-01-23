package com.example.introduction.dto;
// Define o pacote onde a classe está localizada, organizando o projeto.

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
// Marca a classe com anotações de Lombok para gerar automaticamente:
// - `@Getter` e `@Setter`: Métodos de acesso e modificação para os campos.
// - `@AllArgsConstructor`: Um construtor com todos os argumentos.
// - `@NoArgsConstructor`: Um construtor sem argumentos.
public class UpdateAuthorRequest {
    private String name;
    // Define o campo `name` para armazenar o nome do autor que será atualizado, do tipo `String`.
}