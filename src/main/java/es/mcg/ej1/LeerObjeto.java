package es.mcg.ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
/**
 * Esta clase lee las listas de clientes y cuentas cargados en los ficheros.
 * @author Manuel Canio Gil
 * @version 1.0
 */
public class LeerObjeto {
    /**
     * Metodo ejecutable para leer las listas de los clientes y cuentas del banco.
     * @param args
     */
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
            List<Cliente> clientes = null;
            //Leemos solamente la lista de clientes cargadas en el fichero,
            //ya que viene cargado tambien sus cuentas vinculadas
            clientes = (List<Cliente>) objectInputStream.readObject();
            for(int i = 0; i < clientes.size(); i++)
            {
                //Obtenemos los datos de los clientes y de las cuentas asociadas
                System.out.println(clientes.get(i));
            }
        }
        catch (IOException ioException) 
        {
            System.out.println("Fin de lectura");
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
