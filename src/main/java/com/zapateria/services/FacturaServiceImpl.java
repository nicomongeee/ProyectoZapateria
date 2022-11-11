package com.zapateria.services;

import com.zapateria.dao.FacturaDao;
import com.zapateria.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FacturaServiceImpl implements FacturaService{
    //Provoca que si el objeto ya está  en memoria no se crea y se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private FacturaDao facturaDao;
    
    
    //Los métodos para poder hacer un Crud
    //Create Read Update Delete
    @Override
    @Transactional(readOnly=true)
    public List<Factura> getFacturas(boolean filtro){
        var lista=(List<Factura>)facturaDao.findAll();
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Factura getFactura(Factura factura){
    return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save (Factura factura){
        facturaDao.save(factura);
    }
    
    @Override
    @Transactional
    public void delete (Factura factura){
        facturaDao.delete(factura);
    }
}