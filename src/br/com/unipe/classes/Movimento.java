package br.com.unipe.classes;

public class Movimento {
	
	// Attributes
	private int id;
	private String data;
	private float total;
	private PessoaJuridica pessoaJuridica;
	private ItemMovimento itemMovimento;
	
	//Constructor
	public Movimento(int id, String data, PessoaJuridica pessoaJuridica, ItemMovimento itemMovimento) {
		super();
		this.id = id;
		this.data = data;
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
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
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
