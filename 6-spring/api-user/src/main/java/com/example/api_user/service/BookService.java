package com.example.api_user.service;

import com.example.api_user.dto.AuthorResumidoDTO;
import com.example.api_user.dto.BookDTO;
import com.example.api_user.model.Author;
import com.example.api_user.model.Book;
import com.example.api_user.repository.AuthorRepository;
import com.example.api_user.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;


    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro com ID " + id + " não encontrado"));
        return convertToDTO(book);
    }

    public BookDTO saveBook(Book book) {
        if (book.getAuthor() == null || book.getAuthor().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autor é obrigatório");
        }

        Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Autor com ID " + book.getAuthor().getId() + " não encontrado"));

        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .ifPresentOrElse(
                        bookRepository::delete,
                        () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"); }
                );
    }

    public void updateBook(Long id, Book book) {
        bookRepository.findById(id)
                .map(existingBook -> {
                    book.setId(existingBook.getId());
                    book.setAuthor(existingBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());

        if (book.getAuthor() != null) {
            dto.setAuthor(new AuthorResumidoDTO(book.getAuthor().getName()));
        }

        return dto;
    }
}
