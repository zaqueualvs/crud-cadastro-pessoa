package com.alves.backpessoa.infraestructure.delivery.controllers;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.infraestructure.delivery.rest.PessoaRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PessoaController {

    public ResponseEntity<PessoaRest> create(PessoaRest pessoaRest);
    public ResponseEntity<List<PessoaRest>> findAll();
    public ResponseEntity<Object> findById(Long id);
    public ResponseEntity<Object> deleteById(Long id);
    public ResponseEntity<Object> update(PessoaRest pessoaRest);
}
