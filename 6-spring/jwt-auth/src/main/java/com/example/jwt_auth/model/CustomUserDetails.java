// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.model;

// Importa as interfaces necessárias do Spring Security.
import org.springframework.security.core.GrantedAuthority; // Representa uma permissão ou role concedida ao usuário.
import org.springframework.security.core.userdetails.UserDetails; // Interface para representar os detalhes do usuário.

import java.util.Collection; // Representa um grupo de objetos (neste caso, as permissões).

// Implementa a interface UserDetails, que é usada pelo Spring Security para autenticação e autorização.
public class CustomUserDetails implements UserDetails {

    // Define os atributos essenciais do usuário.
    private final String username; // Nome de usuário.
    private final String password; // Senha do usuário.
    private final Collection<? extends GrantedAuthority> authorities; // Lista de permissões ou roles.

    // Construtor para inicializar os atributos da classe.
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username; // Define o nome de usuário.
        this.password = password; // Define a senha.
        this.authorities = authorities; // Define as permissões ou roles.
    }

    // Implementação do método para retornar as permissões ou roles do usuário.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // Retorna a lista de permissões ou roles.
    }

    // Implementação do método para retornar a senha do usuário.
    @Override
    public String getPassword() {
        return password; // Retorna a senha.
    }

    // Implementação do método para retornar o nome de usuário.
    @Override
    public String getUsername() {
        return username; // Retorna o nome de usuário.
    }

    // Indica se a conta do usuário está expirada.
    @Override
    public boolean isAccountNonExpired() {
        return true; // Retorna `true`, indicando que a conta não está expirada.
    }

    // Indica se a conta do usuário está bloqueada.
    @Override
    public boolean isAccountNonLocked() {
        return true; // Retorna `true`, indicando que a conta não está bloqueada.
    }

    // Indica se as credenciais do usuário (ex.: senha) estão expiradas.
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Retorna `true`, indicando que as credenciais não estão expiradas.
    }

    // Indica se o usuário está habilitado.
    @Override
    public boolean isEnabled() {
        return true; // Retorna `true`, indicando que o usuário está habilitado.
    }
}