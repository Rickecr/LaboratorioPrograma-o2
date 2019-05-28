package coisa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Classe responsável por representar um Aluno no sistema. Possue um ArrayList de
 * Disciplina, ContaLaboratorio e de ContaCantina, e possuem Saude.
 * 
 * <font size="2" color="blue">
 * <ul> FUNÇÕES
 * 		<li> Usar os métodos de Disciplina</li>
 * 		<li> Usar os métodos de Laboratório</li>
 * 		<li> Usar os métodos de Cantina</li>
 * 		<li> Usar os métodos de Saíde</li>
 * </ul>
 * 
 * @author Rich Elton - 117210710
 * </font>
 * 
 */

public class Aluno {
	
	/**
	 * Atributo para o nome do aluno.
	 */
	private String nome;
	
	/**
	 * ArrayList para guardar todas as disciplinas do aluno.
	 */
	private ArrayList<Disciplina> disciplinas;
	
	/**
	 * ArrayList para guardar todas as conta dos laboratórios do aluno.
	 */
	private ArrayList<ContaLaboratorio> laboratorios;
	
	/**
	 * ArrayList para guardar todas as contas das cantinas do aluno.
	 */
	private ArrayList<ContaCantina> contasCantinas;
	
	/**
	 * Objeto responsável pela saúde do aluno.
	 */
	private Saude saude;
	
	/**
	 * Construtor que irá criar o meu objeto aluno, recebendo o nome.
	 * 
	 * @param nome : Nome do aluno.
	 */
	public Aluno(String nome) {
		this.nome = nome;
		this.disciplinas = new ArrayList<>();
		this.laboratorios = new ArrayList<>();
		this.contasCantinas = new ArrayList<>();
		this.saude = new Saude();
	}
	
	/**
	 * Método para cadastrar um laboratório do aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para cadastrar.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio);
		this.laboratorios.add(lab);
	}
	
	/**
	 * Método para cadastrar um laboratório(Com cota) do aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para cadastrar.
	 * @param cota : A cota que o lab. possue.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio, cota);
		this.laboratorios.add(lab);
	}
	
	/**
	 * Método para consumir o espaço de um laboratório de um aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para ser consumido.
	 * @param mbytes : O total de mbytes que será consumido.
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		int indice = achaLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).consomeEspaco(mbytes);
	}
	
	/**
	 * Método para liberar espaço de um laboratório de um aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para ser consumido.
	 * @param mbytes : Total de mbytes para serem liberados.
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		int indice = achaLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).liberaEspaco(mbytes);
	}
	
	/**
	 * Método para verificar se um laboratório atingiu uma cota.
	 * 
	 * @param nomeLaboratorio : Nome do lab. que dejesar verificar.
	 * @return true ou false.
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		int indice = achaLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).atingiuCota();
	}
	
	/**
	 * Método que vai detalhar um laboratório de um aluno.
	 * 
	 * @param nomeLaboratorio : Nome do laboratório que deseja verificar.
	 * @return EX: "Nome do laboratório: LCC3, Espaço ocupado: 2000, Cota: 3000"
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		int indice = achaLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).toString();
	}
	
	/**
	 * Método que vai cadastrar uma disciplina para o aluno.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina disci = new Disciplina(nomeDisciplina);
		this.disciplinas.add(disci);
	}
	
	/**
	 * Método que vai cadastrar o total de horas de uma determinada disciplina
	 * de um aluno.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 * @param horas : Total de horas da disciplina.
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		int indice = achaDisciplina(nomeDisciplina);
		this.disciplinas.get(indice).cadastraHoras(horas);
	}
	
	/**
	 * Método para cadastrar uma nota em uma determinada disciplina.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 * @param nota : Posição da nota.
	 * @param valorNota : Valor da nota obtida.
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int indice = achaDisciplina(nomeDisciplina);
		this.disciplinas.get(indice).cadastraNota(nota, valorNota);
	}
	
	/**
	 * Método para verificar se o aluno foi aporvado ou não em uma disciplina.
	 * 
	 * @param nomeDisciplina : Nome da Disciplina.
	 * @return true ou false.
	 */
	public boolean aprovado(String nomeDisciplina) {
		int indice = achaDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).aprovado();
	}
	
	/**
	 * Método que vai detalhar uma determinada disciplina de um aluno.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 * @return EX: "Nome da disciplina: Cálculo 2, horas: 4, média: 8.45, notas: [9.0, 8.6, 8, 8.2]"
	 */
	public String disciplinaToString(String nomeDisciplina) {
		int indice = achaDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).toString();
	}
	
	/**
	 * Método para cadastrar uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 */
	public void cadastraCantina(String nomeCantina) {
		ContaCantina cc = new ContaCantina(nomeCantina);
		this.contasCantinas.add(cc);
	}
	
	/**
	 * Método para cadastrar um lanche em uma cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 * @param qtdItens : Quantidade de itens para cadastrar.
	 * @param valorCentavos : Valor(em centavos) dos itens.
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		int indice = acharContaCantina(nomeCantina);
		this.contasCantinas.get(indice).cadastraLanche(qtdItens, valorCentavos);
	}
	
	/**
	 * Método para pagar a conta de uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 * @param valorCentavos : Valor(em centavos) que deseja pagar na cantina.
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int indice = acharContaCantina(nomeCantina);
		this.contasCantinas.get(indice).pagaConta(valorCentavos);
	}
	
	/**
	 * Método para imprimir os detalhes de uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 * @return EX: "Nome: Rich, Itens: 3, Conta: 500".
	 */
	public String cantinaToString(String nomeCantina) {
		int indice = acharContaCantina(nomeCantina);
		return this.contasCantinas.get(indice).toString();
	}
	
	/**
	 * Método para definir a saúde mental do aluno.
	 * 
	 * @param valor : Saúde mental("boa" ou "fraca").
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * Método para definir a saúde fisica do aluno.
	 * 
	 * @param valor : Saúde fisica("boa" ou "fraca").
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Método para imprimir o status da saúde do meu aluno.
	 * 
	 * @return "boa", "fraca" ou "ok".
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
	
	/**
	 * Método privado para achar qual a conta da cantina que eu devo usar.
	 * 
	 * @param nomeCantina : Nome da cantina que eu vou modificar.
	 * @return o indice da conta cantina no meu ArrayList.
	 */
	private int acharContaCantina(String nomeCantina) {
		for (int i = 0; i < this.contasCantinas.size(); i++) {
			if (this.contasCantinas.get(i).getNome().equals(nomeCantina)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método privado para achar qual a disciplina que eu devo usar.
	 * 
	 * @param nomeCantina : Nome da disciplina que eu vou modificar.
	 * @return o indice da disciplina no meu ArrayList.
	 */
	private int achaDisciplina(String nomeDisciplina) {
		for (int i = 0; i < this.disciplinas.size(); i++) {
			if (this.disciplinas.get(i).getNome().equals(nomeDisciplina)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método privado para achar qual a conta do laboratório que eu devo usar.
	 * 
	 * @param nomeCantina : Nome do laboratório que eu vou modificar.
	 * @return o indice da conta do laboratório no meu ArrayList.
	 */
	private int achaLaboratorio(String nomeLaboratorio) {
		for (int i = 0; i < this.laboratorios.size(); i++) {
			if (laboratorios.get(i).getNome().equals(nomeLaboratorio)) {
				return i;
			}
		}
		return -1;
	}
}