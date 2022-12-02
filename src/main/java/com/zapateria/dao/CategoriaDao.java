package com.zapateria.dao;

import com.zapateria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<Categoria,Long>{ //tiene todos los elementos para interactuar con la BD
    
}
