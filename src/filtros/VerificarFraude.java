package filtros;

import excepciones.PedidoFraudeException;
import modelos.Pedido;

public class VerificarFraude implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getSubtotal() > 5000) {
            pedido.setEstado("EN REVISION");
            throw new PedidoFraudeException("Error: Pedido detectado como fraude, entrando en revisión");
        }
        return pedido;
    }
}
