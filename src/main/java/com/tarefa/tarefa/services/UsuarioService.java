package com.tarefa.tarefa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarefa.tarefa.entities.Usuario;
import com.tarefa.tarefa.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }
}
