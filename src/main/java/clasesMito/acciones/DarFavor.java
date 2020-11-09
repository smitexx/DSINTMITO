package clasesMito.acciones;

import clasesMito.Accion;
import clasesMito.Objeto;
import clasesMito.Personaje;

public class DarFavor extends Accion {
	private Objeto objeto;
	
	public DarFavor(Personaje sujeto, Personaje afectadoP, Objeto obj) {
		super(sujeto, afectadoP);
		this.objeto = obj;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
}
