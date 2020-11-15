package clasesMito.acciones;

import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.KieSession;

import clasesMito.Accion;
import clasesMito.Personaje;

public class Liberar extends Accion {

	public Liberar(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Liberar [" + getSujeto() + ", " + getAfectadoP() + "]";
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarLiberar", this.getSujeto(), this.getAfectadoP());
	}
	
}
