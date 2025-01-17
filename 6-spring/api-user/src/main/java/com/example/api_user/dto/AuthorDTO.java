package com.example.api_user.dto;

import java.util.List;

public class AuthorDTO {
    private Long id;
    private String name;
    private List<BookResumidoDTO> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookResumidoDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookResumidoDTO> books) {
        this.books = books;
    }
}
