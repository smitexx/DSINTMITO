package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class CapacidadCurativa extends Estado {

	public CapacidadCurativa(Personaje sujeto) {
		super(sujeto);
	}

	@Override
	public String toString() {
		return "CapacidadCurativa [" + getSujeto() + "]";
	}	
	
	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarCurativa", this.getSujeto());
	}
	
}