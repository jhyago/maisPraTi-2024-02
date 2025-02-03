// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.dto;

// Classe DTO (Data Transfer Object) para representar um Refresh Token.
public class RefreshTokenDTO {

    // Armazena o token de atualização (refresh token).
    private String refreshToken;

    // Método getter para obter o valor do refresh token.
    public String getRefreshToken() {
        return refreshToken;
    }
}