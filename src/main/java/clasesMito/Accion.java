package clasesMito;
 
public abstract class Accion {
	private Personaje sujeto;
	private Personaje afectadoP;
	private Objeto afectadoC;
	
	public Accion(Personaje sujeto, Objeto afectadoC) {
		super();
		this.sujeto = sujeto;
		this.afectadoC = afectadoC;
	}
	public Accion(Personaje sujeto, Personaje afectadoP) {
		super();
		this.sujeto = sujeto;
		this.afectadoP = afectadoP;
	}
	public Personaje getSujeto() {
		return sujeto;
	}
	public void setSujeto(Personaje sujeto) {
		this.sujeto = sujeto;
	}
	public Personaje getAfectadoP() {
		return afectadoP;
	}
	public void setAfectadoP(Personaje afectadoP) {
		this.afectadoP = afectadoP;
	}
	public Objeto getAfectadoC() {
		return afectadoC;
	}
	public void setAfectadoC(Objeto afectadoC) {
		this.afectadoC = afectadoC;
	}
	
	
	
}
