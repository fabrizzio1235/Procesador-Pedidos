package filtros;

import modelos.Pedido;

public class CalcularImpuestos implements Filtro {
    private final double IVA = 0.16;

    @Override
    public Pedido procesar(Pedido pedido) {
        //Evita calcular impuestos de un pedido en revisión
        if (pedido.getEstado().equals("EN REVISION")) {
            return pedido;
        }
        double base = pedido.getSubtotal() - pedido.getDescuento();
        //Calculamos a dos decimales, la versión anterior trunca los decimales
        pedido.setImpuestos(Math.round(base * IVA * 100) / 100.0);
        pedido.setTotal(Math.round((base + pedido.getImpuestos()) * 100) / 100.0);
        return pedido;
    }
}