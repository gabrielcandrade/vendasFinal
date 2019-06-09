package br.com.unipe.classes;

import java.sql.Date;

public class Movimento {
	
	// Attributes
	private int id;
	private Date data;
	private int total;
	private Usuario usuario;
	private PessoaJuridica pessoaJuridica;
	private ItemMovimento itemMovimento;
	
	//Constructor
	public Movimento(int id, Date data, int total, Usuario usuario, PessoaJuridica pessoaJuridica, ItemMovimento itemMovimento) {
		super();
		this.id = id;
		this.data = data;
		this.total = total;
		this.usuario = usuario;
		this.pessoaJuridica = pessoaJuridica;
		this.itemMovimento = itemMovimento;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public ItemMovimento getItemMovimento() {
		return itemMovimento;
	}
	
	public void setItemMovimento(ItemMovimento itemMovimento) {
		this.itemMovimento = itemMovimento;
	}
}
