package com.rick.sistema;

/**
 * Classe responsável pela lógica dos telefones.
 *  
 * <font size="3" color="blue">
 * 	<ul> Funções
 * 		<li> CRIA UM NOVO TELEFONE </li>
 * 		<li> toString() </li>
 * 	</ul>
 * @author Rich Elton - 117210710
 * </font>
 */
public class Telefone {

	/**
	 * Atributo que representa o DDD do telefone.
	 */
	private String ddd;
	/**
	 * Atributo que representa o número do telefone.
	 */
	private String numero;
	/**
	 * Atributo que representa o código do país do telefone.
	 */
	private String codigoPais;
	/**
	 * Atributo que representa o tipo do meu telefone(CASA, TRABALHO OU CELULAR).
	 */
	private String tipo;
	
	/**
	 * Construtor do telefone.
	 * 
	 * @param ddd do telefone
	 * @param numero Numero de telefone do contato.
	 * @param cod Código do país
	 * @param tipo Valor do nivel da amizade(CASA, TRABALHO OU CELULAR).
	 */
	public Telefone(String ddd, String numero, String codigoPais, String tipo) {
		if (numero.trim().equals("")) {
			throw new NullPointerException("Número vazio!\n");
		} else if (codigoPais.trim().equals("")) {
			throw new NullPointerException("Código do país vazio!\n");
		} else if (ddd.trim().equals("")) {
			throw new NullPointerException("DDD vazio!\n");
		} else if (tipo.trim().equals("")) {
			throw new NullPointerException("Tipo vazio!\n");
		} else if (!(tipo.equals("CASA") || tipo.equals("TRABALHO") || tipo.equals("CELULAR"))){
			throw new IllegalArgumentException("Tipo inválido!\n");
		}
		this.ddd = ddd;
		this.numero = numero;
		this.codigoPais = codigoPais;
		this.tipo = tipo;
	}
	
	/**
	 * Altera o tipo do meu telefone.
	 * 
	 * @param tipo CASA, TRABALHO OU CELULAR.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna o tipo do meu telefone.
	 * 
	 * @return Tipo do telefone.
	 */
	public String getTipo() {
		return this.tipo;
	}
	
	/**
	 * Representação em texto do telefone.
	 * @return Ex: "55 (83) 99841-3386, Tipo: CASA"
	 */
	@Override
	public String toString() {
		return this.codigoPais + " (" + this.ddd + ") " + this.numero + ", Tipo: " + this.getTipo();
	}
}