package com.example.jwt_auth.service;

import com.example.jwt_auth.dto.UserDTO;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers_shouldReturnPaginatedUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "Perna Longa", "password1", "pernalonga@disney.com"),
                new User(2L, "Ace dos Punhos de Fogo", "Morri queimado", "merameranomi@toei.com")
        );

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> pagedUsers = new PageImpl<>(users, pageRequest, users.size());

        when(userRepository.findAll(pageRequest)).thenReturn(pagedUsers);

        Page<UserDTO> result = userService.getAllUsers(pageRequest);

        assertEquals(2, result.getTotalElements());
        assertEquals("Perna Longa", result.getContent().get(0).getUsername());

        verify(userRepository, times(1)).findAll(pageRequest);
    }

}
