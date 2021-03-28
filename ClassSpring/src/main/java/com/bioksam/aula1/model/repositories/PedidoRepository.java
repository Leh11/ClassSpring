package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
