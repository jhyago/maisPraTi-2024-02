package com.example.jwt_auth.service;

import com.example.jwt_auth.model.RefreshToken;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.RefreshTokenRepository;
import com.example.jwt_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final long REFRESH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));

        refreshTokenRepository.deleteByUser(user);

        RefreshToken refreshToken = new RefreshToken(UUID.randomUUID().toString(), Instant.now().plusSeconds(REFRESH_TOKEN_EXPIRATION), user);

        return refreshTokenRepository.save(refreshToken);
    }
}
