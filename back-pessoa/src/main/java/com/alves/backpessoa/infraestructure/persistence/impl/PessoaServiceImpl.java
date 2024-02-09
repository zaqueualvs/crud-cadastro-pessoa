package com.alves.backpessoa.infraestructure.persistence.impl;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.core.pessoa.ports.PessoaRepositoryService;
import com.alves.backpessoa.infraestructure.persistence.converters.PessoaRepositoryConverter;
import com.alves.backpessoa.infraestructure.persistence.entities.PessoaEntity;
import com.alves.backpessoa.infraestructure.persistence.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaRepositoryService {

    @Autowired
    private PessoaRepository pessoaRepository;
    private PessoaRepositoryConverter repositoryConverter;

    public PessoaServiceImpl(PessoaRepositoryConverter repositoryConverter) {
        this.repositoryConverter = repositoryConverter;
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
        var pessoaEntity = pessoaRepository.save(repositoryConverter.mapToEntity(pessoa));
        pessoa.setId(pessoaEntity.getId());
        return pessoa;
    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll().stream()
                .map(pessoaEntity -> repositoryConverter.mapToDomain(pessoaEntity))
                .collect(Collectors.toList());
        return pessoas;
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        var pessoaEntityOptional = pessoaRepository.findById(id);
        var pessoa = repositoryConverter.mapToDomain(pessoaEntityOptional.get());
        return Optional.ofNullable(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
            pessoaRepository.save(repositoryConverter.mapToEntity(pessoa));
    }

    @Override
    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
