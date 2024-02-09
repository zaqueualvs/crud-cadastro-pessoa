package com.alves.backpessoa.infraestructure.configurations;

import com.alves.backpessoa.infraestructure.delivery.controllers.impl.PessoaControllerImpl;
import com.alves.backpessoa.infraestructure.delivery.rest.PessoaRest;
import com.alves.backpessoa.infraestructure.persistence.entities.PessoaEntity;
import com.alves.backpessoa.infraestructure.persistence.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class dbConfig implements CommandLineRunner {

    @Autowired
    private PessoaControllerImpl pessoaController;

    @Override
    public void run(String... args) throws Exception {
        List<PessoaRest> list = Arrays.asList(
                new PessoaRest(null, "Zaqueu", 24),
                new PessoaRest(null, "Ana", 32),
                new PessoaRest(null, "Juliana", 18),
                new PessoaRest(null, "Marcos", 78),
                new PessoaRest(null, "Ze", 44),
                new PessoaRest(null, "Cidah", 17)
        );

        for (PessoaRest a : list) {
            pessoaController.create(a);
        }
    }
}
