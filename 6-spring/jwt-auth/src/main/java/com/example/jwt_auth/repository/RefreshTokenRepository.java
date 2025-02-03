// Define o pacote onde esta interface está localizada.
package com.example.jwt_auth.repository;

// Importa as classes necessárias do Spring Data JPA e os modelos de dados.
import com.example.jwt_auth.model.RefreshToken; // Modelo que representa o refresh token.
import com.example.jwt_auth.model.User; // Modelo que representa um usuário.
import org.springframework.data.jpa.repository.JpaRepository; // Interface base para repositórios JPA.

import java.util.Optional; // Representa um valor opcional, evitando NullPointerException.

// Interface de repositório para manipulação de RefreshTokens no banco de dados.
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    // Busca um refresh token pelo seu valor.
    Optional<RefreshToken> findByToken(String token); // Correção do erro de digitação em "findByTokoen".

    // Exclui todos os refresh tokens associados a um usuário específico.
    void deleteByUser(User user);
}