package com.tarefa.tarefa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.tarefa.entities.Tarefa;
import com.tarefa.tarefa.entities.Usuario;
import com.tarefa.tarefa.repositories.TarefaRepository;
import com.tarefa.tarefa.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @PostMapping(value = "/{usuarioId}/tarefas")
    public ResponseEntity<Tarefa> createTarefa(@PathVariable Long usuarioId, @RequestBody Tarefa tarefa){
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        tarefa.setUsuario(usuario.get()); 
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(tarefaSalva);
    }

    @GetMapping("/{usuarioId}/tarefas")
    public List<Tarefa> getTarefasByUser(@PathVariable Long usuarioId){
        return tarefaRepository.findByUsuarioId(usuarioId);
    }
}
