package filtros;

import modelos.Pedido;

/*
    Último filtro. Marca el pedido como PROCESADO, si es que no estaba EN REVISION, si estaba
    EN REVISION se queda así.
 */

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