package es.mcg.ej2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
/**
 * <p>Esta clase lee el contenido de la lista de las tres notas de los alumnos en el fichero
 * y los muestra por la pantalla de la consola.</p>
 * 
 * @author Manuel Canio Gil
 * @version 1.1
 * 
 */
public class LeerObjeto {
    /**
     * Metodo ejecutable que lee la lista de los alumnos y las tres notas cargada en el fichero.
     * @param args
     */
    public static void main(String[] args) {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Expediente> expedientes = null;
        try 
        {
            file = new File("notasAlumnos.obj");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            //Leemos el contenido de la lista de las tres notas de los alumnos cargados previamente
            //en el fichero.
            expedientes = (List<Expediente>) objectInputStream.readObject();
            for(int i = 0; i < expedientes.size(); i++)
            {
                //Mostramos por pantalla el nombre del alumno, las tres notas y la media
                System.out.println(expedientes.get(i));
            }
        } 
        catch (IOException ioException) 
        {
            System.out.println(ioException.getMessage());
        }
        catch(ClassNotFoundException notFoundException)
        {
            notFoundException.printStackTrace();
        }
        finally
        {
            if(objectInputStream != null)
            {
                try 
                {
                    objectInputStream.close();    
                }
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
            if(fileInputStream != null)
            {
                try 
                {
                    fileInputStream.close();    
                } 
                catch (IOException ioException2) 
                {
                    ioException2.printStackTrace();
                }
            }
        }
    }
}
