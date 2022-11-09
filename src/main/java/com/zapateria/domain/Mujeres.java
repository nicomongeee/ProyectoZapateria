package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mujeres")

public class Mujeres implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que sea la DB la que de los valores
    private Long idProductoM;

    private double cantidad;
    private int talla;
    private String color;
    private int precio;
    private boolean activo;

    public Mujeres(double cantidad, int talla, String color, int precio, boolean activo) {
        this.cantidad = cantidad;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.activo = activo;
    }

}
