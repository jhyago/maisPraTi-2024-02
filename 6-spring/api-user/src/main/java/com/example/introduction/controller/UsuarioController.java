package com.example.introduction.controller;
// Define o pacote onde a classe está localizada, organizando o projeto.

import com.example.introduction.dto.UsuarioDTO;
// Importa a classe `UsuarioDTO`, usada para transferir dados de usuários na API.

import com.example.introduction.model.Usuario;
// Importa a entidade `Usuario`, representando o modelo de dados do usuário.

import com.example.introduction.service.UsuarioService;
// Importa o serviço `UsuarioService`, que contém a lógica de negócio relacionada a usuários.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.http.ResponseEntity;
// Importa a classe `ResponseEntity`, usada para construir respostas HTTP completas.

import org.springframework.web.bind.annotation.*;
// Importa as anotações do Spring para definir um controlador REST e os mapeamentos de endpoints.

// Importa a classe `List`, usada para retornar coleções de objetos.

import java.util.Optional;
// Importa a classe `Optional`, usada para representar valores que podem ou não estar presentes.

@RestController
// Marca a classe como um controlador REST, indicando que os métodos retornarão respostas HTTP diretamente.

@RequestMapping("/usuarios")
// Define a rota base `/usuarios` para todos os endpoints desta classe.
public class UsuarioController {

    @Autowired
    // Injeta automaticamente uma instância de `UsuarioService` para ser usada na classe.
    private UsuarioService usuarioService;

    @PostMapping
    // Mapeia requisições HTTP POST para a rota `/usuarios`.
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody Usuario usuario) {
        // Recebe um objeto `Usuario` do corpo da requisição e chama o serviço para salvar o usuário.

        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        // Salva o usuário no banco de dados usando o serviço.

        return ResponseEntity.ok(new UsuarioDTO(savedUsuario.getId(), savedUsuario.getNome(), savedUsuario.getProfile().getId()));
        // Retorna uma resposta HTTP com status 200 (OK) e um objeto `UsuarioDTO` representando o usuário salvo.
    }

    @PutMapping("/{id}")
    // Mapeia requisições HTTP PUT para a rota `/usuarios/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Recebe o ID do usuário e um objeto `Usuario` do corpo da requisição para atualizar o usuário correspondente.

        Optional<UsuarioDTO> updatedUsuario = usuarioService.updateUsuario(id, usuario);
        // Chama o serviço para atualizar o usuário e obtém um `Optional<UsuarioDTO>` com o usuário atualizado (ou vazio, se não encontrado).

        return updatedUsuario.map(ResponseEntity::ok)
                // Retorna uma resposta HTTP com status 200 (OK) se o usuário foi atualizado.
                .orElseGet(() -> ResponseEntity.notFound().build());
        // Retorna uma resposta HTTP com status 404 (Not Found) se o usuário não foi encontrado.
    }

    @GetMapping("/{id}")
    // Mapeia requisições HTTP GET para a rota `/usuarios/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        // Recebe o ID do usuário como parâmetro de caminho e chama o serviço para buscar o usuário correspondente.

        Optional<UsuarioDTO> usuario = usuarioService.getUsuario(id);
        // Obtém um `Optional<UsuarioDTO>` com o usuário encontrado (ou vazio, se não encontrado).

        return usuario.map(ResponseEntity::ok)
                // Retorna uma resposta HTTP com status 200 (OK) se o usuário foi encontrado.
                .orElseGet(() -> ResponseEntity.notFound().build());
        // Retorna uma resposta HTTP com status 404 (Not Found) se o usuário não foi encontrado.
    }

    @DeleteMapping("/{id}")
    // Mapeia requisições HTTP DELETE para a rota `/usuarios/{id}`, onde `{id}` é um parâmetro de caminho.
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        // Recebe o ID do usuário como parâmetro de caminho e chama o serviço para deletar o usuário correspondente.

        usuarioService.deleteUsuario(id);
        // Deleta o usuário no banco de dados usando o serviço.

        return ResponseEntity.noContent().build();
        // Retorna uma resposta HTTP com status 204 (No Content) indicando que o usuário foi deletado com sucesso.
    }
}