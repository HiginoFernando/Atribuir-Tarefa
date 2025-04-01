package com.tarefa.tarefa.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.tarefa.tarefa.entities.Status;
import com.tarefa.tarefa.entities.Tarefa;
import com.tarefa.tarefa.entities.Usuario;

public class TarefaDTO implements Serializable {


    private Long id;
    private Long usuarioId;
    private String descricao;
    private String nomeSetor;
    private String prioridade;
    private Status status;
    private LocalDate dataCadastro;

    public TarefaDTO() {
    }

    public TarefaDTO(Long id, Long usuarioId, String descricao, String nomeSetor, String prioridade, Status status, LocalDate dataCadastro) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.nomeSetor = nomeSetor;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }

    public TarefaDTO(Tarefa entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.nomeSetor = entity.getNomeSetor();
        this.status = entity.getStatus();
        this.dataCadastro = entity.getDataCadastro();

        Usuario usuario = entity.getUsuario();
        if (usuario != null) {
            this.usuarioId = usuario.getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
