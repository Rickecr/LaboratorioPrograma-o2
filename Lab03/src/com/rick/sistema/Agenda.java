package com.rick.sistema;

/**
 * Classe responsável pela lógica de uma agenda. Possue um array
 * de 100 contatos.
 * 
 * <font size="3" color="blue" >
 * <ul> Funções
 * 	<li> CADASTRAR CONTATO </li>
 * 	<li> EXIBIR CONTATO </li>
 *	<li> LISTAR CONTATOS </li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 *</font>
 */
public class Agenda {

	/**
	 * Array do tipo Contato : Para armazenas todos os objetos(contatos).
	 */
	private Contato[] contatos;
	/**
	 * Construtor
	 * Sem parâmetros.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}

	/**
	 * * Método que faz a ação de adicionar um novo contato no Array de contatos.
	 * 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param cod Código do país do telefone.
	 * @param ddd DDD do telefone.
	 * @param numero Número do telefone.
	 * @param tipo Tipo de Telefone(CASA, TRABALHO OU CELULAR).
	 * @param nivel Nível de amizade.
	 * @param pos Posição para o contato ser adicionado(1 a 100)
	 * @return true ou false.
	 */
	public boolean cadastrarContato(String nome, String sobrenome, String cod, String ddd, 
									String numero, String tipo, int nivel, int pos) {
		if (pos < 1 || pos > 100) {
			throw new IllegalArgumentException("Posição inválida!\n");
		} else {
			Contato c = new Contato(nome, sobrenome, cod, ddd, numero, tipo, nivel);
			contatos[pos-1]= c;
		}
		return true;
	}
	
	/**
	 * Método que cadastrar um telefone em um contato de minha agenda.
	 * 
	 * @param pos Posição do contato na agenda.
	 * @param cod Código do país.
	 * @param ddd DDD do telefone.
	 * @param numero Número do telefone.
	 * @param tipo (CASA, TRABALHO ou CELULAR)
	 * @return true ou false.
	 */
	public boolean cadastrarTelefoneContato(int pos, String cod, String ddd, String numero, String tipo) {
		if (achaContato(pos)) {
			contatos[pos-1].cadastraTelefone(ddd, numero, cod, tipo);
			return true;
		}
		return false;
	}

	/**
	 * Método que faz a ação de imprimir os detalhes de um contato especifico.
	 * 
	 * @param pos Posição do contato.
	 * @return O toString() da Classe Contato.
	 * Ex: "Rick Ramalho - 83998413386"
	 */
	public String detalhesContato(int pos) {
		boolean temContato = achaContato(pos);
		if (temContato) {
			return this.contatos[pos-1].toString();
		} else {
			throw new NullPointerException("Não existe contato nessa posição!\n");
		}
	}
	
	/**
	 * Método que procura os contatos na agenda pelo nome.
	 * 
	 * @param nome Nome dos contatos que desejo procurar.
	 * @return O toString de cada contato com o mesmo nome.
	 */
	public String procuraContatosPeloNome(String nome) {
		String res = "";
		for(Contato contato : this.contatos) {
			if (contato != null) {
				if (contato.getNome().equals(nome)) {
					res += contato.toString();
				}
			}
		}
		return res;
	}
	
	/**
	 * Método que procura contatos na agenda com o mesmo nível de amizade.
	 * 
	 * @param nivel Nível de amizade(1 a 5).
	 * @return ToString de cada contato com o mesmo nível de amizade.
	 */
	public String procuraContatosPeloNivel(int nivel) {
		String res = "";
		for(Contato contato : this.contatos) {
			if (contato != null) {
				if (contato.getNivel() == nivel) {
					res += contato.toString();
				}
			}
		}
		return res;
	}
	
	/**
	 * Método que calcula a média das amizades da minha agenda.
	 * 
	 * @return Float(O valor da média dos contatos existentes).
	 */
	public float mediaAmizade() {
		float media = 0;
		int total = 0;
		for(Contato contato : this.contatos) {
			if (contato != null) {
				total++;
				media += contato.getNivel();
			}
		}
		if (total > 0) {
			return media / total;
		} else {
			throw new NumberFormatException("Sem contatos na agenda.\n");
		}
	}
	
	/**
	 * Método que conta a quantidade de contatos com um determinado nível de amizade.
	 * 
	 * @param nivel Nível de amizade(1 a 5).
	 * @return
	 */
	public int quantContatosNivel(int nivel) {
		if (nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException("Nível de amizade inválido!\n");
		}
		int total = 0;
		for(Contato contato : this.contatos) {
			if (contato.getNivel() == nivel) {
				total++;
			}
		}
		return total;
	}
	
	/**
	 * Método que faz a ação de exibir todos os contatos na minha agenda.
	 * 
	 * @return O toString() de cada contato na minha agenda.
	 * Ex: "1 - Rick Ramalho"
	 */
	public String exibirContatos() {
		String res = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] == null) {
				continue;
			} else {
				res += (i+1) + " - " + this.contatos[i].getNome() + " " + this.contatos[i].getSobrenome() +"\n";
			}
		}
		return res;
	}
	
	/**
	 * Método que faz a busca no array para saber se possui o contato.
	 * 
	 * @param pos Posição que provavelvemente tem o contato.
	 * @return true(Caso o contato esteja no array) ou false(Caso não esteja).
	 */
	private boolean achaContato(int pos) {
		for (int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null) {
				if (this.contatos[pos-1].equals(this.contatos[i])) {
					return true;
				}
			}
		}
		return false;
	}
}