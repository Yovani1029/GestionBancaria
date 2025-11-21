package exceptions;

public class SaldoInsuficiente extends RuntimeException{
    public SaldoInsuficiente(String mensaje){
        super(mensaje);
    }

}
