package filtros;

import excepciones.DatosInvalidosException;
import modelos.Pedido;
import modelos.Producto;

/*
    Verifica que la existencia disponible de cada producto alcance para cubrir la cantidad
    solicitada. Si algún producto no lo hace, marca el pedido como rechazado y lanza la excepción.
 */

public class ComprobarDisponibilidad implements Filtro {
    @Override
    public Pedido procesar (Pedido pedido) {
        for (Producto productoActual : pedido.getProductos()) {
            if (productoActual.getExistencia() < productoActual.getCantidadSolicitada()) {
                pedido.setEstado("RECHAZADO");
                throw new DatosInvalidosException("Error: No hay suficiente existencia de " + productoActual.getNombre());
            }
        }
        return pedido;
    }
}
