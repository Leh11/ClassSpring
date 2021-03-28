package com.bioksam.aula1.model.repositories;

import com.bioksam.aula1.model.dominio.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
