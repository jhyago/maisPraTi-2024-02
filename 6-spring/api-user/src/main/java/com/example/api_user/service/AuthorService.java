package com.example.api_user.service;

import com.example.api_user.dto.AuthorDTO;
import com.example.api_user.dto.BookResumidoDTO;
import com.example.api_user.model.Author;
import com.example.api_user.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Autor com ID " + id + " não encontrado"));
        return convertToDTO(author);
    }

    public AuthorDTO saveAuthor(Author author) {
        Author savedAuthor = authorRepository.save(author);
        return convertToDTO(savedAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.findById(id)
                .ifPresentOrElse(
                        authorRepository::delete,
                        () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"); }
                );
    }

    public void updateAuthor(Long id, Author author) {
        authorRepository.findById(id)
                .map(existingAuthor -> {
                    author.setId(existingAuthor.getId());
                    return authorRepository.save(author);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
    }

    private AuthorDTO convertToDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());

        if (author.getBooks() != null) {
            dto.setBooks(author.getBooks().stream()
                    .map(book -> new BookResumidoDTO(book.getId(), book.getTitle()))
                    .collect(Collectors.toList()));
        }

        return dto;
    }

}
