package filtros;

import modelos.Pedido;

public class ConfirmarPedido implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().equals("EN REVISION")) {
            return pedido;
        }
        pedido.setEstado("PROCESADO");
        return pedido;
    }
}