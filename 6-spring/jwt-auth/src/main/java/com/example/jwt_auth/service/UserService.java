// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.service;

// Importa a classe User, que representa o modelo de usuário.
import com.example.jwt_auth.model.User;
// Importa o repositório de usuários, usado para acessar o banco de dados.
import com.example.jwt_auth.repository.UserRepository;
// Importa a anotação @Autowired para injeção de dependências.
import org.springframework.beans.factory.annotation.Autowired;
// Importa a interface PasswordEncoder, usada para criptografar senhas.
import org.springframework.security.crypto.password.PasswordEncoder;
// Importa a anotação @Service, que marca esta classe como um serviço gerenciado pelo Spring.
import org.springframework.stereotype.Service;

// Marca esta classe como um serviço, permitindo que o Spring gerencie sua criação e injeção.
@Service
public class UserService {

    // Injeta automaticamente o repositório de usuários.
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

        // Define a senha criptografada no objeto usuário.
        user.setPassword(hashedPassword);
        // Salva o usuário no banco de dados e retorna o objeto salvo.
        return userRepository.save(user);
    }

    // Método responsável por buscar um usuário pelo nome de usuário (username).
    public User findByUsername(String username) {
        // Usa o repositório para buscar o usuário pelo nome de usuário.
        // Retorna um Optional contendo o usuário, ou null se não encontrado.
        return userRepository.findByUsername(username).orElse(null);
    }
}