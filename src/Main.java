//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaOne = new CuentaAhorros("12345" , "Pepito" , 50_000, 10, 30000);
        CuentaBancaria cuentaTwo = new CuentaCorriente("54321","Pepa" , 100_000 , 20 , 100000);
        CuentaBancaria cuentaThree = new CuentaInversion("56789", "Grank" , 150_000 , 15, 24, 10000 );

        System.out.println(cuentaOne.describir());
        System.out.println(cuentaTwo.describir());
        System.out.println(cuentaThree.describir());

        System.out.println(cuentaOne.calcularComision());
        System.out.println(cuentaTwo.calcularComision());
        System.out.println(cuentaThree.calcularComision());

        cuentaOne.realizarRetiro(500_000);
        cuentaTwo.realizarRetiro(500_000);
        cuentaThree.realizarRetiro(500_000);

        System.out.println(cuentaOne.getSaldo());
        System.out.println(cuentaTwo.getSaldo());
        System.out.println(cuentaThree.getSaldo());

    }
}