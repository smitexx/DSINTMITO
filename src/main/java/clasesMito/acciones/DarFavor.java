package clasesMito.acciones;

import clasesMito.Accion;
import clasesMito.Personaje;

public class DarFavor extends Accion {
	
	public DarFavor(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
	}

	@Override
	public String toString() {
		return "DarFavor ["+ getSujeto() + ", " + getAfectadoP() + "]";
	}
	
}
