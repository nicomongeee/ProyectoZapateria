package com.zapateria.controller;

import com.zapateria.dao.UsuarioDao;
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

    @GetMapping("/usuario/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "modificarUsuario";
    }

    @PostMapping("/usuario/guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuario/actualiza/{idUsuario}")
    public String usuarioActualiza(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "modificarUsuario";
    }

    @GetMapping("/usuario/elimina/{idUsuario}")
    public String usuarioElimina(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/";
    }
}
