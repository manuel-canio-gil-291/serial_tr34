package es.mcg.ej2;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NExpediente implements Serializable{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    
    private final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private String nombre,email;
    private double nota1, nota2, nota3;
    
    public NExpediente(String nombre, double nota1, double nota2, double nota3) 
    {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public NExpediente(String nombre, String email, double nota1, double nota2, double nota3) 
    {
        this.nombre = nombre;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public double getNota1() 
    {
        return nota1;
    }

    public void setNota1(double nota1) 
    {
        this.nota1 = nota1;
    }

    public double getNota2() 
    {
        return nota2;
    }

    public void setNota2(double nota2) 
    {
        this.nota2 = nota2;
    }

    public double getNota3() 
    {
        return nota3;
    }

    public void setNota3(double nota3) 
    {
        this.nota3 = nota3;
    }

    public double calcularNotaMedia(double nota1, double nota2, double nota3)
    {
        return (nota1+nota2+nota3)/3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validarEmail(String email)
    {
        if(email == null)
        {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    @Override
    public String toString()
    {
        return "Nombre del alumno: "+nombre+"\nNota 1: "+nota1+"\nNota 2: "+nota2+"\nNota 3: "+nota3+"\nNota media: "+calcularNotaMedia(nota1, nota2, nota3);
    }
}
