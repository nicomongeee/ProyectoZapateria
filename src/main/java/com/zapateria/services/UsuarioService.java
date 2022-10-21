package com.zapateria.services;

import com.zapateria.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Usuario> getUsuario();

    public Usuario getUsuario(Usuario usuario);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);
}
