package com.bioksam.aula1.controller.services;

import java.util.Optional;

import com.bioksam.aula1.controller.exceptions.ObjectNotFoundException;
import com.bioksam.aula1.model.dominio.Cliente;
import com.bioksam.aula1.model.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente findById(Integer id) throws ObjectNotFoundException {
        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException("Ojecto nao encontrado: id"+ id +
        ", Tipo: "+ Cliente.class.getName()));
    }
}
