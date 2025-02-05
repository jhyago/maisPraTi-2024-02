package com.example.introduction.service;

import com.example.introduction.dto.AuthorDTO;
import com.example.introduction.dto.UpdateAuthorRequest;
import com.example.introduction.model.Author;
import com.example.introduction.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return  authorRepository.findAll().stream()
                .map(author -> new AuthorDTO(
                        author.getId(),
                        author.getName(),
                        author.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public Optional<AuthorDTO> getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(author -> new AuthorDTO(
                        author.getId(),
                        author.getName(),
                        author.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList())
                ));
    }

    public Optional<AuthorDTO> updateAuthor(Long id, UpdateAuthorRequest request) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(request.getName());
                    authorRepository.save(author);
                    return  new AuthorDTO(
                            author.getId(),
                            author.getName(),
                            author.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList())
                    );
                });
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
