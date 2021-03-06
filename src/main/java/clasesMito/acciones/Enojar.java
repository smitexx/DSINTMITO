package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.*;

public class Enojar extends Accion{

	public Enojar(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
	}

	@Override
	public String toString() {
		return "Enojar [" + getSujeto() + ", " + getAfectadoP() + "]";
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarEnojar", this.getSujeto(), this.getAfectadoP());
	}
	
}
 