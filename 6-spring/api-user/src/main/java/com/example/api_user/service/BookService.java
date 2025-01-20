package com.example.api_user.service;

import com.example.api_user.dto.AuthorDTO;
import com.example.api_user.dto.BookDTO;
import com.example.api_user.dto.UpdateBookRequest;
import com.example.api_user.model.Author;
import com.example.api_user.model.Book;
import com.example.api_user.repository.AuthorRepository;
import com.example.api_user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getId()
                ))
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getId()
                ));
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public Optional<BookDTO> updateBook(Long id, UpdateBookRequest request) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(request.getTitle());
                    bookRepository.save(book);

                    return  new BookDTO(
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor().getId()
                    );
                });
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
