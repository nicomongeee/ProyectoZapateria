package com.zapateria.services;

import com.zapateria.domain.Factura;
import java.util.List;

public interface FacturaService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Factura> getFacturas(boolean activos);
    
    public Factura getFactura(Factura factura);
    
    public void save (Factura factura);
    
    public void delete (Factura factura);
}