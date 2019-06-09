package br.com.unipe.classes;

public class Venda {
	
	// Attributes
	private Movimento movimento;
	
	// Constructor
	public Venda(Movimento movimento) {
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
