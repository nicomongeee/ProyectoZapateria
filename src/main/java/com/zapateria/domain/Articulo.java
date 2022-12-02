package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo_")

public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que sea la DB la que de los valores
    private Long idArticulo;

    private Long idCategoria;
    private double cantidad;
    private int talla;
    private String color;
    private int precio;
    private String descripcion;
    private boolean activo;
    @Column(name="ruta_imagen")
    private String rutaImagen;

    public Articulo(Long idCategoria, double cantidad, int talla, String color, int precio, String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.cantidad = cantidad;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Articulo() {

    }
}
