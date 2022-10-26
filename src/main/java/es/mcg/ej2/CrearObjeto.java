package es.mcg.ej2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Esta clase crea las notas de los alumnos, los almacena en un List y se guarda en el fichero.
 * @author Manuel Canio Gil
 * @version 1.0
 */
public class CrearObjeto {
    /**
     * Metodo ejecutable que crea las tres notas del alumno.
     * @param args
     */
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        //Hacemos una lista de los alumnos
        List<Expediente> expedientes = null;
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
            expedientes = new ArrayList<Expediente>();
            do{
                //Pedimos los datos necesarios, primero el nombre del alumno
                System.out.print("Dime el nombre del alumno: ");
                nombre = sc.nextLine();
                //Despues pedimos las tres notas para calcular la media
                System.out.println("Dime las notas del alumno");
                System.out.print("Nota 1: ");
                nota1 = sc.nextDouble();
                System.out.print("Nota 2: ");
                nota2 = sc.nextDouble();
                System.out.print("Nota 3: ");
                nota3 = sc.nextDouble();
                Expediente expediente = new Expediente(nombre, nota1, nota2, nota3);
                //Si la media de las tres da mayor que 7, los almacena en un List
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
                //Preguntamos si queremos guardar mas datos
                System.out.print("Guardar mas datos? (s/n) ");
                sc.nextLine();
                op = sc.nextLine().charAt(0);
                if(op == 'n')
                {
                    //Si decimos que no, guardamos la lista en el fichero
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
