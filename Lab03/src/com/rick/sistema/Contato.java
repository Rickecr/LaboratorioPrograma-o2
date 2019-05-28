package com.rick.sistema;

/**
 * Classe responsável pela lógica dos meus contatos. Todos os meus contatos possuem
 * nome, sobrenome e numero.
 * 
 * <font size="3" color="blue">
 * 	<ul> Funções
 * 		<li> CRIA UM NOVO CONTATO </li>
 * 		<li> toString() </li>
 * 	</ul>
 * @author Rich Elton - 117210710
 * </font>
 */
public class Contato {
	
	/**
	 * Atributo para o nome do contato.
	 */
	private String nome;
	/**
	 * Atributo para o sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Atributo(Array) dos meus telefones desse contato.
	 */
	private Telefone[] telefones = new Telefone[3];
	/**
	 * Atributos para controlar a posição a ser adicionada do meu telefone.
	 */
	private int telefonesAdd = 1;
	/**
	 * Atributo(Array) que guarda os níveis de amizade dos meus contatos.
	 */
	private String[] niveis = {"distante", "colega", "amigo", "amigão", "irmão"};
	/**
	 * Atributo para o nivel de amizade do contato.
	 */
	private int nivel;
	
	/**
	 * Construtor com tratamentos de exceções.
	 * 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param cod Código do país
	 * @param ddd do telefone
	 * @param numero Numero de telefone do contato.
	 * @param tipo Valor do nivel da amizade(CASA, TRABALHO OU CELULAR).
	 * @param nivel Nível de amizade(1 a 5).
	 */
	public Contato(String nome, String sobrenome, String cod, String ddd, 
				   String numero, String tipo, int nivel) {
		if (nome == null || sobrenome == null || cod == null || ddd == null
			|| 	numero == null || tipo == null){
			throw new IllegalArgumentException("Informação inválido!\n");
		}
		if (nome.trim().equals("")) {
			throw new NullPointerException("Nome inválido!\n");
		} else if (sobrenome.trim().equals("")) {
			throw new NullPointerException("Sobrenome inválido!\n");
		} else if (nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException("Nível inválido!\n");
		} else if (this.telefonesAdd > 3) {
			throw new IllegalArgumentException("Limites de telefones por contatos excedida.\n");
		}
		Telefone tel = new Telefone(ddd, numero, cod, tipo);
		this.telefones[0] = tel;
		this.nivel = nivel;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	/**
	 * Método que cadastra um telefone(máximo 3/contato) no contato.
	 * 
	 * @param ddd DDD do telefone.
	 * @param numero Número de telefone.
	 * @param codigoPais Código do país.
	 * @param tipo Tipo do telefone(CASA, TRABALHO OU CELULAR).
	 */
	public void cadastraTelefone(String ddd, String numero, String codigoPais, String tipo) {
		if (this.telefonesAdd > 3) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			Telefone tel = new Telefone(ddd, numero, codigoPais, tipo);
			this.telefones[telefonesAdd] = tel;
			this.telefonesAdd++;
		}
	}
	
	/**
	 * Método que verifica se o objeto é igual ao atual.
	 * 
	 * @param o Objeto a ser comparado.
	 * @return true(iguais) ou false(diferentes)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!o.getClass().equals(this.getClass())) {
			return false;
		}
		Contato outro = (Contato) o;
		if(this.getNome().equals(outro.getNome())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método que faz a ação de imprimir os detalhes desse meu contato.
	 * 
	 * @return Ex: "Rick Ramalho - 83998413386".
	 */
	@Override
	public String toString() {
		String res = this.nome + " " + this.sobrenome + ", nível de amizade: " + this.niveis[this.getNivel()-1] + " - Total de telefone: " + this.telefonesAdd + "\n";
		res += "Telefones: \n";
		for(Telefone tel : this.telefones) {
			if (!(tel == null)) {
				res += "-> " + tel.toString() + "\n";
			}
		}
		return res;
	}
	
	/**
	 * Método que retorna o nome do contato.
	 * 
	 * @return Nome do contato(String).
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método que retorna o nível de amizade do contato.

	 * @return Nível de amizade do contato.
	 */
	public int getNivel() {
		return this.nivel;
	}
	
	/**
	 * Método que retorna o sobrenome do contato.
	 * 
	 * @return Sobrenome do contato(String).
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
}