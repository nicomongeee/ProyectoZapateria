package com.zapateria.controller;

import com.zapateria.domain.Usuario;
import com.zapateria.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @Autowired

    private UsuarioService usuarioService;

    @GetMapping("/usuario/listado")
    public String inicio(Model model) {

        var usuario = usuarioService.getUsuario(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("usuario", usuario);

        return "/usuario/listado";
    }

    //mapeo de los recursos
    @GetMapping("/usuario/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modificar";
    }

    @PostMapping("/usuario/guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/listado"; //para redireccionar la ruta
    }

    @GetMapping("/usuario/actualiza/{idUsuario}")
    public String usuarioActualiza(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario); // va y hace un select en la tabla
        model.addAttribute("usuario", usuario);
        return "/usuario/modificar";
    }

    @GetMapping("/usuario/elimina/{idUsuario}")
    public String usuarioElimina(Usuario usuario) {
        usuarioService.delete(usuario); // va y hace un select en la tabla
        return "redirect:/usuario/listado";
    }
}
