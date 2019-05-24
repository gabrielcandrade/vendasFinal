package br.com.unipe.classes;

public class Compra {
	
	// Attributes
	private Movimento movimento;
	
	// Constructor
	public Compra(Movimento movimento) {
		super();
		this.movimento = movimento;
	}

	// Getters and Setters
	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

}
