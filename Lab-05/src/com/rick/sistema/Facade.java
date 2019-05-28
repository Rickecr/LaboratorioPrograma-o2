package com.rick.sistema;

import com.rick.controllers.CenarioController;

import easyaccept.EasyAccept;

/**
 * Classe responsavel por fazer o controle entre o sistema(Controles e o Main).
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtor</li>
 * <li>inicializa</li>
 * <li>cadastrarCenario</li>
 * <li>exibirCenarios</li>
 * <li>exibirCenario</li>
 * <li>cadastrarAposta</li>
 * <li>alterarSeguroValor</li>
 * <li>cadastrarApostaSeguraTaxa</li>
 * <li>alterarSeguroTaxa</li>
 * <li>alterarOrdem</li>
 * <li>exibirCenarioOrdenado</li>
 * <li>valorTotalDeApostas</li>
 * <li>totalDeApostas</li>
 * <li>exibirApostas</li>
 * <li>fecharAposta</li>
 * <li>getCaixaCenario</li>
 * <li>getTotalRateioCenario</li>
 * <li>getCaixa</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class Facade {

	/**
	 * Atributo que representa o meu controle dos cenarios.
	 */
	private CenarioController cenarioController;

	/**
	 * Construtor de Facade.
	 */
	public Facade() {
	}

	/**
	 * Método principal que irá fazer os testes de aceitação.
	 * 
	 * @param args
	 *            Será os meus testes.
	 */
	public static void main(String[] args) {
		args = new String[] { "com.rick.sistema.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt", "acceptance_test/us7_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Metodo que inicializa o sistema.
	 * 
	 * @param caixa
	 *            Valor inicial do caixa.
	 * @param taxa
	 *            Taxa do sistema(Imutavel).
	 */
	public void inicializa(int caixa, double taxa) {
		this.cenarioController = new CenarioController(caixa, taxa);
	}

	/**
	 * Metodo que cadastra cenarios.
	 * 
	 * @param descricao
	 *            Descricao do cenario.
	 * @return ID do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		return cenarioController.cadastrarCenario(descricao);
	}

	/**
	 * Método que cadastra um cenario com bonus.
	 * 
	 * @param descricao
	 *            Descrição do cenario.
	 * @param bonus
	 *            Bonus para os vencedores do cenario.
	 * @return Posicao do cenario.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return this.cenarioController.cadastrarCenario(descricao, bonus);
	}

	/**
	 * Metodo que ira cadastrar uma aposta em um cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao da aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.cenarioController.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Método que cadastra uma aposta com seguro por valor em um cenario.
	 * 
	 * @param cenario
	 *            Posicao do cenario.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsa para a aposta.
	 * @param valorAssegurado
	 *            Valor do seguro.
	 * @param custo
	 *            Custo do seguro.
	 * @return Posicao da aposta cadastrada.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,
			int valorAssegurado, int custo) {
		return cenarioController.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado,
				custo);
	}

	/**
	 * /** Método que cadastra uma aposta com seguro por taxa em um cenario.
	 * 
	 * @param cenario
	 *            Posicao do cenario.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsa para a aposta.
	 * @param taxa
	 *            Taxa do seguro.
	 * @param custo
	 *            Custo do seguro.
	 * @return Posicao da aposta cadastrada.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return cenarioController.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	/**
	 * Método que altera o tipo do seguro de uma aposta em um cenario.
	 * 
	 * @param cenario
	 *            Id do cenario.
	 * @param apostaAssegurada
	 *            Posicao da aposta para ser alterada.
	 * @param valor
	 *            Valor do seguro da aposta.
	 * @return Posicao da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return cenarioController.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	/**
	 * Método que altera o tipo do seguro de uma aposta em um cenario.
	 * 
	 * @param cenario
	 *            Id do cenario.
	 * @param apostaAssegurada
	 *            Posicao da aposta para ser alterada.
	 * @param taxa
	 *            Taxa do seguro da aposta.
	 * @return Posicao da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return cenarioController.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}

	/**
	 * Método que altera a ordem para exibição dos cenarios.
	 * 
	 * @param ordem Ordem que desejar ordenar os cenarios.
	 */
	public void alterarOrdem(String ordem) {
		this.cenarioController.alterarOrdem(ordem);
	}
	
	/**
	 * Método que exibe o cenario ordenado.
	 * 
	 * @param cenario Posição do cenario.
	 * 
	 * @return toString do cenario especificado.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		return this.cenarioController.exibirCenarioOrdenado(cenario);
	}
	
	/**
	 * Metodo que ira exibir os cenarios cadastrados.
	 * 
	 * @return String
	 */
	public String exibirCenarios() {
		return cenarioController.exibirCenarios();
	}

	/**
	 * Metodo que ira exibir um cenario especificado pelo seu ID.
	 * 
	 * @param id
	 *            ID do cenario.
	 * @return String
	 */
	public String exibirCenario(int id) {
		return cenarioController.exibirCenario(id);
	}

	/**
	 * Metodo que ira retorna o valor das apostas de um determinado cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return int
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.cenarioController.valorTotalDeApostas(cenario);
	}

	/**
	 * Metodo que ira retorna o total de apostas feitas no cenario especifico.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return int
	 */
	public int totalDeApostas(int cenario) {
		return this.cenarioController.totalDeApostas(cenario);
	}

	/**
	 * Metodo que ira exibir todas as apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return String
	 */
	public String exibirApostas(int cenario) {
		return this.cenarioController.exibirApostas(cenario);
	}

	/**
	 * Metodo que ira fechar a um cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @param ocorreu
	 *            Se ocorreu ou n�o.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarioController.fecharCenario(cenario, ocorreu);
	}

	/**
	 * Metodo que ira retornar o valor a ser adicionado ao caixa(Caso cenario esteja
	 * encerrado).
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return int
	 */
	public int getCaixaCenario(int cenario) {
		return this.cenarioController.getCaixaCenario(cenario);
	}

	/**
	 * Metodo que ira retornar o valor a ser distribuido aos vencedores da aposta.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @param valor
	 * @return Total para ser divido entre os vencedores.
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.cenarioController.getTotalRateioCenario(cenario);
	}

	/**
	 * Metodo que ira retornar o total do caixa.
	 * 
	 * @return Valor do caixa.
	 */
	public int getCaixa() {
		return this.cenarioController.getCaixa();
	}
}