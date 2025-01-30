// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.controller;

// Importa as classes necessárias para manipular requisições e serviços.
import com.example.jwt_auth.dto.RefreshTokenDTO;
import com.example.jwt_auth.dto.UserDTO;
import com.example.jwt_auth.model.RefreshToken;
import com.example.jwt_auth.model.User; // Representa o modelo de usuário.
import com.example.jwt_auth.service.RefreshTokenService;
import com.example.jwt_auth.service.UserService; // Serviço para lógica relacionada a usuários.
import com.example.jwt_auth.util.JwtUtil; // Classe utilitária para manipulação de tokens JWT.
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência automática.
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity; // Representa as respostas HTTP.
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.security.authentication.AuthenticationManager; // Gerencia o processo de autenticação.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Representa o token de autenticação.
import org.springframework.security.core.Authentication; // Representa o contexto de autenticação.
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*; // Fornece suporte para anotações REST.

import java.util.HashMap;
import java.util.Map;


// Marca esta classe como um controlador REST, gerenciando endpoints relacionados à autenticação.
@RestController
@RequestMapping("/auth") // Define o prefixo de URL para todos os endpoints deste controlador.
@Tag(name = "Autenticação", description="Endpoints para Autenticação")
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

    @Autowired
    private UserDetailsService userDetailsService;

    // /users?page=1&size=7&sortBy=id&sortDirection=asc

    // Endpoint para registrar um novo usuário.
    @PostMapping("/register") // Define o método HTTP POST para a URL "/auth/register".
    @Operation(summary = "Registrar um novo usuário")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Validação: Verifica se o nome de usuário já está em uso.
        if (userService.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Erro: Nome de Usuário já está em uso!");
        }

        // Salva o usuário com a senha criptografada.
        userService.saveUser(user);

        // Retorna uma resposta de sucesso.
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    // Endpoint para login de usuários.
//    @PostMapping("/login") // Define o método HTTP POST para a URL "/auth/login".
//    public ResponseEntity<String> login(@RequestBody User user) {
//        try {
//            // Exibe no console os dados do usuário que está tentando se autenticar (usado para depuração).
//            System.out.println("Tentando autenticar: " + user.getUsername());
//            System.out.println("Senha fornecida: " + user.getPassword());
//
//            // Realiza a autenticação utilizando o gerenciador de autenticação do Spring Security.
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );
//
//            // Exibe no console que o usuário foi autenticado com sucesso.
//            System.out.println("Usuário autenticado com sucesso: " + authentication.getName());
//
//            // Gera um token JWT para o usuário autenticado.
//            String accessToken = jwtUtil.generateToken(authentication.getName());
//            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication.getName());
//
//            Map<String, String> tokens = new HashMap<>();
//            tokens.put("accessToken", accessToken);
//            tokens.put("refreshToken", refreshToken.getToken());
//
//            // Retorna o token no corpo da resposta.
//            return ResponseEntity.ok(tokens);
//
//        } catch (AuthenticationException e) {
//            // Exibe o erro no console e retorna uma resposta de erro 401.
//            throw new AuthenticationException("Usuário ou senha Inválidos") {};
//            }
//    }

    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestBody RefreshTokenDTO refreshToken) {
        try {
            String username = jwtUtil.getUsernameFromToken(refreshToken.getRefreshToken());

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(jwtUtil.isTokenValid(refreshToken.getRefreshToken(), userDetails)) {
                String newAccessToken = jwtUtil.generateToken(username);
                return ResponseEntity.ok(newAccessToken);
            } else {
                return ResponseEntity.status(401).body("Refresh Token Inválido!");
            }
        } catch(Exception error){
            return ResponseEntity.status(401).body("Erro ao processar o Refresh Token!");
        }
    }
}