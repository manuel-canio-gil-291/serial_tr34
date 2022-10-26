package es.mcg.ej2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AntiguoAlumno extends NExpediente{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;

    private final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private String email;

    public AntiguoAlumno(String nombre, double nota1, double nota2, double nota3, String email) {
        super(nombre, nota1, nota2, nota3);
        this.email = email;
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
        return "Nombre del alumno: "+getNombre()+"\nNota 1: "+getNota1()+"\nNota 2: "+getNota2()+"\nNota 3: "+getNota3()+"\nNota media: "+calcularNotaMedia(getNota1(), getNota2(), getNota3())+"\nCorreo: "+email;
    }
}
