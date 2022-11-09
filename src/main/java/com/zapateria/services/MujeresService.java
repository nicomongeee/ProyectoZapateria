package com.zapateria.services;

import com.zapateria.domain.Mujeres;
import java.util.List;

public interface MujeresService {

    public List<Mujeres> getMujeres(boolean activo);

    public Mujeres getMujeres(Mujeres mujeres);

    public void save(Mujeres mujeres);

    public void delete(Mujeres mujeres);
}
