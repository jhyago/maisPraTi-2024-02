package com.example.api_user.service;

import com.example.api_user.model.Profile;
import com.example.api_user.model.Usuario;
import com.example.api_user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuarioComPerfil(String nome, String bio) {
        Profile profile = new Profile();
        profile.setBio(bio);

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setProfile(profile);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void update(Long id, String nome) {
        usuarioRepository.findById(id).ifPresent(usuario -> {
                usuario.setNome(nome);
                usuarioRepository.save(usuario);
        });
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }


}
