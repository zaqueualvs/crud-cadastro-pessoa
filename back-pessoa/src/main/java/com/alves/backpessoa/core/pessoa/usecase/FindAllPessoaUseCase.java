package com.alves.backpessoa.core.pessoa.usecase;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;

import java.util.List;

public interface FindAllPessoaUseCase {

    public List<Pessoa> findAll();
}
