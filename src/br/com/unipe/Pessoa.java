package br.com.unipe;

public class Pessoa {
	
	// Attributes
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String celular;
	private Endereco endereco;
	private Movimento movimento;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Movimento getMovimento() {
		return movimento;
	}
	
	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}
}
