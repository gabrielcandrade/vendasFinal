package br.com.unipe.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		cadastrarCategoria();
//		listarCategoria();
//		alterarCategoria();
//		cadastrarUnidade();
//		cadastrarProduto();
//		listarProdutos();
		autenticacao();
	}
	
// Categories functions
	public static void cadastrarCategoria() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o nome da categoria: ");
		String nomeCategoria = leitor.nextLine();
		
		try {
			File f = new File("Categoria.txt");
			if (f.exists()){
				int idCategoria = 0;
				BufferedReader reader = new BufferedReader(new FileReader("Categoria.txt"));
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] corte = linha.split("-");
					
					for (int i = 0; i < corte.length; i++) {
						if (i % 2 == 0) {
							idCategoria = Integer.parseInt(corte[i]);
						}
					}
				}
				reader.close();
				Categoria categoria = new Categoria(idCategoria+1, nomeCategoria);
				BufferedWriter writer = new BufferedWriter(new FileWriter("Categoria.txt", true));
				writer.write(categoria.getId() + "-");
				writer.write(categoria.getNome() + "\n");
				writer.close();
			}
			else {
				Categoria categoria = new Categoria(1, nomeCategoria);
				FileWriter arquivo = new FileWriter(f);
				arquivo.write(categoria.getId() + "-");
				arquivo.write(categoria.getNome() + "\n");
				arquivo.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		leitor.close();
	}
	
	public static void alterarCategoria() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Qual o id da categoria que voce deseja modificar: ");
		int idCategoria = Integer.parseInt(leitor.nextLine());
		
		System.out.print("Digite o novo nome da Categoria: ");
		String novoNomeCategoria = leitor.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Categoria.txt"));
			Categoria categoriaAlterada;
			
			ArrayList<String> listaDeIds = new ArrayList<String>();
			ArrayList<String> listaDeCategorias = new ArrayList<String>();
			
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				
				for (int i = 0; i < corte.length; i++) {
					if (i % 2 == 0) {
						listaDeIds.add(corte[i]);
						if (idCategoria == Integer.parseInt(corte[i])) {
							listaDeCategorias.add(novoNomeCategoria);
						}
					}
					else {
						if (idCategoria != Integer.parseInt(corte[i-1])) {
							listaDeCategorias.add(corte[i]);
						}
					}
				}
			}
			reader.close();
			
			File file = new File("Categoria.txt");
			file.delete();
			
			int n = listaDeIds.size();
			
			for (int i = 0; i < n; i++) {
				categoriaAlterada = new Categoria(Integer.parseInt(listaDeIds.get(i)), listaDeCategorias.get(i));
				BufferedWriter writer = new BufferedWriter(new FileWriter("Categoria.txt", true));
				writer.write(categoriaAlterada.getId() + "-");
				writer.write(categoriaAlterada.getNome() + "\n");
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		leitor.close();
	}

	public static void listarCategoria() {
		System.out.print("=== Todas as categorias serao listadas ===\n\n");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Categoria.txt"));
			while(reader.ready()) {
				String linha = reader.readLine();
				System.out.println(linha);
		}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// Unity functions
	public static void cadastrarUnidade() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o nome da unidade: ");
		String nomeUnidade = leitor.nextLine();
		
		try {
			File f = new File("Unidade.txt");
			if (f.exists()){
				int idUnidade = 0;
				BufferedReader reader = new BufferedReader(new FileReader("Unidade.txt"));
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] corte = linha.split("-");
					
					for (int i = 0; i < corte.length; i++) {
						if (i % 2 == 0) {
							idUnidade = Integer.parseInt(corte[i]);
						}
					}
				}
				reader.close();
				Unidade unidade = new Unidade(idUnidade+1, nomeUnidade);
				BufferedWriter writer = new BufferedWriter(new FileWriter("Unidade.txt", true));
				writer.write(unidade.getId() + "-");
				writer.write(unidade.getNome() + "\n");
				writer.close();
			}
			else {
				Unidade unidade = new Unidade(1, nomeUnidade);
				FileWriter arquivo = new FileWriter(f);
				arquivo.write(unidade.getId() + "-");
				arquivo.write(unidade.getNome() + "\n");
				arquivo.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		leitor.close();
	}
	
