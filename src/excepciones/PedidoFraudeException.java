package excepciones;

public class PedidoFraudeException extends RuntimeException {
    public PedidoFraudeException(String message) {
        super(message);
    }
}
