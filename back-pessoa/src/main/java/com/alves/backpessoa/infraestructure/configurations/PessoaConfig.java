package com.alves.backpessoa.infraestructure.configurations;

import com.alves.backpessoa.core.pessoa.usecase.*;
import com.alves.backpessoa.core.pessoa.usecase.impl.*;
import com.alves.backpessoa.infraestructure.delivery.converters.PessoaRestConverter;
import com.alves.backpessoa.infraestructure.persistence.converters.PessoaRepositoryConverter;
import com.alves.backpessoa.infraestructure.persistence.impl.PessoaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {

    @Bean
    public PessoaRepositoryConverter createPessoaRepositoryConverter(){
        return new PessoaRepositoryConverter();
    }

    @Bean
    public PessoaRestConverter createPessoaRestConverter(){
        return new PessoaRestConverter();
    }

    @Bean
    public PessoaServiceImpl createPessoaServiceImpl(){
        return new PessoaServiceImpl(createPessoaRepositoryConverter());
    }

    @Bean
    public CreatePessoaUseCase createCreatePessoaUseCase(){
        return new CreatePessoaUseCaseImpl(createPessoaServiceImpl());
    }

    @Bean
    public FindByIdPessoaUseCase createFindByIdPessoaUseCase(){
        return new FindByIdPessoaUseCaseImpl(createPessoaServiceImpl());
    }

    @Bean
    public UpdatePessoaUseCase createUpdatePessoaUseCase(){
        return new UpdatePessoaUseCaseImpl(createPessoaServiceImpl());
    }

    @Bean
    public DeleteByIdPessoaUseCase createDeleteByIdPessoaUseCase(){
        return new DeleteByIdPessoaUseCaseImpl(createPessoaServiceImpl());
    }

    @Bean
    public FindAllPessoaUseCase createFindAllPessoaUseCase(){
        return new FindAllPessoaUseCaseImpl(createPessoaServiceImpl());
    }
}
