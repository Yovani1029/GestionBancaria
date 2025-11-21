package exceptions;

public class UsuarioDuplicado extends RuntimeException{
    public UsuarioDuplicado(String mensaje){
        super(mensaje);
    }
}
