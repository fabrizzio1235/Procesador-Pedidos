package filtros;

import modelos.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
    Aplica un 10% de descuento sobre el subtotal cuando es mayor o igual a mil. Si el pedido
    está marcado EN REVISION, no se le aplica descuento y se devuelve sin cambios.
 */

public class AplicarDescuento implements Filtro {
    private static final BigDecimal INICIO_DESCUENTO = new BigDecimal("1000");
    private static final BigDecimal PORCENTAJE_DESCUENTO = new BigDecimal("0.10");

    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.estaEnRevision()){ // La operación no se realiza a un pedido en revisión por fraude.
            return pedido;
        }
        BigDecimal subtotal = pedido.getSubtotal();
        if (subtotal.compareTo(INICIO_DESCUENTO) > 0){
            pedido.setDescuento(subtotal.multiply(PORCENTAJE_DESCUENTO).setScale(2, RoundingMode.HALF_UP));
        }
        return pedido;
    }
}
