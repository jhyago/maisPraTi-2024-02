package com.example.api_user.controller;

import com.example.api_user.dto.UsuarioDTO;
import com.example.api_user.model.Usuario;
import com.example.api_user.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(new UsuarioDTO(savedUsuario.getId(), savedUsuario.getNome(), savedUsuario.getProfile().getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<UsuarioDTO> updatedUsuario = usuarioService.updateUsuario(id, usuario);
        return updatedUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        Optional<UsuarioDTO> usuario = usuarioService.getUsuario(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
