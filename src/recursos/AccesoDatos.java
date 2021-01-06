package recursos;

import entidad.Almacen;
import entidad.Clientes;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoDatos {

	public static Clientes obtenerNombre(String nombre) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaexamen", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM clientes WHERE nombre = '" + nombre + "'";
			ResultSet rst = stmt.executeQuery(query);
			rst.next();
			Clientes usuario = new Clientes();
			usuario.setNombre(rst.getString(1));
			usuario.setSaldo(rst.getInt(2));
			return usuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static ArrayList<Almacen> obtenerstock() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaexamen", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM almacen";
			ResultSet rst = stmt.executeQuery(query);

			ArrayList<Almacen> lista = new ArrayList<Almacen>();
			while (rst.next()) {
				Almacen stock = new Almacen();
				stock.setNombre(rst.getString(1));
				stock.setPrecio(rst.getInt(2));
				stock.setCantidad(rst.getInt(3));
				lista.add(stock);

			}
			return lista;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void borrarObjeto(int posicion, ArrayList<Almacen> lista) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaexamen", "root", null);
			Statement stmt = c.createStatement();
			int cantidadfinal = lista.get(posicion).getCantidad() - 1;
			String query = "UPDATE almacen SET cantidad = " + cantidadfinal + " WHERE nombre ='"
					+ lista.get(posicion).getNombre() + "'";
			int rst = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cambiarSaldo(Clientes cliente, int comprado, ArrayList<Almacen> stock) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaexamen", "root", null);
			Statement stmt = c.createStatement();
			int saldofinal = cliente.getSaldo() - stock.get(comprado).getPrecio();
			String query = "UPDATE clientes SET saldo = " + saldofinal + " WHERE nombre ='" + cliente.getNombre() + "'";
			int rst = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int mostrarSaldo(String nombre) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaexamen", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT saldo FROM clientes WHERE nombre = '" + nombre + "'";
			ResultSet rst = stmt.executeQuery(query);
			rst.next();
			int saldo = rst.getInt(1);
			return saldo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
