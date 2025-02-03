// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.controller;

// Importa as classes necessárias para manipular requisições e serviços.
import com.example.jwt_auth.dto.RefreshTokenDTO; // DTO para requisições de refresh token.
import com.example.jwt_auth.dto.UserDTO; // DTO para transferir dados de usuário.
import com.example.jwt_auth.model.RefreshToken; // Modelo que representa um token de atualização.
import com.example.jwt_auth.model.User; // Modelo que representa um usuário.
import com.example.jwt_auth.service.RefreshTokenService; // Serviço responsável pelo gerenciamento do refresh token.
import com.example.jwt_auth.service.UserService; // Serviço que contém a lógica relacionada a usuários.
import com.example.jwt_auth.util.JwtUtil; // Classe utilitária para manipulação de tokens JWT.
import io.swagger.v3.oas.annotations.Operation; // Anotação para documentação de operações no Swagger.
import io.swagger.v3.oas.annotations.tags.Tag; // Define categorias de endpoints no Swagger.
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired; // Permite injeção automática de dependências pelo Spring.
import org.springframework.data.domain.PageRequest; // Representa uma requisição paginada.
import org.springframework.data.domain.Pageable; // Interface para paginação de dados.
import org.springframework.data.domain.Sort; // Permite definir critérios de ordenação.
import org.springframework.http.ResponseEntity; // Representa as respostas HTTP.
import org.springframework.security.authentication.AuthenticationManager; // Gerencia o processo de autenticação.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Representa um token de autenticação (usuário e senha).
import org.springframework.security.core.Authentication; // Representa a autenticação de um usuário no contexto do Spring Security.
import org.springframework.security.core.AuthenticationException; // Exceção lançada em falhas de autenticação.
import org.springframework.security.core.userdetails.UserDetails; // Representa detalhes de um usuário autenticado.
import org.springframework.security.core.userdetails.UserDetailsService; // Serviço para carregar detalhes do usuário.
import org.springframework.web.bind.annotation.*; // Fornece suporte para anotações REST.

import java.util.HashMap;
import java.util.Map;

// Marca esta classe como um controlador REST, responsável por gerenciar endpoints de autenticação.
@RestController
@RequestMapping("/auth") // Define o prefixo "/auth" para todos os endpoints desta classe.
@Tag(name = "Autenticação", description = "Endpoints para autenticação") // Documenta a API no Swagger.
public class AuthController {

    // Injeta o gerenciador de autenticação do Spring Security.
    @Autowired
    private AuthenticationManager authenticationManager;

    // Injeta a classe utilitária para manipulação de tokens JWT.
    @Autowired
    private JwtUtil jwtUtil;

    // Injeta o serviço relacionado a usuários.
    @Autowired
    private UserService userService;

    // Injeta o serviço de carregamento de detalhes do usuário.
    @Autowired
    private UserDetailsService userDetailsService;

    // Endpoint para registrar um novo usuário.
    @PostMapping("/register") // Define que este método será acessado via HTTP POST em "/auth/register".
    @Operation(summary = "Registrar um novo usuário") // Documentação no Swagger.
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Validação: Verifica se o nome de usuário já está em uso.
        if (userService.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Erro: Nome de usuário já está em uso!");
        }

        // Salva o usuário no banco de dados, aplicando criptografia na senha.
        userService.saveUser(user);

        // Retorna uma resposta de sucesso com status 200 (OK).
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    // **Método de login comentado**
    // O trecho abaixo está comentado e poderia ser utilizado para autenticar usuários via senha.
    /*
    @PostMapping("/login") // Define que este método será acessado via HTTP POST em "/auth/login".
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            // Exibe no console os dados do usuário que está tentando se autenticar (apenas para depuração).
            System.out.println("Tentando autenticar: " + user.getUsername());
            System.out.println("Senha fornecida: " + user.getPassword());

            // Realiza a autenticação no Spring Security utilizando o gerenciador de autenticação.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            // Exibe no console que o usuário foi autenticado com sucesso.
            System.out.println("Usuário autenticado com sucesso: " + authentication.getName());

            // Gera um token JWT para o usuário autenticado.
            String accessToken = jwtUtil.generateToken(authentication.getName());
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication.getName());

            // Cria um mapa para armazenar os tokens de acesso e refresh.
            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", accessToken);
            tokens.put("refreshToken", refreshToken.getToken());

            // Retorna os tokens na resposta HTTP.
            return ResponseEntity.ok(tokens);

        } catch (AuthenticationException e) {
            // Lança uma exceção de autenticação em caso de erro (usuário ou senha inválidos).
            throw new AuthenticationException("Usuário ou senha inválidos") {};
        }
    }
    */

    // Endpoint para renovar um token JWT utilizando um refresh token.
    @PostMapping("/refresh-token") // Define que este método será acessado via HTTP POST em "/auth/refresh-token".
    @Operation(summary = "Renovar um token de acesso utilizando um refresh token") // Documentação no Swagger.
    public ResponseEntity<String> refreshToken(@RequestBody RefreshTokenDTO refreshToken) {
        try {
            // Extrai o nome de usuário do refresh token.
            String username = jwtUtil.getUsernameFromToken(refreshToken.getRefreshToken());

            // Carrega os detalhes do usuário a partir do banco de dados.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Verifica se o refresh token ainda é válido.
            if (jwtUtil.isTokenValid(refreshToken.getRefreshToken(), userDetails)) {
                // Gera um novo token de acesso JWT.
                String newAccessToken = jwtUtil.generateToken(username);
                return ResponseEntity.ok(newAccessToken); // Retorna o novo token de acesso.
            } else {
                // Retorna erro 401 (Não autorizado) se o refresh token for inválido.
                return ResponseEntity.status(401).body("Refresh Token inválido!");
            }
        } catch (Exception error) {
            // Retorna erro 401 caso ocorra um problema ao processar o refresh token.
            return ResponseEntity.status(401).body("Erro ao processar o Refresh Token!");
        }
    }
}
