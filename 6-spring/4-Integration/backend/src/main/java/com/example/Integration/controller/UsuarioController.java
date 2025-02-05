package com.example.Integration.controller; // Define o pacote onde o controlador está localizado

import com.example.Integration.model.Curso; // Importa a classe Curso do pacote de modelos
import com.example.Integration.model.Usuario; // Importa a classe Usuario do pacote de modelos
import com.example.Integration.repository.CursoRepository; // Importa o repositório para a entidade Curso
import com.example.Integration.repository.UsuarioRepository; // Importa o repositório para a entidade Usuario
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências do Spring
import org.springframework.http.HttpStatus; // Importa os status HTTP para construir respostas
import org.springframework.http.ResponseEntity; // Importa a classe para construir respostas HTTP
import org.springframework.security.authentication.AuthenticationManager; // Importa a interface para gerenciar autenticações
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Importa o token que encapsula as credenciais de autenticação
import org.springframework.security.core.Authentication; // Importa a interface que representa a autenticação
import org.springframework.security.core.context.SecurityContextHolder; // Importa a classe que permite manipular o contexto de segurança
import org.springframework.web.bind.annotation.*; // Importa as anotações para mapeamento de requisições REST

import java.util.HashMap; // Importa a classe HashMap para manipulação de mapas
import java.util.List; // Importa a interface List para manipulação de listas
import java.util.Map; // Importa a interface Map para manipulação de mapas

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/usuarios") // Define a rota base para todas as requisições deste controlador
public class UsuarioController { // Declaração da classe UsuarioController

    @Autowired // Injeta automaticamente a dependência do AuthenticationManager
    private AuthenticationManager authenticationManager; // Gerenciador de autenticação

    @Autowired // Injeta automaticamente a dependência do UsuarioRepository
    private UsuarioRepository usuarioRepository; // Repositório para operações com a entidade Usuario

    @Autowired // Injeta automaticamente a dependência do CursoRepository
    private CursoRepository cursoRepository; // Repositório para operações com a entidade Curso

    @GetMapping // Mapeia requisições HTTP GET para o método abaixo
    public List<Usuario> listarUsuarios() { // Método que lista todos os usuários
        return usuarioRepository.findAll(); // Retorna uma lista com todos os usuários encontrados no repositório
    }

    @PostMapping // Mapeia requisições HTTP POST para o método abaixo
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) { // Método que cria um novo usuário a partir dos dados enviados no corpo da requisição
        Usuario novoUsuario = usuarioRepository.save(usuario); // Salva o novo usuário no repositório e armazena o resultado em novoUsuario
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario); // Retorna uma resposta HTTP 201 (Created) com o usuário criado no corpo da resposta
    }

    @PostMapping("/login") // Mapeia requisições HTTP POST para o endpoint /usuarios/login
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) { // Método que realiza o login do usuário recebendo um objeto AuthRequest com username e password
        try { // Inicia bloco de tentativa para realizar a autenticação
            Authentication authentication = authenticationManager.authenticate( // Tenta autenticar o usuário com as credenciais fornecidas
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()) // Cria um token de autenticação com o nome de usuário e senha
            );

            SecurityContextHolder.getContext().setAuthentication(authentication); // Define a autenticação no contexto de segurança do Spring
            Map<String, String> response = new HashMap<>(); // Cria um mapa para armazenar a resposta de sucesso
            response.put("message", "Login bem-sucedido!"); // Adiciona uma mensagem de sucesso ao mapa
            response.put("user", authRequest.getUsername()); // Adiciona o nome do usuário autenticado ao mapa

            return ResponseEntity.ok(response); // Retorna uma resposta HTTP 200 (OK) com o mapa contendo a mensagem e o usuário
        } catch(Exception e){ // Captura quaisquer exceções ocorridas durante a autenticação
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário inválido"); // Retorna uma resposta HTTP 401 (Unauthorized) com uma mensagem de erro
        }
    }

    // Classe interna que representa os dados de autenticação enviados pelo cliente no login
    class AuthRequest { // Declaração da classe AuthRequest
        private String username; // Atributo para armazenar o nome de usuário
        private String password; // Atributo para armazenar a senha

        public AuthRequest() {} // Construtor padrão vazio

        public AuthRequest(String username, String password) { // Construtor que inicializa os atributos username e password
            this.username = username; // Atribui o valor do parâmetro username ao atributo da classe
            this.password = password; // Atribui o valor do parâmetro password ao atributo da classe
        }

        public String getUsername() { // Método getter para username
            return username; // Retorna o nome de usuário
        }

        public void setUsername(String username) { // Método setter para username
            this.username = username; // Define o nome de usuário
        }

        public String getPassword() { // Método getter para password
            return password; // Retorna a senha
        }

        public void setPassword(String password) { // Método setter para password
            this.password = password; // Define a senha
        }
    }

    @PostMapping("/{usuarioId}/matricular/{cursoId}") // Mapeia requisições HTTP POST para o endpoint de matrícula, com IDs do usuário e do curso na URL
    public ResponseEntity<Usuario> matricularUsuario(@PathVariable Long usuarioId, @PathVariable Long cursoId) { // Método que realiza a matrícula de um usuário em um curso, recebendo os IDs como parâmetros da URL
        Usuario usuario = usuarioRepository.findById(usuarioId) // Busca o usuário pelo ID fornecido
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")); // Lança uma exceção se o usuário não for encontrado
        Curso curso = cursoRepository.findById(cursoId) // Busca o curso pelo ID fornecido
                .orElseThrow(() -> new RuntimeException("Curso não encontrado")); // Lança uma exceção se o curso não for encontrado

        usuario.getCursos().add(curso); // Adiciona o curso à lista de cursos do usuário
        curso.setUsuario(usuario); // Associa o usuário ao curso (definindo o proprietário ou responsável pelo curso)

        usuarioRepository.save(usuario); // Salva as alterações do usuário no repositório
        cursoRepository.save(curso); // Salva as alterações do curso no repositório

        return ResponseEntity.ok(usuario); // Retorna uma resposta HTTP 200 (OK) com o usuário atualizado no corpo da resposta
    }
}