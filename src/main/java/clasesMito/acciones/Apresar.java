package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Accion;
import clasesMito.Personaje;

public class Apresar extends Accion {

	public Apresar(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarApresar", this.getSujeto(), this.getAfectadoP());
	}
	
}
 