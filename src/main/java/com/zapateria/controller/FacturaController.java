package com.zapateria.controller;
import com.zapateria.domain.Factura;
import com.zapateria.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FacturaController {
     
    //Provoca que el objeto se cree si no existe o se use el que existe, no hace más de 1 objeto
    //Se conoce como inyección de dependencias
    @Autowired
    private FacturaService facturaService;
    
    
    @GetMapping("/factura/listado")
    public String inicio(Model model){
        var facturas = facturaService.getFacturas(false);
        model.addAttribute("facturas",facturas);
        return "/factura/listado";
    }
    
    @GetMapping("/factura/nuevo")
    public String facturaNuevo(Factura factura){
        return "/factura/modificar";
    }
    
     @PostMapping("/factura/guardar")
    public String facturaGuardar(Factura factura){
        facturaService.save(factura);
        return "redirect:/factura/listado";
    }
    
    @GetMapping("/factura/actualiza/{idFactura}")
    public String facturaActualiza(Factura factura, Model model){
        factura=facturaService.getFactura(factura);
        model.addAttribute("factura",factura);
        
                
        return "/factura/modificar";
    }
    
    @GetMapping("/factura/elimina/{idFactura}")
    public String facturaElimina(Factura factura){
        facturaService.delete(factura);
        return "redirect:/factura/listado";
    }
}