// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.dto;

// Classe DTO (Data Transfer Object) para representar os dados de registro de um usuário.
public class UserRegisterDTO {

    // Nome de usuário escolhido pelo usuário.
    private String username;

    // Senha do usuário (deverá ser criptografada antes de ser armazenada no banco de dados).
    private String password;

    // Endereço de e-mail do usuário.
    private String email;

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    // Obtém o nome de usuário.
    public String getUsername() {
        return username;
    }

    // Define o nome de usuário.
    public void setUsername(String username) {
        this.username = username;
    }

    // Obtém a senha do usuário.
    public String getPassword() {
        return password;
    }

    // Define a senha do usuário.
    public void setPassword(String password) {
        this.password = password;
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