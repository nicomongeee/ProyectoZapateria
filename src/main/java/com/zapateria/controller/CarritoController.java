package com.zapateria.controller;

import com.zapateria.domain.Carrito;
import com.zapateria.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarritoController {

    @Autowired

    private CarritoService carritoService;

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {

        var carritos = carritoService.getCarrito(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("carritos", carritos);

        return "/carrito/listado";
    }

    //mapeo de los recursos
    @GetMapping("/carrito/nuevo")
    public String carritoNuevo(Carrito carrito) {
        return "/carrito/modificar";
    }

    @PostMapping("/carrito/guardar")
    public String carritoGuardar(Carrito carrito) {
        carritoService.save(carrito);
        return "redirect:/carrito/listado"; //para redireccionar la ruta
    }

    @GetMapping("/carrito/actualiza/{idCarrito}")
    public String carritoActualiza(Carrito carrito, Model model) {
        carrito = carritoService.getCarrito(carrito); // va y hace un select en la tabla
        model.addAttribute("carrito", carrito);
        return "/carrito/modificar";
    }

    @GetMapping("/carrito/elimina/{idCarrito}")
    public String carritoElimina(Carrito carrito) {
        carritoService.delete(carrito); // va y hace un select en la tabla
        return "redirect:/carrito/listado";
    }
}
