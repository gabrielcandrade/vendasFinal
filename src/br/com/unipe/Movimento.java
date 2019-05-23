package br.com.unipe;

import java.sql.Date;

public class Movimento {
	
	// Attributes
	private int id;
	private Date data;
	private int total;
	private Usuario usuario;
	private Pessoa pessoa;
	private ItemMovimento itemMovimento;
	
	//Constructor
	public Movimento(int id, Date data, int total, Usuario usuario, Pessoa pessoa, ItemMovimento itemMovimento) {
		super();
		this.id = id;
		this.data = data;
		this.total = total;
		this.usuario = usuario;
		this.pessoa = pessoa;
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
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public ItemMovimento getItemMovimento() {
		return itemMovimento;
	}
	
	public void setItemMovimento(ItemMovimento itemMovimento) {
		this.itemMovimento = itemMovimento;
	}
}
