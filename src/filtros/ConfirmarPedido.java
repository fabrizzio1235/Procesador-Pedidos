package filtros;

import modelos.Pedido;

public class ConfirmarPedido implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.estaEnRevision()) {
            return pedido;
        }
        pedido.setEstado("PROCESADO");
        return pedido;
    }
}