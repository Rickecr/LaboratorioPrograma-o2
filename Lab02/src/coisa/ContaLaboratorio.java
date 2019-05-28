package coisa;

/**
 * Classe respons�vel por controlar um laborat�rio. Possue nome, espa�o que
 * ocupa e a cota.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUN��ES
 *     <li> CONSOME ESPA�O</li>
 *     <li> LIBERA ESPA�O</li>
 *     <li> VERIFICA SE ATINGIU COTA</li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 */
public class ContaLaboratorio {
	
	/**
	 * Atributo para o nome do laborat�rio.
	 */
	private String nomeLab;
	
	/**
	 * Atributo para o espa�o ocupado do laborat�rio.
	 */
	private int espacoOcupado;
	
	/**
	 * Atributo para a cota(limite) do laborat�rio.
	 */
	private int cota;
	
	/**
	 * Construtor para receber um laborat�rio com o nome, e com cota
	 * padr�o de 2000;
	 * 
	 * @param nomeLaboratorio : Nome do laborat�rio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}
	
	/**
	 * Construtor para receber um laborat�rio apenas com o nome e um valor
	 * para a cota.
	 * 
	 * @param nomeLaboratorio : Nome do laborat�rio.
	 * @param cota : Total da cota do laborat�rio.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLab = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * M�todo para aumentar o espa�o ocupado.
	 * 
	 * @param mbytes : Quantidade de espa�o que ser� ocupado.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * M�todo para diminuir o espa�o ocupado.
	 * 
	 * @param mbytes : Quantidade de espa�o que ser� liberado.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * M�todo para verificar se a cota foi atingida.
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
	 * M�todo para pegar o nome do laborat�rio.
	 * 
	 * @return nome do laborat�rio.
	 */
	public String getNome() {
		return this.nomeLab;
	}
	
	/**
	 * M�todo para imprimir os detalhes do laborat�rio.
	 * 
	 * @return X: "Nome do laborat�rio: LCC3, Espa�o ocupado: 2000, Cota: 3000"
	 */
	public String toString() {
		return "Nome do laborat�rio: "+ this.nomeLab +", Espa�o ocupado: "+ this.espacoOcupado +", Cota: "+ this.cota;
		
	}
}
