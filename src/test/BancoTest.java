package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.Banco;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BancoTest {

    @Test
    public void crearCuenta(){
        Banco banco = new Banco();
        banco.crearCuenta("001",100000);
        Assertions.assertEquals(100000, banco.consultarSaldo("001"));
    }

    @Test
    public void crearCuentaexistente(){
        Banco banco = new Banco();
        banco.crearCuenta("001",150000);
        assertThrows(IllegalArgumentException.class, () -> banco.crearCuenta("001", 150000));
    }

    @Test
    public void consultarSaldoCuentaNoExiste() {
        Banco banco = new Banco();

        assertThrows(exceptions.CuentaNoEncontrada.class, () -> {
            banco.consultarSaldo("999");
        });
    }

    @Test
    public void depositar() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 200000);

        banco.depositar("001", 50000);

        Assertions.assertEquals(250000, banco.consultarSaldo("001"), 0);
    }

    @Test
    public void depositarEnCuentaInexistente() {
        Banco banco = new Banco();

        assertThrows(exceptions.CuentaNoEncontrada.class, () -> {
            banco.depositar("999", 30000);
        });
    }

    @Test
    public void retirarCorrectamente() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 300000);

        banco.retirar("001", 50000);

        Assertions.assertEquals(250000, banco.consultarSaldo("001"), 0);
    }

    @Test
    public void retirarSaldoInsuficiente() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 100000);

        assertThrows(exceptions.SaldoInsuficiente.class, () -> {
            banco.retirar("001", 200000);
        });
    }

    @Test
    public void retirarCuentaInexistente() {
        Banco banco = new Banco();

        assertThrows(exceptions.CuentaNoEncontrada.class, () -> {
            banco.retirar("999", 50000);
        });
    }

    @Test
    public void transferir() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 500000);
        banco.crearCuenta("002", 200000);

        banco.transferir("001", "002", 300000);

        Assertions.assertEquals(200000, banco.consultarSaldo("001"), 0);
        Assertions.assertEquals(500000, banco.consultarSaldo("002"), 0);
    }

    @Test
    public void transferirCuentaOrigenNoExiste() {
        Banco banco = new Banco();
        banco.crearCuenta("002", 300000);

        assertThrows(exceptions.CuentaNoEncontrada.class, () -> {
            banco.transferir("999", "002", 100000);
        });
    }

    @Test
    public void transferirCuentaDestinoNoExiste() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 400000);

        assertThrows(exceptions.CuentaNoEncontrada.class, () -> {
            banco.transferir("001", "888", 100000);
        });
    }

    @Test
    public void transferenciaSaldoInsuficiente() {
        Banco banco = new Banco();
        banco.crearCuenta("001", 50000);
        banco.crearCuenta("002", 700000);

        assertThrows(exceptions.SaldoInsuficiente.class, () -> {
            banco.transferir("001", "002", 200000);
        });
    }

}
