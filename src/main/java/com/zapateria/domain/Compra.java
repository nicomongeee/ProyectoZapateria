package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "compra")

public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //se dice que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que sea la DB la que de los valores
    private Long idCompra;

    private String nombre;
    private String apellidos;
    private int cedula;
    private String pais;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private int telefono;
    private String correo;
    private String notas;

    public Compra() {
    }

    public Compra(String nombre, String apellidos, int cedula, String pais, String provincia, String canton, String distrito, String direccion, int telefono, String correo, String notas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.pais = pais;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.notas = notas;
    }

    
    
    

}
