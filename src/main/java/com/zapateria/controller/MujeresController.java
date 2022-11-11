package com.zapateria.controller;

import com.zapateria.domain.Mujeres;
import com.zapateria.services.MujeresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MujeresController {

    @Autowired

    private MujeresService mujeresService;

    @GetMapping("/mujeres/listado")
    public String inicio(Model model) {

        var mujeres = mujeresService.getMujeres(false); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("mujeres", mujeres);

        return "/mujeres/listado";
    }

    //mapeo de los recursos
    @GetMapping("/mujeres/nuevo")
    public String mujeresNuevo(Mujeres mujeres) {
        return "/mujeres/modificar";
    }

    @PostMapping("/mujeres/guardar")
    public String mujeresGuardar(Mujeres mujeres) {
        mujeresService.save(mujeres);
        return "redirect:/mujeres/listado"; //para redireccionar la ruta
    }

    @GetMapping("/mujeres/actualiza/{idMujer}")
    public String mujeresActualiza(Mujeres mujeres, Model model) {
        mujeres = mujeresService.getMujeres(mujeres); // va y hace un select en la tabla
        model.addAttribute("mujeres", mujeres);
        return "/mujeres/modificar";
    }

    @GetMapping("/mujeres/elimina/{idMujer}")
    public String mujeresElimina(Mujeres mujeres) {
        mujeresService.delete(mujeres); // va y hace un select en la tabla
        return "redirect:/mujeres/listado";
    }
}
