package es.mcg.ej2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjeto {
    public static void main(String[] args) {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        
        try 
        {
            file = new File("notasAlumnos.obj");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            NExpediente expediente = null;
            for(int i = 0; i < 5; i++)
            {
                expediente = (NExpediente) objectInputStream.readObject();
                System.out.println(expediente);
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
