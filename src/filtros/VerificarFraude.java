package filtros;

import modelos.Pedido;

/*
    Filtro del reto, insertado entre CalcularSubtotal y AplicarDescuento. Si el subtotal supera
    los 5,000, marca el pedido como EN REVISION. No lanza excepción, el pedido en revisión no es
    un error, así que debe de seguir recorriendo el resto de los filtros.
 */

public class VerificarFraude implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getSubtotal() > 5000) {
            pedido.setEstado("EN REVISION");
        }
        return pedido;
    }
}
