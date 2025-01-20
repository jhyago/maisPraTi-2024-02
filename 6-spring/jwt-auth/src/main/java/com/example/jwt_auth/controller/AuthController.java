package com.example.jwt_auth.controller;

import com.example.jwt_auth.Repository.UserRepository;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())){
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok().body("{\"accessToken" + token);
        }

        return ResponseEntity.status(401).body("Credenciais inválidas.");
    }
}
