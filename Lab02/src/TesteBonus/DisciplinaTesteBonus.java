package TesteBonus;

import coisa.Disciplina;

/**
 * Verifica o funcionamento da classe Disciplina com os bônus.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class DisciplinaTesteBonus {
	
	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {
		
		System.out.println("Bônus da Disciplina!");
		int[] p = {1, 3, 1, 2, 3};
        Disciplina prog1 = new Disciplina("prog1", 5, p);
        prog1.cadastraNota(1, 5);
        prog1.cadastraNota(2, 6);
        prog1.cadastraNota(3, 7);
        prog1.cadastraNota(4, 8);
        prog1.cadastraNota(5, 9);
        System.out.println(prog1.aprovado());
        System.out.println(prog1.toString());
        System.out.println("----------");
	}
}
