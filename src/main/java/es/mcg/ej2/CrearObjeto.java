package es.mcg.ej2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CrearObjeto {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Scanner sc = new Scanner(System.in);

        try 
        {
            file = new File("notasAlumnos.obj");
            if(!file.exists())
            {
                file.createNewFile();
            }
            String nombre;
            double nota1,nota2,nota3;
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.print("Dime el nombre del alumno: ");
            nombre = sc.nextLine();
            System.out.println("Dime las notas del alumno");
            System.out.print("Nota 1: ");
            nota1 = sc.nextDouble();
            System.out.print("Nota 2: ");
            nota2 = sc.nextDouble();
            System.out.print("Nota 3: ");
            nota3 = sc.nextDouble();
            NExpediente expediente = new NExpediente(nombre, nota1, nota2, nota3);
            if(expediente.calcularNotaMedia(nota1, nota2, nota3) > 7)
            {
                objectOutputStream.writeObject(expediente);
                System.out.println("La nota media es superior de 7\nSe ha guardado los datos en el fichero '"+file+"'");
                System.out.println("Esto son los datos que se han guardado\n"+expediente);
            }
            else
            {
                System.out.println("La nota media es inferior de 7\nLos datos no pueden ser guardados");
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
                catch(Exception e)
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
                catch(IOException ioException)
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
                catch(IOException ioException2)
                {
                    ioException2.printStackTrace();
                }
            }
        }
    }
}
