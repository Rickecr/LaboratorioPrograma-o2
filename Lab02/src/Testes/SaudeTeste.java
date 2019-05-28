package Testes;

import coisa.Saude;

/**
 * Verifica o funcionamento da classe Saude.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class SaudeTeste {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {

        Saude saude = new Saude();
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("boa");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        System.out.println("----------");
	}
}
