package com.alves.backpessoa.core.pessoa.usecase;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;

import java.util.Optional;

public interface FindByIdPessoaUseCase {

    public Optional<Pessoa> findById(Long id);
}
