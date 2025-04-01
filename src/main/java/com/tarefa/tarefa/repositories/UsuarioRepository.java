package com.tarefa.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.tarefa.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
