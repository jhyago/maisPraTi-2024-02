package com.example.api_user.controller;

import com.example.api_user.model.Usuario;
import com.example.api_user.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criarUsuarioComPerfil(@RequestParam String nome, @RequestParam String bio) {
       return usuarioService.criarUsuarioComPerfil(nome, bio);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public void usuarioEditar(@PathVariable Long id, @RequestParam String nome) {
        usuarioService.update(id, nome);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
    }

}
