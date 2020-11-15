package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadInvisible extends Estado {

	public CapacidadInvisible(Personaje sujeto) {
		super(sujeto);
	}

	@Override
	public String toString() {
		return "CapacidadInvisible [" + getSujeto() + "]";
	}	
	
	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarInvisible", this.getSujeto());
	}
	
}
