package filtros;

import modelos.Pedido;
import modelos.Producto;

/*
    Calcula el subtotal del pedido como la suma de (precio x cantidad solicitada) de cada producto.
    No valida ni modifica el estado del pedido, solo produce el dato que usarán los filtros siguientes.
 */

public class CalcularSubtotal implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        double costoSubtotal = 0;
        for (Producto productoActual : pedido.getProductos()) {
            costoSubtotal += (productoActual.getCantidadSolicitada() * productoActual.getPrecio());
        }
        pedido.setSubtotal(costoSubtotal);
        return pedido;
    }
}
