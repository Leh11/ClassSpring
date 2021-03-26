package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
