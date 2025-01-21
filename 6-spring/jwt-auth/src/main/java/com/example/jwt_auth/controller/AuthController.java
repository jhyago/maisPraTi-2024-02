package com.example.jwt_auth.controller;

import com.example.jwt_auth.Repository.UserRepository;
import com.example.jwt_auth.model.User;
import com.example.jwt_auth.security.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
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
            return ResponseEntity.ok().body("{\"accessToken:" + token);
        }

        return ResponseEntity.status(401).body("Credenciais inválidas.");
    }


}
