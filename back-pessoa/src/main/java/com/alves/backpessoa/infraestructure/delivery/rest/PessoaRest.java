package com.alves.backpessoa.infraestructure.delivery.rest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PessoaRest implements Serializable {
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Integer idade;
}
