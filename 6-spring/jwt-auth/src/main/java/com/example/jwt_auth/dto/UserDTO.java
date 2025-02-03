// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.dto;

// Classe DTO (Data Transfer Object) para representar um usuário de forma simplificada.
public class UserDTO {

    // Identificador único do usuário.
    private Long id;

    // Nome de usuário.
    private String username;

    // Endereço de e-mail do usuário.
    private String email;

    // Construtor padrão (necessário para a desserialização automática, por exemplo, ao receber JSON).
    public UserDTO() {}

    // Construtor parametrizado para inicializar um objeto UserDTO com valores específicos.
    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    // Obtém o ID do usuário.
    public Long getId() {
        return id;
    }

    // Define o ID do usuário.
    public void setId(Long id) {
        this.id = id;
    }

    // Obtém o nome de usuário.
    public String getUsername() {
        return username;
    }

    // Define o nome de usuário.
    public void setUsername(String username) {
        this.username = username;
    }

    // Obtém o e-mail do usuário.
    public String getEmail() {
        return email;
    }

    // Define o e-mail do usuário.
    public void setEmail(String email) {
        this.email = email;
    }
}