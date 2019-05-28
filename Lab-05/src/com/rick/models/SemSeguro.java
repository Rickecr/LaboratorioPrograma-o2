package com.rick.models;

/**
 * Classe responsavel por guardar a logica de Sem Seguro de uma aposta, herda de
 * Seguro.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>getValor</li>
 * <li>toString</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class SemSeguro extends Seguro {

	/**
	 * Método sobrescrito do getValor() da classe mae.
	 */
	@Override
	public int getValor() {
		return 0;
	}

	/**
	 * Método que retorna a representação textual do seguro.
	 */
	@Override
	public String toString() {
		return "";
	}
}