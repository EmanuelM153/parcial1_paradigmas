package modelo;

public class Cuenta {
    private int id;
    private double saldo;
    private int cliente;

    public Cuenta(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Cuenta(double saldo, int cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Cuenta(int id, double saldo, int cliente) {
        this.id = id;
        this.saldo = saldo;
        this.cliente = cliente;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}
