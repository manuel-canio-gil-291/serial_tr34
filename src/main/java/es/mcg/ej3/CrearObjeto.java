package es.mcg.ej3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import es.mcg.ej2.AntiguoAlumno;

public class CrearObjeto {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Scanner sc = new Scanner(System.in);

        try 
        {
            file = new File("CorreosAlumnos.obj");
            if(!file.exists())
            {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            String nombre, correo;
            double nota1,nota2,nota3;
            System.out.print("Dime el nombre del alumno: ");
            nombre = sc.nextLine();
            System.out.print("Dime el correo del alumno: ");
            correo = sc.nextLine();
            System.out.println("Dime las notas del alumno");
            System.out.print("Nota 1: ");
            nota1 = sc.nextDouble();
            System.out.print("Nota 2: ");
            nota2 = sc.nextDouble();
            System.out.print("Nota 3: ");
            nota3 = sc.nextDouble();
            AntiguoAlumno alumno = new AntiguoAlumno(nombre, nota1, nota2, nota3, correo);
            if(alumno.validarEmail(correo))
            {
                System.out.println("El correo es valido");
                objectOutputStream.writeObject(alumno);
                System.out.println("Se ha guardado los datos en el fichero '"+file+"'");
                System.out.println(alumno);
            }
            else
            {
                System.out.println("El correo no es valido");
            }
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
