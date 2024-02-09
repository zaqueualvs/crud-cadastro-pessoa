package com.alves.backpessoa.core.pessoa.ports;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaRepositoryService {

    public Pessoa create(Pessoa pessoa);
    public List<Pessoa> findAll();
    public Optional<Pessoa> findById(Long id);
    public void update(Pessoa pessoa);
    public void deleteById(Long id);
}
