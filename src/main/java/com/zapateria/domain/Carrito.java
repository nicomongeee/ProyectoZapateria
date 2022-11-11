package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="carrito")

public class Carrito implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id //se dice que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que sea la DB la que de los valores
    private Long idCarrito;
    private Long cantidad;

    public Carrito() {
    }

    public Carrito(Long idCarrito, Long cantidad) {
        this.idCarrito = idCarrito;
        this.cantidad = cantidad;
    }
    
    
    
    
}


