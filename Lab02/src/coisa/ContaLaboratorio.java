package coisa;

/**
 * Classe responsável por controlar um laboratório. Possue nome, espaço que
 * ocupa e a cota.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUNÇÕES
 *     <li> CONSOME ESPAÇO</li>
 *     <li> LIBERA ESPAÇO</li>
 *     <li> VERIFICA SE ATINGIU COTA</li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 */
public class ContaLaboratorio {
	
	/**
	 * Atributo para o nome do laboratório.
	 */
	private String nomeLab;
	
	/**
	 * Atributo para o espaço ocupado do laboratório.
	 */
	private int espacoOcupado;
	
	/**
	 * Atributo para a cota(limite) do laboratório.
	 */
	private int cota;
	
	/**
	 * Construtor para receber um laboratório com o nome, e com cota
	 * padrão de 2000;
	 * 
	 * @param nomeLaboratorio : Nome do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}
	
	/**
	 * Construtor para receber um laboratório apenas com o nome e um valor
	 * para a cota.
	 * 
	 * @param nomeLaboratorio : Nome do laboratório.
	 * @param cota : Total da cota do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLab = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Método para aumentar o espaço ocupado.
	 * 
	 * @param mbytes : Quantidade de espaço que será ocupado.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * Método para diminuir o espaço ocupado.
	 * 
	 * @param mbytes : Quantidade de espaço que será liberado.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * Método para verificar se a cota foi atingida.
	 * 
	 * @return true ou false.
	 */
	public boolean atingiuCota() {
		if (this.espacoOcupado >= this.cota) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método para pegar o nome do laboratório.
	 * 
	 * @return nome do laboratório.
	 */
	public String getNome() {
		return this.nomeLab;
	}
	
	/**
	 * Método para imprimir os detalhes do laboratório.
	 * 
	 * @return X: "Nome do laboratório: LCC3, Espaço ocupado: 2000, Cota: 3000"
	 */
	public String toString() {
		return "Nome do laboratório: "+ this.nomeLab +", Espaço ocupado: "+ this.espacoOcupado +", Cota: "+ this.cota;
		
	}
}
