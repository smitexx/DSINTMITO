package clasesMito.acciones;

import clasesMito.*;


public class Pulir extends Accion {
	private Objeto objPulido;
	
	public Pulir(Personaje sujeto, Personaje afectadoP, Objeto objPulido) {
		super(sujeto, afectadoP);
		this.objPulido = objPulido;
		// TODO Auto-generated constructor stub
	}

	public Objeto getObjPulido() {
		return objPulido;
	}

	public void setObjPulido(Objeto objPulido) {
		this.objPulido = objPulido;
	}
}
