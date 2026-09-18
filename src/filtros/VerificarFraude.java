package filtros;

import modelos.Pedido;

import java.math.BigDecimal;

/*
    Filtro del reto, insertado entre CalcularSubtotal y AplicarDescuento. Si el subtotal supera
    los 5,000, marca el pedido como EN REVISION. No lanza excepción, el pedido en revisión no es
    un error, así que debe de seguir recorriendo el resto de los filtros.
 */

public class VerificarFraude implements Filtro {
    private static final BigDecimal CANTIDAD_SOSPECHOSA = new BigDecimal("5000");

    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getSubtotal().compareTo(CANTIDAD_SOSPECHOSA) > 0) {
            pedido.setEstado("EN REVISION");
        }
        return pedido;
    }
}
