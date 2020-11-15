package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Accion;
import clasesMito.Personaje;

public class Matar extends Accion {

	public Matar(Personaje sujeto, Personaje afectadoP) {
		super(sujeto, afectadoP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarMatar", this.getSujeto(), this.getAfectadoP());
	}

}
 