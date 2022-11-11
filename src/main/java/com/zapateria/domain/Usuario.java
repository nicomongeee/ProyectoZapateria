package com.zapateria.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String correo;
    private String direccion;
    private int telefono;

    public Usuario(String nombre, String correo, String direccion, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Usuario() {

    }

}
