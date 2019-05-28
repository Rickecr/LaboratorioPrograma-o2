package com.rick.models;

/**
 * Classe responsavel por guardar a logica do seguro por valor de uma aposta,
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
public class SeguroValor extends Seguro {

	/**
	 * Construtor.
	 * 
	 * @param valor
	 *            Valor da aposta.
	 */
	public SeguroValor(int valorAssegurado) {
		if (valorAssegurado <= 0) {
			throw new IllegalArgumentException("Erro ao cadastrar aposta: Valor ou taxa inválidos.");
		}
		this.valor = valorAssegurado;
	}

	/**
	 * Método sobrescrito do getValor() da classe mae.
	 */
	@Override
	public int getValor() {
		return this.valor;
	}

	/**
	 * Método que retorna a representação textual do seguro.
	 */
	@Override
	public String toString() {
		return " - ASSEGURADA (VALOR) - R$ " + String.format("%.2f", this.valor / 100.0);
	}
}