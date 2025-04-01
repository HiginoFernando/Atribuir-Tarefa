package com.tarefa.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarefa.tarefa.entities.Tarefa;
import com.tarefa.tarefa.repositories.TarefaRepository;

@Service // Indica que essa classe é um serviço do Spring (lógica de negócio)
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Autowired // Injeta o repositório no serviço (menos código, mais eficiência)
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional // Garante que essa operação seja atômica (evita problemas no banco)
    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Transactional // Busca todas as tarefas de um usuário pelo ID
    public List<Tarefa> getTarefasByUserId(Long userId) {
        return tarefaRepository.findByUsuarioId(userId);
    }
}
