package com.rick.models;

/**
 * Classe responsavel por guardar a logica de um apostador.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtores(3 tipos)</li>
 * <li>alterarSeguroValor</li>
 * <li>alterarSeguroTaxa</li>
 * <li>getPrevisao</li>
 * <li>getValor</li>
 * <li>getSeguro</li>
 * <li>toString</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class Aposta {

	/**
	 * Atributo que representa o nome de um apostador.
	 */
	private String nome;
	/**
	 * Atributo que representa o valor que um apostado vai apostar.
	 */
	private int valor;
	/**
	 * Atributo que representa o que o apostador acha que vai ocorrer.
	 */
	private String previsao;

	/**
	 * Atributo que representa o tipo de seguro que a aposta possui.
	 */
	private Seguro seguro;

	/**
	 * Construtor de um aposta sem seguro.
	 * 
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsao da aposta("VAI ACONTECER" ou "N VAI ACONTECER")
	 */
	public Aposta(String nome, int valor, String previsao) {
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Previsao invalida!\n");
		}
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SemSeguro();
	}

	/**
	 * Construtor de um aposta com seguro de valor.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsao da aposta
	 * @param valorAssegurado
	 *            Valor do seguro
	 */
	public Aposta(String nome, int valor, String previsao, int valorAssegurado) {
		if (nome == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Previsao invalida!\n");
		}
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SeguroValor(valorAssegurado);
	}

	/**
	 * Construtor de um aposta com seguro taxa.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsao para a aposta.
	 * @param taxa
	 *            Taxa do seguro.
	 */
	public Aposta(String nome, int valor, String previsao, double taxa) {
		if (nome == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Previsao invalida!\n");
		}
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SeguroTaxa(valor, taxa);
	}

	/**
	 * Método altera o tipo do seguro de taxa para valor.
	 * 
	 * @param valorAssegurado
	 *            Valor do seguro.
	 */
	public void alterarSeguroValor(int valorAssegurado) {
		this.seguro = new SeguroValor(valorAssegurado);
	}

	/**
	 * Método altera o tipo do seguro de valor para taxa.
	 * 
	 * @param taxa
	 *            Taxa do seguro.
	 */
	public void alterarSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(this.valor, taxa);
	}

	/**
	 * Metodo que retorna a previs�o do apostador.
	 * 
	 * @return "VAI ACONTECER" ou "N VAI ACONTECER".
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Metodo que retorna o valor da aposta.
	 * 
	 * @return Valor da aposta.
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Método que retorna o valor do meu seguro.
	 * 
	 * @return
	 */
	public int getSeguro() {
		return seguro.getValor();
	}

	/**
	 * Metodo que retorna uma representacao textual do meu apostador.
	 */
	@Override
	public String toString() {
		return this.nome + " - R$" + this.valor + " - " + this.previsao + seguro.toString();
	}
}