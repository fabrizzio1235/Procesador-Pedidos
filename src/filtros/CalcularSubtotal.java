package filtros;

import modelos.Pedido;
import modelos.Producto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*
    Calcula el subtotal del pedido como la suma de (precio x cantidad solicitada) de cada producto.
    No valida ni modifica el estado del pedido, solo produce el dato que usarán los filtros siguientes.
 */

public class CalcularSubtotal implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        BigDecimal subtotal = new BigDecimal(BigInteger.ZERO);
        for (Producto producto :  pedido.getProductos()) {
            BigDecimal cantidad = new BigDecimal(producto.getCantidadSolicitada());
            subtotal = subtotal.add(producto.getPrecio().multiply(cantidad));

        }
        pedido.setSubtotal(subtotal.setScale(2, RoundingMode.HALF_UP));
        return pedido;
    }
}
