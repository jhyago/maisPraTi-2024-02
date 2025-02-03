// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.controller;

// Importa as classes necessárias para manipular requisições e serviços.
import com.example.jwt_auth.dto.UserDTO; // DTO para transferir dados do usuário sem expor a entidade completa.
import com.example.jwt_auth.service.UserService; // Serviço que contém a lógica para manipulação de usuários.
import org.springframework.beans.factory.annotation.Autowired; // Permite a injeção automática de dependências pelo Spring.
import org.springframework.data.domain.Page; // Representa uma página de resultados paginados.
import org.springframework.data.domain.PageRequest; // Classe para criar uma solicitação de página.
import org.springframework.data.domain.Pageable; // Interface para paginação de dados.
import org.springframework.data.domain.Sort; // Permite definir critérios de ordenação.
import org.springframework.http.ResponseEntity; // Representa as respostas HTTP.
import org.springframework.web.bind.annotation.GetMapping; // Define que um método responde a requisições HTTP GET.
import org.springframework.web.bind.annotation.RequestMapping; // Define um prefixo para os endpoints desta classe.
import org.springframework.web.bind.annotation.RequestParam; // Define parâmetros opcionais na URL.
import org.springframework.web.bind.annotation.RestController; // Marca esta classe como um controlador REST.

// Marca esta classe como um controlador REST.
@RestController
@RequestMapping("/users") // Define que todos os endpoints desta classe terão o prefixo "/users".
public class UsersController {

    // Injeta o serviço responsável pela lógica de usuários.
    @Autowired
    private UserService userService;

    // Endpoint para buscar todos os usuários com suporte a paginação e ordenação.
    @GetMapping // Define que este método responde a requisições HTTP GET na URL "/users".
    public ResponseEntity<Page<UserDTO>> getAllUsers(
            @RequestParam(defaultValue = "0") int page, // Define o número da página (padrão: 0).
            @RequestParam(defaultValue = "10") int size, // Define o tamanho da página (padrão: 10 usuários por página).
            @RequestParam(defaultValue = "id") String sortBy, // Define o campo pelo qual os resultados serão ordenados (padrão: "id").
            @RequestParam(defaultValue = "asc") String sortDirection // Define a direção da ordenação (ascendente ou descendente, padrão: "asc").
    ) {
        // Define a direção da ordenação com base no parâmetro recebido.
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        // Cria um objeto Pageable para configurar paginação e ordenação dos resultados.
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        // Obtém a lista paginada de usuários do serviço.
        Page<UserDTO> users = userService.getAllUsers(pageable);

        // Retorna a lista paginada de usuários no corpo da resposta HTTP com status 200 (OK).
        return ResponseEntity.ok(users);
    }
}