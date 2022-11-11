package com.zapateria.dao;

import com.zapateria.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long>{
    
}
