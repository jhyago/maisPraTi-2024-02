// Define o pacote em que esta classe está localizada, organizando o projeto em módulos.
package com.example.jwt_auth.model;

// Importa as anotações do Jakarta Persistence (JPA) para mapeamento ORM (Object-Relational Mapping).
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Indica que esta classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Entity
// Especifica o nome da tabela no banco de dados associada a esta entidade.
@Table(name = "users")
public class User {
    // Indica que o atributo "id" é a chave primária da tabela.
    @Id
    // Define a estratégia de geração automática de valores para a chave primária.
    // Neste caso, "IDENTITY" significa que o banco de dados gerará o valor automaticamente (geralmente usado com colunas AUTO_INCREMENT).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Representa o nome de usuário associado à entidade.
    // Nenhuma anotação adicional é aplicada aqui, portanto, o nome da coluna será igual ao nome do atributo.
    private String username;

    // Representa a senha associada à entidade.
    private String password;

    // Especifica que a coluna "email" deve ser única e não pode ser nula.
    // O nome da coluna no banco de dados será "email".
    @Column(unique = true, name = "email", nullable = false)
    private String email;
    private List<Post> posts = new ArrayList<>();

    public User() {}

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // Método getter para o campo "id". Permite obter o valor do identificador da entidade.
    public Long getId() {
        return id;
    }

    // Método setter para o campo "id". Permite definir ou alterar o valor do identificador da entidade.
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para o campo "username". Retorna o nome de usuário associado à entidade.
    public String getUsername() {
        return username;
    }

    // Método setter para o campo "username". Permite definir ou alterar o nome de usuário associado à entidade.
    public void setUsername(String username) {
        this.username = username;
    }

    // Método getter para o campo "password". Retorna a senha associada à entidade.
    public String getPassword() {
        return password;
    }

    // Método setter para o campo "password". Permite definir ou alterar a senha associada à entidade.
    public void setPassword(String password) {
        this.password = password;
    }

    // Método getter para o campo "email". Retorna o e-mail associado à entidade.
    public String getEmail() {
        return email;
    }

    // Método setter para o campo "email". Permite definir ou alterar o e-mail associado à entidade.
    public void setEmail(String email) {
        this.email = email;
    }
}