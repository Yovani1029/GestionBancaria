package service;

import Model.Cuenta;
import exceptions.CuentaNoEncontrada;
import exceptions.SaldoInsuficiente;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Cuenta> cuentas = new HashMap<>();

    public void crearCuenta(String numero, double saldoInicial){
        if (cuentas.containsKey(numero)){
            throw new IllegalArgumentException("LA CUENTA YA EXISTE");
        }
        cuentas.put(numero, new Cuenta(numero, saldoInicial));

    }
    public double consultarSaldo (String numero){
        Cuenta c = cuentas.get(numero);
        if (c == null) throw new CuentaNoEncontrada("CUENTA NO EXISTE");
        return c.getSaldo();

    }

    public void depositar (String numero, double monto){
        Cuenta c = cuentas.get(numero);
        if (c == null) throw new CuentaNoEncontrada("CUENTA NO EXISTE");
        c.depositar(monto);
    }
    public void retirar(String numero, double monto){
        Cuenta c = cuentas.get(numero);
        if( c == null) throw new CuentaNoEncontrada("CUENTA NO EXISTE");

        if(c.getSaldo() < monto)
            throw new SaldoInsuficiente("NO HAY SALDO SUFICIENTE");

        c.retirar(monto);
    }

    public void transferir(String origen, String destino,  double monto){
        Cuenta c1 = cuentas.get(origen);
        Cuenta c2 = cuentas.get(destino);

        if(c1 == null)
            throw new CuentaNoEncontrada("CUENTA ORIGEN NO EXISTE");
        if(c2 == null)
            throw new CuentaNoEncontrada("CUENTA DESTINO NO EXISTE");
        if(c1.getSaldo() < monto)
            throw new SaldoInsuficiente("SALDO INSUFICIENTE");

        c1.retirar(monto);
        c2.depositar(monto);
    }


}
