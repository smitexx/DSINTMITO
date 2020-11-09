package clasesMito;

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
	
}
