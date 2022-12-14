package com.zapateria.controller;

import com.zapateria.services.ArticuloService;
import com.zapateria.services.UsuarioService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired

    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {     
        
        var articulo = articuloService.getArticulo(true); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("articulo", articulo);

        return "index";
    }
}
