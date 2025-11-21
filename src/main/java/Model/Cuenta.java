package Model;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double monto){
        if(monto <= 0) throw new IllegalArgumentException("EL MONTO DEBE SER MAYOR A 0");
        saldo += monto;
    }
    public void retirar(double monto) {
        if(monto <= 0) throw new IllegalArgumentException("EL MONTO DEBE SER MAYOR A 0");
        if (saldo < monto) throw new IllegalArgumentException("SALDO INSUFICIENTE");
        saldo -= monto;
    }
}
