package com.alves.backpessoa.core.pessoa.usecase.impl;

import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.core.pessoa.usecase.DeleteByIdPessoaUseCase;

public class DeleteByIdPessoaUseCaseImpl implements DeleteByIdPessoaUseCase {
    private final PessoaRepositoryService pessoaRepositoryService;

    public DeleteByIdPessoaUseCaseImpl(PessoaRepositoryService pessoaRepositoryService) {
        this.pessoaRepositoryService = pessoaRepositoryService;
    }

    public void deleteById(Long id) {
        pessoaRepositoryService.deleteById(id);
    }
}
