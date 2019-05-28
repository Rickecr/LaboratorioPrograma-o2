package TesteBonus;

import coisa.Saude;

/**
 * Verifica o funcionamento da classe Saude com os b�nus.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class SaudeTesteBonus {

	/**
	 * Fun��o principal da classe.
	 * 
	 * @param args : N�o � utilizada.
	 */
	public static void main(String[] args) {
		
		System.out.println("B�nus da Sa�de!");
        Saude saudeBonus = new Saude();
        saudeBonus.definirEmojin(":(");
        System.out.println(saudeBonus.getStatusGeral());
        saudeBonus.defineSaudeFisica("fraca");
        saudeBonus.defineSaudeMental("fraca");
        System.out.println(saudeBonus.getStatusGeral());
        System.out.println("----------");
	}
}
