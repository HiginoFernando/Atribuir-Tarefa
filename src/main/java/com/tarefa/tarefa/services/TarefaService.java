package com.tarefa.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarefa.tarefa.entities.Tarefa;
import com.tarefa.tarefa.repositories.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public List<Tarefa> getTarefasByUserId(Long userId) {
        return tarefaRepository.findByUsuarioId(userId);
    }
}
