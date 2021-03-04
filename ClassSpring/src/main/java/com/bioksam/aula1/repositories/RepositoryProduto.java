package com.bioksam.aula1.repositories;

import com.bioksam.aula1.dominio.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, Integer>{
    
}
