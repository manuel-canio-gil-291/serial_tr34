package es.mcg.ej1;
/**
 * Esta clase crea los objetos de Cliente y Cuenta, los almacena en un List y los guarda en un fichero
 * @author Manuel Canio Gil
 * @version 1.0
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearObjeto {
    /**
     * Metodo ejecutable para crear objetos Cliente y Cuenta
     * @param args
     */
    public static void main(String[] args) {
        String nombreCliente, direccion;
        int ncliente, ncuenta;
        double saldo;
        String estado, nombreCuenta;
        boolean salir = false;
        File file = null, file2 = null;
        FileOutputStream fileOutputStream = null, fileOutputStream2 = null;
        ObjectOutputStream objectOutputStream = null, objectOutputStream2 = null;
        //Hacemos una lista de cuentas
        List<Cuenta> cuentas = null;
        //Hacemos una lista de clientes
        List<Cliente> clientes = null;
        Scanner sc = new Scanner(System.in);

        try 
        {
        
            file = new File("datosCliente.obj");
            file2 = new File("datosCuenta.obj");
            if(!file.exists())
            {
                file.createNewFile();
            }
            if(!file2.exists())
            {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream2 = new FileOutputStream(file2, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
            //Llamamos a los objetos
            Cuenta cuenta = null;
            Cliente cliente = null;
            cuentas = new ArrayList<Cuenta>();
            clientes = new ArrayList<Cliente>();
            do{   
                //Pedimos los datos por pantalla, primero el nombre del cliente
                System.out.print("Digame el nombre del cliente: ");
                nombreCliente = sc.nextLine();
                //Despues la direccion del cliente
                System.out.print("Indicame la direccion del cliente: ");
                direccion = sc.nextLine();
                //Despues el saldo inicial
                System.out.print("Introduzca el saldo inicial (si no posee saldo, escriba 0): ");
                saldo = sc.nextDouble();
                sc.nextLine();
                //Despues pedimos el nombre de la cuenta a asignar
                System.out.print("Digame el nombre de la cuenta: ");
                nombreCuenta = sc.nextLine();
                //Indicamos el estado de la cuenta
                System.out.print("Digame el estado de la cuenta: ");
                estado = sc.nextLine();
                //El numero de cuenta y cliente generara uno aleatorio
                ncuenta = (int) Math.floor(Math.random()*1000000000);
                ncliente = (int) Math.floor(Math.random()*1000000000);
                cuenta = new Cuenta(nombreCuenta, ncuenta);
                cliente = new Cliente(nombreCliente, direccion, ncliente, saldo, cuenta);
                switch(estado)
                {
                    case "Al dia": cuenta.setEstado(Estado.ALDIA);break;
                    case "Atrasada": cuenta.setEstado(Estado.ATRASADA);break;
                    case "Deudor": cuenta.setEstado(Estado.DEUDOR);break;
                    default: {
                        //Si ninguna de las opciones vienen dadas en la enumeracion, se cierra el programa
                        System.err.println("ERROR FATAL. El estado introducido no es valido. El programa se ha cerrado inesperadamente");
                        System.exit(210);
                    }
                }
                System.out.println("Estos son los datos del cliente y cuenta guardados:\n"+cliente);
                cuentas.add(cuenta);
                clientes.add(cliente);
                //Pedimos confirmacion si queremos seguir agregando mas datos
                char op = 's';
                System.out.print("Desea guardar mas datos? (s/n) ");
                op = sc.nextLine().charAt(0);
                if(op == 's')
                {
                    salir = false;
                }
                else if(op == 'n')
                {
                    //Si decimos que no, guardamos las listas tanto las cuentas como los clientes
                    salir = true;
                    objectOutputStream.writeObject(clientes);
                    objectOutputStream2.writeObject(cuentas);
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
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }
            if(objectOutputStream2 != null)
            {
                try 
                {
                    objectOutputStream2.close();
                } 
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
            if(fileOutputStream2 != null)
            {
                try 
                {
                    fileOutputStream2.close();
                } 
                catch (IOException ioException2) 
                {
                    ioException2.printStackTrace();
                }
            }
            if(objectOutputStream != null)
            {
                try 
                {
                    objectOutputStream.close();
                } 
                catch (IOException ioException3) 
                {
                    ioException3.printStackTrace();
                }
            }
            if(fileOutputStream != null)
            {
                try 
                {
                    fileOutputStream.close();
                } 
                catch (IOException ioException4) 
                {
                    ioException4.printStackTrace();
                }
            }
        }
    }
}
