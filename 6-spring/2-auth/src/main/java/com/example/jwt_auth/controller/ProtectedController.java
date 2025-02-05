// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.controller;

// Importa as classes necessárias do Spring Security e Spring Web.
import org.springframework.security.core.Authentication; // Representa a autenticação do usuário.
import org.springframework.web.bind.annotation.GetMapping; // Indica que o método responde a requisições HTTP GET.
import org.springframework.web.bind.annotation.RequestMapping; // Define um prefixo para os endpoints desta classe.
import org.springframework.web.bind.annotation.RestController; // Indica que esta classe é um controlador REST.

// Marca esta classe como um controlador REST.
@RestController
@RequestMapping("/api") // Define que todos os endpoints desta classe terão o prefixo "/api".
public class ProtectedController {

    // Endpoint protegido que só pode ser acessado por usuários autenticados.
    @GetMapping("/protected") // Define que este método responde a requisições HTTP GET na URL "/api/protected".
    public String getProtectedResource(Authentication authentication) {
        // Exibe no console o nome do usuário autenticado.
        System.out.println("Usuário autenticado: " + authentication.getName());

        // Exibe no console as roles (permissões) do usuário autenticado.
        System.out.println("Roles do usuário: " + authentication.getAuthorities());

        // Retorna uma mensagem informando que o usuário acessou um recurso protegido.
        return "Você acessou um recurso protegido!";
    }
}
