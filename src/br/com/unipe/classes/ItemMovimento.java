package br.com.unipe.classes;

public class ItemMovimento {
	
	// Attributes
	private int quantidade;
	private float preco;
	private Produto produto;
	
	// Constructor
	public ItemMovimento(int quantidade, float preco, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}
	
	// Getters and Setters
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
