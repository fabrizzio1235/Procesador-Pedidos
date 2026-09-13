package modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cliente;
    private List<Producto> productos;
    private double subtotal;
    private double descuento;
    private double impuestos;
    private double total;
    private String estado;

    public Pedido() {}

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.impuestos = 0.0;
        this.total = 0.0;
        this.estado = ""; // TODO: Por definir
    }

    public void agregarProductos (Producto prod) {
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

    public double getTotal() {
        return total;
    }

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
                "Pedido{cliente='%s', estado='%s', subtotal=$%.2f," +
                        " descuento=$%.2f, impuestos=$%.2f, total=$%.2f}",
                cliente, estado, subtotal, descuento, impuestos, total
        );
    }
}