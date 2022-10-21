package com.zapateria.controller;

import com.zapateria.services.UsuarioService;
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
        var texto = "Estamos en semana 4";
        model.addAttribute("saludo", texto);

        /*Usuario usuario1= new Usuario("Pedro", "pjimenez@gmail.com");
        Usuario usuario2= new Usuario("Juan", "pretana@gmail.com");
        Usuario usuario3= new Usuario("Nicole", "nmongeg@gmail.com");
        
        var usuario=Arrays.asList(usuario1, usuario2,usuario3);*/
        var usuarios = usuarioService.getUsuario(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("usuarios", usuarios);

        return "index";
    }
}
