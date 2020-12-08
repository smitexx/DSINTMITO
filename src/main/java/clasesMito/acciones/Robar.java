package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.*;

public class Robar extends Accion {
	private Objeto objRobado;
	public Robar(Personaje sujeto, Personaje afectadoP, Objeto objRobado) {
		super(sujeto, afectadoP);
		this.objRobado = objRobado;
		// TODO Auto-generated constructor stub
	}
	public Objeto getObjRobado() {
		return objRobado;
	}
	public void setObjRobado(Objeto objRobado) {
		this.objRobado = objRobado;
	}
	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarRobar", this.getSujeto(), this.getAfectadoP(), this.getObjRobado());
	}
	
} 
