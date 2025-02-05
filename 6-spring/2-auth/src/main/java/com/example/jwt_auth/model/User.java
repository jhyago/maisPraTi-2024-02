// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.model;

// Importa as anotações necessárias do Jakarta Persistence para mapeamento da entidade.
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Indica que esta classe é uma entidade gerenciada pelo JPA.
@Entity
// Define o nome da tabela no banco de dados.
@Table(name = "users")
public class User {

    // Define o identificador único da entidade e sua geração automática pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia de geração automática do ID.
    private Long id;

    // Define o nome de usuário do sistema.
    private String username;

    // Define a senha do usuário (deve ser armazenada de forma segura utilizando criptografia).
    private String password;

    // Define o e-mail do usuário, garantindo que seja único e obrigatório.
    @Column(unique = true, name = "email", nullable = false)
    private String email;

    // Define o relacionamento One-to-Many entre Usuário e Postagens.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    // Construtor padrão necessário para o uso do JPA e serialização.
    public User(){}

    // Construtor parametrizado para facilitar a criação de instâncias.
    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    // Obtém a lista de postagens associadas ao usuário.
    public List<Post> getPosts() {
        return posts;
    }

    // Define a lista de postagens associadas ao usuário.
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

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