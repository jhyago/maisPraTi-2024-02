// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.model;

// Importa as anotações necessárias para mapear a classe como uma entidade JPA.
import jakarta.persistence.*;

// Indica que esta classe é uma entidade gerenciada pelo JPA.
@Entity
// Define o nome da tabela no banco de dados.
@Table(name = "posts")
public class Post {

    // Define o identificador único da entidade e sua geração automática.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID com estratégia baseada no banco de dados.
    private Long id;

    // Define o título do post.
    private String title;

    // Define o conteúdo do post, permitindo armazenar textos longos no banco de dados.
    @Column(columnDefinition = "TEXT") // Define a coluna como "TEXT" para suportar textos grandes.
    private String content;

    // Define um relacionamento Many-to-One com a entidade User.
    @ManyToOne(fetch = FetchType.LAZY) // Um usuário pode ter vários posts, mas cada post pertence a um único usuário.
    @JoinColumn(name = "user_id", nullable = false) // Define a chave estrangeira para associar o post ao usuário.
    private User user;

    // Construtor padrão necessário para a serialização e uso pelo JPA.
    public Post() {}

    // Construtor parametrizado para facilitar a criação de instâncias da entidade.
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
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

    // Obtém o usuário associado ao post.
    public User getUser() {
        return user;
    }

    // Define o usuário associado ao post.
    public void setUser(User user) {
        this.user = user;
    }
}