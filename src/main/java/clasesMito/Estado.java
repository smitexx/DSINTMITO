package clasesMito;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

public abstract class Estado {
	private Personaje sujeto;

	public Estado(Personaje sujeto) {
		super();
		this.sujeto = sujeto;
	}

	public Personaje getSujeto() {
		return sujeto;
	}

	public void setSujeto(Personaje sujeto) {
		this.sujeto = sujeto;
	}

	@Override
	public String toString() {
		return "[" + sujeto + "]";
	}
	
	public abstract QueryResults buscarRespuesta(KieSession kSession);
}
