package com.alves.backpessoa.core.pessoa.usecase.impl;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.core.pessoa.usecase.CreatePessoaUseCase;

public class CreatePessoaUseCaseImpl implements CreatePessoaUseCase {

    private final PessoaRepositoryService pessoaRepositoryService;

    public CreatePessoaUseCaseImpl(PessoaRepositoryService pessoaRepositoryService) {
        this.pessoaRepositoryService = pessoaRepositoryService;
    }

    public Pessoa create(Pessoa pessoa) {
        return pessoaRepositoryService.create(pessoa);
    }
}
