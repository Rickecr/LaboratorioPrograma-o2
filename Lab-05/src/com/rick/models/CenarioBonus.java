package com.rick.models;

/**
 * Classe responsavel por guardar a logica de um cenario bonus que herda de
 * Cenario seus atributos e métodos.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos novos
 * <li>Construtor</li>
 * <li>Sobrescrita do método getTotalRateioCenario</li>
 * <li>Sobrescrita do método toString</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class CenarioBonus extends Cenario {

	/**
	 * Atributo que representa o bônus do meu cenario
	 */
	private int bonus;

	/**
	 * Construtor.
	 * 
	 * @param descricao
	 *            Descrição do cenario.
	 * @param bonus
	 *            Bonus
	 */
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;
	}

	/**
	 * Método que sobrescreve o da classe mãe e soma ao bonus.
	 */
	@Override
	public int getTotalRateioCenario(int valor) {
		return super.getTotalRateioCenario(valor) + this.bonus;
	}

	/**
	 * Sobrescrita do método da classe mãe que retorna a representação textual.
	 */
	@Override
	public String toString() {
		return super.toString() + " - R$ " + String.format("%.2f", (float) this.bonus / 100);
	}
}