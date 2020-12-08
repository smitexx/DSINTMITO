package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

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

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarDarFavor", this.getSujeto(), this.getAfectadoP());
	}
	
}
