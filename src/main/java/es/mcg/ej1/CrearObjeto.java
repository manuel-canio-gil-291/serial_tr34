package es.mcg.ej1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearObjeto {
    public static void main(String[] args) {
        String nombreCliente, direccion;
        int ncliente, ncuenta;
        double saldo;
        String estado, nombreCuenta;
        boolean salir = false;
        File file = null, file2 = null;
        FileOutputStream fileOutputStream = null, fileOutputStream2 = null;
        ObjectOutputStream objectOutputStream = null, objectOutputStream2 = null;
        List<Cuenta> cuentas = null;
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
            Cuenta cuenta = null;
            Cliente cliente = null;
            cuentas = new ArrayList<Cuenta>();
            clientes = new ArrayList<Cliente>();
            do{   
                System.out.print("Digame el nombre del cliente: ");
                nombreCliente = sc.nextLine();
                System.out.print("Indicame la direccion del cliente: ");
                direccion = sc.nextLine();
                System.out.print("Introduzca el saldo inicial (si no posee saldo, escriba 0): ");
                saldo = sc.nextDouble();
                sc.nextLine();
                System.out.print("Digame el nombre de la cuenta: ");
                nombreCuenta = sc.nextLine();
                System.out.print("Digame el estado de la cuenta: ");
                estado = sc.nextLine();
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
                        System.err.println("ERROR FATAL. El estado introducido no es valido. El programa se ha cerrado inesperadamente");
                        System.exit(210);
                    }
                }
                System.out.println("Estos son los datos del cliente y cuenta guardados:\n"+cliente);
                cuentas.add(cuenta);
                clientes.add(cliente);
                char op = 's';
                System.out.print("Desea guardar mas datos? (s/n) ");
                op = sc.nextLine().charAt(0);
                if(op == 's')
                {
                    salir = false;
                }
                else if(op == 'n')
                {
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
