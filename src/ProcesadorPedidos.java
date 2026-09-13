import filtros.*;
import modelos.Pedido;

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
        Pedido pedido = new Pedido();
        //TODO: por definir que tipo de entrada manejar:
        // durante ejecución o definirlas directamente en el main
        for (Filtro filtro : tuberia) {
            pedido = filtro.procesar(pedido);
        }

    }
}
