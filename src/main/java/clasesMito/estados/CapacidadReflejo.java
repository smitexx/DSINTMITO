package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadReflejo extends Estado {

	public CapacidadReflejo(Personaje sujeto) {
		super(sujeto);
	}
	
	@Override
	public String toString() {
		return "CapacidadReflej0[" + getSujeto() + "]";
	}
	
	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarReflejo", this.getSujeto());
	}
}
