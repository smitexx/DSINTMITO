package clasesMito.estados;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Estado;
import clasesMito.Personaje;

public class Vivo extends Estado {

	public Vivo(Personaje sujeto) {
		super(sujeto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarVivo", this.getSujeto());
	}

}
 