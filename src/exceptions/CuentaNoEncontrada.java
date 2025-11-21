package exceptions;

public class CuentaNoEncontrada extends RuntimeException{
    public CuentaNoEncontrada(String mensaje){
        super(mensaje);
    }
}
