package com.bioksam.aula1.services;

import java.util.Optional;

import com.bioksam.aula1.dominio.Categoria;
import com.bioksam.aula1.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
