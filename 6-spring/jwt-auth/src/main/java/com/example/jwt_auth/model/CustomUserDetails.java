// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.model;

// Importa as interfaces necessárias do Spring Security.
import org.springframework.security.core.GrantedAuthority; // Representa uma permissão ou role concedida ao usuário.
import org.springframework.security.core.userdetails.UserDetails; // Interface para representar os detalhes do usuário autenticado.

import java.util.Collection; // Representa um grupo de objetos (neste caso, as permissões ou roles).

// Implementa a interface UserDetails, que é usada pelo Spring Security para autenticação e autorização.
public class CustomUserDetails implements UserDetails {

    // Define os atributos essenciais do usuário.
    private final String username; // Nome de usuário utilizado na autenticação.
    private final String password; // Senha do usuário (deve estar criptografada no banco de dados).
    private final Collection<? extends GrantedAuthority> authorities; // Lista de permissões ou roles do usuário.

    // Construtor para inicializar os atributos da classe.
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username; // Define o nome de usuário.
        this.password = password; // Define a senha do usuário.
        this.authorities = authorities; // Define as permissões ou roles do usuário.
    }

    // Retorna a coleção de permissões (roles) do usuário.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // Retorna a lista de permissões associadas ao usuário.
    }

    // Retorna a senha do usuário.
    @Override
    public String getPassword() {
        return password; // Retorna a senha cadastrada no banco de dados.
    }

    // Retorna o nome de usuário utilizado na autenticação.
    @Override
    public String getUsername() {
        return username; // Retorna o nome de usuário do sistema.
    }

    // Indica se a conta do usuário está expirada.
    @Override
    public boolean isAccountNonExpired() {
        return true; // Retorna `true`, indicando que a conta do usuário não está expirada.
    }

    // Indica se a conta do usuário está bloqueada.
    @Override
    public boolean isAccountNonLocked() {
        return true; // Retorna `true`, indicando que a conta não está bloqueada.
    }

    // Indica se as credenciais do usuário (ex.: senha) estão expiradas.
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Retorna `true`, indicando que as credenciais do usuário não estão expiradas.
    }

    // Indica se o usuário está habilitado para acessar o sistema.
    @Override
    public boolean isEnabled() {
        return true; // Retorna `true`, indicando que o usuário está ativo e pode acessar o sistema.
    }
}