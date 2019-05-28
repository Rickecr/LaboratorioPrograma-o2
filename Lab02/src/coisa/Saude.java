package coisa;

/**
 * Classe respons�vel pela parte da sa�de do aluno que possui um estado
 * mental e um estado fisico.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUN��ES
 *     <li> DEFINE SA�DE MENTAL</li>
 *     <li> DEFINE SA�DE FISICA</li>
 *     <li> IMPRIME OS DETALHES DESSE ALUNO</li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 */
public class Saude {
	
	/**
	 * Atributo para representar o estado mental do aluno.
	 */
	private String estadoMental;
	
	/**
	 * Atributo para representar o estado fisico do aluno.
	 */
	private String estadoFisico;
	
	/**
	 * Atributo para representar emoji padr�o do aluno.
	 */
	private String emojinPadrao;
	
	/**
	 * Atributo para representar o eemoji definido pelo aluno.
	 */
	private String emojin;
	
	/**
	 * CONSTRUTOR.
	 * Estado fisico e mental definidos com "boa" e emojinPadrao com "".
	 */
	public Saude() {
		this.estadoFisico = "boa";
		this.estadoMental = "boa";
		this.emojinPadrao = "";
		this.emojin = emojinPadrao;
	}
	
	/**
	 * Método para mudar a sa�de mental do aluno.
	 * 
	 * @param valor : "boa" ou "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.emojin = emojinPadrao;
		this.estadoMental = valor;
	}
	
	/**
	 * Método para muda a sa�de fisica do aluno.
	 * 
	 * @param valor : "boa" ou "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.emojin = emojinPadrao;
		this.estadoFisico = valor;
	}
	
	/**
	 * Método para definir um emoji.
	 * 
	 * @param valor : Para ser o emoji que representa o aluno.
	 */
	public void definirEmojin(String valor) {
		this.emojin = valor;
	}
	
	/**
	 * Método para imprimir o status da sa�de do aluno.
	 * 
	 * @return "boa", "fraca" ou "ok".
	 */
	public String getStatusGeral() {
		if (this.estadoFisico.equals("fraca") && this.estadoMental.equals("fraca")) {
			return "fraca " + this.emojin;
		} else if (this.estadoFisico.equals("boa") && this.estadoMental.equals("boa")) {
			return "boa " + this.emojin;
		}
		return "ok " + this.emojin;
	}
}