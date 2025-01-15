package com.example.api_user.service;

import com.example.api_user.model.Profile;
import com.example.api_user.model.Usuario;
import com.example.api_user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
