package coisa;

/**
 * Classe responsável pela parte da saúde do aluno que possui um estado
 * mental e um estado fisico.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUNÇÕES
 *     <li> DEFINE SAÚDE MENTAL</li>
 *     <li> DEFINE SAÚDE FISICA</li>
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
	 * Atributo para representar emoji padrão do aluno.
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
	 * MÃ©todo para mudar a saúde mental do aluno.
	 * 
	 * @param valor : "boa" ou "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.emojin = emojinPadrao;
		this.estadoMental = valor;
	}
	
	/**
	 * MÃ©todo para muda a saúde fisica do aluno.
	 * 
	 * @param valor : "boa" ou "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.emojin = emojinPadrao;
		this.estadoFisico = valor;
	}
	
	/**
	 * MÃ©todo para definir um emoji.
	 * 
	 * @param valor : Para ser o emoji que representa o aluno.
	 */
	public void definirEmojin(String valor) {
		this.emojin = valor;
	}
	
	/**
	 * MÃ©todo para imprimir o status da saúde do aluno.
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