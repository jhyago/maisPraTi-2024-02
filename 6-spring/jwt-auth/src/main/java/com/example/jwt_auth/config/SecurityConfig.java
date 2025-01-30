// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.config;

// Importa os serviços, filtros e utilitários necessários para a configuração de segurança.
import com.example.jwt_auth.util.JwtAuthenticationFilter; // Filtro JWT personalizado para autenticação.
import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência automática.
import org.springframework.context.annotation.Bean; // Marca métodos como produtores de beans gerenciados pelo Spring.
import org.springframework.context.annotation.Configuration; // Indica que esta classe contém configurações de Spring.
import org.springframework.security.authentication.AuthenticationManager; // Gerencia a autenticação no Spring Security.
import org.springframework.security.authentication.ProviderManager; // Gerencia provedores de autenticação.
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Provedor de autenticação que utiliza um banco de dados.
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Configura a segurança de requisições HTTP.
import org.springframework.security.core.userdetails.UserDetailsService; // Serviço para carregar detalhes do usuário.
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; // Interface para codificadores de senha.
import org.springframework.security.web.SecurityFilterChain; // Configura a cadeia de filtros de segurança.
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Filtro padrão de autenticação por nome de usuário e senha.

// Indica que esta classe contém configurações de segurança do Spring.
@Configuration
public class SecurityConfig {

    // Injeta o filtro de autenticação JWT personalizado.
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // Define o codificador de senha como um bean gerenciado pelo Spring.

    //openssl genpkey -algorithm RSA -out private.pem -pkeyopt rsa_key_gen_bits:2048
    //openssl rsa -pubout -in private.pem -out public.pem
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder(16, 32, 1, 65536, 3);
    }

    // Configura o gerenciador de autenticação como um bean.
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService, // Serviço para carregar os detalhes do usuário.
            PasswordEncoder passwordEncoder // Codificador de senha.
    ) throws Exception {

        // Configura um provedor de autenticação baseado no DAO.
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // Define o serviço para carregar os usuários.
        provider.setPasswordEncoder(passwordEncoder); // Define o codificador de senha.

        return new ProviderManager(provider); // Retorna um ProviderManager com o provedor configurado.
    }

    // Configura a cadeia de filtros de segurança.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desabilita a proteção contra CSRF (não recomendada para produção sem análise).
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Permite acesso às rotas iniciadas por "/auth/" sem autenticação.
                        .requestMatchers("/api/protected").hasAuthority("ROLE_USER") // Restringe acesso às rotas "/api/protected" para usuários com a role "ROLE_USER".
                        .anyRequest().authenticated() // Exige autenticação para todas as outras requisições.
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro de autenticação JWT antes do filtro padrão de autenticação.
                .build(); // Constrói e retorna a configuração de segurança.
    }
}