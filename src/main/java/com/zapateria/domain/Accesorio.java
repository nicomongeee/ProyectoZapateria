package com.zapateria.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accesorio")

public class Accesorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccesorio;
    
    private double cantidad;
    private String color;
    private String detalle;
    private int precio;
    private String descripcion;
    private boolean activo;

    public Accesorio() {
    }

    public Accesorio(double cantidad, String color, String detalle, int precio, String descripcion, boolean activo) {
        this.cantidad = cantidad;
        this.color = color;
        this.detalle = detalle;
        this.precio = precio;
        this.descripcion = descripcion;
        this.activo = activo;
    }

   

    

}
