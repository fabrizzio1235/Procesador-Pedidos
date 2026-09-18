package modelos;

/*
    Representa un producto dentro de un pedido, su precio, cantidad solicitada, existencia
    disponible.
 */

import java.math.BigDecimal;

public class Producto {
    private String nombre;
    private BigDecimal precio;
    private int cantidadSolicitada;
    private int existencia;

    public Producto(String nombre, BigDecimal precio, int cantidad, int existencia) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadSolicitada = cantidad;
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidadSolicitada() {return cantidadSolicitada;}

    public int getExistencia() {return existencia;}
}
