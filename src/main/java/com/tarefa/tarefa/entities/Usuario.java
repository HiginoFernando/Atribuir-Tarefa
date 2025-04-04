package com.tarefa.tarefa.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario") // Define que essa entidade será armazenada na tabela "tb_usuario"
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente pelo banco
    private Long id;
    private String nome;
    private String email;

    @JsonIgnore // Evita loop infinito na serialização (evita que tarefas puxem usuários e vice-versa)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY) // Um usuário pode ter várias tarefas
    private List<Tarefa> tarefas = new ArrayList<>();

    public Usuario() {
    }

    // Getters e Setters (basicamente, só para acessar e modificar os atributos)
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
