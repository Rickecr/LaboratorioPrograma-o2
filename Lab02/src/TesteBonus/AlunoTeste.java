package TesteBonus;

import coisa.Aluno;

/**
 * Verifica o funcionamento da classe Aluno.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class AlunoTeste {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {
		
		Aluno rick = new Aluno("Rick");
		
		/**
		 * Testando os laboratórios.
		 * 
		 */
		rick.cadastraLaboratorio("LCC3");
		rick.cadastraLaboratorio("LCC2", 4000);
		rick.consomeEspaco("LCC3", 1000);
		rick.consomeEspaco("LCC2", 2000);
		rick.liberaEspaco("LCC3", 500);
		rick.liberaEspaco("LCC2", 1000);
		rick.consomeEspaco("LCC3", 2000);
		System.out.println(rick.atingiuCota("LCC3"));
		System.out.println(rick.laboratorioToString("LCC3"));
		System.out.println(rick.laboratorioToString("LCC2"));
		
		System.out.println("-------");

		/**
		 * Testando as disciplinas.
		 */
		rick.cadastraDisciplina("Cálculo 2");
		rick.cadastraDisciplina("Programação 2");
		rick.cadastraHoras("Cálculo 2", 4);
		rick.cadastraHoras("Programação 2", 4);
		
		rick.cadastraNota("Cálculo 2", 1, 9);
		rick.cadastraNota("Cálculo 2", 2, 8);
		rick.cadastraNota("Cálculo 2", 3, 8.6);
		rick.cadastraNota("Cálculo 2", 4, 8.2);
		System.out.println(rick.aprovado("Cálculo 2"));
		
		rick.cadastraNota("Programação 2", 1, 9);
		rick.cadastraNota("Programação 2", 2, 9);
		rick.cadastraNota("Programação 2", 3, 8.6);
		rick.cadastraNota("Programação 2", 4, 8.2);
		System.out.println(rick.aprovado("Programação 2"));
		
		System.out.println(rick.disciplinaToString("Cálculo 2"));
		System.out.println(rick.disciplinaToString("Programação 2"));
		
		System.out.println("-------");

		/**
		 * Testando Conta na Cantina.
		 */
		rick.cadastraCantina("Mulher do bolo");
		rick.cadastraCantina("Café para programadores");
		
		rick.cadastraLanche("Mulher do bolo", 2, 500);
		rick.cadastraLanche("Café para programadores", 50, 500);
		
		rick.pagarConta("Mulher do bolo", 450);
		rick.pagarConta("Café para programadores", 400);
		
		System.out.println(rick.cantinaToString("Mulher do bolo"));
		System.out.println(rick.cantinaToString("Café para programadores"));
		
		System.out.println("-------");

		/**
		 * Testando a saúde do aluno.
		 */
		rick.defineSaudeMental("boa");
		rick.defineSaudeFisica("fraca");
		System.out.println(rick.getStatusGeral());
	}
}
