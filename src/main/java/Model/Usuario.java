package Model;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Cuenta cuenta;

    public Usuario(String id, String nombre, String apellido, String telefono, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }
    public String getId() {
        return id;
    }
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
