package es.mcg.ej2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearObjeto {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        List<NExpediente> expedientes = null;
        Scanner sc = new Scanner(System.in);
        try 
        {
            file = new File("notasAlumnos.obj");
            if(!file.exists())
            {
                file.createNewFile();
            }
            boolean salir = false;
            String nombre;
            double nota1,nota2,nota3;
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            expedientes = new ArrayList<NExpediente>();
            do{
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
                    System.out.println("La nota media es superior de 7");
                    expedientes.add(expediente);
                }
                else
                {
                    System.out.println("La nota media es inferior de 7");
                }
                char op;
                System.out.print("Guardar mas datos? (s/n) ");
                sc.nextLine();
                op = sc.nextLine().charAt(0);
                if(op == 'n')
                {
                    objectOutputStream.writeObject(expediente);
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
