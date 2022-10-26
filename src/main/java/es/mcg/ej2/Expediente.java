package es.mcg.ej2;
/**
 * Esta clase define el objeto Expediente, o como quiere decir, el objeto que da las 3 notas del alumno
 * y calcula la media de las tres.
 * @author Manuel Canio Gil
 * @version 1.0
 */
import java.io.Serializable;

public class Expediente implements Serializable{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    
    /**
     * Nombre del alumno.
     */
    private String nombre;
    /**
     * Las tres notas del alumno.
     */
    private double nota1, nota2, nota3;
    /**
     * Constructor que pasa el nombre del alumno y las tres notas.
     * @param nombre
     * @param nota1
     * @param nota2
     * @param nota3
     */
    public Expediente(String nombre, double nota1, double nota2, double nota3) 
    {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    /**
     * Obtiene el nombre del alumno.
     * @return nombre
     */
    public String getNombre() 
    {
        return nombre;
    }
    /**
     * Establece el nombre del alumno.
     * @param nombre
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    /**
     * Obtiene la primera nota del alumno.
     * @return nota1
     */
    public double getNota1() 
    {
        return nota1;
    }
    /**
     * Establece la primera nota del alumno.
     * @param nota1
     */
    public void setNota1(double nota1) 
    {
        this.nota1 = nota1;
    }
    /**
     * Obtiene la segunda nota del alumno.
     * @return nota2
     */
    public double getNota2() 
    {
        return nota2;
    }
    /**
     * Establece la segunda nota del alumno.
     * @param nota2
     */
    public void setNota2(double nota2) 
    {
        this.nota2 = nota2;
    }
    /**
     * Obtiene la tercera nota del alumno.
     * @return nota3
     */
    public double getNota3() 
    {
        return nota3;
    }
    /**
     * Establece la tercera nota del alumno.
     * @param nota3
     */
    public void setNota3(double nota3) 
    {
        this.nota3 = nota3;
    }
    /**
     * Metodo que calcula la media de las tres notas.
     * @param nota1
     * @param nota2
     * @param nota3
     * @return media de las tres notas
     */
    public double calcularNotaMedia(double nota1, double nota2, double nota3)
    {
        return (nota1+nota2+nota3)/3;
    }
    /**
     * Texto que devuelve las notas del alumno y la media por la pantalla de la consola.
     */
    @Override
    public String toString()
    {
        return "Nombre del alumno: "+nombre+"\nNota 1: "+nota1+"\nNota 2: "+nota2+"\nNota 3: "+nota3+"\nNota media: "+calcularNotaMedia(nota1, nota2, nota3);
    }
}
