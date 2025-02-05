// Define o pacote onde este teste está localizado.
package com.example.jwt_auth.utils;

// Importa as classes necessárias para manipulação de JWT e autenticação de usuários.
import com.example.jwt_auth.model.CustomUserDetails;
import com.example.jwt_auth.util.JwtUtil;

// Importa classes do JUnit para testes.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

// Importa utilitários para manipulação de listas.
import java.util.Collections;

// Importa métodos estáticos para asserções e verificações.
import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil; // Instância do utilitário de JWT.

    private UserDetailsService userDetailsService; // Serviço para carregar detalhes do usuário.

    // Configuração inicial antes de cada teste.
    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(); // Instancia manualmente a classe JwtUtil.

        // Define um segredo fixo para teste (simulado, não recomendado em produção).
        jwtUtil.secret = "5T8hpBGUKIu1foBEpdN6+XJF/JJvX0sXq9a7vmFxHhQ=";

        // Define o tempo de expiração do token como 1 hora.
        jwtUtil.expirationTime = 1000 * 60 * 60;

        // Exibe informações de inicialização.
        System.out.println("Inicializando o teste com o segredo e tempo de expiração: "
                + jwtUtil.secret + ", " + jwtUtil.expirationTime + " ms");
    }

    // Teste: Deve gerar um token válido.
    @Test
    void generateToken_shouldGenerateValidToken() {
        // Cria um usuário fictício para teste.
        CustomUserDetails userDetails = new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        // Gera um token JWT para o usuário.
        String token = jwtUtil.generateToken(userDetails.getUsername());

        // Exibe o token gerado.
        System.out.println("Token gerado: " + token);

        // Verifica se o token possui três partes (header, payload, signature).
        String[] parts = token.split("\\.");
        assertTrue(parts.length == 3, "O token JWT deve ter 3 partes.");

        System.out.println("Token é válido, passou no teste.");
    }

    // Teste: Deve validar um token corretamente.
    @Test
    void isTokenValid_shouldReturnTrueForValidToken() {
        // Gera um token para o usuário fictício.
        String token = jwtUtil.generateToken("testUser");

        System.out.println("Token válido gerado: " + token);

        // Verifica se o token é válido para o usuário correto.
        assertTrue(jwtUtil.isTokenValid(token, new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        )));

        System.out.println("Token válido passou na validação.");
    }

    // Teste: Deve retornar falso para um token expirado.
    @Test
    void isTokenValid_shouldReturnFalseForExpiredToken() throws InterruptedException {
        // Define um tempo de expiração curto para simular um token expirado.
        jwtUtil.expirationTime = 1000; // 1 segundo

        // Gera um token com expiração curta.
        String token = jwtUtil.generateToken("testUser");

        System.out.println("Token gerado com expiração de 1 segundo: " + token);

        // Aguarda 2 segundos para garantir que o token expire.
        Thread.sleep(2000);

        // Verifica se o token agora é inválido.
        assertFalse(jwtUtil.isTokenValid(token, new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        )));

        System.out.println("Token expirado foi corretamente invalidado.");
    }

    // Teste: Deve lançar exceção para um token malformado.
    @Test
    void getUsernameFromToken_shouldThrowExceptionForMalformedToken() {
        // Cria um token malformado manualmente.
        String malformedToken = "malformed.token.value";

        System.out.println("Tentando obter o nome de usuário a partir de um token malformado: " + malformedToken);

        // Verifica se uma exceção é lançada ao tentar extrair o nome de usuário de um token inválido.
        assertThrows(IllegalArgumentException.class, () -> {
            jwtUtil.getUsernameFromToken(malformedToken);
        });

        System.out.println("A exceção esperada foi lançada para token malformado.");
    }

    // Teste: Deve retornar falso para um token inválido.
    @Test
    void isTokenValid_shouldReturnFalseForInvalidToken() {
        // Gera um token válido.
        String validToken = jwtUtil.generateToken("testUser");

        // Modifica o token adicionando caracteres extras, tornando-o inválido.
        String invalidToken = validToken + "invalid";

        System.out.println("Token gerado: " + validToken);
        System.out.println("Token modificado para ser inválido: " + invalidToken);

        // Verifica se o token alterado é corretamente identificado como inválido.
        assertFalse(jwtUtil.isTokenValid(invalidToken, new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        )));

        System.out.println("Token inválido foi corretamente invalidado.");
    }
}