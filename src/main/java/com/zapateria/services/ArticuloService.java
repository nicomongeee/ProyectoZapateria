package com.zapateria.services;

import com.zapateria.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulo(boolean activo);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);
}
