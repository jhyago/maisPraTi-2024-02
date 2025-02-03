package com.example.spring_fundamentals.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditLogService {
    private final List<String> logs = new ArrayList<>();

    public AuditLogService(){
        System.out.println("Serviço de auditoria foi instanciado!");
    }

    @PostConstruct
    public void init() {
        String message = "[ " + LocalDateTime.now() + " ] - Sistema Inicializado!";
        logs.add(message);
        System.out.println("PostConstruct Finished: " + message);
    }

    public void logAction(String user, String action) {
        String log = "[ " + LocalDateTime.now() + " ] - Ação registrada no sistema pelo Usuário: " + user + " - Ação: " + action;
        logs.add(log);
        System.out.println("Log: " + log);
    }

    @PreDestroy
    public void destroy() {
        String log = "[ " + LocalDateTime.now() + " ] - Serviço sendo destruído!";
        logs.add(log);
        System.out.println("PreDestroy: " + log);
    }

    public List<String> getLogs() {
        return logs;
    }
}
