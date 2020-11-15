package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class Muerto extends Estado {

	public Muerto(Personaje sujeto) {
		super(sujeto);
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarMuerto", this.getSujeto());
	}

}
