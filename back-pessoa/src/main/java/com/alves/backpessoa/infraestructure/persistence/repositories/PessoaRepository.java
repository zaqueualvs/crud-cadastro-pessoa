package com.alves.backpessoa.infraestructure.persistence.repositories;

import com.alves.backpessoa.infraestructure.persistence.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
