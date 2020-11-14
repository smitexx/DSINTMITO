package clasesMito;

import java.util.List;

public abstract class Personaje {
	private Personaje hijoDe;
	private  List<Objeto> inventario;
	private String nombre;
	private List<Personaje> padreDe;
	
	
	
	public Personaje(Personaje hijoDe, List<Objeto> inventario, String nombre, List<Personaje> padreDe) {
		super();
		this.hijoDe = hijoDe;
		this.inventario = inventario;
		this.nombre = nombre;
		this.padreDe = padreDe;
	}
	
	public Personaje getHijoDe() {
		return hijoDe;
	}
	public void setHijoDe(Personaje hijoDe) {
		this.hijoDe = hijoDe;
	}
	public List<Objeto> getInventario() {
		return inventario;
	}
	public void setInventario(List<Objeto> inventario) {
		this.inventario = inventario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Personaje> getPadreDe() {
		return padreDe;
	}
	public void setPadreDe(List<Personaje> padreDe) {
		this.padreDe = padreDe;
	}

	@Override
	public String toString() {
		return "" + nombre + "";
	}
	
	
}
