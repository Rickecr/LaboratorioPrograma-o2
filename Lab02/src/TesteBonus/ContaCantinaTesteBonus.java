package TesteBonus;

import coisa.ContaCantina;

/**
 * Verifica o funcionamento da classe ContaCantina com os b�nus.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class ContaCantinaTesteBonus {

	/**
	 * Fun��o principal da classe.
	 * 
	 * @param args : N�o � utilizada.
	 */
	public static void main(String[] args) {
		
		System.out.println("Bonus da Conta Cantina!");
        ContaCantina contaCantinaBonus = new ContaCantina("Bolo");
        contaCantinaBonus.cadastraLanche(2, 500, "Meu bolo");
        contaCantinaBonus.cadastraLanche(2, 500, "Meu caf�");
        contaCantinaBonus.cadastraLanche(2, 500, "Meu suco");
        contaCantinaBonus.cadastraLanche(2, 500, "Meu refrigerante");
        contaCantinaBonus.cadastraLanche(2, 500, "Meu almo�o");
        contaCantinaBonus.cadastraLanche(2, 500, "Minha janta");
        contaCantinaBonus.cadastraLanche(2, 500, "Minha coxinha");
        System.out.println(contaCantinaBonus.listarDetalhes());
        System.out.println("----------");
	}
}
