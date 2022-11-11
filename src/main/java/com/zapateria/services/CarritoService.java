package com.zapateria.services;

import com.zapateria.domain.Carrito;
import java.util.List;

public interface CarritoService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Carrito> getCarrito();

    public Carrito getCarrito(Carrito carrito);

    public void save(Carrito carrito);

    public void delete(Carrito carrito);
}
