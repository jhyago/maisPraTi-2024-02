package com.example.jwt_auth;

import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegistrationIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldRegisterUserSuccessfully() throws Exception {
        User newUser = new User();
        newUser.setUsername("Penelope");
        newUser.setPassword("CorridaMaluca");
        newUser.setEmail("penelope@charmosa.com");

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuário registrado com sucesso!"));

        User savedUser = userRepository.findByUsername("Penelope").orElse(null);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getEmail().equals("penelope@charmosa.com"));
    }

    @Test
    void shouldFailToRegisterUserWithDuplicateUsername() throws Exception {
        User existingUser = new User();
        existingUser.setUsername("Dracula");
        existingUser.setPassword("Pensilvania");
        existingUser.setEmail("dracula@vampiro.com");

        User duplicateUser = new User();
        duplicateUser.setUsername("Van Helsing");
        duplicateUser.setPassword("Caçador");
        duplicateUser.setEmail("van@helsing.com");

        mockMvc.perform(MockMvcRequestBuilders.post("auth/register"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString((duplicateUser)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Erro: nome de usuário já está cadastrado."));
    }
}
