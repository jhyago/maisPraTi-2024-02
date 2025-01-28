package com.example.jwt_auth.utils;

import com.example.jwt_auth.model.CustomUserDetails;
import com.example.jwt_auth.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;
    private UserDetailsService userDetailsService;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        jwtUtil.secret = "5T8hpBGUKIu1foBEpdN6+XJF/JJvX0sXq9a7vmFxHhQ=";
        jwtUtil.expirationTime = 1000 * 60 * 60; // 1 hora
        System.out.println("Inicializando o teste com o segredo e tempo de expiração: " + jwtUtil.secret + ", " + jwtUtil.expirationTime + " ms");
    }

    @Test
    void generateToken_shouldGenerateValidToken() {
        CustomUserDetails userDetails = new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        String token = jwtUtil.generateToken(userDetails.getUsername());
        System.out.println("Token gerado: " + token);

        String[] parts = token.split("\\.");
        assertTrue(parts.length == 3, "O token JWT deve ter 3 partes.");
        System.out.println("Token é válido, passou no teste.");
    }

    @Test
    void isTokenValid_shouldReturnTrueForValidToken() {
        String token = jwtUtil.generateToken("testUser");

        System.out.println("Token válido gerado: " + token);

        assertTrue(jwtUtil.isTokenValid(token, new CustomUserDetails("testUser", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))));

        System.out.println("Token válido passou na validação.");
    }

    @Test
    void isTokenValid_shouldReturnFalseForExpiredToken() throws InterruptedException {
        jwtUtil.expirationTime = 1000; // 1 segundo
        String token = jwtUtil.generateToken("testUser");

        System.out.println("Token gerado com expiração de 1 segundo: " + token);

        // Aguarda 2 segundos para garantir que o token expire
        Thread.sleep(2000);

        // Verifica se o token expirou
        assertFalse(jwtUtil.isTokenValid(token, new CustomUserDetails("testUser", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))));

        System.out.println("Token expirado foi corretamente invalidado.");
    }

    @Test
    void getUsernameFromToken_shouldThrowExceptionForMalformedToken() {
        String malformedToken = "malformed.token.value";

        System.out.println("Tentando obter o nome de usuário a partir de um token malformado: " + malformedToken);

        // Verifica se o método lança uma exceção ao tentar extrair o nome de usuário de um token malformado
        assertThrows(IllegalArgumentException.class, () -> {
            jwtUtil.getUsernameFromToken(malformedToken);
        });

        System.out.println("A exceção esperada foi lançada para token malformado.");
    }

    @Test
    void isTokenValid_shouldReturnFalseForInvalidToken() {
        String validToken = jwtUtil.generateToken("testUser");
        String invalidToken = validToken + "invalid";

        System.out.println("Token gerado: " + validToken);
        System.out.println("Token modificado para ser inválido: " + invalidToken);

        assertFalse(jwtUtil.isTokenValid(invalidToken, new CustomUserDetails("testUser", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))));

        System.out.println("Token inválido foi corretamente invalidado.");
    }
}

