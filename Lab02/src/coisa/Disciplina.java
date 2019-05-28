package coisa;

import java.util.Arrays;

/**
 * Classe respons�vel pelas disciplinas, que possue nome, notas, horas e
 * m�dia.
 * 
 * <font size="2.5" color="blue" >
 * <ul> FUN��ES
 *     <li> CADASTRAR HORAS</li>
 *     <li> CADASTRAR NOTA</li>
 *     <li> VERIFICA SE FOI APROVADO</li>
 *     <li> IMPRIME OS DETALHES</li>
 * <ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 */
public class Disciplina {
	
	/**
	 * Atributo para o nome da disciplina.
	 */
	private String nome;
	
	/**
	 * Array para representar as notas da disciplina.
	 */
	private double[] notas;
	
	/**
	 * Array para representar os pesos das notas.
	 */
	private int[] pesos;
	
	/**
	 * Vari�vel respons�vel por verificar se a disciplina possue pesos nas notas.
	 */
	private boolean temPesos = false;
	
	/**
	 * Atributo que representa o total de horas da disciplina.
	 */
	private int horas;
	
	/**
	 * Atributo que representa a m�dia na disciplina.
	 */
	private double media;
	
	/**
	 * Construtor que recebe apenas o nome da disciplina e com total de notas = 4.
	 * 
	 * @param nome : Nome da disciplina.
	 */
	public Disciplina(String nome) {
		this(nome, 4);
	}
	
	/**
	 * Construtor que recebe o nome da disciplina e a quantidade de notas da disciplina.
	 * E que tamb�m cria o array de pesos.
	 * 
	 * @param nome : Nome da disciplina.
	 * @param quantNotas : Quantidade de notas.
	 */
	public Disciplina(String nome, int quantNotas) {
		this.nome = nome;
		this.notas = new double[quantNotas];
		this.pesos = new int[quantNotas];
	}
	
	/**
	 * Construtor que recebe nome, quantidade de notas e um array de pesos da disciplina.
	 * 
	 * @param nome : Nome da disciplina.
	 * @param quantNotas : Quantidade de notas.
	 * @param pesos1 : Array para representar os pesos das notas.
	 */
	public Disciplina(String nome, int quantNotas, int[] pesos1) {
		this.nome = nome;
		this.notas = new double[quantNotas];
		this.pesos = new int[quantNotas];
		System.arraycopy(pesos1, 0, this.pesos, 0, quantNotas);
		this.temPesos = true;
	}
	
	/**
	 * M�todo para cadastrar o total de horas da disciplina.
	 * 
	 * @param horas : Total de horas da disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	
	/**
	 * M�todo para cadastrar uma nota.
	 * 
	 * @param nota : Posi��o da nota.
	 * @param valorNota : Valor da nota(0 a 10).
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * M�todo para verificar a aprova��o na disciplina.
	 * 
	 * @return true ou false.
	 */
	public boolean aprovado() {
		this.calculaMedia();
		if (this.media >= 7.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo para pegar o nome da disciplina.
	 * 
	 * @return nome da disciplina.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * M�todo para imprimir os detalhes da disciplina.
	 * 
	 * @return EX: "Nome da disciplina: C�lculo 2, horas: 4, m�dia: 8.45, notas: [9.0, 8.6, 8, 8.2]"
	 */
	public String toString() {
		return "Nome da disciplina: "+ this.nome + ", horas: " + this.horas + ", m�dia: " + this.media + ", notas: "+ Arrays.toString(this.notas);
	}
	
	/**
	 * M�todo para calcular a m�dia.
	 */
	private void calculaMedia() {
		int somaPesos = 0;
		if(this.temPesos) {
			for (int i = 0; i < this.notas.length; i++) {
				this.media += this.notas[i] * this.pesos[i];
				somaPesos += pesos[i];
			}
			this.media /= somaPesos;
		} else {
			this.media = (this.notas[0] + this.notas[1] + this.notas[2] + this.notas[3]) / 4.0;
		}
	}
}