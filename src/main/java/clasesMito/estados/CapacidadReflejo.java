package clasesMito.estados;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadReflejo extends Estado {

	public CapacidadReflejo(Personaje sujeto) {
		super(sujeto);
	}
	@Override
	public String toString() {
		return "CapacidadReflej0[" + getSujeto() + "]";
	}
	
}
