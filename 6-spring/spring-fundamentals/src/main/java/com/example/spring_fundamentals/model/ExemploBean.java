package com.example.spring_fundamentals.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ExemploBean {

    public ExemploBean() {
        System.out.println("Construtor: Exemplo Bean foi criado!");
    }
    @PostConstruct
    public void init() {
        System.out.println("Bean foi inicializado!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean está sendo destruído");
    }
}
