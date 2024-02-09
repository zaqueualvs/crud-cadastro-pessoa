package com.alves.backpessoa.core.pessoa.usecase.impl;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.core.pessoa.usecase.UpdatePessoaUseCase;

public class UpdatePessoaUseCaseImpl implements UpdatePessoaUseCase {

    private final PessoaRepositoryService pessoaRepositoryService;

    public UpdatePessoaUseCaseImpl(PessoaRepositoryService pessoaRepositoryService) {
        this.pessoaRepositoryService = pessoaRepositoryService;
    }

    public void update(Pessoa pessoa) {
        var pessoaO  = pessoaRepositoryService.findById(pessoa.getId());
        if(pessoaO.isPresent()){
            var pessoaDomain = pessoaO.get();
            pessoaDomain.setNome(pessoa.getNome());
            pessoaDomain.setIdade(pessoa.getIdade());
            pessoaRepositoryService.update(pessoa);
        }
    }
}
