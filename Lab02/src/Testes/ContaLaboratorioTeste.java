package Testes;

import coisa.ContaLaboratorio;

/**
 * Verifica o funcionamento da classe ContaLaboratorio.
 * 
 * @author Rick Elton - 117210710
 *
 */
public class ContaLaboratorioTeste {

	/**
	 * Função principal da classe.
	 * 
	 * @param args : Não é utilizada.
	 */
	public static void main(String[] args) {

		ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");
        contaLCC2.consomeEspaco(1999);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.consomeEspaco(2);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        System.out.println(contaLCC2.toString());
        System.out.println("----------");
	}
}
