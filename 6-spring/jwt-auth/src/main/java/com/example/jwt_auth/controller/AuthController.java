package com.example.jwt_auth.controller;

import com.example.jwt_auth.repository.UserRepository;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.service.UserService;
import com.example.jwt_auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.saveUser(user);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
                return jwtUtil.generateToken(authentication.getName());
    }


}
