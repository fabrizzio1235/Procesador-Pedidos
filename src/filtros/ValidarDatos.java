package filtros;

import excepciones.DatosInvalidosException;
import modelos.Pedido;

/*
    Primer filtro. Verifica que el pedido tenga los datos mínimos para poder procesarse,
    un cliente y al menos un producto. Si algo falta, marca el pedido como rechazado y lanza
    la excepción para detener el flujo.
 */

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
