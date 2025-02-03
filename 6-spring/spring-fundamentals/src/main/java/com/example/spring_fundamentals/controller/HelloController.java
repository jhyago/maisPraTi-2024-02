package com.example.spring_fundamentals.controller;

import com.example.spring_fundamentals.model.AuditLogService;
import com.example.spring_fundamentals.service.HelloService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private AuditLogService auditLogService;

    @Autowired
    private HelloService helloService;

    @PostMapping("/log")
    public String logAction(@RequestParam String user, @RequestParam String action){
        auditLogService.logAction(user, action);
        return "Ação registrada com sucesso";
    }

    @GetMapping("/logs")
    public List<String> getLogs() {
        return auditLogService.getLogs();
    }
    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getMessage();
    }
}
