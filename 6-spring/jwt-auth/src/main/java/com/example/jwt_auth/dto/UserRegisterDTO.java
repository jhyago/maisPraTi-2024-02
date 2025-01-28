package com.example.jwt_auth.dto;

public class UserRegisterDTO {
    @NotBlank(message = "O nome de usuário não pode estar vazio.")
    @Size(min = 3, max = 50, message = "O nome de usuário deve ter entre 3 e 50 caracarteres")
    private String username;
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String password;
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    public UserRegisterDTO(){}

    public UserRegisterDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
