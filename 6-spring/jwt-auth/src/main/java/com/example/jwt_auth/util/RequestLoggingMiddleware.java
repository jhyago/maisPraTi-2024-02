package com.example.jwt_auth.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class RequestLoggingMiddleware extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===============================");
        System.out.println("Requisição Recebida:");
        System.out.println("Método: " + request.getMethod());
        System.out.println("URL: " + request.getRequestURI());
        System.out.println("Headers: ");
        request.getHeaderNames().asIterator().forEachRemaining(header ->
                System.out.println(header + ": " + request.getHeader(header))
        );
        System.out.println("Horário: " + LocalDateTime.now());
        System.out.println("===============================");

        filterChain.doFilter(request, response);

        System.out.println("===============================");
        System.out.println("Resposta Enviada: ");
        System.out.println("Status: " + response.getStatus());
        System.out.println("===============================");
    }
}
