package com.zapateria.services;

import com.zapateria.dao.HombreDao;
import com.zapateria.domain.Hombre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HombreServiceImpl implements HombreService{
    //Provoca que si el objeto ya está  en memoria no se crea y se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private HombreDao hombreDao;
    
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    @Override
    @Transactional(readOnly=true)
    public List<Hombre> getHombres(boolean filtro){
        var lista=(List<Hombre>)hombreDao.findAll();
        
        //Solo activas retornan
        if (filtro){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Hombre getHombre(Hombre hombre){
    return hombreDao.findById(hombre.getIdHombre()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save (Hombre hombre){
        hombreDao.save(hombre);
    }
    
    @Override
    @Transactional
    public void delete (Hombre hombre){
        hombreDao.delete(hombre);
    }
}