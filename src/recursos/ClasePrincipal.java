package recursos;

import java.util.ArrayList;

import entidad.Almacen;
import entidad.Clientes;

public class ClasePrincipal {
	public static void main(String[] args) {
		String nombre = EntradaSalida.solicitarNombre();
		Clientes cliente = AccesoDatos.obtenerNombre(nombre);
		System.out.println("Bienvenino " + cliente.getNombre() + ", su saldo actual es de: " + cliente.getSaldo());

		int opcion = EntradaSalida.mostraMenu();
		while (opcion != EntradaSalida.SALIR) {
			switch (opcion) {
			case EntradaSalida.COMPRAR:
				ArrayList<Almacen> stock = AccesoDatos.obtenerstock();
				int comprado = EntradaSalida.MostrarAlmacen(stock);
				if (cliente.getSaldo() < stock.get(comprado).getPrecio()) {
					System.err.println("Saldo insuficiente");

				} else {
					AccesoDatos.borrarObjeto(comprado, stock);
					AccesoDatos.cambiarSaldo(cliente, comprado, stock);
					cliente.getCarrito().add(stock.get(comprado));

				}

				break;
			case EntradaSalida.CARRITO:
				EntradaSalida.mostrarCarrito(cliente);
				break;
			case EntradaSalida.SALDO:
				int saldo = AccesoDatos.mostrarSaldo(nombre);
				EntradaSalida.mostrarSaldo(saldo);

				break;
			case EntradaSalida.CSV:

				break;
			case EntradaSalida.SALIR:
	
				break;

			default:
				break;
			}
			opcion = EntradaSalida.mostraMenu();

		}
		System.out.println("GRACIAS POR SU VISITA!!!");

	}

}
