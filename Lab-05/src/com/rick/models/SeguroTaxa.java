package com.rick.models;

/**
 * Classe responsavel por guardar a logica do seguro por taxa de uma aposta,
 * herda de Seguro.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtor</li>
 * <li>getValor</li>
 * <li>toString</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class SeguroTaxa extends Seguro {

	/**
	 * Atributo que representa a taxa do meu seguro.
	 */
	private double taxa;

	/**
	 * Construtor.
	 * 
	 * @param valor
	 *            Valor da aposta.
	 * @param taxa
	 *            Taxa de aposta.
	 */
	public SeguroTaxa(int valor, double taxa) {
		if (valor <= 0 || taxa <= 0) {
			throw new IllegalArgumentException("Erro ao cadastrar aposta: Valor ou taxa inválidos.");
		}
		this.valor = valor;
		this.taxa = taxa;
	}

	/**
	 * Método sobrescrito do getValor() da classe mae.
	 */
	@Override
	public int getValor() {
		return (int) (this.valor * this.taxa);
	}

	/**
	 * Método que retorna a representação textual do seguro.
	 */
	@Override
	public String toString() {
		return " - ASSEGURADA (TAXA) - " + (int) (this.taxa * 100) + "%";
	}
}