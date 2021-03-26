
package com.bioksam.aula1.model.repositories;
import com.bioksam.aula1.model.dominio.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}