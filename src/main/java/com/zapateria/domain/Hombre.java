package com.zapateria.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hombre")

public class Hombre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHombre;

    private double cantidad;
    private int talla;
    private String color;
    private int precio;
    private String descripcion;
    private boolean activo;
    @Column(name="ruta_imagen")
    private String rutaImagen;

    public Hombre() {
    }

    public Hombre(double cantidad, int talla, String color, int precio, String descripcion, boolean activo) {
        this.cantidad = cantidad;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    

}
