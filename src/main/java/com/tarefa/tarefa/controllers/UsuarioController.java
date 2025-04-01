package com.tarefa.tarefa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.tarefa.dto.UsuarioDTO;
import com.tarefa.tarefa.entities.Usuario;
import com.tarefa.tarefa.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

   
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuarioSalvo));
    }

   
    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(new UsuarioDTO(usuario));
        }

        return usuariosDTO;
    }


 
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId){
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        return ResponseEntity.ok(usuario.orElse(null)); 
    }
}
