package br.com.unipe;

public class Usuario {
	
	// Attributes
	private String login;
	private String senha;
	private String matricula;
	private String nome;
	
	// Constructor
	public Usuario(String login, String senha, String matricula, String nome) {
		super();
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.nome = nome;
	}
	
	// Getters and Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
