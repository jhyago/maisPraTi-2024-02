package com.example.api_user.service;

import com.example.api_user.dto.AuthorDTO;
import com.example.api_user.dto.UpdateAuthorRequest;
import com.example.api_user.model.Author;
import com.example.api_user.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
