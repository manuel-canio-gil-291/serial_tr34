package es.mcg.ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import es.mcg.ej2.AntiguoAlumno;
/**
 * Esta clase lee la lista de las tres notas y el correo de los alumnos antiguos cargados en el fichero.
 * 
 * @author Manuel Canio Gil
 * @version 1.0
 */
public class LeerObjeto {
    /**
     * Metodo ejecutable que lee la lista de datos de los antiguos alumnos cargados en el fichero.
     * @param args
     */
    public static void main(String[] args) {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<AntiguoAlumno> antiguoAlumnos = null;
        try 
        {
            file = new File("CorreosAlumnos.obj");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            //Leemos la lista de los datos de los antiguos alumnos
            antiguoAlumnos = (List<AntiguoAlumno>) objectInputStream.readObject();
            for(int i = 0; i < antiguoAlumnos.size(); i++)
            {
                //Una vez leido mostramos los datos de los alumnos antiguos por la pantalla
                System.out.println(antiguoAlumnos.get(i));
            }
        } 
        catch (IOException ioException) 
        {
            System.out.println(ioException.getMessage());
        }
        catch (ClassNotFoundException notFoundException)
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
