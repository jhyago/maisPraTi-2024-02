package com.example.api_user.controller;

import com.example.api_user.dto.AuthorDTO;
import com.example.api_user.model.Author;
import com.example.api_user.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO save(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }
}
