package modelos;

/*
    Representa un producto dentro de un pedido, su precio, cantidad solicitada, existencia
    disponible.
 */

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadSolicitada;
    private int existencia;

    public Producto(String nombre, double precio, int cantidad, int existencia) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadSolicitada = cantidad;
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSolicitada() {return cantidadSolicitada;}

    public int getExistencia() {return existencia;}
}
