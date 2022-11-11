package com.zapateria.services;

import com.zapateria.dao.AccesorioDao;
import com.zapateria.domain.Accesorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccesorioServiceImpl implements AccesorioService{
    //Provoca que si el objeto ya está  en memoria no se crea y se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private AccesorioDao accesorioDao;
    
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    @Override
    @Transactional(readOnly=true)
    public List<Accesorio> getAccesorios(boolean filtro){
        var lista=(List<Accesorio>)accesorioDao.findAll();
        
        //Solo activas retornan
        if (filtro){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Accesorio getAccesorio(Accesorio accesorio){
    return accesorioDao.findById(accesorio.getIdAccesorio()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save (Accesorio accesorio){
        accesorioDao.save(accesorio);
    }
    
    @Override
    @Transactional
    public void delete (Accesorio accesorio){
        accesorioDao.delete(accesorio);
    }
}