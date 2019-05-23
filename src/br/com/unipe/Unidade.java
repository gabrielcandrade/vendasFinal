package br.com.unipe;

public class Unidade {
	
	// Attributes
	private int id;
	private String nome;
	
	// Constructor
	public Unidade(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
