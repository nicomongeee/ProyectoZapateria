package com.zapateria.controller;
import com.zapateria.domain.Hombre;
import com.zapateria.services.HombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HombreController {
     
    //Provoca que el objeto se cree si no existe o se use el que existe, no hace más de 1 objeto
    //Se conoce como inyección de dependencias
    @Autowired
    private HombreService hombreService;
    
    
    @GetMapping("/hombre/listado")
    public String inicio(Model model){
        var hombres = hombreService.getHombres(false);
        model.addAttribute("hombres",hombres);
        return "/hombre/listado";
    }
    
    @GetMapping("/hombre/nuevo")
    public String hombreNuevo(Hombre hombre){
        return "/hombre/modificar";
    }
    
     @PostMapping("/hombre/guardar")
    public String hombreGuardar(Hombre hombre){
        hombreService.save(hombre);
        return "redirect:/hombre/listado";
    }
    
    @GetMapping("/hombre/actualiza/{idHombre}")
    public String hombreActualiza(Hombre hombre, Model model){
        hombre=hombreService.getHombre(hombre);
        model.addAttribute("hombre",hombre);
        
                
        return "/hombre/modificar";
    }
    
    @GetMapping("/hombre/elimina/{idHombre}")
    public String hombreElimina(Hombre hombre){
        hombreService.delete(hombre);
        return "redirect:/hombre/listado";
    }
}