// Define o pacote onde este teste de integração está localizado.
package com.example.jwt_auth;

// Importa classes do modelo e repositório do usuário.
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;

// Importa classes para manipulação de JSON.
import com.fasterxml.jackson.databind.ObjectMapper;

// Importa classes do JUnit para testes.
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Importa métodos para asserções e simulação de requisições HTTP.
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Indica que este é um teste de integração que inicializa o contexto completo do Spring Boot.
@SpringBootTest
@AutoConfigureMockMvc // Configura automaticamente o ambiente para simular requisições HTTP.
public class UserRegistrationIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // Simula requisições HTTP sem precisar de um servidor real.

    @Autowired
    private UserRepository userRepository; // Permite acesso ao banco de dados para verificar os resultados.

    @Autowired
    private ObjectMapper objectMapper; // Converte objetos Java para JSON e vice-versa.

    @Test
    void shouldRegisterUserSuccessfully() throws Exception {
        // Cria um novo usuário fictício para teste.
        User newUser = new User();
        newUser.setUsername("Penelope");
        newUser.setPassword("CorridaMaluca");
        newUser.setEmail("penelope@charmosa.com");

        // Simula uma requisição HTTP POST para registrar o usuário.
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON) // Define o tipo de conteúdo como JSON.
                        .content(objectMapper.writeValueAsString(newUser))) // Converte o objeto para JSON.
                .andExpect(status().isOk()) // Espera que a resposta seja HTTP 200 (OK).
                .andExpect(content().string("Usuário registrado com sucesso!")); // Espera que o retorno seja esta mensagem.

        // Verifica se o usuário foi salvo corretamente no banco de dados.
        User savedUser = userRepository.findByUsername("Penelope").orElse(null); // Busca o usuário pelo username.

        assertThat(savedUser).isNotNull(); // Verifica se o usuário foi encontrado.
        assertThat(savedUser.getEmail()).isEqualTo("penelope@charmosa.com"); // Confirma se o email foi salvo corretamente.
    }

    @Test
    void shouldFailToRegisterUserWithDuplicateUsername() throws Exception {
        // Cria e salva um usuário existente no banco de dados.
        User existingUser = new User();
        existingUser.setUsername("Dracula");
        existingUser.setPassword("Pensilvania");
        existingUser.setEmail("dracula@vampiro.com");
        userRepository.save(existingUser); // Salva no banco para garantir que o nome de usuário já exista.

        // Cria um usuário com o mesmo nome de usuário (deve falhar).
        User duplicateUser = new User();
        duplicateUser.setUsername("Dracula"); // Mesmo username que o existente.
        duplicateUser.setPassword("Caçador");
        duplicateUser.setEmail("van@helsing.com");

        // Simula a requisição HTTP POST para tentar cadastrar o usuário duplicado.
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(duplicateUser)))
                .andExpect(status().isBadRequest()) // Espera que a resposta seja HTTP 400 (Bad Request).
                .andExpect(content().string("Erro: nome de usuário já está cadastrado.")); // Mensagem esperada.
    }
}