package test;

import Model.Cuenta;
import Model.Usuario;
import exceptions.TelefonoInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.UsuarioService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioServiceTest {

    @Test
    public void registrarUsuario() {
        UsuarioService service = new UsuarioService();
        Usuario user = new Usuario("U001", "Yovani", "Navarro", "3206040097", new Cuenta("001", 100000));

        service.registrarUsuario(user);
        Assertions.assertTrue(true);
    }

    @Test
    public void registrarUsuarioDuplicado() {
        UsuarioService service = new UsuarioService();

        Usuario user1 = new Usuario("U001", "Yovani", "Navarro", "3206040097", new Cuenta("001", 100000));
        Usuario user2 = new Usuario("U001", "Sofia", "Gonzalez", "3101234567", new Cuenta("002", 200000));

        service.registrarUsuario(user1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.registrarUsuario(user2);
        });
    }

    @Test
    public void telefonoMenosDe10Digitos() {
        UsuarioService service = new UsuarioService();
        Usuario user = new Usuario("U002", "Yovani", "Navarro", "123456", new Cuenta("003", 150000));

        assertThrows(TelefonoInvalido.class, () -> {
            service.registrarUsuario(user);
        });
    }

    @Test
    public void telefonoMasDe10Digitos() {
        UsuarioService service = new UsuarioService();
        Usuario user = new Usuario("U003", "Yovani", "Navarro", "300123456789", new Cuenta("004", 200000));

        assertThrows(TelefonoInvalido.class, () -> {
            service.registrarUsuario(user);
        });
    }

    @Test
    public void telefonoConLetras() {
        UsuarioService service = new UsuarioService();
        Usuario user = new Usuario("U004", "Yova", "Navarro", "30AB234567", new Cuenta("005", 250000));

        assertThrows(TelefonoInvalido.class, () -> {
            service.registrarUsuario(user);
        });
    }

    @Test
    public void registrarVariosUsuarios() {
        UsuarioService service = new UsuarioService();

        Usuario user1 = new Usuario("U001", "Yovani", "Navarro", "3206040097", new Cuenta("001", 100000));
        Usuario user2 = new Usuario("U002", "Camilo", "Barrios", "3104100869", new Cuenta("002", 200000));

        service.registrarUsuario(user1);
        service.registrarUsuario(user2);

        Assertions.assertTrue(true);
    }
}
