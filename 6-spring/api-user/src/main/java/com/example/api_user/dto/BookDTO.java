package com.example.api_user.dto;

public class BookDTO {
    private Long id;
    private String title;
    private AuthorResumidoDTO author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorResumidoDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorResumidoDTO author) {
        this.author = author;
    }
}
