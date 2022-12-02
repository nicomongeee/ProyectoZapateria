package com.zapateria.dao;

import com.zapateria.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloDao extends JpaRepository <Articulo, Long>{
    
}
