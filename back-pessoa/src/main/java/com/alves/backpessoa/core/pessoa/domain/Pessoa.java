package com.alves.backpessoa.core.pessoa.domain;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private Long id;
    private String nome;
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
