package filtros;

import excepciones.DatosInvalidosException;
import modelos.Pedido;

public class ValidarDatos implements Filtro {
    @Override
    public Pedido procesar (Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().isEmpty()) {
            pedido.setEstado("RECHAZADO");
            throw new DatosInvalidosException("Error: El pedido no tiene cliente.");
        }

        if (pedido.getProductos().isEmpty()) {
            pedido.setEstado("RECHAZADO");
            throw new DatosInvalidosException("Error: El pedido de '" + pedido.getCliente() + "' no tiene productos.");
        }
        return pedido;
    }
}
