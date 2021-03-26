package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
}
