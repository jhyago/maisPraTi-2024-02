package com.example.introduction.service;

import com.example.introduction.dto.UsuarioDTO;
import com.example.introduction.model.Profile;
import com.example.introduction.model.Usuario;
import com.example.introduction.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario) {
        if (usuario.getProfile() == null) {
            Profile profile = new Profile();
            profile.setBio("Default Bio"); // Ou outra lógica para criar o Profile
            usuario.setProfile(profile);
        }
        return usuarioRepository.save(usuario);
    }


    public Optional<UsuarioDTO> getUsuario(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getProfile().getId()));
    }

    public Optional<UsuarioDTO> updateUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNome(usuario.getNome());
                    existingUsuario.setProfile(usuario.getProfile());
                    usuarioRepository.save(existingUsuario);
                    return new UsuarioDTO(existingUsuario.getId(), existingUsuario.getNome(), existingUsuario.getProfile().getId());
                });
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
