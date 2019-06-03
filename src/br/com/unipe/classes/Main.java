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
//		autenticacao();
//		cadastrarUsuario();
//		alterarProduto();
		cadastrarPessoa();
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
		}catch (Exception e) {
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
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Qual o id do produto que voce deseja modificar: ");
		int idProduto = Integer.parseInt(leitor.nextLine());
		
		System.out.print("Digite o novo nome do produto: ");
		String novoNomeProduto = leitor.nextLine();
		
		System.out.print("Digite o novo preco de venda do produto: ");
		float novoPrecoVendaProduto = Float.parseFloat(leitor.nextLine());
		
		System.out.print("Digite a nova quantidade de estoque do produto: ");
		int novaQntDeEstoqueProduto = Integer.parseInt(leitor.nextLine());
		
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
		
		leitor.close();
	}
	
// Users functions
	public static void autenticacao() {
		Scanner leitor = new Scanner(System.in);
		
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
									message = "Sucess";
									break;
								}
							}
						}
					}
				}
				System.out.println(message);
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
		
		leitor.close();
	}

// System functions
    public static void limpaTela(){
    	for (int i = 0; i < 50; ++i) {
    		System.out.println ();
    	}		
    }
    
    public static void menu() {
        while (true){
        	Scanner leitor = new Scanner(System.in);
        	
        	System.out.println(" ___________________________________________");
        	System.out.println("|                                           |");
        	System.out.println("|       Selecione a opcao desejada:         |");
        	System.out.println("|                                           |");
	      	System.out.println("|               1- Produtos                 |");
	      	System.out.println("|               2- Clientes                 |");
	      	System.out.println("|               3- Fornecedores             |");
	      	System.out.println("|               4- Compra (Estoque)         |");
	      	System.out.println("|               5- Venda                    |");
	      	System.out.println("|               6- Relatorios               |");
	      	System.out.println("|                                           |");
	      	System.out.println("|___________________________________________|");
	        System.out.print("    Opcao desejada: ");
	        int opcao = leitor.nextInt();
          
	        switch (opcao) {
	          	case 1:
		          	System.out.println("Voce entrou no menu de produtos. ");
		          	break;
	          	case 2:
		          	System.out.println("Voce entrou no menu de clientes. ");
		          	//CLIENTE (ADD, REMOVE, ALTERA)
		          	break;
	          	case 3:
		          	System.out.println("Voce entrou no menu de fornecedores. ");
		          	//FORNECEDOR (ADD, REMOVE, ALTERA)
		          	break;
	          	case 4:
		          	System.out.println("Voce entrou no menu de compra de estoque. ");
		          	//Abastece estoque
		          	break;
	          	case 5:
		          	System.out.println("Voce entrou no menu de venda. ");
		          	//Efetuar uma venda
		          	//A venda sera feita com o ID do cliente e ID*QTD do produto
		          	break;
	          	case 6:
		          	System.out.println("Voce entrou no menu de relatorios. ");
  				    //•	Gerar relatórios de vendas por intervalos de datas;
				    //•	Visualizar compras anteriores de um dado cliente;
				    //•	Calcular o consumo médio mensal de cada produto;
				    //•	Gerar relatório do que se precisa comprar pra suprir um mês com base no consumo médio mensal, ou seja, mostrar os produtos que estão com quantidade abaixo do consumo médio mensal;
				    //•	Gerar relatório dos fornecedores por produto que ofereceram um dado produto com o menor preço registrado.
				    //•	Gerar relatório de lucro líquido mensal por exercício
	          	default: 
		          	System.out.println("Opcao invalida. ");
		          	break;
	        }
	        leitor.close();
        }
    }  

// Person functions
    public static void cadastrarPessoa() {
    	Scanner leitor = new Scanner(System.in);
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
//    	
//    	Pessoa pessoa = new Pessoa()
    	
    	if (resposta.equalsIgnoreCase("s")) {
    		System.out.println("Qual o seu CNPJ: ");
    		String cnpj = leitor.nextLine();
    		
    		PessoaJuridica fornecedor = new PessoaJuridica(pessoa, cnpj);
    		// Criar arquivo de Fornecedores.
    	}
    	
    	leitor.close();
    }
}