package Testes;

import coisa.Disciplina;

/**
 * Verifica o funcionamento da classe Disciplina.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class DisciplinaTeste {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {
		
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());
        System.out.println("----------");
	}
}
