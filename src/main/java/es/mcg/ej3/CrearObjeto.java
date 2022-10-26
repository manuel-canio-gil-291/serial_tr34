package es.mcg.ej3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.mcg.ej2.AntiguoAlumno;

public class CrearObjeto {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Scanner sc = new Scanner(System.in);
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
                    antiguoAlumnos.add(alumno);
                }
                else
                {
                    System.out.println("El correo no es valido");
                }
                char op;
                System.out.print("Guardar mas datos? (s/n) ");
                sc.nextLine();
                op = sc.nextLine().charAt(0);
                if(op == 'n')
                {
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
