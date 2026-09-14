package filtros;

import modelos.Pedido;

public class CalcularImpuestos implements Filtro {

    @Override
    public Pedido procesar(Pedido pedido) {
        //Evita calcular impuestos de un pedido en revisión
        if (pedido.estaEnRevision()) {
            return pedido;
        }
        double base = pedido.getSubtotal() - pedido.getDescuento();
        //Calculamos a dos decimales, la versión anterior trunca los decimales
        double IVA = 0.16;
        pedido.setImpuestos(Math.round(base * IVA * 100) / 100.0);
        pedido.setTotal(Math.round((base + pedido.getImpuestos()) * 100) / 100.0);
        return pedido;
    }
}