import excepciones.DatosInvalidosException;

import filtros.*;
import modelos.Pedido;
import modelos.Producto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
    Punto de entrada del programa. Construye los pedidos de prueba y define la tubería de filtros.
 */

public class ProcesadorPedidos {
    public static void main(String[] args) {
        List <Pedido> pedidos = new ArrayList<>();

        // Casos de Prueba

        // Pedido válido
        Pedido pedidoCorrecto = new Pedido("Ana", new ArrayList<>(List.of(
                new Producto("Teclado", new BigDecimal(500), 1, 5),
                new Producto("Mouse", new BigDecimal(250), 2, 10)
        )));
        pedidos.add(pedidoCorrecto);

        // Pedido sin productos
        Pedido sinProductos = new Pedido("Vanessa", new ArrayList<>((List.of())));
        pedidos.add(sinProductos);

        // Pedido con cantidad superior a la existencia;
        Pedido pedidoSuperaExistencias = new Pedido("Pablo", new ArrayList<>(List.of(
                new Producto("Teclado", new BigDecimal(500), 5, 3)
        )));
        pedidos.add(pedidoSuperaExistencias);

        //Pedido con descuento
        Pedido pedidoDescuento = new Pedido("Juan", new ArrayList<>(List.of(
                new Producto("Platos", new BigDecimal(260), 8, 22),
                new Producto("Cubiertos", new BigDecimal(45), 10, 45)
        )));
        pedidos.add(pedidoDescuento);

        //Pedido sin descuento
        Pedido pedidoSinDescuento = new Pedido("Diego", new ArrayList<>(List.of(
                new Producto("Cuchara", new BigDecimal(22), 1, 22),
                new Producto("Servilletas", new BigDecimal(38), 2, 51)
        )));
        pedidos.add(pedidoSinDescuento);

        // Pedido detectado como fraude
        Pedido pedidoFraude = new Pedido("Roberto Azarcoya", new ArrayList<>(List.of(
                new Producto("Play 5 Pro", new BigDecimal(13999), 4, 14),
                new Producto("GTA 6", new BigDecimal(1999), 4, 100)
        )));
        pedidos.add(pedidoFraude);

        List<Filtro> tuberia = List.of(
                new ValidarDatos(),
                new ComprobarDisponibilidad(),
                new CalcularSubtotal(),
                new VerificarFraude(),
                new AplicarDescuento(),
                new CalcularImpuestos(),
                new ConfirmarPedido()
        );

        for (Pedido pedido : pedidos) {
            try {
                for (Filtro filtro : tuberia) {
                    pedido = filtro.procesar(pedido);
                    System.out.println(pedido);
                }
            } catch (DatosInvalidosException e) {
                System.out.println(e.getMessage());
                System.out.println(pedido);
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
        }

    }
}
