package filtros;

import modelos.Pedido;

public class AplicarDescuento implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        double subtotal = pedido.getSubtotal();
        if (subtotal >= 1000) {
            pedido.setDescuento(subtotal * 0.10);
        }
        return pedido;
    }
}
