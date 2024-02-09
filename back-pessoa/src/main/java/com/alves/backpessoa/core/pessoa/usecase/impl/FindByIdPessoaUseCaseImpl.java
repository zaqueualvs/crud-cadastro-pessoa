package com.alves.backpessoa.core.pessoa.usecase.impl;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.core.pessoa.usecase.FindByIdPessoaUseCase;

import java.util.Optional;

public class FindByIdPessoaUseCaseImpl implements FindByIdPessoaUseCase {

    private final PessoaRepositoryService pessoaRepositoryService;

    public FindByIdPessoaUseCaseImpl(PessoaRepositoryService pessoaRepositoryService) {
        this.pessoaRepositoryService = pessoaRepositoryService;
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepositoryService.findById(id);
    }
}
