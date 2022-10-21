package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id //se dice que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que sea la DB la que de los valores
    private Long id_usuario;
    
    private String nombre;
    private String correo;
    
    public Usuario (String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
        
    }
    
    public Usuario() {
        
    }
    
    
}


