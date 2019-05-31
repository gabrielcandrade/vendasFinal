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
		cadastrarCategoria();

//		alterarCategoria();
	}
	
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

}


