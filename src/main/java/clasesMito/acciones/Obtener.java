package clasesMito.acciones;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

import clasesMito.Accion;
import clasesMito.Objeto;
import clasesMito.Personaje;

public class Obtener extends Accion {

	public Obtener(Personaje sujeto, Objeto afectadoC) {
		super(sujeto, afectadoC);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Obtener [getSujeto()=" + getSujeto() + ", getAfectadoC()=" + getAfectadoC() + "]";
	}
	
	@Override
	public QueryResults buscarRespuesta(KieSession kSession) {
		return kSession.getQueryResults("buscarObtener", this.getSujeto(), this.getAfectadoC());
	}

}
 