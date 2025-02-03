package com.example.spring_fundamentals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String appMessage() {
        return "Este é um bean criado manualmente!";
    }
}
