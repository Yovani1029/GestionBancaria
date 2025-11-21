package exceptions;

public class UsuarioNoEncontrado extends  RuntimeException{
    public UsuarioNoEncontrado(String mensaje){
        super(mensaje);
    }
}
