// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.service;

// Importa a classe CustomUserDetails, que implementa os detalhes do usuário.
import com.example.jwt_auth.model.CustomUserDetails;
// Importa a classe User, que representa a entidade do usuário.
import com.example.jwt_auth.model.User;
// Importa o repositório de usuários para interagir com o banco de dados.
import com.example.jwt_auth.repository.UserRepository;
// Importa a anotação @Autowired para injeção de dependência automática.
import org.springframework.beans.factory.annotation.Autowired;
// Importa a interface UserDetails, usada pelo Spring Security para representar os detalhes do usuário autenticado.
import org.springframework.security.core.userdetails.UserDetails;
// Importa a interface UserDetailsService, que deve ser implementada para integração com o Spring Security.
import org.springframework.security.core.userdetails.UserDetailsService;
// Importa a exceção UsernameNotFoundException, lançada quando um usuário não é encontrado.
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// Importa a classe SimpleGrantedAuthority, usada para definir as permissões (roles) do usuário.
import org.springframework.security.core.authority.SimpleGrantedAuthority;
// Importa a anotação @Service, que marca esta classe como um serviço gerenciado pelo Spring.
import org.springframework.stereotype.Service;

import java.util.List; // Importa a classe List para criar uma lista de permissões.

// Marca esta classe como um serviço, para que o Spring gerencie sua criação e injeção.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Injeta automaticamente o repositório de usuários para buscar dados do banco de dados.
    @Autowired
    private UserRepository userRepository;

    // Sobrescreve o método loadUserByUsername da interface UserDetailsService.
    // Este método é chamado pelo Spring Security durante a autenticação para carregar os dados do usuário.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo nome de usuário.
        // Caso o usuário não seja encontrado, lança uma exceção UsernameNotFoundException.
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        // Imprime informações do usuário no console (usado para depuração).
        System.out.println("Usuário carregado: " + user.getUsername());
        System.out.println("Senha carregada: " + user.getPassword());
        System.out.println("Roles atribuídas: " + List.of(new SimpleGrantedAuthority("ROLE_USER")));

        // Retorna uma instância de CustomUserDetails com as informações do usuário autenticado.
        return new CustomUserDetails(
                user.getUsername(), // Nome de usuário.
                user.getPassword(), // Senha do usuário (criptografada).
                List.of(new SimpleGrantedAuthority("ROLE_USER")) // Lista de permissões (neste caso, apenas "ROLE_USER").
        );
    }
}
