package es.mcg.ej1;

import java.io.Serializable;

public class Cuenta implements Serializable
{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    
    private Estado estado;
    private String nombre;
    private int nCuenta;

    public Cuenta(String nombre, int nCuenta) 
    {
        this.nombre = nombre;
        this.nCuenta = nCuenta;
    }

    public Estado getEstado() 
    {
        return estado;
    }

    public void setEstado(Estado estado) 
    {
        this.estado = estado;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getnCuenta() 
    {
        return nCuenta;
    }

    public void setnCuenta(int nCuenta) 
    {
        this.nCuenta = nCuenta;
    }

    @Override
    public String toString() {
        return "Estado de la cuenta: " + estado + "\nNombre de la cuenta: " + nombre + "\nNº Cuenta: " + nCuenta + "";
    }
    
}
