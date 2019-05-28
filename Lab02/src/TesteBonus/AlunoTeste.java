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
	 * Fun��o principal da classe.
	 * 
	 * @param args : N�o � utilizada.
	 */
	public static void main(String[] args) {
		
		Aluno rick = new Aluno("Rick");
		
		/**
		 * Testando os laborat�rios.
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
		rick.cadastraDisciplina("C�lculo 2");
		rick.cadastraDisciplina("Programa��o 2");
		rick.cadastraHoras("C�lculo 2", 4);
		rick.cadastraHoras("Programa��o 2", 4);
		
		rick.cadastraNota("C�lculo 2", 1, 9);
		rick.cadastraNota("C�lculo 2", 2, 8);
		rick.cadastraNota("C�lculo 2", 3, 8.6);
		rick.cadastraNota("C�lculo 2", 4, 8.2);
		System.out.println(rick.aprovado("C�lculo 2"));
		
		rick.cadastraNota("Programa��o 2", 1, 9);
		rick.cadastraNota("Programa��o 2", 2, 9);
		rick.cadastraNota("Programa��o 2", 3, 8.6);
		rick.cadastraNota("Programa��o 2", 4, 8.2);
		System.out.println(rick.aprovado("Programa��o 2"));
		
		System.out.println(rick.disciplinaToString("C�lculo 2"));
		System.out.println(rick.disciplinaToString("Programa��o 2"));
		
		System.out.println("-------");

		/**
		 * Testando Conta na Cantina.
		 */
		rick.cadastraCantina("Mulher do bolo");
		rick.cadastraCantina("Caf� para programadores");
		
		rick.cadastraLanche("Mulher do bolo", 2, 500);
		rick.cadastraLanche("Caf� para programadores", 50, 500);
		
		rick.pagarConta("Mulher do bolo", 450);
		rick.pagarConta("Caf� para programadores", 400);
		
		System.out.println(rick.cantinaToString("Mulher do bolo"));
		System.out.println(rick.cantinaToString("Caf� para programadores"));
		
		System.out.println("-------");

		/**
		 * Testando a sa�de do aluno.
		 */
		rick.defineSaudeMental("boa");
		rick.defineSaudeFisica("fraca");
		System.out.println(rick.getStatusGeral());
	}
}
