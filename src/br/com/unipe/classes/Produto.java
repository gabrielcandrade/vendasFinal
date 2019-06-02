package br.com.unipe.classes;

public class Produto {
	
	// Attributes
	private int id;
	private String nome;
	private float precoVenda;
	private int qtde_estoque;
	private Categoria categoria;
	private Unidade unidade;
	
	// Constructor
	public Produto(int id, String nome, float precoVenda, int qtde_estoque, Categoria categoria, Unidade unidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.qtde_estoque = qtde_estoque;
		this.categoria = categoria;
		this.unidade = unidade;
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
	
	public float getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public int getQtde_estoque() {
		return qtde_estoque;
	}
	
	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Unidade getUnidade() {
		return unidade;
	}
	
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
