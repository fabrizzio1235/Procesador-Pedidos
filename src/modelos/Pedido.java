package modelos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/*
    Representa el pedido. Cada filtro recibre y devuelve la misma instancia,
    sin conocer qué otros filtros existen.
 */

public class Pedido {
    private String cliente;
    private List<Producto> productos;
    private BigDecimal subtotal = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    private BigDecimal descuento = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    private BigDecimal impuestos = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    private BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getTotal() {return total;}

    public void setTotal(BigDecimal total) {
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