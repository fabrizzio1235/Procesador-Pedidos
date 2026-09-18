package filtros;

import modelos.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
    Calcula el IVA sobre la base (subtotal - descuento) y obtiene el total del pedido,
    redondeando ambos valores a 2 decimales. Si el pedido está EN REVISION, no calcula nada
    y lo devuelve sin cambios.
 */

public class CalcularImpuestos implements Filtro {
    private static final BigDecimal IVA = new BigDecimal("0.16");

    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.estaEnRevision()) { // La operación no se realiza a un pedido en revisión por fraude.
            return pedido;
        }
        BigDecimal base = (pedido.getSubtotal().subtract(pedido.getDescuento()));

        pedido.setImpuestos(base.multiply(IVA).setScale(2, RoundingMode.HALF_UP));
        pedido.setTotal(base.add(pedido.getImpuestos()));
        return pedido;
    }
}