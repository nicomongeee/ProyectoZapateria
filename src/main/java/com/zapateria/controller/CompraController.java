package com.zapateria.controller;

import com.zapateria.domain.Compra;
import com.zapateria.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraController {

    @Autowired

    private CompraService compraService;

    @GetMapping("/compra/listado")
    public String inicio(Model model) {

        var compras = compraService.getCompra(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("compras", compras);

        return "/compra/listado";
    }

    //mapeo de los recursos
    @GetMapping("/compra/nuevo")
    public String compraNuevo(Compra compra) {
        return "/compra/modificar";
    }

    @PostMapping("/compra/guardar")
    public String compraGuardar(Compra compra) {
        compraService.save(compra);
        return "redirect:/compra/listado"; //para redireccionar la ruta
    }

    @GetMapping("/compra/actualiza/{idCompra}")
    public String compraActualiza(Compra compra, Model model) {
        compra = compraService.getCompra(compra); // va y hace un select en la tabla
        model.addAttribute("compra", compra);
        return "/compra/modificar";
    }

    @GetMapping("/compra/elimina/{idCompra}")
    public String compraElimina(Compra compra) {
        compraService.delete(compra); // va y hace un select en la tabla
        return "redirect:/compra/listado";
    }
}
