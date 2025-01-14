package com.example.api_user.service;

import com.example.api_user.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarUsuarios() {
        return this.usuarios;
    }

    public Usuario criarUsuario (Usuario usuario) {
        usuario.setId((long) (usuarios.size() + 1));
        usuarios.add(usuario);
        return usuario;
    }
}
