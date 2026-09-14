package filtros;

import modelos.Pedido;

/*
    Contrato común de todos los filtros de la tubería. Cada filtro recibe un pedido,
    aplica una única transformación y devuelve el pedido resultante. Ningun filtro
    conoce cuál se ejecutó antes ni cuál se ejecutará después.
 */

public interface Filtro {
    Pedido procesar(Pedido pedido);
}