package com.tarefa.tarefa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.tarefa.tarefa.entities.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	List<Tarefa> findByUsuarioId(Long usuarioId);

}
