package clasesMito.estados;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadVuelo extends Estado {

	public CapacidadVuelo(Personaje sujeto) {
		super(sujeto);
	}

	@Override
	public String toString() {
		return "CapacidadVuelo [" + getSujeto() + "]";
	}
	
}
