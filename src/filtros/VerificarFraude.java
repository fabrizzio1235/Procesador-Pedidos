package filtros;

import modelos.Pedido;

public class VerificarFraude implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getSubtotal() > 5000) {
            pedido.setEstado("EN REVISION");
        }
        return pedido;
    }
}

//se quita la excepcion porque en la tarea se indica que se debe
//imprimir el estado del pedido después de cada filtro para poder observar el flujo.
//para pedidos de fraude lo imcumple, porque nunca llega a los siguientes filtros.