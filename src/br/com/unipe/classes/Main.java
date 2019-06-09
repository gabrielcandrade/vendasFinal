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

	static Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) {

		autenticacao();
		
		leitor.close();
   }
	
// System functions
    public static void limpaTela(){
    	for (int i = 0; i < 50; ++i) {
    		System.out.println ();
    	}		
    }
    
    public static void menu() {
        	System.out.println(" ___________________________________________");
        	System.out.println("|                                           |");
        	System.out.println("|       Selecione a opcao desejada:         |");
        	System.out.println("|                                           |");
	      	System.out.println("|           1- Produtos                     |");
	      	System.out.println("|           2- Pessoa                       |");
	      	System.out.println("|           3- Movimento                    |");
	      	System.out.println("|           4- Relatorio do cliente         |");
	      	System.out.println("|                                           |");
	      	System.out.println("|           0- Sair do sistema!             |");
	      	System.out.println("|                                           |");
	      	System.out.println("|___________________________________________|");
	        System.out.print("    Opcao desejada: ");
	        String validacao = leitor.nextLine();
	        int opcao = 9;
	        try{
	        	opcao = Integer.parseInt(validacao);
	        }catch(Exception e){
	        	limpaTela();
	        	System.out.println("\n\t\tValor invalido!");
	        	menu();
	        }
	        while(true) {
	        	switch (opcao) {
	        	case 0:
	        		endGame();
	        		break;
	          	case 1:
		          	limpaTela();
		          	menuProdutos();
		          	break;
	          	case 2:
		          	limpaTela();
		          	menuPessoa();
		          	break;
	          	case 3:
		          	limpaTela();
		          	efetuarMovimento();
		          	break;
	          	case 4:
		          	limpaTela();
		          	gerarRelatorioPorCliente();
		          	break;
	          	default:
	          		limpaTela();
		          	System.out.println("\n\t\tOpcao invalida. ");
		          	menu();
		          	break;
	        	}
	        }
        }

    public static void menuProdutos() {
    	System.out.println(" ___________________________________________");
		System.out.println("|                                           |");
		System.out.println("|      Bem vindo ao meno de Produtos        |");
		System.out.println("|                                           |");
		System.out.println("|       Selecione a opcao desejada:         |");
		System.out.println("|                                           |");
		System.out.println("|             1- Adicionar Produto          |");
		System.out.println("|             2- Listar Produto             |");
		System.out.println("|             3- Alterar Produto            |");
		System.out.println("|                                           |");
		System.out.println("|             4- Adicionar Categoria        |");
		System.out.println("|             5- Listar Categoria           |");
		System.out.println("|             6- Alterar Categoria          |");
		System.out.println("|                                           |");
		System.out.println("|             7- Adicionar Unidade          |");
		System.out.println("|                                           |");
		System.out.println("|             0- Voltar                     |");
		System.out.println("|___________________________________________|");
		System.out.print("  Opcao desejada:");
        String validacao = leitor.nextLine();
        int opcao = 9;
        try{
        	opcao = Integer.parseInt(validacao);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tValor invalido!");
        	menu();
        }
		
		switch (opcao) {
		case 0:
			limpaTela();
			menu();
			break;
		case 1:
			cadastrarProduto();
			menu();
			break;
		case 2:
			listarProdutos();
			menu();
			break;
		case 3:
			alterarProduto();
			menu();
			break;
		case 4:
			cadastrarCategoria();
			menu();
			break;
		case 5:
			listarCategoria();
			menu();
			break;
		case 6:
			alterarCategoria();
			menu();
			break;
		case 7:
			cadastrarUnidade();
			menu();
			break;
		default:
			System.out.println("Opcao invalida.");
			menuProdutos();
			break;
		}
    }
    
    public static void menuPessoa() {    	
		System.out.println(" ___________________________________________");
		System.out.println("|                                           |");
		System.out.println("|      Bem vindo ao menu de Pessoa          |");
		System.out.println("|                                           |");
		System.out.println("|       Selecione a opcao desejada:         |");
		System.out.println("|                                           |");
		System.out.println("|             1- Adicionar Pessoa           |");
		System.out.println("|                                           |");
		System.out.println("|             2- Listar Clientes            |");
		System.out.println("|             3- Alterar Cliente            |");
		System.out.println("|                                           |");
		System.out.println("|             4- Listar Fornecedor          |");
		System.out.println("|             5- Alterar Fornecedor         |");
		System.out.println("|                                           |");
		System.out.println("|             0- Voltar                     |");
		System.out.println("|___________________________________________|");
		System.out.print("  Opcao desejada:");
        String validacao = leitor.nextLine();
        int opcao = 9;
        try{
        	opcao = Integer.parseInt(validacao);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tValor invalido!");
        	menu();
        }
		
		switch (opcao) {
		case 0:
			limpaTela();
			menu();
			break;
		case 1:
			cadastrarPessoa();
			menu();
			break;
		case 2:
			listarClientes();
			menu();
			break;
		case 3:
			alterarClientes();
			menu();
			break;
		case 4:
			listarFornecedores();
			menu();
			break;
		case 5:
			alterarFornecedores();
			menu();
			break;
		default:
			System.out.println("Opcao invalida.");
			menuPessoa();
			break;
		}
    }
    
