package es.mcg.ej2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * <p>Esta clase define el alumno antiguo que hereda de los atributos padre
 * ({@code nombre}, {@code nota1}, {@code nota2}, {@code nota3}) y tiene su correo de contacto.</p>
 * 
 * @author Manuel Canio Gil
 * @version 1.0
 */
public class AntiguoAlumno extends Expediente{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1l;
    /**
     * Valor del email.
     */
    private final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /**
     * Validador del email.
     */
    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    /**
     * Correo del antiguo alumno.
     */
    private String email;
    /**
     * Constructor que pasa el nombre del alumno, las tres notas y el correo.
     * @param nombre
     * @param nota1
     * @param nota2
     * @param nota3
     * @param email
     */
    public AntiguoAlumno(String nombre, double nota1, double nota2, double nota3, String email) {
        super(nombre, nota1, nota2, nota3);
        this.email = email;
    }
    /**
     * Obtiene el correo del alumno.
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Establece el correo del alumno.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que comprueba si el email es valido.
     * @param email
     * @return validacion
     */
    public boolean validarEmail(String email)
    {
        if(email == null)
        {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    /**
     * Texto que muestra los datos del alumno por la pantalla de la consola.
     */
    @Override
    public String toString()
    {
        return "Nombre del alumno: "+getNombre()+"\nNota 1: "+getNota1()+"\nNota 2: "+getNota2()+"\nNota 3: "+getNota3()+"\nNota media: "+calcularNotaMedia(getNota1(), getNota2(), getNota3())+"\nCorreo: "+email;
    }
}
