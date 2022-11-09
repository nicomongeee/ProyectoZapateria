package com.zapateria.dao;

import com.zapateria.domain.Mujeres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MujeresDao extends JpaRepository<Mujeres, Long> { //lo que esta entre <> es lo que hace que podamos interactuar con la tabla

}
