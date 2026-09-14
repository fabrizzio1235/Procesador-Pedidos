package filtros;

import modelos.Pedido;
import modelos.Producto;

public class CalcularSubtotal implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        for (Producto productoActual : pedido.getProductos()) {
            pedido.setSubtotal(productoActual.getCantidad() * productoActual.getPrecio());
        }
        return pedido;
    }
}
