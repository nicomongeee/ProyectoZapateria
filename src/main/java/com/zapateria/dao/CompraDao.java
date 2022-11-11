package com.zapateria.dao;

import com.zapateria.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompraDao extends JpaRepository<Compra,Long> { //lo que esta entre <> es lo que hace que podamos interactuar con la tabla
    
}
