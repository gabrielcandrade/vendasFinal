package br.com.unipe;

public class PessoaFisica {
	
	// Attributes
	private Pessoa pessoa;
	private String cpf;
	
	// Constructor
	public PessoaFisica(Pessoa pessoa, String cpf) {
		super();
		this.pessoa = pessoa;
		this.cpf = cpf;
	}
	
	// Getters and Setters
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
