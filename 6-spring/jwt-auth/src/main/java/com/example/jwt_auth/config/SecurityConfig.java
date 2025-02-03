// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.config;

// Importa os serviços, filtros e utilitários necessários para a configuração de segurança.
import com.example.jwt_auth.util.JwtAuthenticationFilter; // Filtro JWT personalizado para autenticação.
import com.example.jwt_auth.util.LoginRateLimiter; // Limitador de taxa para prevenir ataques de força bruta.
import org.springframework.beans.factory.annotation.Autowired; // Permite a injeção automática de dependências pelo Spring.
import org.springframework.context.annotation.Bean; // Anotação para definir métodos que retornam beans gerenciados pelo Spring.
import org.springframework.context.annotation.Configuration; // Indica que esta classe contém configurações de segurança para o Spring.
import org.springframework.security.authentication.AuthenticationManager; // Interface responsável pelo gerenciamento de autenticação.
import org.springframework.security.authentication.ProviderManager; // Implementação do AuthenticationManager que delega a autenticação para provedores específicos.
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Provedor de autenticação que utiliza um banco de dados para validar usuários.
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Classe para configurar a segurança HTTP.
import org.springframework.security.core.userdetails.UserDetailsService; // Serviço para carregar informações do usuário do banco de dados.
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder; // Implementação do Argon2 para criptografia segura de senhas.
import org.springframework.security.crypto.password.PasswordEncoder; // Interface que define um codificador de senha.
import org.springframework.security.web.SecurityFilterChain; // Define uma cadeia de filtros de segurança para interceptar e processar requisições HTTP.
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Filtro padrão de autenticação baseado em nome de usuário e senha.

// Marca esta classe como uma configuração de segurança para o Spring Security.
@Configuration
public class SecurityConfig {

    // Injeta o filtro de autenticação JWT personalizado.
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // Injeta o limitador de taxa de login para proteção contra múltiplas tentativas falhas.
    @Autowired
    private LoginRateLimiter loginRateLimiter;

    // Define o codificador de senha como um bean gerenciado pelo Spring.
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retorna uma instância de Argon2PasswordEncoder com os parâmetros:
        // - Salt de 16 bytes, hash de 32 bytes, 1 iteração, 65536 KB de memória e 3 threads.
        return new Argon2PasswordEncoder(16, 32, 1, 65536, 3);
    }

    // Configura o gerenciador de autenticação como um bean.
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService, // Serviço para carregar os detalhes do usuário do banco de dados.
            PasswordEncoder passwordEncoder // Codificador de senha utilizado para validar senhas no login.
    ) throws Exception {

        // Cria um provedor de autenticação que utiliza um banco de dados para validar usuários.
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // Define o serviço que carrega os detalhes do usuário.
        provider.setPasswordEncoder(passwordEncoder); // Define o codificador de senha (Argon2 no caso).

        // Retorna um AuthenticationManager que utiliza o provedor de autenticação configurado.
        return new ProviderManager(provider);
    }

    // Configura a cadeia de filtros de segurança.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desabilita a proteção contra CSRF (necessário avaliar se a API realmente não precisa dessa proteção).
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Permite acesso irrestrito às rotas que começam com "/auth/" (exemplo: login, registro).
                        .requestMatchers("/api/protected").hasAuthority("ROLE_USER") // Restringe o acesso a "/api/protected" apenas para usuários com a role "ROLE_USER".
                        .anyRequest().authenticated() // Exige autenticação para qualquer outra requisição não especificada acima.
                )
                // Adiciona um filtro de limitação de taxa de login antes do filtro de autenticação JWT.
                .addFilterBefore(loginRateLimiter, JwtAuthenticationFilter.class)
                // Adiciona o filtro JWT antes do filtro padrão de autenticação por nome de usuário e senha.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build(); // Constrói e retorna a configuração de segurança definida.
    }
}