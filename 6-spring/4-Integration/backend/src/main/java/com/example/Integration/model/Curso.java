package com.example.Integration.model; // Define o pacote onde a classe Curso está localizada

import jakarta.persistence.*; // Importa as anotações e classes necessárias para o mapeamento JPA

@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
public class Curso { // Declaração da classe Curso

    @Id // Indica que o campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor de 'id' será gerado automaticamente pelo banco (geralmente auto-incrementado)
    private Long id; // Declaração do atributo 'id', que representa o identificador único do curso

    private String nome; // Declaração do atributo 'nome', que armazena o nome do curso

    @ManyToOne // Especifica que vários cursos podem estar associados a um único usuário (relação muitos-para-um)
    @JoinColumn(name = "usuario_id") // Define a coluna de junção que armazenará a referência ao usuário associado
    private Usuario usuario; // Declaração do atributo 'usuario', que referencia o usuário ao qual o curso pertence

    // Construtor da classe Curso que inicializa os atributos 'nome' e 'usuario'
    public Curso(String nome, Usuario usuario) {
        this.nome = nome; // Atribui o valor do parâmetro 'nome' ao atributo 'nome'
        this.usuario = usuario; // Atribui o valor do parâmetro 'usuario' ao atributo 'usuario'
    }

    // Método getter para o atributo 'id'
    public Long getId() {
        return id; // Retorna o identificador do curso
    }

    // Método setter para o atributo 'id'
    public void setId(Long id) {
        this.id = id; // Define o identificador do curso
    }

    // Método getter para o atributo 'nome'
    public String getNome() {
        return nome; // Retorna o nome do curso
    }

    // Método setter para o atributo 'nome'
    public void setNome(String nome) {
        this.nome = nome; // Define o nome do curso
    }

    // Método getter para o atributo 'usuario'
    public Usuario getUsuario() {
        return usuario; // Retorna o usuário associado ao curso
    }

    // Método setter para o atributo 'usuario'
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario; // Define o usuário associado ao curso
    }
}