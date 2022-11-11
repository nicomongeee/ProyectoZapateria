package com.zapateria.dao;

import com.zapateria.domain.Hombre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HombreDao extends JpaRepository <Hombre,Long>{
    
}
