package com.example.Integration.controller;

import com.example.Integration.model.Curso;
import com.example.Integration.model.Usuario;
import com.example.Integration.repository.CursoRepository;
import com.example.Integration.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/{usuarioId}/matricular/{cursoId}")
    public ResponseEntity<Usuario> matricularUsuario(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        usuario.getCursos().add(curso);
        curso.setUsuario(usuario);

        usuarioRepository.save(usuario);
        cursoRepository.save(curso);

        return ResponseEntity.ok(usuario);
    }
}
