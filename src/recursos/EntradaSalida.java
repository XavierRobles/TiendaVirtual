package recursos;

import java.time.temporal.TemporalAmount;
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
	public final static int SALIR = 5;
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
		System.out.println("5 - Salir");
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
		while(opcion <0 || opcion >2) {
			System.out.println("Error en la compra");
			
			System.out.println("Introduzca el numero del producto");
			opcion = sc.nextInt();
		}
		return opcion;

	}

	public static void mostrarSaldo(int saldo) {
		System.out.println("El saldo disponible es de: " + saldo + "€");

	}

	public static void mostrarCarrito(Clientes cliente) {
		List<Almacen> carrito = cliente.getCarrito(); 
		for (Almacen i : carrito) {
			System.out.println(i.getNombre()+ " - " + i.getPrecio());
			
		}
		
	}

}
