package filtros;

import modelos.Pedido;

/*
    Aplica un 10% de descuento sobre el subtotal cuando es mayor o igual a mil. Si el pedido
    está marcado EN REVISION, no se le aplica descuento y se devuelve sin cambios.
 */

public class AplicarDescuento implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        //Para que poner un descuento a un pedido que está en revisión?
        if (pedido.estaEnRevision()){
            return pedido;
        }
        double subtotal = pedido.getSubtotal();
        if (subtotal >= 1000) {
            pedido.setDescuento(subtotal * 0.10);
        }
        return pedido;
    }
}
