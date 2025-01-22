package com.example.jwt_auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    // Rota protegida que retorna uma mensagem de sucesso.
    @GetMapping("/protected")
    public String getProtectedResource(Authentication authentication) {
        System.out.println("Usuário autenticado: " + authentication.getName());
        System.out.println("Roles do usuário: " + authentication.getAuthorities());
        return "Você acessou um recurso protegido!";
    }
}
