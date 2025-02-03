// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.service;

// Importa as classes do modelo de Refresh Token e Usuário.
import com.example.jwt_auth.model.RefreshToken;
import com.example.jwt_auth.model.User;

// Importa os repositórios que interagem com o banco de dados.
import com.example.jwt_auth.repository.RefreshTokenRepository;
import com.example.jwt_auth.repository.UserRepository;

// Importa a anotação @Autowired para injeção de dependências.
import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação @Service, que define esta classe como um serviço gerenciado pelo Spring.
import org.springframework.stereotype.Service;

// Importa classes para manipulação de tempo e geração de UUIDs.
import java.time.Instant;
import java.util.UUID;

// Marca esta classe como um serviço, permitindo que seja gerenciada pelo Spring.
@Service
public class RefreshTokenService {

    // Define a validade do refresh token: 7 dias (em segundos).
    private final long REFRESH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60;

    // Injeta o repositório de refresh tokens para manipular tokens no banco de dados.
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    // Injeta o repositório de usuários para buscar usuários no banco de dados.
    @Autowired
    private UserRepository userRepository;

    // Método para criar um refresh token para um usuário específico.
    public RefreshToken createRefreshToken(String username) {
        // Busca o usuário no banco de dados pelo nome de usuário.
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));

        // Remove qualquer refresh token antigo associado ao usuário antes de gerar um novo.
        refreshTokenRepository.deleteByUser(user);

        // Cria um novo refresh token com um UUID único e uma data de expiração.
        RefreshToken refreshToken = new RefreshToken(
                UUID.randomUUID().toString(), // Gera um identificador único para o token.
                Instant.now().plusSeconds(REFRESH_TOKEN_EXPIRATION), // Define a data de expiração do token.
                user // Associa o token ao usuário.
        );

        // Salva e retorna o novo refresh token.
        return refreshTokenRepository.save(refreshToken);
    }
}