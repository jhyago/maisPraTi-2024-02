// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.dto;

// Classe DTO (Data Transfer Object) para representar um Post de forma simplificada.
public class PostDTO {

    // Identificador único do post.
    private Long id;

    // Título do post.
    private String title;

    // Conteúdo do post.
    private String content;

    // Identificador do usuário que criou o post.
    private Long userId;

    // Construtor padrão (necessário para frameworks como Jackson na serialização).
    public PostDTO() {}

    // Construtor que permite inicializar todos os campos.
    public PostDTO(Long id, String title, String content, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    // Obtém o ID do post.
    public Long getId() {
        return id;
    }

    // Define o ID do post.
    public void setId(Long id) {
        this.id = id;
    }

    // Obtém o título do post.
    public String getTitle() {
        return title;
    }

    // Define o título do post.
    public void setTitle(String title) {
        this.title = title;
    }

    // Obtém o conteúdo do post.
    public String getContent() {
        return content;
    }

    // Define o conteúdo do post.
    public void setContent(String content) {
        this.content = content;
    }

    // Obtém o ID do usuário que criou o post.
    public Long getUserId() {
        return userId;
    }

    // Define o ID do usuário que criou o post.
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}