// Products functions
	public static void cadastrarProduto() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = leitor.nextLine();
		
		System.out.print("Digite o preco de venda: ");
		float precoVendaProduto = Float.parseFloat(leitor.nextLine());
		
		System.out.print("Digite a quantidade do estoque: ");
		int qntDeEstoqueProduto = Integer.parseInt(leitor.nextLine());
		
		try {			
			BufferedReader showerCategoria = new BufferedReader(new FileReader("Categoria.txt"));
			while(showerCategoria.ready()) {
				String linha = showerCategoria.readLine();
				System.out.println(linha);
			}
			showerCategoria.close();
			
			System.out.print("Selecione a categoria do produto: ");
			int idCategoria = Integer.parseInt(leitor.nextLine());
			String nomeCategoria = "Default";
			
			BufferedReader readerCategoria = new BufferedReader(new FileReader("Categoria.txt"));
			while(readerCategoria.ready()) {
				String linha = readerCategoria.readLine();
				String[] corteCategoria = linha.split("-");
				
				for (int i = 0; i < corteCategoria.length; i++) {
					if (i % 2 == 0) {
						if (Integer.parseInt(corteCategoria[i]) == idCategoria) {
							idCategoria = Integer.parseInt(corteCategoria[i]);
							nomeCategoria = corteCategoria[i+1];
						}
					}
				}
			}
			
			Categoria categoria = new Categoria(idCategoria, nomeCategoria);
			readerCategoria.close();
			
			BufferedReader showerUnidade = new BufferedReader(new FileReader("Unidade.txt"));
			while(showerUnidade.ready()) {
				String linha = showerUnidade.readLine();
				System.out.println(linha);
			}
			showerUnidade.close();
			
			System.out.print("Selecione a unidade do produto: ");
			int idUnidade = Integer.parseInt(leitor.nextLine());
			String nomeUnidade = "Default";
			
			BufferedReader readerUnidade = new BufferedReader(new FileReader("Unidade.txt"));
			while(readerUnidade.ready()) {
				String linha = readerUnidade.readLine();
				String[] corteUnidade = linha.split("-");
				
				for (int i = 0; i < corteUnidade.length; i++) {
					if (i % 2 == 0) {
						if (Integer.parseInt(corteUnidade[i]) == idUnidade) {
							idUnidade = Integer.parseInt(corteUnidade[i]);
							nomeUnidade = corteUnidade[i+1];
						}
					}
				}
			}
			
			Unidade unidade = new Unidade(idUnidade, nomeUnidade);
			readerUnidade.close();
			
			File f = new File("Produto.txt");
			if (f.exists()){
				int idProduto = 0;
				BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] corte = linha.split("-");
					
					for (int i = 0; i < corte.length; i++) {
						if (i % 6 == 0) {
							idProduto = Integer.parseInt(corte[i]);
						}
					}
				}
				reader.close();
				Produto produto = new Produto(idProduto+1, nomeProduto, precoVendaProduto, 
						qntDeEstoqueProduto, categoria, unidade);
				BufferedWriter writer = new BufferedWriter(new FileWriter("Produto.txt", true));
				writer.write(produto.getId() + "-");
				writer.write(produto.getNome() + "-");
				writer.write(produto.getPrecoVenda() + "-");
				writer.write(produto.getQtde_estoque() + "-");
				writer.write(produto.getCategoria().getNome() + "-");
				writer.write(produto.getUnidade().getNome() + "\n");
				writer.close();
			}
			else {
				Produto produto = new Produto(1, nomeProduto, precoVendaProduto, 
						qntDeEstoqueProduto, categoria, unidade);
				FileWriter arquivo = new FileWriter(f);
				arquivo.write(produto.getId() + "-");
				arquivo.write(produto.getNome() + "-");
				arquivo.write(produto.getPrecoVenda() + "-");
				arquivo.write(produto.getQtde_estoque() + "-");
				arquivo.write(produto.getCategoria().getNome() + "-");
				arquivo.write(produto.getUnidade().getNome() + "\n");
				arquivo.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		leitor.close();
	}
	
	public static void listarProdutos() {
		System.out.print("=== Todas os produtos serao listados ===\n\n");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
			while(reader.ready()) {
				String linha = reader.readLine();
				System.out.println(linha);
		}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alterarProduto() {
		
	}
	
// Users functions
	public static void autenticacao() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite seu login: ");
		String login = leitor.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = leitor.nextLine();
		
		try {
			File f = new File("Usuario.txt");
			if (f.exists()){
				BufferedReader reader = new BufferedReader(new FileReader("Usuario.txt"));
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] corteUsuario = linha.split("-");
					
					for (int i = 0; i < corteUsuario.length; i++) {
						if (i % 2 == 0 && login == corteUsuario[i] && senha == corteUsuario[i+1]) {
							System.out.println("Sucess");
						}
						else {
							System.out.println("Usuario nao encontrado! Acesso negado!");
							System.out.println("Verifique os valores inseridos");
						}
					}
				}
				reader.close();
			}
			else {
				System.out.println("Usuario.txt nao existe com os usuarios cadastrados!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		leitor.close();
	}
	
	public static void cadastrarUsuario() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite seu login: ");
		String login = leitor.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = leitor.nextLine();
		System.out.print("Digite sua matricula: ");
		String matricula = leitor.nextLine();
		System.out.print("Digite seu nome: ");
		String nome = leitor.nextLine();
		
		leitor.close();
	}
}