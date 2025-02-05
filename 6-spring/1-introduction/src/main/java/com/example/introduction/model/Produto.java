package com.example.introduction.model;
// Define o pacote onde a classe está localizada, organizando o projeto.

import jakarta.persistence.Entity;
// Importa a anotação `Entity` do JPA, usada para marcar a classe como uma entidade mapeada para o banco de dados.

import jakarta.persistence.GeneratedValue;
// Importa a anotação `GeneratedValue`, usada para configurar a geração automática de valores para o campo identificado como chave primária.

import jakarta.persistence.GenerationType;
// Importa a enumeração `GenerationType`, que define as estratégias de geração de valores para chaves primárias.

import jakarta.persistence.Id;
// Importa a anotação `Id`, usada para marcar um campo como chave primária da entidade.

@Entity
// Marca a classe como uma entidade JPA, indicando que será mapeada para uma tabela no banco de dados.
public class Produto {
    @Id
    // Marca o campo `id` como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a geração automática do valor do campo `id` usando a estratégia `IDENTITY`, que delega a responsabilidade ao banco de dados.

    private Long id;
    // Define o campo `id` como identificador único do produto, do tipo `Long`.

    private String nome;
    // Define o campo `nome` para armazenar o nome do produto, do tipo `String`.

    private double preco;
    // Define o campo `preco` para armazenar o preço do produto, do tipo `double`.

    public Long getId() {
        return id;
    }
    // Método getter para acessar o valor do campo `id`.

    public void setId(Long id) {
        this.id = id;
    }
    // Método setter para atribuir um valor ao campo `id`.

    public String getNome() {
        return nome;
    }
    // Método getter para acessar o valor do campo `nome`.

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Método setter para atribuir um valor ao campo `nome`.

    public double getPreco() {
        return preco;
    }
    // Método getter para acessar o valor do campo `preco`.

    public void setPreco(double preco) {
        this.preco = preco;
    }
    // Método setter para atribuir um valor ao campo `preco`.
}