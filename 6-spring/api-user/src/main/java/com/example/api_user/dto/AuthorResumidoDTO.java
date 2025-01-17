package com.example.api_user.dto;

public class AuthorResumidoDTO {
    private String name;

    public AuthorResumidoDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
