package clasesMito.Personajes;

import java.util.List;

import clasesMito.Objeto;
import clasesMito.Personaje;

public class Mortal extends Personaje {
	
	private List<Dios> favores;
	public Mortal(Personaje hijoDe, List<Objeto> inventario, String nombre, List<Personaje> padreDe, List<Dios> favores) {
		super(hijoDe, inventario, nombre, padreDe);
		this.favores = favores;
		// TODO Auto-generated constructor stub
	}
	public List<Dios> getFavores() {
		return favores;
	}
	public void setFavores(List<Dios> favores) {
		this.favores = favores;
	}
	
}  
