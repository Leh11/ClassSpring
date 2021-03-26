package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
    
}
