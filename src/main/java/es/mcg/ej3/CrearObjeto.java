package es.mcg.ej3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.mcg.ej2.AntiguoAlumno;
/**
 * Esta clase crea los datos del alumno, las tres notas y el correo o email.
 * @author Manuel Canio Gil
 * @version 1.0
 */
public class CrearObjeto {
    /**
     * Metodo ejecutable que guarda en el fichero las tres notas y el correo del alumno.
     * @param args
     */
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Scanner sc = new Scanner(System.in);
        //Hacemos una lista de alumnos
        List<AntiguoAlumno> antiguoAlumnos = null;

        try 
        {
            file = new File("CorreosAlumnos.obj");
            if(!file.exists())
            {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            antiguoAlumnos = new ArrayList<AntiguoAlumno>();
            boolean salir = false;
            String nombre, correo;
            double nota1,nota2,nota3;
            do{
                //Pedimos los datos necesarios, primero el nombre del alumno
                System.out.print("Dime el nombre del alumno: ");
                nombre = sc.nextLine();
                //Despues el correo del alumno
                System.out.print("Dime el correo del alumno: ");
                correo = sc.nextLine();
                //Y por ultimo las tres notas
                System.out.println("Dime las notas del alumno");
                System.out.print("Nota 1: ");
                nota1 = sc.nextDouble();
                System.out.print("Nota 2: ");
                nota2 = sc.nextDouble();
                System.out.print("Nota 3: ");
                nota3 = sc.nextDouble();
                AntiguoAlumno alumno = new AntiguoAlumno(nombre, nota1, nota2, nota3, correo);
                //Si el correo es valido lo almacena en la lista
                if(alumno.validarEmail(correo))
                {
                    System.out.println("El correo es valido");
                    antiguoAlumnos.add(alumno);
                }
                else
                {
                    System.out.println("El correo no es valido");
                }
                char op;
                //Preguntamos si queremos guardar mas datos en la lista
                System.out.print("Guardar mas datos? (s/n) ");
                sc.nextLine();
                op = sc.nextLine().charAt(0);
                if(op == 'n')
                {
                    //Si decimos que no lo guardamos en el fichero
                    objectOutputStream.writeObject(antiguoAlumnos);
                    salir = true;
                }
                else if(op == 's')
                {
                    salir = false;
                }
                else
                {
                    salir = false;
                }
            }while(!salir);
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
        finally
        {
            if(sc != null)
            {
                try 
                {
                    sc.close();    
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream != null)
            {
                try 
                {
                    objectOutputStream.close();    
                }
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
            if(fileOutputStream != null)
            {
                try 
                {
                    fileOutputStream.close();    
                } 
                catch (IOException ioException2) 
                {
                    ioException2.printStackTrace();
                }
            }
        }
    }
}
