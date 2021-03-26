package com.bioksam.aula1.controller.services;

import java.util.Optional;

import com.bioksam.aula1.controller.exceptions.ObjectNotFoundException;
import com.bioksam.aula1.model.dominio.Categoria;
import com.bioksam.aula1.model.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException("Ojecto nao encontrado: id"+ id +
        ", Tipo: "+ Categoria.class.getName()));
    }
}
