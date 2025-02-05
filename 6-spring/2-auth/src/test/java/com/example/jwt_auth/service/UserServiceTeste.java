// Define o pacote onde esta classe de teste está localizada.
package com.example.jwt_auth.service;

// Importa as classes necessárias para os testes.
import com.example.jwt_auth.dto.UserDTO;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;

// Importa classes do JUnit para testes.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// Importa classes do Spring para paginação.
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

// Importa classes auxiliares para manipulação de listas.
import java.util.Arrays;
import java.util.List;

// Importa métodos estáticos para asserções e verificação de chamadas de métodos.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTeste { // Corrigido de "UserServiceTeste" para "UserServiceTest" (padrão em inglês)

    @Mock
    private UserRepository userRepository; // Simula o repositório de usuários.

    @InjectMocks
    private UserService userService; // Injeta o mock no serviço a ser testado.

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks antes de cada teste.
    }

    @Test
    void getAllUsers_shouldReturnPaginatedUsers() {
        // Cria uma lista de usuários simulada.
        List<User> users = Arrays.asList(
                new User(1L, "Perna Longa", "password1", "pernalonga@disney.com"),
                new User(2L, "Ace dos Punhos de Fogo", "Morri queimado", "merameranomi@toei.com")
        );

        // Define uma solicitação de página com tamanho 10 (primeira página).
        PageRequest pageRequest = PageRequest.of(0, 10);

        // Cria uma página simulada contendo a lista de usuários.
        Page<User> pagedUsers = new PageImpl<>(users, pageRequest, users.size());

        // Configura o mock para retornar a página simulada quando o método findAll for chamado.
        when(userRepository.findAll(pageRequest)).thenReturn(pagedUsers);

        // Chama o método do serviço a ser testado.
        Page<UserDTO> result = userService.getAllUsers(pageRequest);

        // Verifica se o total de usuários retornado é igual ao esperado.
        assertEquals(2, result.getTotalElements());

        // Verifica se o nome do primeiro usuário é "Perna Longa".
        assertEquals("Perna Longa", result.getContent().get(0).getUsername());

        // Garante que o método findAll do repositório foi chamado exatamente uma vez.
        verify(userRepository, times(1)).findAll(pageRequest);

        // Exibe informações para depuração (não recomendado em testes automatizados de produção).
        System.out.println("Total de usuários: " + result.getTotalElements());
        System.out.println("Primeiro usuário: " + result.getContent().get(0).getUsername());
    }
}