package filtros;

import excepciones.DatosInvalidosException;
import modelos.Pedido;

public class ValidarDatos implements Filtro {
    @Override
    public Pedido procesar (Pedido pedido) {
        if (pedido.getCliente().isEmpty()) {
            throw new DatosInvalidosException("El pedido no tiene cliente.");
        }

        if (pedido.getProductos().isEmpty()) {
            throw new DatosInvalidosException("El pedido no tiene productos.");
        }
        return pedido;
    }
}
