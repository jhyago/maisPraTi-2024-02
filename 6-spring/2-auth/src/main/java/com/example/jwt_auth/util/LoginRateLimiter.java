// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para implementar o filtro de requisições.
import jakarta.servlet.FilterChain; // Representa a cadeia de filtros na aplicação.
import jakarta.servlet.ServletException; // Exceção lançada em erros relacionados a servlet.
import jakarta.servlet.ServletRequest; // Representa uma requisição genérica.
import jakarta.servlet.ServletResponse; // Representa uma resposta genérica.
import jakarta.servlet.http.HttpServletRequest; // Representa uma requisição HTTP.
import jakarta.servlet.http.HttpServletResponse; // Representa uma resposta HTTP.
import org.springframework.stereotype.Component; // Marca esta classe como um componente gerenciado pelo Spring.

// Importa classes para manipulação de entrada e saída de dados, tempo e estrutura de dados concorrente.
import java.io.IOException; // Lida com exceções de entrada e saída.
import java.time.Instant; // Representa um instante no tempo.
import java.util.Map; // Estrutura de dados para armazenar tentativas de login.
import java.util.concurrent.ConcurrentHashMap; // Mapa concorrente para evitar problemas em múltiplas threads.
import jakarta.servlet.Filter; // Interface que define um filtro para processar requisições HTTP.

// Marca esta classe como um componente gerenciado pelo Spring.
@Component
public class LoginRateLimiter implements Filter {

    // Define o número máximo de tentativas de login permitidas antes do bloqueio.
    private static final int MAX_ATTEMPTS = 5;

    // Define o tempo de bloqueio em segundos (1 minuto).
    private static final long BLOCK_DURATION = 60;

    // Mapa para armazenar as tentativas de login por endereço IP.
    private final Map<String, LoginAttempt> attempts = new ConcurrentHashMap<>();

    // Método principal do filtro, que intercepta todas as requisições HTTP.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // Verifica se a requisição é do tipo HTTP.
        if (request instanceof HttpServletRequest httpRequest && response instanceof HttpServletResponse httpResponse) {

            // Verifica se a requisição é para o endpoint de login via método POST.
            if (httpRequest.getRequestURI().equals("/auth/login") && httpRequest.getMethod().equalsIgnoreCase("POST")) {

                // Obtém o endereço IP do cliente que fez a requisição.
                String ip = request.getRemoteAddr();

                // Recupera ou cria um novo registro de tentativa de login para o IP.
                LoginAttempt loginAttempt = attempts.getOrDefault(ip, new LoginAttempt());

                // Verifica se o IP está bloqueado devido a muitas tentativas falhas.
                if (loginAttempt.isBlocked()) {
                    httpResponse.setStatus(429); // Código HTTP 429: Too Many Requests.
                    httpResponse.getWriter().write("Muitas tentativas de login. Tente novamente mais tarde.");
                    return; // Interrompe a requisição.
                }

                // Incrementa o contador de tentativas de login para este IP.
                loginAttempt.incrementAttempts();

                // Atualiza o mapa com o novo estado do IP.
                attempts.put(ip, loginAttempt);
            }
        }

        // Continua a execução da cadeia de filtros, permitindo a requisição prosseguir.
        filterChain.doFilter(request, response);
    }

    // Classe interna para armazenar informações sobre tentativas de login por IP.
    private static class LoginAttempt {

        private int attempts; // Número de tentativas de login falhas.
        private Instant blockTime; // Momento em que o IP foi bloqueado.

        // Construtor padrão inicializa os valores.
        public LoginAttempt() {
            this.attempts = 0;
            this.blockTime = null;
        }

        // Método para incrementar o número de tentativas de login.
        public void incrementAttempts() {
            // Se o IP estiver bloqueado e o tempo de bloqueio ainda estiver em vigor, não faz nada.
            if (blockTime != null && Instant.now().isBefore(blockTime)) {
                return;
            }

            // Incrementa o contador de tentativas de login.
            attempts++;

            // Se o número de tentativas ultrapassar o limite, define o tempo de bloqueio.
            if (attempts >= MAX_ATTEMPTS) {
                blockTime = Instant.now().plusSeconds(BLOCK_DURATION);
            }
        }

        // Método para verificar se o IP está bloqueado.
        public boolean isBlocked() {
            return blockTime != null && Instant.now().isBefore(blockTime);
        }
    }
}