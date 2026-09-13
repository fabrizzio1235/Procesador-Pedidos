import filtros.*;
import modelos.Pedido;
import modelos.Producto;

import java.util.ArrayList;
import java.util.List;


public class ProcesadorPedidos {
    public static void main(String[] args) {

        List<Filtro> tuberia = List.of(
                new ValidarDatos(),
                new ComprobarDisponibilidad(),
                new CalcularSubtotal(),
                new VerificarFraude(),
                new AplicarDescuento(),
                new CalcularImpuestos(),
                new ConfirmarPedido()
        );

        // Pedido sacado del Colab
        Pedido pedido1 = new Pedido("Ana", new ArrayList<>(List.of(
                new Producto("Teclado", 500, 1, 5),
                new Producto("Mouse", 250, 2, 10)
        )));

        // Pedido que prueba el filtro de Fraude
        Pedido pedido2 = new Pedido();

        for (Filtro filtro : tuberia) {
            pedido1 = filtro.procesar(pedido1);
        }

    }
}
