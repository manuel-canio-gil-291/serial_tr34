package es.mcg.ej1;
/**
 * Esta clase define el objeto de Cuenta
 * @author Manuel Canio Gil
 * @version 1.0
 */
import java.io.Serializable;

public class Cuenta implements Serializable
{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    /**
     * El estado de la cuenta
     */
    private Estado estado;
    /**
     * Nombre de la cuenta
     */
    private String nombre;
    /**
     * Numero de la cuenta
     */
    private int nCuenta;
    /**
     * Constructor que pasa el nombre de la cuenta y el numero de la cuenta
     * @param nombre
     * @param nCuenta
     */
    public Cuenta(String nombre, int nCuenta) 
    {
        this.nombre = nombre;
        this.nCuenta = nCuenta;
    }
    /**
     * Obtiene el estado de la cuenta
     * @return estado
     */
    public Estado getEstado() 
    {
        return estado;
    }
    /**
     * Establece el estado que se encuentra la cuenta
     * @param estado
     */
    public void setEstado(Estado estado) 
    {
        this.estado = estado;
    }
    /**
     * Obtiene el nombre de la cuenta
     * @return nombre
     */
    public String getNombre() 
    {
        return nombre;
    }
    /**
     * Establece el nombre de la cuenta
     * @param nombre
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    /**
     * Obtiene el numero de la cuenta
     * @return nCuenta
     */
    public int getnCuenta() 
    {
        return nCuenta;
    }
    /**
     * Establece el numero de la cuenta
     * @param nCuenta
     */
    public void setnCuenta(int nCuenta) 
    {
        this.nCuenta = nCuenta;
    }
    /**
     * Texto que mostrara los datos de la cuenta por pantalla de la consola, se realizara la llamada 
     * desde la clase Cliente y no por separado.
     */
    @Override
    public String toString() {
        return "Estado de la cuenta: " + estado + "\nNombre de la cuenta: " + nombre + "\nNº Cuenta: " + nCuenta + "";
    }
    
}
