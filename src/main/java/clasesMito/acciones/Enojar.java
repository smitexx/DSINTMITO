package clasesMito.acciones;

import clasesMito.*;

public class Enojar extends Accion{

	public Enojar(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
	}

	@Override
	public String toString() {
		return "Enojar [" + getSujeto() + ", " + getAfectadoP() + "]";
	}
	
}
 