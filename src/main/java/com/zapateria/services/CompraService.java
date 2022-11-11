package com.zapateria.services;

import com.zapateria.domain.Compra;
import java.util.List;

public interface CompraService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Compra> getCompra();

    public Compra getCompra(Compra compra);

    public void save(Compra compra);

    public void delete(Compra compra);
}
