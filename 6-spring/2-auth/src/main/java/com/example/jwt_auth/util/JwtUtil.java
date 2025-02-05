// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para manipulação de JWT (JSON Web Token).
import io.jsonwebtoken.Claims; // Representa as declarações (claims) contidas no token.
import io.jsonwebtoken.Jwts; // Classe principal para criar e analisar tokens JWT.
import io.jsonwebtoken.SignatureAlgorithm; // Define o algoritmo de assinatura do token.

// Importa as anotações e classes do Spring.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; // Para injetar valores de configuração do application.properties.
import org.springframework.security.core.userdetails.UserDetails; // Representa os detalhes do usuário autenticado.
import org.springframework.stereotype.Component; // Marca a classe como um componente gerenciado pelo Spring.

// Importa classes para manipulação de datas e funções.
import java.util.Date; // Manipula datas e horários.
import java.util.function.Function; // Interface funcional usada para processamento de claims.

// Marca esta classe como um componente gerenciado pelo Spring, permitindo sua injeção automática em outras partes da aplicação.
@Component
public class JwtUtil {

    // Injeta a classe RsaKeyProvider, responsável por fornecer as chaves RSA para assinatura e validação do JWT.
    @Autowired
    private RsaKeyProvider rsaKeyProvider;

    // Injeta o tempo de expiração do token (em milissegundos) a partir do arquivo de configuração.
    @Value("${jwt.expiration}")
    public long expirationTime;

    // Método para gerar um token JWT a partir de um nome de usuário.
    public String generateToken(String username) {
        // Cria um token JWT contendo o nome de usuário como "subject" e define sua data de expiração.
        var token = Jwts.builder()
                .setSubject(username) // Define o "assunto" (usuário) do token.
                .setIssuedAt(new Date()) // Define a data e hora de emissão do token.
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Define a data de expiração do token.
                .signWith(rsaKeyProvider.getPrivateKey(), SignatureAlgorithm.RS256) // Assina o token com a chave privada usando RSA.
                .compact(); // Constrói o token JWT.

        // Exibe o token gerado no console (para depuração).
        System.out.println("Token gerado: " + token);

        // Retorna o token JWT gerado.
        return token;
    }

    // Método para gerar um refresh token (com a mesma lógica do token normal).
    public String generateRefreshToken(String username) {
        return generateToken(username);
    }

    // Método para extrair o nome de usuário (subject) de um token JWT.
    public String getUsernameFromToken(String token) {
        try {
            // Verifica se o token está no formato correto usando uma expressão regular.
            if (!token.matches("^[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+$")) {
                System.out.println("Token JWT malformatado: " + token);
                throw new IllegalArgumentException("Token JWT malformatado.");
            }

            // Extrai o nome de usuário da claim "subject".
            return extractClaim(token, Claims::getSubject);
        } catch (Exception e) {
            System.out.println("Erro ao extrair o username do token: " + e.getMessage());
            throw e; // Propaga a exceção após registrar o erro.
        }
    }

    // Método privado para verificar se um token está expirado.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Compara a data de expiração com a data atual.
    }

    // Método para extrair o nome de usuário diretamente do token.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // Usa a função Claims::getSubject para obter o "subject".
    }

    // Método privado para extrair a data de expiração de um token.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // Usa a função Claims::getExpiration para obter a data de expiração.
    }

    // Método genérico para extrair uma claim específica de um token usando uma função.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token); // Obtém todas as claims do token.
        return claimsResolver.apply(claims); // Aplica a função fornecida para extrair a claim desejada.
    }

    // Método privado para extrair todas as claims (informações) de um token.
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(rsaKeyProvider.getPublicKey()) // Configura a chave pública usada para validar o token.
                .parseClaimsJws(token) // Analisa o token e retorna suas informações.
                .getBody(); // Obtém o corpo do token (as claims).
    }

    // Método para verificar se um token é válido para um determinado usuário.
    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token); // Extrai o nome de usuário do token.
            // Verifica se o nome de usuário extraído do token corresponde ao do usuário autenticado e se o token não está expirado.
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (Exception error) {
            // Retorna falso caso ocorra algum erro na validação.
            return false;
        }
    }
}