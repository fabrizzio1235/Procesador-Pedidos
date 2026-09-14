package filtros;

import modelos.Pedido;

public class VerificarFraude implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getSubtotal() > 5000) {
            pedido.setRevisionFraude(true);
        }
        return pedido;
    }
}
