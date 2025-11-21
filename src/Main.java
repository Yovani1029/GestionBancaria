import service.Banco;

public class Main {
    public static void main(String[] args){

        Banco banco = new Banco();

        banco.crearCuenta("001", 10000);
        banco.crearCuenta("002", 5000);

        banco.depositar("001", 2000);
        banco.transferir("001", "002", 3000);

        System.out.println("saldo 001: " + banco.consultarSaldo("001"));
        System.out.println("saldo 002: " + banco.consultarSaldo("002"));
    }
}