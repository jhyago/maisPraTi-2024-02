// Define o pacote onde esta interface está localizada.
package com.example.jwt_auth.repository;

// Importa a entidade User, que será gerenciada pelo repositório.
import com.example.jwt_auth.model.User;

// Importa a interface JpaRepository, que fornece métodos prontos para operações no banco de dados.
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a anotação Repository, que marca esta interface como um repositório Spring.
import org.springframework.stereotype.Repository;

// Importa a classe Optional, que será usada para trabalhar com valores opcionais.
import java.util.Optional;

// Marca esta interface como um repositório, indicando ao Spring que ela gerencia operações com a entidade User.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Declara um método personalizado para buscar um usuário pelo nome de usuário (username).
    // O retorno é um Optional, o que significa que o resultado pode ou não conter um valor.
    Optional<User> findByUsername(String username);
}