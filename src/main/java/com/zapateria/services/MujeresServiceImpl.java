package com.zapateria.services;

import com.zapateria.dao.MujeresDao;
import com.zapateria.domain.Mujeres;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MujeresServiceImpl implements MujeresService {

    @Autowired
    private MujeresDao mujeresDao;

    @Override
    @Transactional(readOnly = true)
    public List<Mujeres> getMujeres(boolean filtro) {
        var lista = (List<Mujeres>) mujeresDao.findAll();

        if (filtro) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Mujeres getMujeres(Mujeres mujeres) {
        return mujeresDao.findById(mujeres.getIdMujer()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Mujeres mujeres) {
        mujeresDao.save(mujeres);
    }

    @Override
    @Transactional
    public void delete(Mujeres mujeres) {
        mujeresDao.delete(mujeres);
    }
}
