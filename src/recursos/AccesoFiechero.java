package recursos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entidad.Almacen;
import entidad.Clientes;

public class AccesoFiechero {
	public static void copiaSeguridad() {

		File copiaAlmacen = new File("C:\\Users\\xavie\\pruebasmenu\\PruebasCopiaTienda\\CopiaAlmacen.csv");

		try {
			FileWriter fw = new FileWriter(copiaAlmacen);
			ArrayList<Almacen> almacen = AccesoDatos.obtenerStock();
			String archivoAlmacen = "";

			for (Almacen stock : almacen) {
				archivoAlmacen += "Producto: ";
				archivoAlmacen += stock.getNombre();
				archivoAlmacen += ", Precio:";
				archivoAlmacen += stock.getPrecio();
				archivoAlmacen += "€, Cantidad disponible: (";
				archivoAlmacen += stock.getCantidad();
				archivoAlmacen += ")\n";

			}
			fw.write(archivoAlmacen);
			fw.close();
			System.out.println("###########################################################");
			System.out.println("Copia de segurida del almacen creada correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File copiaClientes = new File("C:\\Users\\xavie\\pruebasmenu\\PruebasCopiaTienda\\CopiaClientes.csv");
		try {
			FileWriter fw = new FileWriter(copiaClientes);
			ArrayList<Clientes> clientes = AccesoDatos.obtenerClientes();
			String archivoClientes = "";

			for (Clientes listaClientes : clientes) {
				archivoClientes += "Nombre del cliente: ";
				archivoClientes += listaClientes.getNombre();
				archivoClientes += ", Saldo Actual del cliente ";
				archivoClientes += listaClientes.getSaldo();
				archivoClientes += "€\n";
			}
			fw.write(archivoClientes);
			fw.close();
			System.out.println("Copia de segurida de los Clientes creada correctamente");
			System.out.println("###########################################################\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
