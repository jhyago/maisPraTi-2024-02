// Define o pacote onde esta interface está localizada.
package com.example.jwt_auth.repository;

// Importa as classes necessárias do Spring Data JPA e do modelo de usuário.
import com.example.jwt_auth.model.User; // Modelo que representa um usuário.
import org.springframework.data.domain.Page; // Representa uma página de resultados paginados.
import org.springframework.data.domain.Pageable; // Interface para suporte à paginação e ordenação.
import org.springframework.data.jpa.repository.JpaRepository; // Interface base para repositórios JPA.
import org.springframework.stereotype.Repository; // Define esta interface como um componente de repositório do Spring.

import java.util.Optional; // Representa um valor opcional, evitando NullPointerException.

// Marca esta interface como um repositório do Spring para interação com o banco de dados.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Busca um usuário pelo nome de usuário (username).
    Optional<User> findByUsername(String username);

    // Retorna uma lista paginada de usuários.
    Page<User> findAll(Pageable pageable);
}