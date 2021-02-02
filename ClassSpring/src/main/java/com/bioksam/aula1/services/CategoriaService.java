package com.bioksam.aula1.services;

import java.util.Optional;

import com.bioksam.aula1.dominio.Categoria;
import com.bioksam.aula1.repositories.CategoriaRepository;
import com.bioksam.aula1.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria find(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repository.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException("Ojecto nao encontrado: id"+ id +
        ", Tipo: "+ Categoria.class.getName()));
    }
}
