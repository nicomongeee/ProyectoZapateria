package com.zapateria.controller;
import com.zapateria.domain.Accesorio;
import com.zapateria.services.AccesorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccesorioController {
     
    //Provoca que el objeto se cree si no existe o se use el que existe, no hace más de 1 objeto
    //Se conoce como inyección de dependencias
    @Autowired
    private AccesorioService accesorioService;
    
    
    @GetMapping("/accesorio/listado")
    public String inicio(Model model){
        var accesorios = accesorioService.getAccesorios(false);
        model.addAttribute("accesorios",accesorios);
        return "/accesorio/listado";
    }
    
    @GetMapping("/accesorio/nuevo")
    public String accesorioNuevo(Accesorio accesorio){
        return "/accesorio/modificar";
    }
    
     @PostMapping("/accesorio/guardar")
    public String accesorioGuardar(Accesorio accesorio){
        accesorioService.save(accesorio);
        return "redirect:/accesorio/listado";
    }
    
    @GetMapping("/accesorio/actualiza/{idAccesorio}")
    public String accesorioActualiza(Accesorio accesorio, Model model){
        accesorio=accesorioService.getAccesorio(accesorio);
        model.addAttribute("accesorio",accesorio);
        
                
        return "/accesorio/modificar";
    }
    
    @GetMapping("/accesorio/elimina/{idAccesorio}")
    public String accesorioElimina(Accesorio accesorio){
        accesorioService.delete(accesorio);
        return "redirect:/accesorio/listado";
    }
}