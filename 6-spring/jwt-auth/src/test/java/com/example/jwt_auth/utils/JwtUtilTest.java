package com.example.jwt_auth.utils;

import com.example.jwt_auth.model.CustomUserDetails;
import com.example.jwt_auth.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        jwtUtil.secret = "test_secret";
        jwtUtil.expirationTime = 1000 * 60 * 60;
    }

    @Test
    void generateToken_shouldGenerateValidToken() {
        CustomUserDetails userDetails = new CustomUserDetails(
                "testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        String token = jwtUtil.generateToken(userDetails.getUsername());

        assertNotNull(token);
        assertEquals("testUser", jwtUtil.getUsernameFromToken(token));
    }

    @Test
    void isTokenValid_shouldReturnTrueForValidToken() {
        String token = jwtUtil.generateToken("testUser");
        assertTrue(jwtUtil.isTokenValid(token));
    }
}
