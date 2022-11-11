package com.zapateria.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")

public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    private int fecha;
    private double total;
    private boolean estado;


    public Factura() {
    }

    public Factura(int fecha, double total, boolean estado) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

  

    

 

}
