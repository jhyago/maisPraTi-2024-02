package com.example.spring_fundamentals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    private String appMessage;
    public String getMessage() {
        return appMessage;
    }
}
