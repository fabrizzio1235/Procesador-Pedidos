package filtros;

import modelos.Pedido;
import modelos.Producto;

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
