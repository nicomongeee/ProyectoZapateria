package com.zapateria.dao;

import com.zapateria.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario,Long> { //lo que esta entre <> es lo que hace que podamos interactuar con la tabla
    
}
