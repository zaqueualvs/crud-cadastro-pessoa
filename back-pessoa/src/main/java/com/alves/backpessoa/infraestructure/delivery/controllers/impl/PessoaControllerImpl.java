package com.alves.backpessoa.infraestructure.delivery.controllers.impl;

import com.alves.backpessoa.core.pessoa.usecase.*;
import com.alves.backpessoa.infraestructure.delivery.controllers.PessoaController;
import com.alves.backpessoa.infraestructure.delivery.converters.PessoaRestConverter;
import com.alves.backpessoa.infraestructure.delivery.rest.PessoaRest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaControllerImpl implements PessoaController {

    @Autowired
    private CreatePessoaUseCase createPessoaUseCase;
    @Autowired
    private FindByIdPessoaUseCase findByIdPessoaUseCase;
    @Autowired
    private DeleteByIdPessoaUseCase deleteByIdPessoaUseCase;
    @Autowired
    private FindAllPessoaUseCase findAllPessoaUseCase;
    @Autowired
    private UpdatePessoaUseCase updatePessoaUseCase;
    @Autowired
    private PessoaRestConverter pessoaRestConverter;

    @PostMapping
    @Override
    public ResponseEntity<PessoaRest> create(@RequestBody @Valid PessoaRest pessoaRest) {
        var pessoa = pessoaRestConverter.mapToDomain(pessoaRest);
        pessoa = createPessoaUseCase.create(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRestConverter.mapToRest(pessoa));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PessoaRest>> findAll() {
        List<PessoaRest> pessoaRests = findAllPessoaUseCase.findAll().stream()
                .map(pessoa -> pessoaRestConverter.mapToRest(pessoa))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRests);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        var pessoa = findByIdPessoaUseCase.findById(id);
        var pessoaRest = pessoaRestConverter.mapToRest(pessoa.get());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRest);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        deleteByIdPessoaUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pessoa deletada");
    }

    @PutMapping
    @Override
    public ResponseEntity<Object> update(@RequestBody @Valid PessoaRest pessoaRest) {
        updatePessoaUseCase.update(pessoaRestConverter.mapToDomain(pessoaRest));
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa atualizada");
    }
}
