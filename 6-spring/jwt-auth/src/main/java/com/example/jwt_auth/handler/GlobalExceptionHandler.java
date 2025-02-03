// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.handler;

// Importa as classes necessárias para manipulação de respostas HTTP e exceções.
import org.springframework.http.HttpStatus; // Representa os códigos de status HTTP.
import org.springframework.http.ResponseEntity; // Representa a resposta HTTP personalizada.
import org.springframework.security.core.AuthenticationException; // Exceção lançada em falhas de autenticação.
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Exceção lançada quando um usuário não é encontrado.
import org.springframework.web.bind.MethodArgumentNotValidException; // Exceção lançada quando há falha na validação de argumentos.
import org.springframework.web.bind.annotation.ControllerAdvice; // Permite tratamento global de exceções para todos os controladores.
import org.springframework.web.bind.annotation.ExceptionHandler; // Anotação usada para definir métodos que tratam exceções específicas.

import java.util.HashMap;
import java.util.Map;

// Classe que centraliza o tratamento de exceções para toda a aplicação.
@ControllerAdvice
public class GlobalExceptionHandler {

    // Trata a exceção lançada quando um nome de usuário não é encontrado.
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        // Retorna uma resposta HTTP 404 (Not Found) com a mensagem da exceção.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Trata exceções genéricas que não foram capturadas por outros handlers.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Retorna uma resposta HTTP 500 (Internal Server Error) com a mensagem de erro.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + ex.getMessage());
    }

    // Trata exceções relacionadas à validação de argumentos em requisições.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os erros de validação.
        Map<String, String> errors = new HashMap<>();

        // Itera sobre os erros e os adiciona ao mapa, associando o campo ao erro correspondente.
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        // Retorna uma resposta HTTP 400 (Bad Request) contendo os erros de validação.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Trata exceções relacionadas a falhas na autenticação.
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        // Retorna uma resposta HTTP 401 (Unauthorized) com a mensagem de erro.
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro de autenticação: " + ex.getMessage());
    }
}