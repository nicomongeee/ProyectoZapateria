package com.zapateria.services;


import com.zapateria.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
}
