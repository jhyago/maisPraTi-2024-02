package com.example.Integration.config; // Define o pacote onde a classe de configuração de segurança será armazenada

import org.springframework.context.annotation.Bean; // Importa a anotação @Bean para que métodos retornem beans gerenciados pelo Spring
import org.springframework.context.annotation.Configuration; // Importa a anotação @Configuration para indicar que a classe contém configurações do Spring
import org.springframework.security.authentication.AuthenticationManager; // Importa a interface AuthenticationManager para gerenciar a autenticação
import org.springframework.security.authentication.ProviderManager; // Importa o ProviderManager, que é uma implementação de AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Importa o provedor de autenticação que utiliza um serviço de detalhes de usuário (DAO)
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importa a classe HttpSecurity para configurar aspectos de segurança HTTP
import org.springframework.security.core.userdetails.User; // Importa a classe User para construir instâncias de usuário com detalhes de autenticação
import org.springframework.security.core.userdetails.UserDetails; // Importa a interface UserDetails que representa as informações de um usuário
import org.springframework.security.core.userdetails.UserDetailsService; // Importa a interface UserDetailsService para carregar informações de usuário
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importa o BCryptPasswordEncoder para codificar senhas usando o algoritmo BCrypt
import org.springframework.security.crypto.password.PasswordEncoder; // Importa a interface PasswordEncoder para definir o método de codificação de senha
import org.springframework.security.provisioning.InMemoryUserDetailsManager; // Importa a implementação em memória de UserDetailsService para gerenciar usuários
import org.springframework.security.web.SecurityFilterChain; // Importa a interface SecurityFilterChain para configurar a cadeia de filtros de segurança
import org.springframework.web.cors.CorsConfiguration; // Importa a classe CorsConfiguration para definir configurações de CORS
import org.springframework.web.cors.CorsConfigurationSource; // Importa a interface CorsConfigurationSource para fornecer configurações CORS
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; // Importa a classe UrlBasedCorsConfigurationSource para mapear configurações CORS com base em URLs

@Configuration // Indica que a classe contém configurações e será processada pelo Spring para gerar beans
public class SecurityConfig { // Declaração da classe de configuração de segurança

    @Bean // Define que o método abaixo retornará um bean gerenciado pelo Spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // Método que configura a cadeia de filtros de segurança usando HttpSecurity
        http
                // Configura o CORS utilizando a fonte de configuração definida no método corsConfigurationSource()
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Configura a autorização das requisições HTTP
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cursos").authenticated() // Exige autenticação para qualquer requisição que corresponda ao padrão "/cursos"
                        .anyRequest().permitAll() // Permite todas as outras requisições sem autenticação
                )
                // Desativa a proteção contra CSRF (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable())
                // Configura o gerenciamento de sessão para ser stateless, ou seja, sem armazenar estado de sessão no servidor
                .sessionManagement(session -> session.sessionCreationPolicy(
                        org.springframework.security.config.http.SessionCreationPolicy.STATELESS
                ));

        return http.build(); // Constrói e retorna a cadeia de filtros de segurança configurada
    }

    @Bean // Define que o método abaixo retornará um bean gerenciado pelo Spring
    public UserDetailsService userDetailsService() { // Método que configura os detalhes do usuário para autenticação
        // Cria um usuário com o nome "admin", senha codificada e atribui o papel "USER"
        UserDetails user = User.withUsername("admin")
                .password(passwordEncoder().encode("password")) // Codifica a senha "password" utilizando o bean passwordEncoder
                .roles("USER") // Define o papel do usuário como "USER"
                .build(); // Constrói o objeto UserDetails

        return new InMemoryUserDetailsManager(user); // Retorna um gerenciador de usuários em memória contendo o usuário criado
    }

    @Bean // Define que o método abaixo retornará um bean gerenciado pelo Spring
    public PasswordEncoder passwordEncoder() { // Método que configura o codificador de senhas
        return new BCryptPasswordEncoder(); // Retorna uma instância do BCryptPasswordEncoder para codificar as senhas
    }

    @Bean // Define que o método abaixo retornará um bean gerenciado pelo Spring
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) { // Método que configura o gerenciador de autenticação, injetando o UserDetailsService
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // Cria uma instância do provedor de autenticação baseado em DAO
        authProvider.setUserDetailsService(userDetailsService); // Configura o provedor para usar o serviço de detalhes de usuário definido
        authProvider.setPasswordEncoder(passwordEncoder()); // Configura o provedor para usar o codificador de senha definido
        return new ProviderManager(authProvider); // Retorna um ProviderManager que gerencia o provedor de autenticação configurado
    }

    @Bean // Define que o método abaixo retornará um bean gerenciado pelo Spring
    public CorsConfigurationSource corsConfigurationSource() { // Método que configura e retorna as definições de CORS
        CorsConfiguration configuration = new CorsConfiguration(); // Cria uma nova instância de CorsConfiguration para definir as configurações de CORS
        configuration.addAllowedOrigin("http://localhost:5173"); // Permite requisições de origem "http://localhost:5173"
        configuration.addAllowedMethod("*"); // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc.)
        configuration.addAllowedHeader("*"); // Permite todos os cabeçalhos HTTP
        configuration.setAllowCredentials(true); // Permite o envio de credenciais (cookies, cabeçalhos de autorização, etc.) nas requisições

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // Cria uma nova instância para mapear as configurações de CORS com base em URLs
        source.registerCorsConfiguration("/**", configuration); // Registra as configurações de CORS para todas as rotas da aplicação
        return source; // Retorna a fonte de configuração CORS
    }
}