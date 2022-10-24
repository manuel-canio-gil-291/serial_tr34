package es.mcg.ej1;

import java.io.Serializable;

public class Cliente implements Serializable
{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    
    private String nombre;
    private String direccion;
    private int nCliente;
    private double saldo;
    private Cuenta cuenta;
    
    public Cliente(String nombre, String direccion, int nCliente, double saldo, Cuenta cuenta) 
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nCliente = nCliente;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public int getnCliente() 
    {
        return nCliente;
    }

    public void setnCliente(int nCliente) 
    {
        this.nCliente = nCliente;
    }

    public double getSaldo() 
    {
        return saldo;
    }

    public void setSaldo(double saldo) 
    {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() 
    {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) 
    {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDireccion: " + direccion + "\nNº Cliente: " + nCliente + "\nSaldo: " + saldo
                + "\nCuenta del cliente:\n" + cuenta + "";
    }

    
}
