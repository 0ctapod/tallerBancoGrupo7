public class CuentaCorriente extends CuentaBancaria{
    private double comisionPorTransaccion;
    private double limiteSobreGiro;

    public CuentaCorriente() {}

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double comisionPorTransaccion, double limiteSobreGiro) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobreGiro = limiteSobreGiro;
    }

    public double getComisionPorTransaccion() {
        return comisionPorTransaccion;
    }

    public void setComisionPorTransaccion(double comisionPorTransaccion) {
        this.comisionPorTransaccion = comisionPorTransaccion;
    }

    public double getLimiteSobreGiro() {
        return limiteSobreGiro;
    }

    public void setLimiteSobreGiro(double limiteSobreGiro) {
        this.limiteSobreGiro = limiteSobreGiro;
    }

    @Override
    public String describir(){
        String textPadre = super.describir();
        return textPadre + " | Comisión por transacción: " + this.comisionPorTransaccion;
    }

    @Override
    public double calcularComision() {
        return this.comisionPorTransaccion;
    }

    @Override
    public void realizarRetiro(double monto) {
        double nuevoSaldo = getSaldo() - monto;
        if(nuevoSaldo < getLimiteSobreGiro())
        {
            System.out.println("No es posible realizar este retiro.");
            System.out.println("Se supera el limite de sobregiro.");
        }
        else{
            nuevoSaldo = nuevoSaldo - this.calcularComision();
            setSaldo(nuevoSaldo);
        }

    }
}
