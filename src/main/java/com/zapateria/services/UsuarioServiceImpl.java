package com.zapateria.services;

import com.zapateria.dao.UsuarioDao;
import com.zapateria.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    //@Autowired provoca que si el objeto esta en memoria se utiliza
    //ese y si no, se crea
    @Autowired
    private UsuarioDao usuarioDao;

    //CRUD
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getId_usuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
