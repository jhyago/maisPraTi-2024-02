// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para manipulação de JWT (JSON Web Token).
import io.jsonwebtoken.Claims; // Representa as declarações (claims) contidas no token.
import io.jsonwebtoken.Jwts; // Classe principal para criar e analisar tokens JWT.
import io.jsonwebtoken.SignatureAlgorithm; // Define o algoritmo de assinatura do token.

// Importa as anotações e classes do Spring.
import org.springframework.beans.factory.annotation.Value; // Para injetar valores de configuração.
import org.springframework.security.core.userdetails.UserDetails; // Representa os detalhes do usuário autenticado.
import org.springframework.stereotype.Component; // Marca a classe como um componente gerenciado pelo Spring.

// Importa classes para manipulação de datas e funções.
import java.util.Date; // Manipula datas e horários.
import java.util.function.Function; // Interface funcional usada para processamento de claims.

// Marca esta classe como um componente gerenciado pelo Spring, permitindo sua injeção em outros lugares.
@Component
public class JwtUtil {

    // Injeta o segredo usado para assinar os tokens JWT a partir do arquivo de configuração.
    @Value("${jwt.secret}")
    public String secret;

    // Injeta o tempo de expiração do token (em milissegundos) a partir do arquivo de configuração.
    @Value("${jwt.expiration}")
    public long expirationTime;

    // Gera um token JWT para o nome de usuário fornecido.
    public String generateToken(String username) {
        var token = Jwts.builder()
                .setSubject(username) // Define o "assunto" (usuário) do token.
                .setIssuedAt(new Date()) // Define a data e hora de emissão do token.
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Define a data de expiração do token.
                .signWith(SignatureAlgorithm.HS256, secret) // Assina o token usando o algoritmo HS256 e o segredo.
                .compact(); // Constrói o token JWT.
        System.out.println(token); // Exibe o token gerado no console (usado para depuração).
        return token; // Retorna o token JWT gerado.
    }

    public String generateRefreshToken(String username) {
        return generateToken(username);
    }

    // Extrai o nome de usuário (subject) de um token JWT.
    public String getUsernameFromToken(String token) {
        try {
            if (!token.matches("^[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+$")) {
                System.out.println("Token JWT malformatado: " + token);
                throw new IllegalArgumentException("Token JWT malformatado.");
            }

            return extractClaim(token, Claims::getSubject); // Extrai o "subject" (nome do usuário) do token.
        } catch (Exception e) {
            System.out.println("Erro ao extrair o username do token: " + e.getMessage());
            throw e; // Propaga a exceção após registrar o erro.
        }
    }

    // Verifica se um token está expirado.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Compara a data de expiração com a data atual.
    }

    // Extrai o nome de usuário diretamente do token.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // Usa a função Claims::getSubject para obter o "subject".
    }

    // Extrai a data de expiração de um token.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // Usa a função Claims::getExpiration para obter a data de expiração.
    }

    // Extrai uma claim específica de um token usando uma função.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token); // Obtém todas as claims do token.
        return claimsResolver.apply(claims); // Aplica a função fornecida para extrair a claim desejada.
    }

    // Extrai todas as claims de um token.
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret) // Configura o segredo usado para validar o token.
                .parseClaimsJws(token) // Analisa o token e retorna suas informações.
                .getBody(); // Obtém o corpo do token (as claims).
    }

    // Verifica se um token é válido para um usuário específico.
    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token); // Extrai o nome de usuário do token.
            // Verifica se o nome de usuário coincide com o do UserDetails e se o token não está expirado.
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (Exception error) {
            // Retorna falso caso ocorra algum erro na validação.
            return false;
        }
    }
}