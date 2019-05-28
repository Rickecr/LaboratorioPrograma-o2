package com.rick.models;

import java.util.*;

/**
 * Classe responsavel por guardar a logica de um cenario.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtor</li>
 * <li>cadastrarAposta(3 tipos)</li>
 * <li>valorTotalDeApostas</li>
 * <li>totalDeApostas</li>
 * <li>exibirApostas</li>
 * <li>fecharCenario</li>
 * <li>getCaixaCenario</li>
 * <li>getTotalRateioCenario</li>
 * <li>alterarSeguroValor</li>
 * <li>alterarSeguroTaxa</li>
 * <li>getCaixa</li>
 * <li>getSeguro</li>
 * <li>getFinalizado</li>
 * <li></li>
 * <li>toString</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class Cenario {

	/**
	 * Atributo que representa a descricao de um cenario.
	 */
	private String descricao;
	/**
	 * Atributo que representa todas as apostas nesse cenario.
	 */
	private ArrayList<Aposta> apostas;
	/**
	 * Atributo que representa o estado do cenario('ocorreu' ou 'n ocorreu').
	 */
	private String status;
	/**
	 * Atributo que representa o total dos valores das apostas feitas.
	 */
	private int totalDasApostas;
	
	/**
	 * Atributo que representa se o cenario foi ou nÃ£o finalizado.
	 */
	private boolean finalizado;

	/**
	 * Construtor da classe.
	 * 
	 * @param descricao
	 *            Descricao do cenario
	 */
	public Cenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Descricao invalida!\n");
		}
		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.apostas = new ArrayList<>();
		this.totalDasApostas = 0;
		this.status = "n ocorreu";
		this.finalizado = false;
	}

	/**
	 * Metodo que vai cadastrar uma aposta no cenario.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Qual a previsao("VAI ACONTECER" ou "N VAI ACONTECER").
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.apostas.add(new Aposta(apostador, valor, previsao));
		this.totalDasApostas += valor;
	}

	/**
	 * Método que cadastra uma aposta com seguro por valor.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao da aposta.
	 * @param valorAssegurado
	 *            Valor do seguro.
	 * @return Posicao da aposta.
	 */
	public int cadastrarAposta(String apostador, int valor, String previsao, int valorAssegurado) {
		apostas.add(new Aposta(apostador, valor, previsao, valorAssegurado));
		return apostas.size();
	}

	/**
	 * Método que cadastra uma aposta com seguro por taxa.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao da aposta.
	 * @param taxa
	 *            Taxa do seguro.
	 * @return Posicao da aposta.
	 */
	public int cadastrarAposta(String apostador, int valor, String previsao, double taxa) {
		apostas.add(new Aposta(apostador, valor, previsao, taxa));
		return apostas.size();
	}

	/**
	 * Metodo que tem a funcao de retornar o valor de todas as apostas feitas.
	 * 
	 * @return O valor de todas as apostas feitas
	 */
	public int valorTotalDeApostas() {
		return this.totalDasApostas;
	}

	/**
	 * Metodo que tem a funcao de retornar o total de apostas realizadas.
	 * 
	 * @return O total de apostas realizadas
	 */
	public int totalDeApostas() {
		return this.apostas.size();
	}

	/**
	 * Metodo que exibe todas as apostas do cenario.
	 * 
	 * @return O toString de todas as apostas desse cenario
	 */
	public String exibirApostas() {
		String res = "";
		for (Aposta aposta : this.apostas) {
			res += aposta.toString();
		}
		return res;
	}

	/**
	 * Metodo que fecha o cenario, atualizando os atributos necessarios.
	 * 
	 * @param ocorreu
	 *            True, caso o cenario aconteceu, ou false, caso contrario
	 */
	public void fecharCenario(boolean ocorreu) {
		this.finalizado = true;
		if (ocorreu) {
			this.status = "ocorreu";
		}
	}

	/**
	 * Metodo que calcular o valor para ser adicionado ao meu caixa.
	 * 
	 * @return O valor para ser adicionado ao meu caixa
	 */
	public int getCaixaCenario() {
		if (this.finalizado) {
			if (this.status.equals("n ocorreu")) {
				int valor = this.perdedoresDaAposta("VAI ACONTECER");
				return valor;
			} else {
				int valor = this.perdedoresDaAposta("N VAI ACONTECER");
				return valor;
			}
		} else {
			return 0;
		}
	}

	/**
	 * Metodo que calcular o valor para ser adicionado a cada vencedor do cenario.
	 * 
	 * @param valor
	 *            Valor que foi adicionado no caixa
	 * @return O valor para ser adicionado a cada vencedor do cenario
	 */
	public int getTotalRateioCenario(int valor) {
		return (int) Math.floor((this.getCaixaCenario() - valor));
	}

	/**
	 * Método que altera o tipo do seguro de uma aposta.
	 * 
	 * @param apostaAssegurada
	 *            Posição da aposta.
	 * @param valor
	 *            Valor para o seguro.
	 * @return posicao da aposta alterada.
	 */
	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		apostas.get(apostaAssegurada - 1).alterarSeguroValor(valor);
		return apostaAssegurada;
	}

	/**
	 * Método que altera o tipo do seguro de uma aposta.
	 * 
	 * @param apostaAssegurada
	 *            Posição da aposta.
	 * @param taxa
	 *            Taxa para o seguro.
	 * @return posicao da aposta alterada.
	 */
	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		apostas.get(apostaAssegurada - 1).alterarSeguroTaxa(taxa);
		return apostaAssegurada;
	}

	/**
	 * Método que retorna a soma de todos os meus seguros das apostas.
	 * 
	 * @return int
	 */
	public int getSeguro() {
		int soma = 0;
		for (Aposta aposta : apostas) {
			soma += aposta.getSeguro();
		}
		return soma;
	}
	
	/**
	 * Método que retorna a descricao do cenario.
	 * 
	 * @return String
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Método que retorna se o cenario foi finalizado ou não.
	 * 
	 * @return boolean
	 */
	public boolean getFinalizado() {
		return this.finalizado;
	}

	/**
	 * Metodo que retorna a representacao textual do meu cenario.
	 * 
	 * @return String
	 */
	public String toString() {
		if (this.finalizado) {
			return this.descricao + " - Finalizado (" + this.status + ")";
		} else {
			return this.descricao + " - Nao finalizado";
		}
	}

	/**
	 * Metodo privado que soma o valor das apostas dos perdedores do cenario.
	 * 
	 * @param resultado
	 *            "VAI ACONTECER" ou "N VAI ACONTECER"
	 * @return A soma o valor das apostas dos perdedores do cenario
	 */
	private int perdedoresDaAposta(String resultado) {
		int total = 0;
		for (Aposta aposta : this.apostas) {
			if (aposta.getPrevisao().equals(resultado)) {
				total += aposta.getValor();
			}
		}
		return total;
	}
}