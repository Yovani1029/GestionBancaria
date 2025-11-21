package service;

import Model.Usuario;
import exceptions.*;
import java.util.HashMap;
import java.util.Map;

public class UsuarioService {

    private Map<String, Usuario> usuarios = new HashMap<>();

    public void registrarUsuario(Usuario usuario){
        if (usuarios.containsKey(usuario.getId())){
            throw new IllegalArgumentException("EL USUARIO CON ID "+ usuario.getId() + " YA EXISTE");
        }
        if(!usuario.getTelefono().matches("\\d{10}")){
            throw new TelefonoInvalido("EL TELEFONO DEBE TENER AL MENOS 10 DIGITOS");
        }
        usuarios.put(usuario.getId(), usuario);
    }
}