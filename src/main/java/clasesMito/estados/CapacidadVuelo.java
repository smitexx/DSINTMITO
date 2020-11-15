package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadVuelo extends Estado {

	public CapacidadVuelo(Personaje sujeto) {
		super(sujeto);
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarVuelo", this.getSujeto());
	}
	
}
