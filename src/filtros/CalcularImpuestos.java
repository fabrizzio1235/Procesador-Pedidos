package filtros;

import modelos.Pedido;

public class CalcularImpuestos implements Filtro {
    private final double IVA = 0.16;

    @Override
    public Pedido procesar(Pedido pedido) {
        double base = pedido.getSubtotal() - pedido.getDescuento();
        pedido.setImpuestos(Math.round(base * IVA));
        pedido.setTotal(Math.round(base + pedido.getImpuestos()));
        return pedido;
    }
}
