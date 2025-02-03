// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para implementar o filtro e manipular requisições HTTP.
import jakarta.servlet.FilterChain; // Representa a cadeia de filtros na aplicação.
import jakarta.servlet.ServletException; // Exceção lançada em erros relacionados a servlet.
import jakarta.servlet.http.HttpServletRequest; // Representa a requisição HTTP.
import jakarta.servlet.http.HttpServletResponse; // Representa a resposta HTTP.

// Importa as classes do Spring para autenticação e contexto de segurança.
import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência automática.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Representa um token de autenticação.
import org.springframework.security.core.context.SecurityContextHolder; // Armazena informações de segurança do contexto atual.
import org.springframework.security.core.userdetails.UserDetails; // Representa os detalhes do usuário autenticado.
import org.springframework.security.core.userdetails.UserDetailsService; // Serviço para carregar os detalhes do usuário autenticado.
import org.springframework.stereotype.Component; // Marca a classe como um componente gerenciado pelo Spring.
import org.springframework.web.filter.OncePerRequestFilter; // Filtro que garante execução única por requisição.

import java.io.IOException; // Lida com exceções de entrada e saída.

// Marca esta classe como um componente gerenciado pelo Spring, permitindo sua injeção automática em outras partes da aplicação.
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Injeta a classe utilitária JwtUtil para manipulação de tokens JWT.
    @Autowired
    private JwtUtil jwtUtil;

    // Injeta o serviço UserDetailsService para carregar os detalhes do usuário.
    @Autowired
    private UserDetailsService userDetailsService;

    // Método principal do filtro que intercepta todas as requisições HTTP.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Obtém o cabeçalho Authorization da requisição.
        String authHeader = request.getHeader("Authorization");

        // Verifica se o cabeçalho Authorization não é nulo e começa com "Bearer ".
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Remove o prefixo "Bearer " do token e remove espaços em branco ao redor, se existirem.
            String jwt = authHeader.substring(7).trim();
            System.out.println("Token recebido (após remover Bearer): " + jwt);

            try {
                // Valida o formato do token utilizando uma expressão regular.
                if (!jwt.matches("^[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+$")) {
                    throw new IllegalArgumentException("Token JWT malformatado: " + jwt);
                }

                // Extrai o nome de usuário do token.
                String username = jwtUtil.getUsernameFromToken(jwt);
                System.out.println("Usuário extraído do token: " + username);

                // Verifica se o nome de usuário foi extraído e se não há autenticação no contexto de segurança atual.
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // Carrega os detalhes do usuário com base no nome de usuário extraído.
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    // Valida o token usando a classe JwtUtil.
                    if (jwtUtil.isTokenValid(jwt, userDetails)) {
                        // Cria um token de autenticação com os detalhes do usuário e suas permissões.
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails, null, userDetails.getAuthorities());
                        // Define a autenticação no contexto de segurança.
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (Exception e) {
                // Captura e imprime erros ao processar o token JWT.
                System.out.println("Erro ao processar o token JWT: " + e.getMessage());
            }
        } else {
            // Mensagem de depuração se o cabeçalho Authorization estiver ausente ou malformado.
            if (authHeader == null) {
                System.out.println("Cabeçalho Authorization não está presente.");
            } else {
                System.out.println("Cabeçalho Authorization não começa com Bearer.");
            }
        }

        // Continua a execução da cadeia de filtros para a próxima etapa.
        filterChain.doFilter(request, response);
    }
}