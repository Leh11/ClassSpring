package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
