package es.mcg.ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjeto {
    public static void main(String[] args) {
        File file = null, file2 = null;
        FileInputStream fileInputStream = null, fileInputStream2 = null;
        ObjectInputStream objectInputStream = null, objectInputStream2 = null;
        
        try 
        {
            file = new File("datosCliente.obj");
            file2 = new File("datosCuenta.obj");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            fileInputStream2 = new FileInputStream(file2);
            objectInputStream2 = new ObjectInputStream(fileInputStream2);

            Cuenta cuenta = (Cuenta) objectInputStream2.readObject();
            Cliente cliente = (Cliente) objectInputStream.readObject();

            if(cuenta.getEstado() == Estado.DEUDOR)
            {
                System.out.println(cliente);
            }
        }
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
        catch (ClassNotFoundException notFoundException)
        {
            notFoundException.printStackTrace();
        }
        finally
        {
            if(objectInputStream2 != null)
            {
                try 
                {
                    objectInputStream2.close();
                } 
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
            if(fileInputStream2 != null)
            {
                try 
                {
                    fileInputStream2.close();    
                } 
                catch (IOException ioException2) 
                {
                    ioException2.printStackTrace();
                }
            }
            if(objectInputStream != null)
            {
                try 
                {
                    objectInputStream.close();    
                } 
                catch (IOException ioException3) 
                {
                    ioException3.printStackTrace();
                }
            }
            if(fileInputStream != null)
            {
                try 
                {
                    fileInputStream.close();
                } 
                catch (IOException ioException4) 
                {
                    ioException4.printStackTrace();
                }
            }
        }
    }
}
