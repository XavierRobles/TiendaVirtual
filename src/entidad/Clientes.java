package entidad;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
	private String nombre;
	private int saldo;
	private List<Almacen> carrito = new ArrayList();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public List<Almacen> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Almacen> carrito) {
		this.carrito = carrito;
	}

}
