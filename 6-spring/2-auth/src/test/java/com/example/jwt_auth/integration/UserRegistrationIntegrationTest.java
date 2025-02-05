// Define o pacote onde este teste de integração está localizado.
package com.example.jwt_auth.integration;

// Importa classes do modelo e repositório do usuário.
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;

// Importa classes para serialização e desserialização JSON.
import com.fasterxml.jackson.databind.ObjectMapper;

// Importa classes para testes do Spring Boot.
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Importa métodos estáticos para asserções e simulação de requisições.
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Indica que este é um teste de integração que inicializa o contexto completo do Spring Boot.
@SpringBootTest
@AutoConfigureMockMvc // Configura automaticamente um ambiente de teste para requisições HTTP simuladas.
public class UserRegistrationIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // Simula requisições HTTP sem precisar de um servidor real.

    @Autowired
    private UserRepository userRepository; // Permite acessar o banco de dados para verificar os resultados.

    @Autowired
    private ObjectMapper objectMapper; // Converte objetos Java para JSON e vice-versa.

    @Test
    void shouldRegisterUserSuccessfully() throws Exception {
        // Cria um novo usuário fictício para teste.
        User newUser = new User();
        newUser.setUsername("Batman");
        newUser.setPassword("Begins2022");
        newUser.setEmail("batman@robin.com");

        // Simula uma requisição HTTP POST para registrar o usuário.
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON) // Define o tipo de conteúdo como JSON.
                        .content(objectMapper.writeValueAsString(newUser))) // Converte o objeto para JSON.
                .andExpect(status().isOk()) // Espera que a resposta seja HTTP 200 (OK).
                .andExpect(content().string("Usuário registrado com sucesso!")); // Espera que o retorno seja esta mensagem.

        // Verifica se o usuário foi salvo corretamente no banco de dados.
        User savedUser = userRepository.findByUsername("Batman").orElse(null); // Busca o usuário pelo username.

        assertThat(savedUser).isNotNull(); // Verifica se o usuário foi encontrado.
        assertThat(savedUser.getEmail()).isEqualTo("batman@robin.com"); // Confirma se o email foi salvo corretamente.
    }

    @Test
    void shouldFailToRegisterUserWithDuplicateUsername() throws Exception {
        // Cria um usuário existente no banco de dados.
        User existingUser = new User();
        existingUser.setUsername("Dracula");
        existingUser.setPassword("pensilvania123");
        existingUser.setEmail("dracula@mk10.com");

        // Salva o usuário no banco antes de rodar o teste para simular um nome já cadastrado.
        userRepository.save(existingUser);

        // Cria um novo usuário com o mesmo nome de usuário (deve falhar).
        User newUser = new User();
        newUser.setUsername("Dracula"); // Mesmo username que o existente.
        newUser.setPassword("getOverHere");
        newUser.setEmail("scorpion@mk10.com");

        // Simula a requisição HTTP POST para registrar o usuário duplicado.
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isBadRequest()) // Espera que a resposta seja HTTP 400 (Bad Request).
                .andExpect(content().string("Erro: Nome de usuário já está em uso!")); // Mensagem esperada.
    }
}