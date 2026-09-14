package excepciones;

/*
    Se lanza cuando un pedido no cumple las condiciones mínimas para continuar en la tubería
    (sin cliente, sin productos o sin existencia suficiente). Interrumpe el recorrido
    por los filtros restantes.
 */

public class DatosInvalidosException extends RuntimeException {
    public DatosInvalidosException(String message) {
        super(message);
    }
}
