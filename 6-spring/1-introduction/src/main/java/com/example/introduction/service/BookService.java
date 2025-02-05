package com.example.introduction.service;
// Define o pacote onde a classe está localizada, organizando o projeto.

// Importa o DTO `AuthorDTO`, que representa os dados simplificados de um autor.

import com.example.introduction.dto.BookDTO;
// Importa o DTO `BookDTO`, que representa os dados simplificados de um livro.

import com.example.introduction.dto.UpdateBookRequest;
// Importa o DTO `UpdateBookRequest`, usado para receber os dados de atualização de um livro.

// Importa a entidade `Author`, representando o modelo de dados de um autor.

import com.example.introduction.model.Book;
// Importa a entidade `Book`, representando o modelo de dados de um livro.

import com.example.introduction.repository.AuthorRepository;
// Importa o repositório `AuthorRepository`, que gerencia as operações de banco de dados para a entidade `Author`.

import com.example.introduction.repository.BookRepository;
// Importa o repositório `BookRepository`, que gerencia as operações de banco de dados para a entidade `Book`.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.stereotype.Service;
// Importa a anotação `@Service`, usada para marcar a classe como um componente de serviço do Spring.

import java.util.List;
// Importa a classe `List`, usada para retornar coleções de objetos.

import java.util.Optional;
// Importa a classe `Optional`, usada para representar valores que podem ou não estar presentes.

import java.util.stream.Collectors;
// Importa a classe `Collectors`, usada para transformar fluxos de dados (`Stream`) em coleções ou outros tipos.

@Service
// Marca a classe como um serviço do Spring, indicando que contém lógica de negócios.
public class BookService {

    @Autowired
    // Injeta automaticamente uma instância de `BookRepository` para gerenciar operações relacionadas a livros.
    private BookRepository bookRepository;

    @Autowired
    // Injeta automaticamente uma instância de `AuthorRepository` para gerenciar operações relacionadas a autores.
    private AuthorRepository authorRepository;

    public List<BookDTO> getAllBooks() {
        // Retorna uma lista de todos os livros no banco de dados como uma lista de `BookDTO`.

        return bookRepository.findAll().stream()
                // Obtém todos os livros do repositório e os transforma em um fluxo de dados.

                .map(book -> new BookDTO(
                        // Mapeia cada entidade `Book` em um objeto `BookDTO`.
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getId()
                ))
                .collect(Collectors.toList());
        // Coleta os objetos `BookDTO` gerados no fluxo em uma lista.
    }

    public Optional<BookDTO> getBookById(Long id) {
        // Retorna um livro pelo ID como um `Optional<BookDTO>`.

        return bookRepository.findById(id)
                // Busca o livro pelo ID no repositório, retornando um `Optional<Book>`.

                .map(book -> new BookDTO(
                        // Se o livro for encontrado, mapeia-o para um objeto `BookDTO`.
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getId()
                ));
    }

    public Book saveBook(Book book) {
        // Salva um livro no banco de dados e retorna a entidade salva.

        return bookRepository.save(book);
    }

    public Optional<BookDTO> updateBook(Long id, UpdateBookRequest request) {
        // Atualiza um livro existente com base no ID e nos dados fornecidos no corpo da requisição.

        return bookRepository.findById(id)
                // Busca o livro pelo ID no repositório.

                .map(book -> {
                    // Se o livro for encontrado, executa a atualização.

                    book.setTitle(request.getTitle());
                    // Atualiza o título do livro com o valor recebido no `UpdateBookRequest`.

                    bookRepository.save(book);
                    // Salva o livro atualizado no repositório.

                    return new BookDTO(
                            // Retorna um novo objeto `BookDTO` representando o livro atualizado.
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor().getId()
                    );
                });
    }

    public void deleteBook(Long id) {
        // Deleta um livro do banco de dados com base no ID fornecido.

        bookRepository.deleteById(id);
    }
}