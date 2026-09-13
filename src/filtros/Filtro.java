package filtros;

import modelos.Pedido;

public interface Filtro {
    Pedido procesar(Pedido pedido);
}