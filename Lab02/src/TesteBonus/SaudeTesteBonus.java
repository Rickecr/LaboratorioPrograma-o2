package TesteBonus;

import coisa.Saude;

/**
 * Verifica o funcionamento da classe Saude com os bônus.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class SaudeTesteBonus {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {
		
		System.out.println("Bônus da Saúde!");
        Saude saudeBonus = new Saude();
        saudeBonus.definirEmojin(":(");
        System.out.println(saudeBonus.getStatusGeral());
        saudeBonus.defineSaudeFisica("fraca");
        saudeBonus.defineSaudeMental("fraca");
        System.out.println(saudeBonus.getStatusGeral());
        System.out.println("----------");
	}
}
