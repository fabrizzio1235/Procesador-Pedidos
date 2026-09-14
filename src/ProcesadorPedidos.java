import filtros.*;
import modelos.Pedido;
import modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorPedidos {
    public static void main(String[] args) {

        // Pedido sacado del Colab
        Pedido pedidoCorrecto = new Pedido("Ana", new ArrayList<>(List.of(
                new Producto("Teclado", 500, 1, 5),
                new Producto("Mouse", 250, 2, 10)
        )));

        /* TODO: Pruebas mínimas

            El programa deberá demostrar al menos estos casos:

            - pedido válido;
            - pedido sin productos;
            - producto con cantidad superior a la existencia;
            - pedido con descuento;
            - pedido sin descuento;
            - pedido marcado para revisión de fraude. */

        // TODO: Imprimir el estado del pedido después de cada filtro para poder observar el flujo.

        List<Filtro> tuberia = List.of(
                new ValidarDatos(),
                new ComprobarDisponibilidad(),
                new CalcularSubtotal(),
                new VerificarFraude(),
                new AplicarDescuento(),
                new CalcularImpuestos(),
                new ConfirmarPedido()
        );

        for (Filtro filtro : tuberia) {
            pedidoCorrecto = filtro.procesar(pedidoCorrecto);
        }

    }
}
