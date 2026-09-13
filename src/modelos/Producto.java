package modelos;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private int existencia;


    public Producto(String nombre, double precio, int cantidad, int existencia) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public int getCantidad() {return cantidad;}

    public int getExistencia() {return existencia;}
}
