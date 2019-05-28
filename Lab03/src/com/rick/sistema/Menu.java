package com.rick.sistema;

import java.util.Scanner;

/**
 * Classe principal do meu sistema de agenda de contatos.
 * 
 * <font size="3" color="blue" >
 * <ul> Funções
 * 	<li> CADASTRAR CONTATO </li>
 * 	<li> CADASTRAR TELEFONES EM UM CONTATO </LI>
 * 	<li> LISTAR CONTATOS </li>
 *  <li> EXIBIR CONTATOS(POR POSIÇÃO, NOMES OU NIVEL) OU EXIBIR MÉDIA DAS AMIZADES </li>
 * </ul>
 * @author Rich Elton - 117210710
 * </font>
 */
public class Menu {
	
	/*
	 * Dois atributos estáticos.
	 * sc : Leitura das entradas.
	 * agenda : Instância da minha classe Agenda.
	 */
	private static Scanner sc = new Scanner(System.in);
	private static Agenda agenda = new Agenda();
	
	/**
	 * Função principal do meu projeto.
	 * 
	 * @param args Não é utilizada.
	 */
	public static void main(String[] args) {
		// O laço de execução do meu programa.
		boolean sair = false;
		while(!sair) {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(A)dicionar telefone em um contato");
			System.out.println("(S)air\n");
			System.out.print("Opção> ");
			char opcao = sc.nextLine().charAt(0);
			switch (opcao) {
				 // Cadastra um contato na agenda.
				case 'C':
					boolean contaV = cadastrarNaAgenda();
					if (contaV) { 
						System.out.println("CADASTRO REALIZADO!\n");
					}
					break;
				// Cadastra um novo telefone em um determinado contato.
				case 'A':
					cadastraTelefoneContato();
					System.out.println();
					break;
				// Lista os contatos da agenda.
				case 'L':
					System.out.println(agenda.exibirContatos());
					break;
				// Exibi informações de um determinado contato.
				case 'E':
					exibicaoDosContatos();
					break;
				// Sai do programa.
				case 'S':
					sair = true;
					break;
				default:
					System.out.println("OPÇÃO INVALIDA!\n");
			}
		}
	}
	
	/**
	 * Função que exibi o menu da Exibição de Contatos.
	 */
	private static void exibicaoDosContatos() {
		System.out.println("TIPO DE EXIBIÇÃO");
		System.out.println("1 - Pelo contato");
		System.out.println("2 - Pelo nome");
		System.out.println("3 - Pelo nível de amizade");
		System.out.println("4 - Media de amizade na agenda");
		System.out.println("5 - Total de contato com o determinado nível de amizade");
		System.out.print("Opção> ");
		char opcao = sc.nextLine().charAt(0);
		if (opcao == '1') {
			System.out.print("Posição> ");
			int pos = Integer.parseInt(sc .nextLine());
			try {
				System.out.println("\n" + agenda.detalhesContato(pos));
			} catch (NullPointerException msg) {
				System.out.println(msg.getMessage());
			}
		} else if (opcao == '2') {
			System.out.print("Nome> ");
			String nome = sc.nextLine();
			String res = agenda.procuraContatosPeloNome(nome);
			if (res.equals("")) {
				System.out.println("Sem contatos com esse nome.");
			} else {
				System.out.println(res);
			}
		} else if (opcao == '3') {
			System.out.print("Nível> ");
			int nivel = Integer.parseInt(sc.nextLine());
			if (nivel < 1 || nivel > 5) {
				System.out.println("Nível inválido!\n");
			} else {
			    System.out.println(agenda.procuraContatosPeloNivel(nivel));
			}
		} else	if (opcao == '4') {
			System.out.println("Média: " + agenda.mediaAmizade());
		} else if (opcao == '5') {
			try {
				System.out.print("Nível de amizade(1 a 5)> ");
				int nivel = Integer.parseInt(sc.nextLine());
				System.out.println("Total de contatos com nível de amizade: " + nivel + " é: "+ agenda.quantContatosNivel(nivel));
			} catch (IllegalArgumentException msg){
				System.out.print(msg.getMessage());
			}
		} else {
			System.out.println("Opção inválida!\n");
		}
	}

	/**
	 * Função que é responsável pela lógica de cadastrar um telefone
	 * em um contato.
	 */
	private static void cadastraTelefoneContato() {
		System.out.print("---- Telefone ----\n");
		System.out.print("Posição do contato que vai ser adicionado o telefone: ");
		int pos = Integer.parseInt(sc.nextLine());
		
		System.out.print("Codigo do país: ");
		String codPais = sc.nextLine();
		
		System.out.print("DDD: ");
		String ddd = sc.nextLine();
		
		System.out.print("numero: ");
		String numero = sc.nextLine();
		
		System.out.print("Tipo(CASA, TRABALHO OU CELULAR): ");
		String tipo = sc.nextLine();
		try {
			agenda.cadastrarTelefoneContato(pos, codPais, ddd, numero, tipo);
			System.out.print("Telefone cadastrado com sucesso!\n");
		} catch (IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
		} catch (NullPointerException msg) {
			System.out.print(msg.getMessage());
		} catch (ArrayIndexOutOfBoundsException msg) {
			System.out.print("Limites de telefones por contatos excedida.\n");
		}
	}

	/**
	 * Função responsável pela lógica de cadastrar um contato
	 * na agenda, usando os métodos da classe Agenda.
	 * 
	 * @return Se foi ou não cadastrado com sucesso.
	 */
	private static boolean cadastrarNaAgenda() {
		System.out.print("Posição: ");
		int pos = Integer.parseInt(sc.nextLine());
		if(pos < 1 || pos > 100) {
			System.out.println("Posição inválida!\n");
			return false;
		}
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine();
		
		System.out.print("Nivel de amizade: ('1-distante, 2-colega,3-amigo,4-amigão,5-irmão) ");
		int nivel = Integer.parseInt(sc.nextLine());
		
		System.out.print("---- Telefone ----\n");
		System.out.print("Codigo do país: ");
		String codPais = sc.nextLine();
		
		System.out.print("DDD: ");
		String ddd = sc.nextLine();
		
		System.out.print("numero: ");
		String numero = sc.nextLine();
		
		System.out.print("Tipo(CASA, TRABALHO OU CELULAR): ");
		String tipo = sc.nextLine();
		try {
			return agenda.cadastrarContato(nome, sobrenome, codPais, ddd, numero, tipo, nivel, pos);
		} catch (IllegalArgumentException msg) {
			System.out.println(msg.getMessage());
		} catch (NullPointerException msg) {
			System.out.println(msg.getMessage());
		} catch (RuntimeException msg) {
			System.out.println(msg.getMessage());
		}
		return false;
	}
}