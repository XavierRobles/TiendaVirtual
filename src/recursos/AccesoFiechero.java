package recursos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entidad.Almacen;


public class AccesoFiechero {
	public static void copiaSeguridad() {
		
		File copiaAlmacen = new File("C:\\Users\\xavie\\pruebasmenu\\PruebasCopiaTienda\\CopiaAlmacen.csv");
		
		try {
			FileWriter fw = new FileWriter(copiaAlmacen);
			ArrayList<Almacen> almacen = AccesoDatos.obtenerstock();
			String archivo = "";
			
			for (Almacen stock : almacen) {
				archivo += stock.getNombre();
				archivo += stock.getPrecio();
				archivo += stock.getCantidad();
				
				
			}
			fw.write(archivo);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
