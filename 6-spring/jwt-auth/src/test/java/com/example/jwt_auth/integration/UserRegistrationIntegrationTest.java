package com.example.jwt_auth.integration;

import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        newUser.setUsername("Batman");
        newUser.setPassword("Begins2022");
        newUser.setEmail("batman@robin.com");

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
        existingUser.setPassword("pensilvania123");
        existingUser.setEmail("dracula@MK10.com");

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(existingUser)))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuario registrado com sucesso!"));

        User newUser = new User();
        newUser.setUsername("Scorpion");
        newUser.setPassword("getOverHere");
        newUser.setEmail("scorpion@MK10.com");

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Nome de usuário já está em uso"));
    }
}

