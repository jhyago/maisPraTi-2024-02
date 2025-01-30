package com.example.jwt_auth.repository;

import com.example.jwt_auth.model.RefreshToken;
import com.example.jwt_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByTokoen(String token);
    void deleteByUser(User user);
}
