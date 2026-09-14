package filtros;

import excepciones.DatosInvalidosException;
import modelos.Pedido;
import modelos.Producto;

public class ComprobarDisponibilidad implements Filtro {
    @Override
    public Pedido procesar (Pedido pedido) {
        for (Producto productoActual : pedido.getProductos()) {
            if (productoActual.getExistencia() < productoActual.getCantidad()) {
                throw new DatosInvalidosException("No hay suficiente existencia de " + productoActual.getNombre());
            }
        }
        return pedido;
    }
}
