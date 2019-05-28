package Testes;

import coisa.ContaCantina;

/**
 * Verifica o funcionamento da classe ContaCantina.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class ContaCantinaTeste {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {

        ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");            
        mulherDoBolo.cadastraLanche(2, 500);
        mulherDoBolo.cadastraLanche(1, 500);
        mulherDoBolo.pagaConta(200);
        System.out.println(mulherDoBolo.toString());
        System.out.println("----------");
	}
}
