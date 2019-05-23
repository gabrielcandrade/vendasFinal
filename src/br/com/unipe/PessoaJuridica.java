package br.com.unipe;

public class PessoaJuridica {
	
	// Attributes
	private Pessoa pessoa;
	private String cnpj;
	
	// Constructor
	public PessoaJuridica(Pessoa pessoa, String cnpj) {
		super();
		this.pessoa = pessoa;
		this.cnpj = cnpj;
	}
	
	// Getters and Setters
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
