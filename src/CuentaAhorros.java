public class CuentaAhorros extends CuentaBancaria{
    double tasaInteresMensual;
    double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteresMensual, double saldoMinimo) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public String describir() {
        String base = super.describir();
        return base + " | Tasa mensual: " + tasaInteresMensual + "%";
    }

    @Override
    public double calcularComision() {
        if (getSaldo() >= saldoMinimo) {
            return 0.0;
        } else {
            return 12000.0;
        }
    }

    public void realizarRetiro(double monto, boolean esUrgente) {

        System.out.println("saldo antes retiro"+ getSaldo());
        double nuevoSaldo = getSaldo()-monto;

        if (esUrgente && nuevoSaldo < saldoMinimo) {
            setSaldo(nuevoSaldo);
            setSaldo(getSaldo()-calcularComision());
            System.out.println("saldo menos retiro y comision: "+ getSaldo());
        } else {
            setSaldo(nuevoSaldo);
            System.out.println("saldo menos retiro sin comision: "+ getSaldo());
        }
        System.out.println("saldo despues retiro"+ getSaldo());
    }

    public double calcularInteresDelMes() {
        return getSaldo()*tasaInteresMensual/100;
    }
}
