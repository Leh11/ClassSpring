package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
