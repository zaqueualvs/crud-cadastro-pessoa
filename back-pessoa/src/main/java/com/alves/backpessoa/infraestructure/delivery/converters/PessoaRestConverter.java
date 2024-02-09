package com.alves.backpessoa.infraestructure.delivery.converters;

import com.alves.backpessoa.core.pessoa.domain.Pessoa;
import com.alves.backpessoa.infraestructure.delivery.rest.PessoaRest;
import com.alves.backpessoa.infraestructure.shared.RestConverter;

public class PessoaRestConverter implements RestConverter<Pessoa, PessoaRest> {

    @Override
    public Pessoa mapToDomain(PessoaRest rest) {
        return new Pessoa(rest.getId(),
                rest.getNome(),
                rest.getIdade());
    }

    @Override
    public PessoaRest mapToRest(Pessoa domain) {
        return new PessoaRest(domain.getId(),
                domain.getNome(),
                domain.getIdade());
    }
}
