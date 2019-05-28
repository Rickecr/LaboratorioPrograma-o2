package com.rick.controllers;

import java.util.*;

import com.rick.comparator.CenarioOrdenadoApostas;
import com.rick.comparator.CenarioOrdenadoNome;
import com.rick.models.Cenario;
import com.rick.models.CenarioBonus;

/**
 * Classe responsavel por controlar a classe Cenario.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtor</li>
 * <li>cadastrarCenario</li>
 * <li>cadastrarAposta</li>
 * <li>alterarSeguroValor</li>
 * <li>alterarSeguroTaxa</li>
 * <li>alterarOrdem</li>
 * <li>exibirCenarioOrdenado</li>
 * <li>exibirCenarios</li>
 * <li>exibirCenario</li>
 * <li>valorTotalDeApostas</li>
 * <li>totalDeApostas</li>
 * <li>exibirApostas</li>
 * <li>fecharAposta</li>
 * <li>getCaixaCenario</li>
 * <li>getTotalRateioCenario</li>
 * <li>getCaixa</li>
 * <li>ordenaPorNome</li>
 * <li>ordenaPorCadastro</li>
 * <li>ordenaPorApostas</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class CenarioController {

	/**
	 * Atributo que representa os cenarios cadastrados no meu sistema(S�o
	 * diferenciados com um ID).
	 */
	private Map<Integer, Cenario> cenarios;
	/**
	 * Atributo que representa a taxa do meu sistema e n�o pode ser alterado.
	 */
	private final double taxa;
	/**
	 * Atributo que representa a caixa do meu sistema.
	 */
	private int caixa;
	/**
	 * Atributo que representa o ID de um determinado cenario cadastrado.
	 */
	private int idCenario;
	/**
	 * Atributo que representa os cenarios ordenados como o usuario desejar.
	 */
	private List<Cenario> cenariosOrdenados;

	/**
	 * Construtor do CenarioController.
	 * 
	 * @param caixa
	 *            Valor do caixa inicial.
	 * @param taxa
	 *            Taxa do sistema.
	 */
	public CenarioController(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.cenarios = new TreeMap<>();
		this.cenariosOrdenados = new ArrayList<>();
		this.idCenario = 1;
		this.caixa = caixa;
		this.taxa = taxa;
	}

	/**
	 * Metodo que ira cadastrar um cenario no sistema.
	 * 
	 * @param descricao
	 *            Descricao do cenario.
	 * @return O ID do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		this.cenarios.put(this.idCenario, new Cenario(descricao));
		return this.idCenario++;
	}

	/**
	 * Método que cadastrar um cenario bonus.
	 * 
	 * @param descricao
	 *            Descrição do cenario.
	 * @param bonus
	 *            Bonus para o cenario.
	 * @return Posicao do cenario.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		Cenario c = new CenarioBonus(descricao, bonus);
		this.caixa -= bonus;
		this.cenarios.put(this.idCenario, c);
		return this.idCenario++;
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
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			this.cenarios.get(cenario).cadastrarAposta(apostador, valor, previsao);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
	}

	/**
	 * Método que cadastra uma aposta com seguro por Taxa.
	 * 
	 * @param cenario
	 *            Posição do cenario.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao para a aposta.
	 * @param taxa
	 *            Taxa para o seguro.
	 * @param custo
	 *            Custo do seguro.
	 * @return Posicao da aposta.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		this.caixa += custo;
		return cenarios.get(cenario).cadastrarAposta(apostador, valor, previsao, taxa);
	}

	/**
	 * Método que cadastrar uma aposta com seguro por valor.
	 * 
	 * @param cenario
	 *            Posicao do cenario.
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao para a aposta.
	 * @param valorAssegurado
	 *            Valor do seguro.
	 * @param custo
	 *            Custo do seguro.
	 * @return Posicao da aposta.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,
			int valorAssegurado, int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		this.caixa += custo;
		return cenarios.get(cenario).cadastrarAposta(apostador, valor, previsao, valorAssegurado);
	}

	/**
	 * Método que altera o sgeuro de uma aposta para valor.
	 * 
	 * @param cenario
	 *            Posicao do cenario.
	 * @param apostaAssegurada
	 *            Posicao da aposta.
	 * @param valor
	 *            Valor do seguro.
	 * @return Posicao da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return cenarios.get(cenario).alterarSeguroValor(apostaAssegurada, valor);
	}

	/**
	 * Método que altera o sgeuro de uma aposta para taxa.
	 * 
	 * @param cenario
	 *            Posicao do cenario.
	 * @param apostaAssegurada
	 *            Posicao da aposta.
	 * @param taxa
	 *            Taxa do seguro
	 * @return Posicao da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return cenarios.get(cenario).alterarSeguroTaxa(apostaAssegurada, taxa);
	}
	
	/**
	 * Método que altera o tipo de ordenação dos cenarios.
	 * 
	 * @param ordem Por "nome", "apostas" ou "cadastro".
	 */
	public void alterarOrdem(String ordem) {
		if (ordem.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		switch (ordem.toLowerCase()) {
			case "nome":
				this.ordenaPorNome();
				break;
			case "apostas":
				this.ordenaPorApostas();
				break;
			case "cadastro":
				this.ordenarPorCadastro();
				break;
			default:
				throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
	
	/**
	 * Método que exibe o cenario ordenado.
	 * 
	 * @param cenario Posicao do cenario na ordem.
	 * 
	 * @return toString do cenario desejado.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		if (this.cenariosOrdenados.size() == 0) {
			return cenario + " - " + this.cenarios.get(cenario).toString();
		}
		if (!this.cenarios.containsKey(cenario)) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		return this.retornaIndice(cenario) + " - " + this.cenariosOrdenados.get(cenario-1).toString();
	}

	/**
	 * Metodo que ira exibir os cenarios cadastrados no meu sistema.
	 * 
	 * @return String
	 */
	public String exibirCenarios() {
		String res = "";
		for (int id : this.cenarios.keySet()) {
			res += id + " - " + this.cenarios.get(id).toString();
		}
		return res;
	}

	/**
	 * Metodo que ira exibir um cenario especificado pelo seu ID.
	 * 
	 * @param id
	 *            ID do cenario.
	 * @return String
	 */
	public String exibirCenario(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (this.cenarios.containsKey(id)) {
			return id + " - " + this.cenarios.get(id).toString();
		} else {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
	}

	/**
	 * Metodo que ira retorna o valor das apostas de um determinado cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return int
	 */
	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			return this.cenarios.get(cenario).valorTotalDeApostas();
		} else {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
	}

	/**
	 * Metodo que ira retorna o total de apostas feitas no cenario especifico.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return int
	 */
	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			return this.cenarios.get(cenario).totalDeApostas();
		} else {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
	}

	/**
	 * Metodo que ira exibir todas as apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @return String
	 */
	public String exibirApostas(int cenario) {
		if (this.cenarios.containsKey(cenario))
			return this.cenarios.get(cenario).exibirApostas();
		else
			return "Cenario nao existe\n";
	}

	/**
	 * Metodo que ira fechar a um cenario.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @param ocorreu
	 *            Se ocorreu ou n�o.
	 */
	public void fecharCenario(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			if (this.cenarios.get(cenario).getFinalizado()) {
				throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
			}
			this.cenarios.get(cenario).fecharCenario(ocorreu);
			int valor = this.cenarios.get(cenario).getCaixaCenario();
			int valorParaSerAddCaixa = (int) Math.floor(valor * this.taxa);
			this.caixa += valorParaSerAddCaixa;
			this.caixa -= this.cenarios.get(cenario).getSeguro();
		} else {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
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
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			if (!this.cenarios.get(cenario).getFinalizado()) {
				throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
			}
			int valor = this.cenarios.get(cenario).getCaixaCenario();
			int valorParaSerAddCaixa = (int) Math.floor(valor * this.taxa);
			return valorParaSerAddCaixa;
		} else {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
	}

	/**
	 * Metodo que ira retornar o valor a ser distribuido aos vencedores da aposta.
	 * 
	 * @param cenario
	 *            ID do cenario.
	 * @param valor
	 * @return
	 */
	public int getTotalRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (this.cenarios.containsKey(cenario)) {
			if (!this.cenarios.get(cenario).getFinalizado()) {
				throw new IllegalArgumentException(
						"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
			}
			int valor = this.getCaixaCenario(cenario);
			return this.cenarios.get(cenario).getTotalRateioCenario(valor);
		} else {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
	}
	

	/**
	 * Metodo que ira retornar o total do caixa.
	 * 
	 * @return Valor do caixa.
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Método que retorna o indice do cenario sem ser no ordenado.
	 * 
	 * @param cenario Posicao do cenario desejado.
	 *
	 * @return int(indice)
	 */
	private int retornaIndice(int cenario) {
		for (int i : this.cenarios.keySet()) {
			if (this.cenarios.get(i).toString().equals(this.cenariosOrdenados.get(cenario-1).toString())) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Método que ordena os cenarios por cadastro.
	 */
	private void ordenarPorCadastro() {
		this.cenariosOrdenados = new ArrayList<>();
		for(Cenario c : this.cenarios.values()) {
			this.cenariosOrdenados.add(c);
		}
	}
	
	/**
	 * Método que ordena os cenarios por nome.
	 */
	private void ordenaPorNome() {
		List<Cenario> cenariosLista = new ArrayList<>(this.cenarios.values());
		Collections.sort(cenariosLista, new CenarioOrdenadoNome());
		this.cenariosOrdenados = cenariosLista;
	}
	
	/**
	 * Método que ordena os cenarios por apostas.
	 */
	private void ordenaPorApostas() {
		List<Cenario> cenariosLista = new ArrayList<>(this.cenarios.values());
		Collections.sort(cenariosLista, new CenarioOrdenadoApostas());
		this.cenariosOrdenados = cenariosLista;
	}
}