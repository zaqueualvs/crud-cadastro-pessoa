package com.alves.backpessoa.infraestructure.persistence.converters;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.infraestructure.persistence.entities.PessoaEntity;
import com.alves.backpessoa.infraestructure.shared.RepositoryConverter;

public class PessoaRepositoryConverter implements RepositoryConverter<Pessoa, PessoaEntity> {

    @Override
    public Pessoa mapToDomain(PessoaEntity entity) {
        return new Pessoa(entity.getId(),
                entity.getNome(),
                entity.getIdade());
    }

    @Override
    public PessoaEntity mapToEntity(Pessoa domain) {
        return new PessoaEntity(domain.getId(),
                domain.getNome(),
                domain.getIdade());
    }
}
