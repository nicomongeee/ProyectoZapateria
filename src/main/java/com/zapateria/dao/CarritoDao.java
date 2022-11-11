package com.zapateria.dao;

import com.zapateria.domain.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoDao extends JpaRepository<Carrito,Long> { //lo que esta entre <> es lo que hace que podamos interactuar con la tabla
    
}
