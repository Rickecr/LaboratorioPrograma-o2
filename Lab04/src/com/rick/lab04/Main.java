package com.rick.lab04;

import java.util.Scanner;

/**
 * Classe principal que se comunica com a classe Sistema.
 * 
 * @author Rich Ramalho - 117210710
 *
 */
public class Main {

	// Objeto que representa o sistema.
	private static Sistema sistema = new Sistema();
	// Objeto que controla as entradas do meu sistema
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Funcao principal.
	 * 
	 * @param args
	 *            Nao eh usado.
	 */
	public static void main(String[] args) {
		mostrarMenu();
		String opcao = sc.nextLine();

		while (!opcao.equals("O")) {
			switch (opcao) {
			case "C":
				cadastrarAluno();
				break;

			case "E":
				System.out.print("Matricula: ");
				String matricula = sc.nextLine();
				System.out.println(sistema.exibirAluno(matricula));
				break;

			case "N":
				cadastrarGrupo();
				break;

			case "A":
				alocarImprimirGrupo();
				break;

			case "R":
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				System.out.println(sistema.registraParticipacao(matricula));
				break;

			case "I":
				System.out.println(sistema.imprimirParticapacoes());
				break;
			
			default:
				System.out.println("Opcao invalida!\n");
				break;
			}
			mostrarMenu();
			opcao = sc.nextLine();
		}
	}

	/**
	 * Funcao que mostra o menu das opcoes.
	 */
	private static void mostrarMenu() {
		System.out.println("(C)adastrar um aluno.");
		System.out.println("(E)xibir um aluno.");
		System.out.println("(N)ovo grupo.");
		System.out.println("(A)locar um aluno em um grupo e imprimir grupos.");
		System.out.println("(R)egistrar aluno que respondeu.");
		System.out.println("(I)mprimir alunos que responderam.");
		System.out.println("(O)ra, vamos fechar o programar!\n");
		System.out.print("Opcao> ");
	}

	/**
	 * Funcao que cadastra um aluno.
	 */
	private static void cadastrarAluno() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		try {
			if (sistema.cadastrarAluno(matricula, nome, curso)) {
				System.out.println("CADASTRO REALIZADO!\n");
			} else {
				System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
			}
		} catch (IllegalArgumentException msg) {
			System.out.println(msg.getMessage());
		}
	}

	/**
	 * Funcao que cadastra um grupo.
	 */
	private static void cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nome = sc.nextLine();
		try {
			if (sistema.cadastrarGrupo(nome)) {
				System.out.println("CADASTRO REALIZADO!\n");
			} else {
				System.out.println("GRUPO JÁ CADASTRADO!\n");
			}
		} catch (IllegalArgumentException msg) {
			System.out.println(msg.getMessage());
		}
	}

	/**
	 * Funcao que aloca um aluno ou imprime os detalhes de um grupo.
	 */
	private static void alocarImprimirGrupo() {
		System.out.print("(A)locar aluno ou (I)mprimir grupo? ");
		String op = sc.nextLine();
		if (op.equals("A")) {
			System.out.print("Matricula: ");
			String matricula = sc.nextLine();
			System.out.print("Grupo: ");
			String nome = sc.nextLine();
			System.out.println(sistema.alocarAluno(matricula, nome.toLowerCase()));
		} else if (op.equals("I")) {
			System.out.print("Grupo: ");
			String nome = sc.nextLine();
			System.out.println(sistema.imprimirGrupos(nome));
		}
	}
}