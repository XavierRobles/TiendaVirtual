package recursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import entidad.Almacen;
import entidad.Clientes;

public class EntradaSalida {
	public final static int COMPRAR = 1;
	public final static int CARRITO = 2;
	public final static int SALDO = 3;
	public final static int CSV = 4;
	public final static int RESET = 5;
	public final static int SALIR = 6;
	private static Scanner sc = new Scanner(System.in);

	public static String solicitarNombre() {

		System.out.println("Introduzca el usuario para acceder a su cuenta.");
		String nombre = sc.nextLine();
		return nombre;

	}

	public static int mostraMenu() {
		System.out.println("Seleccione una opcion del Menu");
		System.out.println("1 - Comprar");
		System.out.println("2 - Carrito de la compra");
		System.out.println("3 - Comprueba tu saldo actual");
		System.out.println("4 - Grabar los datos en un CSV");
		System.out.println("5 - Resetear la base de datos por defecto");
		System.out.println("6 - Salir");
		int opcion = sc.nextInt();
		return opcion;

	}

	public static int MostrarAlmacen(ArrayList<Almacen> stock) {
		int i = 0;
		for (Almacen almacen : stock) {
			System.out.println(
					i + " - " + almacen.getNombre() + " - " + almacen.getPrecio() + " - " + almacen.getCantidad());
			i++;
		}
		System.out.println("Seleccione el numero del objeto que quiere comprar");
		int opcion = sc.nextInt();
		while (opcion < 0 || opcion > 2) {
			System.err.println("Error en la compra\n");

			System.out.println("Introduzca el numero del producto");
			opcion = sc.nextInt();
		}
		return opcion;

	}

	public static void mostrarSaldo(int saldo) {
		System.out.println("El saldo disponible es de: " + saldo + "€\n");

	}

	public static void mostrarCarrito(Clientes cliente) {
		List<Almacen> carrito = cliente.getCarrito();
		for (Almacen i : carrito) {
			System.out.println(i.getNombre() + " - " + i.getPrecio());

		}

	}

	public static boolean resetearBBDD() {
		boolean reset = false;
		
		System.out.println("¿Estas seguro que quieres resetear la base de datos?");
		System.out.println("#######################");
		System.out.println("Seleccione 'y' o 'n'");
		System.out.println("#######################\n");
		String opcion;
		sc.nextLine();
		opcion = (sc.nextLine().toLowerCase());
		
		
		if (opcion.equals("y")) {
			System.out.println("###########################################################");
			System.out.println("Restableciendo base de datos");
			System.out.println("###########################################################\n");
			try {
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println("..");
				Thread.sleep(1000);
				System.out.println("...");
				Thread.sleep(1000);
				System.out.println("....");
				Thread.sleep(1000);
				System.out.println(".....");
				Thread.sleep(1000);
				System.out.println("......");
				System.err.println("Operacion completada con exito\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reset = true;

		} else {
			System.err.println("Operacion cancelada\n");
		}
		return reset;
	}

}
