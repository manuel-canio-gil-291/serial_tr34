package es.mcg.ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import es.mcg.ej2.AntiguoAlumno;

public class LeerObjeto {
    public static void main(String[] args) {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try 
        {
            file = new File("CorreosAlumnos.obj");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            AntiguoAlumno alumno = null;
            for(int i = 0; i < 5; i++)
            {
                alumno = (AntiguoAlumno) objectInputStream.readObject();
                System.out.println(alumno);
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
