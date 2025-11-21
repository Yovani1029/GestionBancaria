package exceptions;

public class TelefonoInvalido extends RuntimeException{
    public TelefonoInvalido(String mensaje){
        super(mensaje);
    }
}
