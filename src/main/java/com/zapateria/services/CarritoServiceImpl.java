package com.zapateria.services;

import com.zapateria.dao.CarritoDao;
import com.zapateria.domain.Carrito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServiceImpl implements CarritoService {

    //@Autowired provoca que si el objeto esta en memoria se utiliza
    //ese y si no, se crea
    @Autowired
    private CarritoDao carritoDao;

    //CRUD
    @Override
    @Transactional(readOnly = true)
    public List<Carrito> getCarrito() {
        return (List<Carrito>) carritoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Carrito carrito) {
        carritoDao.save(carrito);
    }

    @Override
    @Transactional
    public void delete(Carrito carrito) {
        carritoDao.delete(carrito);
    }
}
