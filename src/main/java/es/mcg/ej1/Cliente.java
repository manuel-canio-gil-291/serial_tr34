package es.mcg.ej1;
/**
 * Esta clase define un objeto Cliente
 * @author Manuel Canio Gil
 * @version 1.0
 * 
 */
import java.io.Serializable;

public class Cliente implements Serializable
{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    /**
     * Nombre completo del cliente
     */
    private String nombre;
    /**
     * Direccion del cliente
     */
    private String direccion;
    /**
     * Numero del cliente
     */
    private int nCliente;
    /**
     * Saldo que dispone el cliente
     */
    private double saldo;
    /**
     * La cuenta del banco que esta asociada con el cliente
     */
    private Cuenta cuenta;
    /**
     * Constructor que pasa el nombre completo, direccion, numero del cliente, saldo, y cuenta asociada
     * @param nombre
     * @param direccion
     * @param nCliente
     * @param saldo
     * @param cuenta
     */
    public Cliente(String nombre, String direccion, int nCliente, double saldo, Cuenta cuenta) 
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nCliente = nCliente;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }
    /**
     * Obtiene el nombre del cliente
     * @return nombre
     */
    public String getNombre() 
    {
        return nombre;
    }
    /**
     * Establece el nombre completo del cliente
     * @param nombre
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    /**
     * Obtiene la direccion del cliente
     * @return direccion
     */
    public String getDireccion() 
    {
        return direccion;
    }
    /**
     * Establece una direccion del cliente
     * @param direccion
     */
    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }
    /**
     * Obtiene el numero del cliente
     * @return nCliente
     */
    public int getnCliente() 
    {
        return nCliente;
    }
    /**
     * Establece el numero del cliente
     * @param nCliente
     */
    public void setnCliente(int nCliente) 
    {
        this.nCliente = nCliente;
    }
    /**
     * Obtiene el saldo del cliente
     * @return saldo
     */
    public double getSaldo() 
    {
        return saldo;
    }
    /**
     * Establece el saldo del cliente
     * @param saldo
     */
    public void setSaldo(double saldo) 
    {
        this.saldo = saldo;
    }
    /**
     * Obtiene la cuenta asociada con el cliente
     * @return cuenta
     */
    public Cuenta getCuenta() 
    {
        return cuenta;
    }
    /**
     * Establece la cuenta que se asociara con el cliente
     * @param cuenta
     */
    public void setCuenta(Cuenta cuenta) 
    {
        this.cuenta = cuenta;
    }
    /**
     * Texto que obtiene los datos del cliente por la pantalla de la consola
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDireccion: " + direccion + "\nNº Cliente: " + nCliente + "\nSaldo: " + saldo
                + "\nCuenta del cliente:\n" + cuenta + "";
    }
}