// Categories functions
	public static void cadastrarCategoria() {		
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
	}
	
	public static void alterarCategoria() {
		listarCategoria();
		
		System.out.print("Qual o id da categoria que voce deseja modificar: ");
		
        String validacaoIdCategoria = leitor.nextLine();
        int idCategoria = 0;
        try{
        	idCategoria = Integer.parseInt(validacaoIdCategoria);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
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
	}

	// Todo: Melhorar essa listagem
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// Unity functions
	public static void cadastrarUnidade() {		
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
	}
	
// Products functions
	public static void cadastrarProduto() {		
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = leitor.nextLine();
		
		System.out.print("Digite o preco de venda: ");

		String validacaoPrecoVendaProduto = leitor.nextLine();
        float precoVendaProduto = 0;
        try{
        	precoVendaProduto = Float.parseFloat(validacaoPrecoVendaProduto);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
		System.out.print("Digite a quantidade do estoque: ");

		String validacaoQntDeEstoqueProduto = leitor.nextLine();
        int qntDeEstoqueProduto = 0;
        try{
        	qntDeEstoqueProduto = Integer.parseInt(validacaoQntDeEstoqueProduto);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
		try {
			BufferedReader showerCategoria = new BufferedReader(new FileReader("Categoria.txt"));
			while(showerCategoria.ready()) {
				String linha = showerCategoria.readLine();
				System.out.println(linha);
			}
			showerCategoria.close();
			
			System.out.print("Selecione a categoria do produto: ");
			
	        String validacaoIdCategoria = leitor.nextLine();
	        int idCategoria = 0;
	        try{
	        	idCategoria = Integer.parseInt(validacaoIdCategoria);
	        }catch(Exception e){
	        	limpaTela();
	        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
	        	menu();
	        }
			
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
			
	        String validacaoIdUnidade = leitor.nextLine();
	        int idUnidade = 0;
	        try{
	        	idUnidade = Integer.parseInt(validacaoIdUnidade);
	        }catch(Exception e){
	        	limpaTela();
	        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
	        	menu();
	        }

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
	}
	
	// Todo: Melhorar esta listagem;
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
		System.out.print("Qual o id do produto que voce deseja modificar: ");
//		int idProduto = Integer.parseInt(leitor.nextLine());
		
        String validacaoIdProduto = leitor.nextLine();
        int idProduto = 0;
        try{
        	idProduto = Integer.parseInt(validacaoIdProduto);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
		System.out.print("Digite o novo nome do produto: ");
		String novoNomeProduto = leitor.nextLine();
		
		System.out.print("Digite o novo preco de venda do produto: ");
//		float novoPrecoVendaProduto = Float.parseFloat(leitor.nextLine());
		
        String validacaoNovoPrecoVendaProduto = leitor.nextLine();
        float novoPrecoVendaProduto = 0;
        try{
        	novoPrecoVendaProduto = Float.parseFloat(validacaoNovoPrecoVendaProduto);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
		System.out.print("Digite a nova quantidade de estoque do produto: ");
//		int novaQntDeEstoqueProduto = Integer.parseInt(leitor.nextLine());
		
        String validacaoNovaQntDeEstoqueProduto = leitor.nextLine();
        int novaQntDeEstoqueProduto = 0;
        try{
        	novaQntDeEstoqueProduto = Integer.parseInt(validacaoNovaQntDeEstoqueProduto);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tVoce entrou com um valor incoerente! Retorne ao menu!");
        	menu();
        }
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
			Produto produtoAlterado;
			
			ArrayList<String> listaDeIds = new ArrayList<String>();
			ArrayList<String> listaDeNomesDeProduto = new ArrayList<String>();
			ArrayList<Float> listaDePrecoVendaProduto = new ArrayList<Float>();
			ArrayList<Integer> listaDeQntDeEstoqueProduto = new ArrayList<Integer>();
			ArrayList<String> listaDeCategoriaProduto = new ArrayList<String>();
			ArrayList<String> listaDeUnidadeProduto = new ArrayList<String>();
			
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				
				for (int i = 0; i < corte.length; i++) {
					if (i % 5 == 0 && i == 0) {
						listaDeIds.add(corte[i]);
						listaDeCategoriaProduto.add(corte[i+4]);
						listaDeUnidadeProduto.add(corte[i+5]);
						if (idProduto == Integer.parseInt(corte[i])) {
							listaDeNomesDeProduto.add(novoNomeProduto);
							listaDePrecoVendaProduto.add(novoPrecoVendaProduto);
							listaDeQntDeEstoqueProduto.add(novaQntDeEstoqueProduto);
						}
						else {
							listaDeNomesDeProduto.add(corte[i+1]);
							listaDePrecoVendaProduto.add(Float.parseFloat(corte[i+2]));
							listaDeQntDeEstoqueProduto.add(Integer.parseInt(corte[i+3]));
						}
					}
				}
			}
			reader.close();
			
			File file = new File("Produto.txt");
			file.delete();
			
			int n = listaDeIds.size();
			Categoria categoriaAtual = null;
			Unidade unidadeAtual = null;
			for (int i = 0; i < n; i++) {
				try {
					BufferedReader readerCategoria = new BufferedReader(new FileReader("Categoria.txt"));
					while(readerCategoria.ready()) {
						String linha = readerCategoria.readLine();
						String[] corteCategoria = linha.split("-");
						
						for (int j = 0; j < corteCategoria.length; j++) {
							if (j % 2 == 0) {
								if (listaDeCategoriaProduto.get(i).equals(corteCategoria[1])) {
									categoriaAtual = new Categoria(Integer.parseInt(corteCategoria[0]), corteCategoria[1]);
								}
							}
						}
					}
					readerCategoria.close();
				}catch (IOException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
				try {
					BufferedReader readerUnidade = new BufferedReader(new FileReader("Unidade.txt"));
					while(readerUnidade.ready()) {
						String linha = readerUnidade.readLine();
						String[] corteUnidade = linha.split("-");
						
						for (int j = 0; j < corteUnidade.length; j++) {
							if (j % 2 == 0) {
								if (listaDeUnidadeProduto.get(i).equals(corteUnidade[1])) {
									unidadeAtual = new Unidade(Integer.parseInt(corteUnidade[0]), corteUnidade[1]);
								}
							}
						}
					}
					readerUnidade.close();
				}catch (IOException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
				produtoAlterado = new Produto(Integer.parseInt(listaDeIds.get(i)), 
															   listaDeNomesDeProduto.get(i), 
															   listaDePrecoVendaProduto.get(i),
															   listaDeQntDeEstoqueProduto.get(i),
															   categoriaAtual,
															   unidadeAtual);
				BufferedWriter writer = new BufferedWriter(new FileWriter("Produto.txt", true));
				writer.write(produtoAlterado.getId() + "-");
				writer.write(produtoAlterado.getNome() + "-");
				writer.write(produtoAlterado.getPrecoVenda() + "-");
				writer.write(produtoAlterado.getQtde_estoque() + "-");
				writer.write(produtoAlterado.getCategoria().getNome() + "-");
				writer.write(produtoAlterado.getUnidade().getNome() + "\n");
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// Users functions
	// Blindado
	public static void autenticacao() {	
		System.out.println(" ___________________________________________");
	    System.out.println("|                                           |");
	    System.out.println("|                Bem vindo                  |");
	    System.out.println("|                                           |");
	    System.out.println("|    Para continuar, insira seus dados:     |");
	    System.out.println("|                                           |");
	    System.out.println("|___________________________________________|");
	    System.out.print("     Login: ");
	    String login = leitor.nextLine();
	    System.out.print("     Senha: ");
	    String senha = leitor.nextLine();
		
		try {
			File f = new File("Usuario.txt");
			if (f.exists()){
				BufferedReader reader = new BufferedReader(new FileReader("Usuario.txt"));
				String message = "Usuario nao encontrado. Verifique suas credenciais";
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] corteUsuario = linha.split("-");
					
					for (int i = 0; i < corteUsuario.length; i++) {
						if (i % 4 == 0) {
							if (login.equals(corteUsuario[i])) {
								if (senha.equals(corteUsuario[i+1])) {
									System.out.println("Usuario Autenticado.");
									menu();
								}
							}
						}
					}
				}
				System.out.println(message);
				reader.close();
				autenticacao();
			}
			else {
				System.out.println("Usuario.txt nao existe!");
				autenticacao();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cadastrarUsuario() {
		System.out.print("Digite seu login: ");
		String login = leitor.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = leitor.nextLine();
		System.out.print("Digite sua matricula: ");
		String matricula = leitor.nextLine();
		System.out.print("Digite seu nome: ");
		String nome = leitor.nextLine();
		
		try {
			BufferedWriter creater = new BufferedWriter(new FileWriter("Usuario.txt", true));
			creater.close();
			File f = new File("Usuario.txt");
			if (f.exists()){
				Usuario usuario = new Usuario(login, senha, matricula, nome);
				BufferedWriter writer = new BufferedWriter(new FileWriter("Usuario.txt", true));
				writer.write(usuario.getLogin() + "-");
				writer.write(usuario.getSenha() + "-");
				writer.write(usuario.getMatricula() + "-");
				writer.write(usuario.getNome() + "\n");
				writer.close();
			}				
			else {
				System.out.println("Arquivo Usuario.txt nao existe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Person functions
    public static void cadastrarPessoa() {
    	Pessoa pessoa = null;
    	
    	System.out.println("=== Dados Pessoais ===\n\n");
    	System.out.print("Digite o seu nome: ");
    	String nomePessoa = leitor.nextLine();
    	
    	System.out.print("Digite o seu email: ");
    	String emailPessoa = leitor.nextLine();
    	
    	System.out.print("Digite o seu telefone:");
    	String telefonePessoa = leitor.nextLine();
    	
    	System.out.print("Digite o seu celular: ");
    	String celularPessoa = leitor.nextLine();
    	
    	System.out.println("\n=== Dados Residenciais ===\n\n");
    	System.out.print("Rua: ");
    	String ruaEndereco = leitor.nextLine();
    	
    	System.out.print("CEP: ");
    	String cepEndereco = leitor.nextLine();
    	
    	System.out.print("Bairro: ");
    	String bairroEndereco = leitor.nextLine();
    	
    	System.out.print("Numero: ");
    	String numeroEndereco = leitor.nextLine();
    	
    	System.out.print("Complemento: ");
    	String complementoEndereco = leitor.nextLine();
    	
    	System.out.print("Cidade: ");
    	String cidadeEndereco = leitor.nextLine();
    	
    	System.out.print("Estado: ");
    	String estadoEndereco = leitor.nextLine();
    	
    	System.out.println("Voce eh fornecedor (s/n): ");
    	String resposta = leitor.nextLine();
    	
    	try {
			File f = new File("Pessoa.txt");
			if (f.exists()){
				int idPessoa = 0;
				BufferedReader reader = new BufferedReader(new FileReader("Pessoa.txt"));
				while(reader.ready()) {
					String linha = reader.readLine();
					String[] cortePessoa = linha.split("-");
					
					for (int i = 0; i < cortePessoa.length; i++) {
						if (i % 11 == 0 && i != 0) {
							idPessoa = Integer.parseInt(cortePessoa[i-11]);
						}
					}
				}
				reader.close();
				Endereco endereco = new Endereco (ruaEndereco, cepEndereco, bairroEndereco,
						numeroEndereco, complementoEndereco, cidadeEndereco, estadoEndereco);
				pessoa = new Pessoa(idPessoa+1, nomePessoa, emailPessoa, telefonePessoa, 
						celularPessoa, endereco);
				
				BufferedWriter writer = new BufferedWriter(new FileWriter("Pessoa.txt", true));
				writer.write(pessoa.getId() + "-");
				writer.write(pessoa.getNome() + "-");
				writer.write(pessoa.getEmail() + "-");
				writer.write(pessoa.getTelefone() + "-");
				writer.write(pessoa.getCelular() + "-");
				writer.write(pessoa.getEndereco().getRua() + "-");
				writer.write(pessoa.getEndereco().getCep() + "-");
				writer.write(pessoa.getEndereco().getBairro() + "-");
				writer.write(pessoa.getEndereco().getNumero() + "-");
				writer.write(pessoa.getEndereco().getComplemento() + "-");
				writer.write(pessoa.getEndereco().getCidade() + "-");
				writer.write(pessoa.getEndereco().getEstado() + "\n");
				writer.close();
			}
			else {
				Endereco endereco = new Endereco (ruaEndereco, cepEndereco, bairroEndereco,
						numeroEndereco, complementoEndereco, cidadeEndereco, estadoEndereco);
				pessoa = new Pessoa(1, nomePessoa, emailPessoa, telefonePessoa, 
						celularPessoa, endereco);
				
				BufferedWriter writer = new BufferedWriter(new FileWriter("Pessoa.txt", true));
				writer.write(pessoa.getId() + "-");
				writer.write(pessoa.getNome() + "-");
				writer.write(pessoa.getEmail() + "-");
				writer.write(pessoa.getTelefone() + "-");
				writer.write(pessoa.getCelular() + "-");
				writer.write(pessoa.getEndereco().getRua() + "-");
				writer.write(pessoa.getEndereco().getCep() + "-");
				writer.write(pessoa.getEndereco().getBairro() + "-");
				writer.write(pessoa.getEndereco().getNumero() + "-");
				writer.write(pessoa.getEndereco().getComplemento() + "-");
				writer.write(pessoa.getEndereco().getCidade() + "-");
				writer.write(pessoa.getEndereco().getEstado() + "\n");
				writer.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if (resposta.equalsIgnoreCase("s")) {
    		System.out.println("Qual o seu CNPJ: ");
    		String cnpj = leitor.nextLine();
    		
    		PessoaJuridica fornecedor = new PessoaJuridica(pessoa, cnpj);
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter("Fornecedor.txt", true));
			writer.write(pessoa.getId() + "-");
			writer.write(pessoa.getNome() + "-");
			writer.write(pessoa.getEmail() + "-");
			writer.write(pessoa.getTelefone() + "-");
			writer.write(pessoa.getCelular() + "-");
			writer.write(pessoa.getEndereco().getRua() + "-");
			writer.write(pessoa.getEndereco().getCep() + "-");
			writer.write(pessoa.getEndereco().getBairro() + "-");
			writer.write(pessoa.getEndereco().getNumero() + "-");
			writer.write(pessoa.getEndereco().getComplemento() + "-");
			writer.write(pessoa.getEndereco().getCidade() + "-");
			writer.write(pessoa.getEndereco().getEstado() + "-");
			writer.write(fornecedor.getCnpj() + "\n");
			writer.close();
    	}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

    	}
    	else {
    		System.out.println("Qual o seu CPF: ");
    		String cpf = leitor.nextLine();
    		
    		PessoaFisica cliente = new PessoaFisica(pessoa, cpf);
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter("Cliente.txt", true));
			writer.write(pessoa.getId() + "-");
			writer.write(pessoa.getNome() + "-");
			writer.write(pessoa.getEmail() + "-");
			writer.write(pessoa.getTelefone() + "-");
			writer.write(pessoa.getCelular() + "-");
			writer.write(pessoa.getEndereco().getRua() + "-");
			writer.write(pessoa.getEndereco().getCep() + "-");
			writer.write(pessoa.getEndereco().getBairro() + "-");
			writer.write(pessoa.getEndereco().getNumero() + "-");
			writer.write(pessoa.getEndereco().getComplemento() + "-");
			writer.write(pessoa.getEndereco().getCidade() + "-");
			writer.write(pessoa.getEndereco().getEstado() + "-");
			writer.write(cliente.getCpf() + "\n");
			writer.close();
    	}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
    	}
    }

    public static void listarClientes() {
		System.out.print("=== Todas os clientes serao listados ===\n\n");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
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
    
    public static void listarFornecedores() {
		System.out.print("=== Todas os fornecedores serao listados ===\n\n");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Fornecedor.txt"));
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

    public static void alterarClientes() {
		System.out.print("Qual o id do cliente que voce deseja modificar: ");
		int idCliente = Integer.parseInt(leitor.nextLine());
		
		System.out.print("Digite o novo nome do cliente: ");
		String novoNomeCliente = leitor.nextLine();
		
		System.out.print("Digite o email do cliente: ");
		String novoEmailCliente = leitor.nextLine();
		
		System.out.print("Digite o novo telefone do cliente:");
    	String novoTelefonePessoa = leitor.nextLine();
    	
    	System.out.print("Digite o novo celular do Cliente: ");
    	String novoCelularPessoa = leitor.nextLine();
    	    	
    	System.out.print("Digite a nova rua do cliente: ");
    	String novaRuaEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo CEP do cliente: ");
    	String novoCepEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo bairro do cliente: ");
    	String novoBairroEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo numero do cliente: ");
    	String novoNumeroEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo complemento do cliente: ");
    	String novoComplementoEndereco = leitor.nextLine();
    	
    	System.out.print("Digite a nova cidade do cliente: ");
    	String novaCidadeEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo estado do cliente: ");
    	String novoEstadoEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo CPF do cliente: ");
    	String novoCPFCliente = leitor.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
			
			ArrayList<Integer> listaDeIds = new ArrayList<Integer>();
			ArrayList<String> listaDeNomes = new ArrayList<String>();
			ArrayList<String> listaDeEmails = new ArrayList<String>();
			ArrayList<String> listaDeTelefones = new ArrayList<String>();
			ArrayList<String> listaDeCelulares = new ArrayList<String>();
			ArrayList<String> listaDeRuas = new ArrayList<String>();
			ArrayList<String> listaDeCeps = new ArrayList<String>();
			ArrayList<String> listaDeBairros = new ArrayList<String>();
			ArrayList<String> listaDeNumero = new ArrayList<String>();
			ArrayList<String> listaDeComplementos = new ArrayList<String>();
			ArrayList<String> listaDeCidades = new ArrayList<String>();
			ArrayList<String> listaDeEstados = new ArrayList<String>();
			ArrayList<String> listaDeCpfs = new ArrayList<String>();
			
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				
				for (int i = 0; i < corte.length; i++) {
					if (i % 12 == 0 && i != 0) {
						listaDeIds.add(Integer.parseInt(corte[i-12]));
						if (idCliente == Integer.parseInt(corte[i-12])) {
							listaDeNomes.add(novoNomeCliente);
							listaDeEmails.add(novoEmailCliente);
							listaDeTelefones.add(novoTelefonePessoa);
							listaDeCelulares.add(novoCelularPessoa);
							listaDeRuas.add(novaRuaEndereco);
							listaDeCeps.add(novoCepEndereco);
							listaDeBairros.add(novoBairroEndereco);
							listaDeNumero.add(novoNumeroEndereco);
							listaDeComplementos.add(novoComplementoEndereco);
							listaDeCidades.add(novaCidadeEndereco);
							listaDeEstados.add(novoEstadoEndereco);
							listaDeCpfs.add(novoCPFCliente);
						}
					}
					else {
						if (i % 12 == 0) {
							if (idCliente != Integer.parseInt(corte[i])) {
								listaDeNomes.add(corte[i+1]);
								listaDeEmails.add(corte[i+2]);
								listaDeTelefones.add(corte[i+3]);
								listaDeCelulares.add(corte[i+4]);
								listaDeRuas.add(corte[i+5]);
								listaDeCeps.add(corte[i+6]);
								listaDeBairros.add(corte[i+7]);
								listaDeNumero.add(corte[i+8]);
								listaDeComplementos.add(corte[i+9]);
								listaDeCidades.add(corte[i+10]);
								listaDeEstados.add(corte[i+11]);
								listaDeCpfs.add(corte[i+12]);
							}
						}
						else {
							System.out.println("VAI DAR MERDA");
						}
					}
				}
				System.out.println("ids: " + listaDeIds);
				System.out.println("nomes: " + listaDeNomes);
				System.out.println("emails: " + listaDeEmails);
				System.out.println("telefones: " + listaDeTelefones);
				System.out.println("celulares: " + listaDeCelulares);
				System.out.println("ruas: " + listaDeRuas);
				System.out.println("ceps: " + listaDeCeps);
				System.out.println("bairros: " + listaDeBairros);
				System.out.println("numeros: " + listaDeNumero);
				System.out.println("complementos: " + listaDeComplementos);
				System.out.println("cidades: " + listaDeCidades);
				System.out.println("estados: " + listaDeEstados);
				System.out.println("cpfs: " + listaDeCpfs);
			}
			reader.close();
			
			File file = new File("Cliente.txt");
			file.delete();
			
			int n = listaDeIds.size();
			System.out.println(n);
						
			for (int i = 0; i < n; i++) {
				
				Endereco endereco = new Endereco(listaDeRuas.get(i), listaDeCeps.get(i), listaDeBairros.get(i), listaDeNumero.get(i), listaDeComplementos.get(i), listaDeCidades.get(i), listaDeEstados.get(i));
				
				Pessoa pessoa = new Pessoa(listaDeIds.get(i), listaDeNomes.get(i), listaDeEmails.get(i), listaDeTelefones.get(i), listaDeCelulares.get(i), endereco);
				
				PessoaFisica cliente = new PessoaFisica(pessoa, listaDeCpfs.get(i));
			
				BufferedWriter writer = new BufferedWriter(new FileWriter("Cliente.txt", true));
				writer.write(pessoa.getId() + "-");
				writer.write(pessoa.getNome() + "-");
				writer.write(pessoa.getEmail() + "-");
				writer.write(pessoa.getTelefone() + "-");
				writer.write(pessoa.getCelular() + "-");
				writer.write(pessoa.getEndereco().getRua() + "-");
				writer.write(pessoa.getEndereco().getCep() + "-");
				writer.write(pessoa.getEndereco().getBairro() + "-");
				writer.write(pessoa.getEndereco().getNumero() + "-");
				writer.write(pessoa.getEndereco().getComplemento() + "-");
				writer.write(pessoa.getEndereco().getCidade() + "-");
				writer.write(pessoa.getEndereco().getEstado() + "-");
				writer.write(cliente.getCpf() + "\n");
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void alterarFornecedores() {
		System.out.print("Qual o id do fornecedor que voce deseja modificar: ");
		int idFornecedor = Integer.parseInt(leitor.nextLine());
		
		System.out.print("Digite o novo nome do fornecedor: ");
		String novoNomeFornecedor = leitor.nextLine();
		
		System.out.print("Digite o email do fornecedor: ");
		String novoEmailFornecedor = leitor.nextLine();
		
		System.out.print("Digite o novo telefone do fornecedor:");
    	String novoTelefonePessoa = leitor.nextLine();
    	
    	System.out.print("Digite o novo celular do fornecedor: ");
    	String novoCelularPessoa = leitor.nextLine();
    	    	
    	System.out.print("Digite a nova rua do fornecedor: ");
    	String novaRuaEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo CEP do fornecedor: ");
    	String novoCepEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo bairro do fornecedor: ");
    	String novoBairroEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo numero do fornecedor: ");
    	String novoNumeroEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo complemento do fornecedor: ");
    	String novoComplementoEndereco = leitor.nextLine();
    	
    	System.out.print("Digite a nova cidade do fornecedor: ");
    	String novaCidadeEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo estado do fornecedor: ");
    	String novoEstadoEndereco = leitor.nextLine();
    	
    	System.out.print("Digite o novo CNPJ do fornecedor: ");
    	String novoCNPJFornecedor = leitor.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
			
			ArrayList<Integer> listaDeIds = new ArrayList<Integer>();
			ArrayList<String> listaDeNomes = new ArrayList<String>();
			ArrayList<String> listaDeEmails = new ArrayList<String>();
			ArrayList<String> listaDeTelefones = new ArrayList<String>();
			ArrayList<String> listaDeCelulares = new ArrayList<String>();
			ArrayList<String> listaDeRuas = new ArrayList<String>();
			ArrayList<String> listaDeCeps = new ArrayList<String>();
			ArrayList<String> listaDeBairros = new ArrayList<String>();
			ArrayList<String> listaDeNumero = new ArrayList<String>();
			ArrayList<String> listaDeComplementos = new ArrayList<String>();
			ArrayList<String> listaDeCidades = new ArrayList<String>();
			ArrayList<String> listaDeEstados = new ArrayList<String>();
			ArrayList<String> listaDeCnpjs = new ArrayList<String>();
			
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				
				for (int i = 0; i < corte.length; i++) {
					if (i % 12 == 0 && i != 0) {
						listaDeIds.add(Integer.parseInt(corte[i-12]));
						if (idFornecedor == Integer.parseInt(corte[i-12])) {
							listaDeNomes.add(novoNomeFornecedor);
							listaDeEmails.add(novoEmailFornecedor);
							listaDeTelefones.add(novoTelefonePessoa);
							listaDeCelulares.add(novoCelularPessoa);
							listaDeRuas.add(novaRuaEndereco);
							listaDeCeps.add(novoCepEndereco);
							listaDeBairros.add(novoBairroEndereco);
							listaDeNumero.add(novoNumeroEndereco);
							listaDeComplementos.add(novoComplementoEndereco);
							listaDeCidades.add(novaCidadeEndereco);
							listaDeEstados.add(novoEstadoEndereco);
							listaDeCnpjs.add(novoCNPJFornecedor);
						}
					}
					else {
						if (i % 12 == 0) {
							if (idFornecedor != Integer.parseInt(corte[i])) {
								listaDeNomes.add(corte[i+1]);
								listaDeEmails.add(corte[i+2]);
								listaDeTelefones.add(corte[i+3]);
								listaDeCelulares.add(corte[i+4]);
								listaDeRuas.add(corte[i+5]);
								listaDeCeps.add(corte[i+6]);
								listaDeBairros.add(corte[i+7]);
								listaDeNumero.add(corte[i+8]);
								listaDeComplementos.add(corte[i+9]);
								listaDeCidades.add(corte[i+10]);
								listaDeEstados.add(corte[i+11]);
								listaDeCnpjs.add(corte[i+12]);
							}
						}
						else {
							System.out.println("VAI DAR MERDA");
						}
					}
				}
				System.out.println("ids: " + listaDeIds);
				System.out.println("nomes: " + listaDeNomes);
				System.out.println("emails: " + listaDeEmails);
				System.out.println("telefones: " + listaDeTelefones);
				System.out.println("celulares: " + listaDeCelulares);
				System.out.println("ruas: " + listaDeRuas);
				System.out.println("ceps: " + listaDeCeps);
				System.out.println("bairros: " + listaDeBairros);
				System.out.println("numeros: " + listaDeNumero);
				System.out.println("complementos: " + listaDeComplementos);
				System.out.println("cidades: " + listaDeCidades);
				System.out.println("estados: " + listaDeEstados);
				System.out.println("cnpjs: " + listaDeCnpjs);
			}
			reader.close();
			
			File file = new File("Fornecedor.txt");
			file.delete();
			
			int n = listaDeIds.size();
			System.out.println(n);
						
			for (int i = 0; i < n; i++) {
				
				Endereco endereco = new Endereco(listaDeRuas.get(i), listaDeCeps.get(i), listaDeBairros.get(i), listaDeNumero.get(i), listaDeComplementos.get(i), listaDeCidades.get(i), listaDeEstados.get(i));
				
				Pessoa pessoa = new Pessoa(listaDeIds.get(i), listaDeNomes.get(i), listaDeEmails.get(i), listaDeTelefones.get(i), listaDeCelulares.get(i), endereco);
				
				PessoaJuridica fornecedor = new PessoaJuridica(pessoa, listaDeCnpjs.get(i));
			
				BufferedWriter writer = new BufferedWriter(new FileWriter("Fornecedor.txt", true));
				writer.write(pessoa.getId() + "-");
				writer.write(pessoa.getNome() + "-");
				writer.write(pessoa.getEmail() + "-");
				writer.write(pessoa.getTelefone() + "-");
				writer.write(pessoa.getCelular() + "-");
				writer.write(pessoa.getEndereco().getRua() + "-");
				writer.write(pessoa.getEndereco().getCep() + "-");
				writer.write(pessoa.getEndereco().getBairro() + "-");
				writer.write(pessoa.getEndereco().getNumero() + "-");
				writer.write(pessoa.getEndereco().getComplemento() + "-");
				writer.write(pessoa.getEndereco().getCidade() + "-");
				writer.write(pessoa.getEndereco().getEstado() + "-");
				writer.write((fornecedor.getCnpj()) + "\n");
				writer.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

// Moviments functions    
    public static void efetuarMovimento() {
    	System.out.println("Caso voce nao realize uma compra, sera realizado uma venda. \n");
    	System.out.print("Voce deseja fazer uma compra? (s/n): ");
    	String opcaoCompra = leitor.nextLine();
    	
    	if (opcaoCompra.equalsIgnoreCase("s")) {		
    		System.out.print("Qual a data de hoje: ");
    		String dataMovimento = leitor.nextLine();
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Fornecedor.txt"));
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				System.out.println(linha);
    		}
    			reader.close();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		System.out.println();
    		
    		System.out.print("Selecione qual o fornecedor (ID): ");
    		int idFornecedor = Integer.parseInt(leitor.nextLine());
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				System.out.println(linha);
    		}
    			reader.close();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		System.out.println();
    		
    		System.out.print("Selecione o produto (ID): ");
    		int idProduto = Integer.parseInt(leitor.nextLine());
    		
    		System.out.print("Digite a quantidade de itens importada: ");
    		int quantidadeDeItens = Integer.parseInt(leitor.nextLine());
    		
    		System.out.println("Digite o preco unitario: ");
    		float precoUnitario = Float.parseFloat(leitor.nextLine());
    		
			String nomeFornecedor = null;
			String emailFornecedor = null;
			String telefoneFornecedor = null;
			String celularFornecedor = null;
			String ruaFornecedor = null;
			String cepFornecedor = null;
			String bairroFornecedor = null;
			String numeroFornecedor = null;
			String complementoFornecedor = null;
			String cidadeFornecedor = null;
			String estadoFornecedor = null;
			String cnpjFornecedor = null;
			String nomeProduto = null;
			float precoVendaProduto = 0;
			int qntDeEstoqueProduto = 0;
			String categoriaProduto = null;
			String unidadeProduto = null;
			int idCategoria = 0;
			int idUnidade = 0;
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Fornecedor.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 12 == 0 && i != 0) {
    						if (idFornecedor == Integer.parseInt(corte[i-12])) {
    		    				idFornecedor = Integer.parseInt(corte[i-12]);
    		    				nomeFornecedor = corte[i-11];
    		    				emailFornecedor = corte[i-10];
    		    				telefoneFornecedor = corte[i-9];
    		    				celularFornecedor = corte[i-8];
    		    				ruaFornecedor = corte[i-7];
    		    				cepFornecedor = corte[i-6];
    		    				bairroFornecedor = corte[i-5];
    		    				numeroFornecedor = corte[i-4];
    		    				complementoFornecedor = corte[i-3];
    		    				cidadeFornecedor = corte[i-2];
    		    				estadoFornecedor = corte[i-1];
    		    				cnpjFornecedor = corte[i];
    						}
    					}
    				}
    				
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Pegando produto pelo ID
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 5 == 0 && i != 0) {
    						if (idProduto == Integer.parseInt(corte[i-5])) {
								idProduto = Integer.parseInt(corte[i-5]);
								nomeProduto = corte[i-4];
								precoVendaProduto = Float.parseFloat(corte[i-3]);
								qntDeEstoqueProduto = quantidadeDeItens;
								categoriaProduto = corte[i-1];
								unidadeProduto = corte[i];    							
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Pegando categoria pelo nome
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Categoria.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 2 == 0) {
    						if (categoriaProduto.equals(corte[i+1])) {
    							idCategoria = Integer.parseInt(corte[i]);
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Pegando unidade pelo nome
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Unidade.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 2 == 0) {
    						if (unidadeProduto.equals(corte[i+1])) {
    							idUnidade = Integer.parseInt(corte[i]);
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		Endereco endereco = new Endereco(ruaFornecedor, cepFornecedor, bairroFornecedor, numeroFornecedor, complementoFornecedor, cidadeFornecedor, estadoFornecedor);
    		Pessoa pessoa = new Pessoa(idFornecedor, nomeFornecedor, emailFornecedor, telefoneFornecedor, celularFornecedor, endereco);
    		PessoaJuridica fornecedor = new PessoaJuridica(pessoa, cnpjFornecedor);
    		Categoria categoria = new Categoria(idCategoria, categoriaProduto);
    		Unidade unidade = new Unidade(idUnidade, unidadeProduto);
    		Produto produto = new Produto(idProduto, nomeProduto, precoVendaProduto, qntDeEstoqueProduto, categoria, unidade);
    		ItemMovimento itemMovimento = new ItemMovimento(quantidadeDeItens, precoUnitario, produto);
    		Movimento movimento = null;
    		Compra compra = null;
    		
    		try {
    			File f = new File("Movimento.txt");
    			if (f.exists()){
    				int idMovimento = 0;
    				BufferedReader reader = new BufferedReader(new FileReader("Movimento.txt"));
    				while(reader.ready()) {
    					String linha = reader.readLine();
    					String[] corte = linha.split("-");
    					
    					for (int i = 0; i < corte.length; i++) {
        					if (i % 4 == 0 && i != 0) {
        						idMovimento = Integer.parseInt(corte[i-4]);
        					}
        				}
    				}
    				reader.close();
    				movimento = new Movimento(idMovimento+1, dataMovimento, fornecedor, itemMovimento);
    	    		compra = new Compra(movimento);

    				BufferedWriter writer = new BufferedWriter(new FileWriter("Movimento.txt", true));
    				
    				float total = precoUnitario * quantidadeDeItens;
    				movimento.setTotal(total);
    				
    				writer.write(movimento.getId() + "-");
    				writer.write(movimento.getData() + "-");
    				writer.write(movimento.getTotal() + "-");
    				writer.write(compra.getMovimento().getPessoaJuridica().getPessoa().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writer.close();
    				
    				BufferedWriter writerCompra = new BufferedWriter(new FileWriter("Compra.txt", true));
    				writerCompra.write(compra.getMovimento().getId() + "-");
    				writerCompra.write(compra.getMovimento().getData() + "-");
    				writerCompra.write(compra.getMovimento().getTotal() + "-");
    				writerCompra.write(compra.getMovimento().getPessoaJuridica().getPessoa().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writerCompra.close();
    			}
    			else {
    				movimento = new Movimento(1, dataMovimento, fornecedor, itemMovimento);
    	    		compra = new Compra(movimento);
    				
    				float total = precoUnitario * quantidadeDeItens;
    				movimento.setTotal(total);
    				
    				BufferedWriter writer = new BufferedWriter(new FileWriter("Movimento.txt", true));
    				writer.write(movimento.getId() + "-");
    				writer.write(movimento.getData() + "-");
    				writer.write(movimento.getTotal() + "-");
    				writer.write(compra.getMovimento().getPessoaJuridica().getPessoa().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writer.write(compra.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writer.close();
    				
    				BufferedWriter writerCompra = new BufferedWriter(new FileWriter("Compra.txt", true));
    				writerCompra.write(compra.getMovimento().getId() + "-");
    				writerCompra.write(compra.getMovimento().getData() + "-");
    				writerCompra.write(compra.getMovimento().getTotal() + "-");
    				writerCompra.write(compra.getMovimento().getPessoaJuridica().getPessoa().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writerCompra.write(compra.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writerCompra.close();
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}		
    	}
    	else {
    		try {    			
    			BufferedReader reader = new BufferedReader(new FileReader("Compra.txt"));
				System.out.println("------------------------");

    			while(reader.ready()) {
    				String linha = reader.readLine();
					String[] corte = linha.split("-");
					for (int i = 0; i < corte.length; i++) {
    					if (i % 9 == 0 && i != 0) {
							System.out.println("ID: " + corte[i-5]);
							System.out.println("NOME: " + corte[i-4]);
							System.out.println("PRECO: " + corte[i-3]);
							System.out.println("QNT: " + corte[i-2]);
							System.out.println("CATEGORIA: " + corte[i-1]);
							System.out.println("UNIDADE: " + corte[i]);
							System.out.println("------------------------");
    					}
    				}
    		}
    			reader.close();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		System.out.println();
    		
    		System.out.print("Escolha o item (ID) que voce deseja comprar: ");
    		int idProduto = Integer.parseInt(leitor.nextLine());
    		
    		System.out.print("Qual a data de hoje: ");
    		String dataMovimento = leitor.nextLine();
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
				System.out.println("------------------------");

    			while(reader.ready()) {
    				String linha = reader.readLine();
					String[] corte = linha.split("-");
					for (int i = 0; i < corte.length; i++) {
    					if (i % 12 == 0 && i != 0) {
    						System.out.println("ID: " + corte[i-12]);
    						System.out.println("NOME: " + corte[i-11]);
    						System.out.println("------------------------");
    					}
    				}
    		}
    			reader.close();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		System.out.println();
    		
    		System.out.print("Para qual cliente (ID) voce deseja vender: ");
    		int idCliente = Integer.parseInt(leitor.nextLine());
    		    		

			String nomeCliente = null;
			String emailCliente = null;
			String telefoneCliente = null;
			String celularCliente = null;
			String ruaCliente = null;
			String cepCliente = null;
			String bairroCliente = null;
			String numeroCliente = null;
			String complementoCliente = null;
			String cidadeCliente = null;
			String estadoCliente = null;
			String cpfCliente = null;
			String nomeProduto = null;
			float precoVendaProduto = 0;
			int qntDeEstoqueProduto = 0;
			String categoriaProduto = null;
			String unidadeProduto = null;
			int idCategoria = 0;
			int idUnidade = 0;
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 12 == 0 && i != 0) {
    						if (idCliente == Integer.parseInt(corte[i-12])) {
    							idCliente = Integer.parseInt(corte[i-12]);
    		    				nomeCliente = corte[i-11];
    		    				emailCliente = corte[i-10];
    		    				telefoneCliente = corte[i-9];
    		    				celularCliente = corte[i-8];
    		    				ruaCliente = corte[i-7];
    		    				cepCliente = corte[i-6];
    		    				bairroCliente = corte[i-5];
    		    				numeroCliente = corte[i-4];
    		    				complementoCliente = corte[i-3];
    		    				cidadeCliente = corte[i-2];
    		    				estadoCliente = corte[i-1];
    		    				cpfCliente = corte[i];
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Produto.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 5 == 0 && i != 0) {
    						if (idProduto == Integer.parseInt(corte[i-5])) {
								idProduto = Integer.parseInt(corte[i-5]);
								nomeProduto = corte[i-4];
								precoVendaProduto = Float.parseFloat(corte[i-3]);
								qntDeEstoqueProduto = Integer.parseInt(corte[i-2]);
								categoriaProduto = corte[i-1];
								unidadeProduto = corte[i];    							
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Pegando categoria pelo nome
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Categoria.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 2 == 0) {
    						if (categoriaProduto.equals(corte[i+1])) {
    							idCategoria = Integer.parseInt(corte[i]);
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Pegando unidade pelo nome
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader("Unidade.txt"));
    			
    			while(reader.ready()) {
    				String linha = reader.readLine();
    				String[] corte = linha.split("-");
    				
    				for (int i = 0; i < corte.length; i++) {
    					if (i % 2 == 0) {
    						if (unidadeProduto.equals(corte[i+1])) {
    							idUnidade = Integer.parseInt(corte[i]);
    						}
    					}
    				}
    			}
    			reader.close();    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		Endereco endereco = new Endereco(ruaCliente, cepCliente, bairroCliente, numeroCliente, complementoCliente, cidadeCliente, estadoCliente);
    		Pessoa pessoa = new Pessoa(idCliente, nomeCliente, emailCliente, telefoneCliente, celularCliente, endereco);
    		PessoaFisica cliente = new PessoaFisica(pessoa, cpfCliente);
    		Categoria categoria = new Categoria(idCategoria, categoriaProduto);
    		Unidade unidade = new Unidade(idUnidade, unidadeProduto);
    		Produto produto = new Produto(idProduto, nomeProduto, precoVendaProduto, qntDeEstoqueProduto, categoria, unidade);
    		ItemMovimento itemMovimento = new ItemMovimento(produto.getQtde_estoque(), produto);
    		Movimento movimento = null;
    		Venda venda = null;
    		
    		try {
    			File f = new File("Movimento.txt");
    			if (f.exists()){
    				int idMovimento = 0;
    				BufferedReader reader = new BufferedReader(new FileReader("Movimento.txt"));
    				while(reader.ready()) {
    					String linha = reader.readLine();
    					String[] corte = linha.split("-");
    					
    					for (int i = 0; i < corte.length; i++) {
        					if (i % 4 == 0 && i != 0) {
        						idMovimento = Integer.parseInt(corte[i-4]);
        					}
        				}
    				}
    				reader.close();
    				movimento = new Movimento(idMovimento+1, dataMovimento, cliente, itemMovimento);
    	    		venda = new Venda(movimento);

    				BufferedWriter writer = new BufferedWriter(new FileWriter("Movimento.txt", true));
    				
    				writer.write(movimento.getId() + "-");
    				writer.write(movimento.getData() + "-");
    				writer.write(movimento.getTotal() + "-");
    				writer.write(venda.getMovimento().getPessoaFisica().getPessoa().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writer.close();
    				
    				BufferedWriter writerVenda = new BufferedWriter(new FileWriter("Venda.txt", true));
    				writerVenda.write(venda.getMovimento().getId() + "-");
    				writerVenda.write(venda.getMovimento().getData() + "-");
    				writerVenda.write(venda.getMovimento().getTotal() + "-");
    				writerVenda.write(venda.getMovimento().getPessoaFisica().getPessoa().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writerVenda.close();
    			}
    			else {
    				movimento = new Movimento(1, dataMovimento, cliente, itemMovimento);
    	    		venda = new Venda(movimento);
    				
    				BufferedWriter writer = new BufferedWriter(new FileWriter("Movimento.txt", true));
    				writer.write(movimento.getId() + "-");
    				writer.write(movimento.getData() + "-");
    				writer.write(movimento.getTotal() + "-");
    				writer.write(venda.getMovimento().getPessoaFisica().getPessoa().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writer.write(venda.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writer.close();
    				
    				BufferedWriter writerVenda = new BufferedWriter(new FileWriter("Venda.txt", true));
    				writerVenda.write(venda.getMovimento().getId() + "-");
    				writerVenda.write(venda.getMovimento().getData() + "-");
    				writerVenda.write(venda.getMovimento().getTotal() + "-");
    				writerVenda.write(venda.getMovimento().getPessoaFisica().getPessoa().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getId() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getPrecoVenda() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getQtde_estoque() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getCategoria().getNome() + "-");
    				writerVenda.write(venda.getMovimento().getItemMovimento().getProduto().getUnidade().getNome() + "\n");
    				writerVenda.close();
    			}
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}		
    	}
    }
    
    public static void gerarRelatorioPorCliente() {
    	
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
			System.out.println("------------------------");

			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				for (int i = 0; i < corte.length; i++) {
					if (i % 12 == 0 && i != 0) {
						System.out.println("ID: " + corte[i-12]);
						System.out.println("NOME: " + corte[i-11]);
						System.out.println("------------------------");
					}
				}
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		    	
    	System.out.println("Selecione o cliente (ID) que voce deseja visualizar o relatorio de compras: ");	
        String validacao = leitor.nextLine();
        int idCliente = 0;
        try{
        	idCliente = Integer.parseInt(validacao);
        }catch(Exception e){
        	limpaTela();
        	System.out.println("\n\t\tValor invalido!");
        	menu();
        }
    	
    	String nomeCliente = null;
    	
    	// Pegar nome do cliente pelo ID
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("Cliente.txt"));
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				for (int i = 0; i < corte.length; i++) {
					if (i % 12 == 0 && i != 0) {
						if (idCliente == Integer.parseInt(corte[i-12])) {
							nomeCliente = corte[i-11];
						}
					}
				}
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
    	
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Venda.txt"));
			System.out.println("------------------------");

			System.out.println("Produtos adquiridos pelo cliente: ");
			while(reader.ready()) {
				String linha = reader.readLine();
				String[] corte = linha.split("-");
				
				for (int i = 0; i < corte.length; i++) {
					if (i % 9 == 0 && i != 0) {
						if (nomeCliente.equals(corte[i-6])) {
							System.out.println(" - " + corte[i-4] + "\n");
						}						
					}
				}
				System.out.println("------------------------");
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		menu();
		System.out.println();
    }
    
    public static void endGame() {
    	while(true) {
    	}
    }

}