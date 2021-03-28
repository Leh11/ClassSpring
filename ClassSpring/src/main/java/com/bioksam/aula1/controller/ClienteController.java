package com.bioksam.aula1.controller;

import com.bioksam.aula1.controller.exceptions.ObjectNotFoundException;
import com.bioksam.aula1.controller.services.ClienteService;
import com.bioksam.aula1.model.dominio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    
    public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{

        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
