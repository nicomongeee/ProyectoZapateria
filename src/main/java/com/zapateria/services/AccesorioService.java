package com.zapateria.services;

import com.zapateria.domain.Accesorio;
import java.util.List;

public interface AccesorioService {
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    public List<Accesorio> getAccesorios(boolean activos);
    
    public Accesorio getAccesorio(Accesorio accesorio);
    
    public void save (Accesorio accesorio);
    
    public void delete (Accesorio accesorio);
}