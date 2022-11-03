package com.zapateria.controller;

import com.zapateria.services.UsuarioService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired

    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {     
        
        var usuarios = usuarioService.getUsuario(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("usuarios", usuarios);

        return "index";
    }
}
