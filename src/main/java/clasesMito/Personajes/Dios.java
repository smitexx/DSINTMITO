package clasesMito.Personajes;

import java.util.List; 

import clasesMito.Objeto;
import clasesMito.Personaje;

public class Dios extends Inmortal {
	private String tipoDios;
	public Dios(Personaje hijoDe, List<Objeto> inventario, String nombre, List<Personaje> padreDe, String tipoDios) {
		super(hijoDe, inventario, nombre, padreDe);
		this.tipoDios = tipoDios;
		// TODO Auto-generated constructor stub
	}
	public String getTipoDios() {
		return tipoDios;
	}
	public void setTipoDios(String tipoDios) {
		this.tipoDios = tipoDios;
	}
	

}
 