// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para interceptar e registrar informações das requisições HTTP.
import jakarta.servlet.ServletException; // Exceção lançada para erros relacionados a servlets.
import jakarta.servlet.http.HttpServletRequest; // Representa a requisição HTTP.
import jakarta.servlet.http.HttpServletResponse; // Representa a resposta HTTP.
import org.springframework.stereotype.Component; // Marca a classe como um componente gerenciado pelo Spring.
import org.springframework.web.filter.OncePerRequestFilter; // Garante que o filtro seja executado apenas uma vez por requisição.

import java.io.IOException; // Lida com exceções de entrada e saída de dados.
import java.time.LocalDateTime; // Classe usada para registrar o horário da requisição.

// Marca esta classe como um componente gerenciado pelo Spring, permitindo sua injeção automática em outras partes da aplicação.
@Component
public class RequestLoggingMiddleware extends OncePerRequestFilter {

    // Método que intercepta todas as requisições HTTP e registra informações detalhadas.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
            throws ServletException, IOException {

        // Imprime no console informações sobre a requisição recebida.
        System.out.println("===============================");
        System.out.println("Requisição Recebida:");
        System.out.println("Método: " + request.getMethod()); // Exibe o método HTTP (GET, POST, PUT, DELETE, etc.).
        System.out.println("URL: " + request.getRequestURI()); // Exibe a URL requisitada.
        System.out.println("Headers: ");

        // Percorre todos os cabeçalhos da requisição e os imprime no console.
        request.getHeaderNames().asIterator().forEachRemaining(header ->
                System.out.println(header + ": " + request.getHeader(header))
        );

        // Exibe o horário da requisição.
        System.out.println("Horário: " + LocalDateTime.now());
        System.out.println("===============================");

        // Passa a requisição para o próximo filtro na cadeia de execução.
        filterChain.doFilter(request, response);

        // Imprime no console informações sobre a resposta enviada.
        System.out.println("===============================");
        System.out.println("Resposta Enviada: ");
        System.out.println("Status: " + response.getStatus()); // Exibe o código de status HTTP da resposta.
        System.out.println("===============================");
    }
}