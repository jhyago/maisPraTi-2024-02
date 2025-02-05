// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.service;

// Importa a classe User, que representa o modelo de usuário.
import com.example.jwt_auth.dto.UserDTO;
import com.example.jwt_auth.model.User;
// Importa o repositório de usuários, usado para acessar o banco de dados.
import com.example.jwt_auth.repository.UserRepository;
// Importa classes do Spring para gerenciamento de usuários e criptografia de senhas.
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

// Marca esta classe como um serviço, permitindo que o Spring gerencie sua criação e injeção.
@Service
public class UserService {

    // Injeta automaticamente o repositório de usuários para interagir com o banco de dados.
    @Autowired
    private UserRepository userRepository;

    // Injeta automaticamente o encoder de senhas, usado para criptografar senhas antes de salvá-las.
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método responsável por salvar um usuário no banco de dados.
    public User saveUser(User user) {
        // Criptografa a senha do usuário usando o PasswordEncoder.
        String hashedPassword = passwordEncoder.encode(user.getPassword());

        // Exibe a senha original e a senha criptografada no console (para depuração).
        System.out.println("Senha original: " + user.getPassword());
        System.out.println("Senha criptografada: " + hashedPassword);

        // Define a senha criptografada no objeto usuário antes de salvar no banco de dados.
        user.setPassword(hashedPassword);

        // Salva o usuário no banco de dados e retorna o objeto salvo.
        return userRepository.save(user);
    }

    // Método responsável por buscar todos os usuários paginados e convertê-los para DTO.
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        // Usa o método findAll() do repositório e converte cada usuário para um UserDTO.
        return userRepository.findAll(pageable).map(user -> new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        ));
    }

    // Método responsável por buscar um usuário pelo nome de usuário (username).
    public User findByUsername(String username) {
        // Usa o repositório para buscar o usuário pelo nome de usuário.
        // Retorna um Optional contendo o usuário, ou null se não encontrado.
        return userRepository.findByUsername(username).orElse(null);
    }
}