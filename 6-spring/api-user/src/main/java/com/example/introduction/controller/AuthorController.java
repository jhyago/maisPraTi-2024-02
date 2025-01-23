package com.example.introduction.controller;
// Define o pacote onde a classe está localizada, organizando o projeto.

import com.example.introduction.dto.AuthorDTO;
// Importa a classe `AuthorDTO`, usada para transferir dados sobre autores na API.

import com.example.introduction.dto.UpdateAuthorRequest;
// Importa a classe `UpdateAuthorRequest`, usada para receber dados de atualização de um autor.

import com.example.introduction.model.Author;
// Importa a entidade `Author`, representando o modelo de dados do autor.

import com.example.introduction.service.AuthorService;
// Importa o serviço `AuthorService`, que contém a lógica de negócio relacionada a autores.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.http.ResponseEntity;
// Importa a classe `ResponseEntity`, usada para construir respostas HTTP completas.

import org.springframework.web.bind.annotation.*;
// Importa as anotações do Spring para definir um controlador REST e os mapeamentos de endpoints.

import java.util.List;
// Importa a classe `List`, usada para retornar coleções de objetos.

import java.util.Optional;
// Importa a classe `Optional`, usada para representar valores que podem ou não estar presentes.

@RestController
// Marca a classe como um controlador REST, indicando que os métodos retornarão respostas HTTP diretamente.

@RequestMapping("/authors")
// Define a rota base `/authors` para todos os endpoints desta classe.
public class AuthorController {

    @Autowired
    // Injeta automaticamente uma instância de `AuthorService` para ser usada na classe.
    private AuthorService authorService;

    @GetMapping
    // Mapeia requisições HTTP GET para a rota `/authors`.
    public List<AuthorDTO> getAllAuthors() {
        // Chama o serviço para obter todos os autores e os retorna como uma lista de `AuthorDTO`.
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    // Mapeia requisições HTTP GET para a rota `/authors/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        // Chama o serviço para buscar um autor pelo ID.
        return authorService.getAuthorById(id)
                .map(ResponseEntity::ok)
                // Retorna um `ResponseEntity` com status 200 (OK) se o autor for encontrado.
                .orElse(ResponseEntity.notFound().build());
        // Retorna um `ResponseEntity` com status 404 (Not Found) se o autor não for encontrado.
    }

    @PostMapping
    // Mapeia requisições HTTP POST para a rota `/authors`.
    public Author saveAuthor(@RequestBody Author author) {
        // Chama o serviço para salvar um novo autor. O objeto `author` é recebido do corpo da requisição.
        return authorService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    // Mapeia requisições HTTP PUT para a rota `/authors/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorRequest request) {
        // Chama o serviço para atualizar o autor com base no ID e nos dados fornecidos no corpo da requisição.
        Optional<AuthorDTO> updatedAuthor = authorService.updateAuthor(id, request);
        // Se o autor for atualizado, retorna um `ResponseEntity` com status 200 (OK) e o autor atualizado.
        return updatedAuthor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        // Se o autor não for encontrado, retorna um `ResponseEntity` com status 404 (Not Found).
    }

    @DeleteMapping("/{id}")
    // Mapeia requisições HTTP DELETE para a rota `/authors/{id}`, onde `{id}` é um parâmetro de caminho.
    public void deleteAuthor(@PathVariable Long id) {
        // Chama o serviço para deletar o autor com base no ID fornecido.
        authorService.deleteAuthor(id);
    }
}