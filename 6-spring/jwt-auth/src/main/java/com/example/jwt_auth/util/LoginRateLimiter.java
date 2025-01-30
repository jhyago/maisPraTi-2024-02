package com.example.jwt_auth.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Filter;

@Component
public class LoginRateLimiter implements Filter {
        private static final int MAX_ATTEMPTS = 5;
        private static final long BLOCK_DURATION = 60;

        private final Map<String, LoginAttempt> attempts = new ConcurrentHashMap<>();

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
            if(request instanceof HttpServletRequest httpRequest && response instanceof HttpServletResponse httpResponse) {
                if(httpRequest.getRequestURI().equals("/auth/login") && httpRequest.getMethod().equalsIgnoreCase("POST")) {
                    String ip = request.getRemoteAddr();

                    LoginAttempt loginAttempt = attempts.getOrDefault(ip, new LoginAttempt);

                    if(loginAttempt.isBlocked()) {
                        httpResponse.setStatus(HttpServletResponse.SC_TOO_MANY_REQUESTS);
                        httpResponse.getWriter().write("Muitas tentativas de login.");
                    }

                    loginAttempt.incrementAttempts();
                    attempts.put(ip, loginAttempt);
                }
            }

            filterChain.doFilter(request, response);
        }

        private static class LoginAttempt {
            private int attempts;
            private Instant blockTime;

            public LoginAttempt() {
                this.attempts = 0;
                this.blockTime = null;
            }

            public void incrementAttempts() {
                if(blockTime != null && Instant.now().isBefore(blockTime)) {
                    return;
                }

                attempts++;

                if(attempts >= MAX_ATTEMPTS) {
                    blockTime = Instant.now().plusSeconds(BLOCK_DURATION);
                }
            }

            public boolean isBlocked(){
                return blockTime != null && Instant.now().isBefore(blockTime);
            }
        }
}
