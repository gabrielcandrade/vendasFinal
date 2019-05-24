package br.com.unipe.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		cadastrarCategoria();
	}
	
	public static void cadastrarCategoria() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o id da categoria: ");
		int id = Integer.parseInt(leitor.nextLine());
		System.out.println("Digite o nome da categoria: ");
		String nome = leitor.nextLine();


		Categoria categoria = new Categoria(id, nome);
		
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File("Categoria.txt"));
			arquivo.write(categoria.getId() + "-");
			arquivo.write(categoria.getNome() + "\n");
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		leitor.close();
		
	}
	
	public void cadastrarProduto(Produto produto) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o nome do produto: ");
		produto.setNome(leitor.nextLine());
		System.out.println("Digite o preco de venda: ");
		produto.setPrecoVenda(Float.parseFloat(leitor.nextLine()));
		System.out.println("Digite sua quantidade no estoque: ");
		produto.setQtde_estoque(Integer.parseInt(leitor.nextLine()));
		System.out.println("Dada as categorias: ");
		produto.setCategoria(produto.getCategoria(Integer.parseInt(leitor.nextLine())));
		
		leitor.close();
	}

}


//try{
//		String nome;
//		nome = JOptionPane.showInputDialog(null,"Entre com o nome do arquivo");
//		BufferedReader br = new BufferedReader(new FileReader(nome));
//		while(br.ready()){
//		String linha = br.readLine();
//		System.out.println(linha);
//		}
//		br.close();
//		}catch(IOException ioe){
//		ioe.printStackTrace();
//		}