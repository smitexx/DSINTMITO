package clasesMito.estados;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadInvisible extends Estado {

	public CapacidadInvisible(Personaje sujeto) {
		super(sujeto);
	}
	@Override
	public String toString() {
		return "CapacidadInvisible [" + getSujeto() + "]";
	}
	
	
}
