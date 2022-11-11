package com.zapateria.services;

import com.zapateria.dao.CompraDao;
import com.zapateria.domain.Compra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompraServiceImpl implements CompraService {

    //@Autowired provoca que si el objeto esta en memoria se utiliza
    //ese y si no, se crea
    @Autowired
    private CompraDao compraDao;

    //CRUD
    @Override
    @Transactional(readOnly = true)
    public List<Compra> getCompra() {
        return (List<Compra>) compraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Compra getCompra(Compra compra) {
        return compraDao.findById(compra.getIdCompra()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Compra compra) {
        compraDao.save(compra);
    }

    @Override
    @Transactional
    public void delete(Compra compra) {
        compraDao.delete(compra);
    }
}
