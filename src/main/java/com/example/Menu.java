package com.example;
import java.time.LocalDateTime;
import java.util.Scanner;

import controllers.PedidoDAO;
import controllers.ProductoDAO;
import models.Pedido;

public class Menu {

    public Menu(){
        menu();
    }

    public void menu(){
        System.out.println("Bienvenido, este es el menú de opciones: \n");
        System.out.println("1. Ver la carta" );
        System.out.println("2. Hacer un pedido");
        System.out.println("3. Eliminar un pedido");
        System.out.println("4. Marcar un pedido como recogido");
        System.out.println("5. Ver el numero de pedidos asociados a un cliente");
        System.out.println("6. Ver los pedidos realizados hoy");
        System.out.println("7. Resumen Estadístico");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch(opcion){
        case 1:
            ProductoDAO carta = new ProductoDAO();
            carta.getAll().forEach(System.out::println);
            pressEnter();
            break;
        case 2:
            PedidoDAO pedido2 = new PedidoDAO();
            Pedido pe = new Pedido();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Introduce el nombre del cliente");
            String cliente = sc2.nextLine();
            pe.setCliente(cliente);
            System.out.println("Introduce el identificador del producto");
            Integer producto = sc2.nextInt();
            pe.setProducto(producto);
            
            pe.setFecha(LocalDateTime.now().toString());
            pe.setEstado("En camino");

            pedido2.add(pe);
            pressEnter();
            break;
        case 3:
            Scanner sc3 = new Scanner(System.in);
            PedidoDAO pedido3 = new PedidoDAO();
            System.out.println("Introduce el id del pedido");
            Integer id = sc3.nextInt();
            pedido3.delete(id);
            break;
        case 4:
            Scanner sc4 = new Scanner(System.in);
            PedidoDAO pedido4 = new PedidoDAO();
            System.out.println("Introduce el id del pedido");
            int id2 = sc4.nextInt();
            pedido4.updateStatus(id2, "Recogido");
            break;
        case 5:
            Scanner sc5 = new Scanner(System.in);
            PedidoDAO pedido5 = new PedidoDAO();
            System.out.println("Introduce el nombre del cliente");
            String cliente2 = sc5.nextLine();
            pedido5.getByCliente(cliente2);
            break;
        case 6:
            PedidoDAO pedido6 = new PedidoDAO();
            var fecha = LocalDateTime.now().toString();
            pedido6.getByDate( fecha.substring(0, fecha.indexOf("T")));
            break;
        case 7:
            PedidoDAO pedido7 = new PedidoDAO();
            pedido7.topCustomer();
            pedido7.earnings();
            pedido7.lastMonth();
            pressEnter();
            break;
        case 8:
            System.exit(0);
            break;
        default: menu();
        }
        menu();
    }

    public static void pressEnter() { 
		System.out.println("Presiona Enter para continuar.");
		try
		{
			System.in.read();
		}  
		catch(Exception e)
		{}  
	}

}
