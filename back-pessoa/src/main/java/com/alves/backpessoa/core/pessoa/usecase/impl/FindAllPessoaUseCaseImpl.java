package com.alves.backpessoa.core.pessoa.usecase.impl;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.core.pessoa.usecase.FindAllPessoaUseCase;

import java.util.List;

public class FindAllPessoaUseCaseImpl implements FindAllPessoaUseCase {

    private final PessoaRepositoryService pessoaRepositoryService;

    public FindAllPessoaUseCaseImpl(PessoaRepositoryService pessoaRepositoryService) {
        this.pessoaRepositoryService = pessoaRepositoryService;
    }

    public List<Pessoa> findAll(){
        return pessoaRepositoryService.findAll();
    }
}
