// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.controller;

// Importa as classes necessárias para manipular requisições e serviços.
import com.example.jwt_auth.model.User; // Representa o modelo de usuário.
import com.example.jwt_auth.service.UserService; // Serviço para lógica relacionada a usuários.
import com.example.jwt_auth.util.JwtUtil; // Classe utilitária para manipulação de tokens JWT.
import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência automática.
import org.springframework.http.ResponseEntity; // Representa as respostas HTTP.
import org.springframework.security.authentication.AuthenticationManager; // Gerencia o processo de autenticação.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Representa o token de autenticação.
import org.springframework.security.core.Authentication; // Representa o contexto de autenticação.
import org.springframework.web.bind.annotation.*; // Fornece suporte para anotações REST.

import java.util.Optional; // Classe para valores opcionais.

// Marca esta classe como um controlador REST, gerenciando endpoints relacionados à autenticação.
@RestController
@RequestMapping("/auth") // Define o prefixo de URL para todos os endpoints deste controlador.
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

    // Endpoint para registrar um novo usuário.
    @PostMapping("/register") // Define o método HTTP POST para a URL "/auth/register".
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Validação: Verifica se o nome de usuário já está em uso.
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Erro: Nome de usuário já está em uso!"); // Retorna erro 400.
        }

        // Salva o usuário com a senha criptografada.
        userService.saveUser(user);

        // Retorna uma resposta de sucesso.
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    // Endpoint para login de usuários.
    @PostMapping("/login") // Define o método HTTP POST para a URL "/auth/login".
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            // Exibe no console os dados do usuário que está tentando se autenticar (usado para depuração).
            System.out.println("Tentando autenticar: " + user.getUsername());
            System.out.println("Senha fornecida: " + user.getPassword());

            // Realiza a autenticação utilizando o gerenciador de autenticação do Spring Security.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            // Exibe no console que o usuário foi autenticado com sucesso.
            System.out.println("Usuário autenticado com sucesso: " + authentication.getName());

            // Gera um token JWT para o usuário autenticado.
            String token = jwtUtil.generateToken(authentication.getName());

            // Retorna o token no corpo da resposta.
            return ResponseEntity.ok(token);

        } catch (Exception e) {
            // Exibe o erro no console e retorna uma resposta de erro 401.
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return ResponseEntity.status(401).body("Usuário inexistente ou senha inválida");
        }
    }
}