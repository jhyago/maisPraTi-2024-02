// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.model;

// Importa as anotações e classes necessárias para o mapeamento da entidade.
import jakarta.persistence.*;
import java.time.Instant; // Representa um ponto no tempo para a expiração do token.

// Indica que esta classe é uma entidade gerenciada pelo JPA.
@Entity
// Define o nome da tabela no banco de dados.
@Table(name = "refresh_tokens")
public class RefreshToken {

    // Define o identificador único da entidade e sua geração automática.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID com estratégia baseada no banco de dados.
    private Long id;

    // Define o campo do token, que deve ser único e não pode ser nulo.
    @Column(nullable = false, unique = true)
    private String token;

    // Define a data de expiração do token.
    @Column(nullable = false)
    private Instant expiryDate;

    // Define um relacionamento Many-to-One com a entidade User.
    @ManyToOne // Vários refresh tokens podem pertencer a um único usuário.
    @JoinColumn(name = "user_id", nullable = false) // Define a chave estrangeira associando o token ao usuário.
    private User user;

    // Construtor padrão necessário para serialização e uso pelo JPA.
    public RefreshToken() {}

    // Construtor parametrizado para facilitar a criação de instâncias da entidade.
    public RefreshToken(String token, Instant expiryDate, User user) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe.

    // Obtém o ID do token.
    public Long getId() {
        return id;
    }

    // Define o ID do token.
    public void setId(Long id) {
        this.id = id;
    }

    // Obtém o valor do token.
    public String getToken() {
        return token;
    }

    // Define o valor do token.
    public void setToken(String token) {
        this.token = token;
    }

    // Obtém a data de expiração do token.
    public Instant getExpiryDate() {
        return expiryDate;
    }

    // Define a data de expiração do token.
    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Obtém o usuário associado ao token.
    public User getUser() {
        return user;
    }

    // Define o usuário associado ao token.
    public void setUser(User user) {
        this.user = user;
    }
}