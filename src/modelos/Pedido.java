package modelos;

import java.util.List;

/*
    Representa el pedido. Cada filtro recibre y devuelve la misma instancia,
    sin conocer qué otros filtros existen.
 */

public class Pedido {
    private String cliente;
    private List<Producto> productos;
    private double subtotal;
    private double descuento;
    private double impuestos;
    private double total;
    private String estado;


    public Pedido(String cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.estado = "EN PROCESO";
    }

    /*
    Indica si el pedido fue marcado por VerificarFraude.
     */
    public boolean estaEnRevision() {
        return "EN REVISION".equals(estado);
    }

    public void agregarProductos(Producto prod) {
        this.productos.add(prod);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {return total;}

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return String.format(
                "Pedido de '%s': { Estado: '%s' | Subtotal: $%.2f | Descuento: $%.2f " +
                        "Impuestos: $%.2f | Total: $%.2f  }",
                cliente, estado, subtotal, descuento, impuestos, total
        );
    }
}