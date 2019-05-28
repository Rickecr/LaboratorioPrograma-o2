package com.rick.models;

/**
 * Classe abstrata responsavel por guardar a logica que os seguros tem em comum.
 * 
 * <font size="2" color="red" >
 * 
 * @author Rich Ramalho - 117210710 </font>
 * 
 */
public abstract class Seguro {

	/**
	 * Atributo que representa o valor do seguro.
	 */
	protected int valor;

	/**
	 * Método que deve ser implementado nas classes que herdarem desta.
	 * 
	 * @return Valor da aposta.
	 */
	public abstract int getValor();

	/**
	 * Método que retorna a representação textual do objeto.
	 */
	public abstract String toString();
}