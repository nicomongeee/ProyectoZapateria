package com.zapateria.services;

import com.zapateria.domain.Hombre;
import java.util.List;

public interface HombreService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Hombre> getHombres(boolean activos);
    
    public Hombre getHombre(Hombre hombre);
    
    public void save (Hombre hombre);
    
    public void delete (Hombre hombre);
}