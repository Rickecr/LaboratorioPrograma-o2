package coisa;

import java.util.Arrays;

/**
 * Classe responsável por controlar a conta de uma pessoa na cantina.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUNÇÕES
 * 	   <li> CADASTRAR LANCHE </li>
 *     <li> PAGAR CONTA </li>
 *     <li> RETORNAR OS DADOS </li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 */
public class ContaCantina {
	
	/**
	 * Atributo para o nome da cantina.
	 */
	private String nome;
	
	/**
	 * Atributo para a quantidade de itens na cantina.
	 */
	private int quantItens = 0;
	
	/**
	 * Atributo para o total da conta nessa cantina.
	 */
	private int conta;
	
	/**
	 * Atributo(Array de string) para guardar os 5 primeiros detalhes de lanches.
	 */
	private String[] detalhesLanches;
	
	/**
	 * Variável para contar o total dos lanches que foram cadastrados com detalhes.
	 */
	private int contador;
	
	/**
	 * CONSTRUTOR.
	 * @param nome : Nome da conta na cantina.
	 */
	public ContaCantina(String nome) {
		this.nome = nome;
		this.detalhesLanches = new String[5];
	}
	
	/**
	 * Método para somar o valor da minha conta que devo pagar.
	 * 
	 * @param qtsItens : quantidade de itens que a pessoa comprou.
	 * @param valorCentavos : valor total gasto.
	 */
	public void cadastraLanche(int qtsItens, int valorCentavos) {
		this.quantItens += qtsItens;
		this.conta += valorCentavos;
	}
	
	/**
	 * Método para cadastrar um lanche, mas passando detalhes desse lanche.
	 * 
	 * @param qtsItens : Quantidade de itens que a pessoa comprou.
	 * @param valorCentavos : Valor total gasto.
	 * @param detalhes : Os detalhes do lanche para ser adicionados no Array de detalhes.
	 */
	public void cadastraLanche(int qtsItens, int valorCentavos, String detalhes) {
		this.quantItens += qtsItens;
		this.conta += valorCentavos;
		if (this.contador <= 4) {
			this.detalhesLanches[this.contador] = detalhes;
			this.contador++;
		} else {
			atualizaDetalhes();
			this.detalhesLanches[this.contador-1] = detalhes;
		}
	}
	
	/**
	 * Método para imprimir os detalhes que eu passei ao cadastrar um lanche.
	 * 
	 * @return "["almoço", "estudando P2", "Se aprofundando em java"]"
	 */
	public String listarDetalhes() {
		return Arrays.toString(this.detalhesLanches);
	}
	
	/**
	 * Método que irá decrementar da minha conta o valor que eu pagar.
	 * 
	 * @param valorCentavos : Valor que a pessoa desejar pagar.
	 */
	public void pagaConta(int valorCentavos) {
		this.conta -= valorCentavos;
	}
	
	/**
	 * Método para pegar o nome da minha conta na cantina.
	 * 
	 * @return o nome da conta na cantina.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método para imprimir os dados da conta na cantina.
	 * 
	 * Ex: "Nome: Rich, Itens: 3, Conta: 500"
	 */
	public String toString() {
		return "Nome: " + this.nome + ", Itens: " + this.quantItens + ", Conta: " + this.conta;
	}
	
	/**
	 * Método privado para atualizar os detalhes dos meus 5 últimos lanches.
	 * 
	 */
	private void atualizaDetalhes() {
		String[] copia = new String[5];
		System.arraycopy(this.detalhesLanches, 1, copia, 0, 4);
		detalhesLanches = copia;
	}
}