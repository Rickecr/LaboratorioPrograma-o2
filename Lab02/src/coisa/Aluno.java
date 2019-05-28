package coisa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Classe respons�vel por representar um Aluno no sistema. Possue um ArrayList de
 * Disciplina, ContaLaboratorio e de ContaCantina, e possuem Saude.
 * 
 * <font size="2" color="blue">
 * <ul> FUN��ES
 * 		<li> Usar os m�todos de Disciplina</li>
 * 		<li> Usar os m�todos de Laborat�rio</li>
 * 		<li> Usar os m�todos de Cantina</li>
 * 		<li> Usar os m�todos de Sa�de</li>
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
	 * ArrayList para guardar todas as conta dos laborat�rios do aluno.
	 */
	private ArrayList<ContaLaboratorio> laboratorios;
	
	/**
	 * ArrayList para guardar todas as contas das cantinas do aluno.
	 */
	private ArrayList<ContaCantina> contasCantinas;
	
	/**
	 * Objeto respons�vel pela sa�de do aluno.
	 */
	private Saude saude;
	
	/**
	 * Construtor que ir� criar o meu objeto aluno, recebendo o nome.
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
	 * M�todo para cadastrar um laborat�rio do aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para cadastrar.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio);
		this.laboratorios.add(lab);
	}
	
	/**
	 * M�todo para cadastrar um laborat�rio(Com cota) do aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para cadastrar.
	 * @param cota : A cota que o lab. possue.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio, cota);
		this.laboratorios.add(lab);
	}
	
	/**
	 * M�todo para consumir o espa�o de um laborat�rio de um aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para ser consumido.
	 * @param mbytes : O total de mbytes que ser� consumido.
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		int indice = achaLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).consomeEspaco(mbytes);
	}
	
	/**
	 * M�todo para liberar espa�o de um laborat�rio de um aluno.
	 * 
	 * @param nomeLaboratorio : O nome do lab. para ser consumido.
	 * @param mbytes : Total de mbytes para serem liberados.
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		int indice = achaLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).liberaEspaco(mbytes);
	}
	
	/**
	 * M�todo para verificar se um laborat�rio atingiu uma cota.
	 * 
	 * @param nomeLaboratorio : Nome do lab. que dejesar verificar.
	 * @return true ou false.
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		int indice = achaLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).atingiuCota();
	}
	
	/**
	 * M�todo que vai detalhar um laborat�rio de um aluno.
	 * 
	 * @param nomeLaboratorio : Nome do laborat�rio que deseja verificar.
	 * @return EX: "Nome do laborat�rio: LCC3, Espa�o ocupado: 2000, Cota: 3000"
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		int indice = achaLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).toString();
	}
	
	/**
	 * M�todo que vai cadastrar uma disciplina para o aluno.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina disci = new Disciplina(nomeDisciplina);
		this.disciplinas.add(disci);
	}
	
	/**
	 * M�todo que vai cadastrar o total de horas de uma determinada disciplina
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
	 * M�todo para cadastrar uma nota em uma determinada disciplina.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 * @param nota : Posi��o da nota.
	 * @param valorNota : Valor da nota obtida.
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int indice = achaDisciplina(nomeDisciplina);
		this.disciplinas.get(indice).cadastraNota(nota, valorNota);
	}
	
	/**
	 * M�todo para verificar se o aluno foi aporvado ou n�o em uma disciplina.
	 * 
	 * @param nomeDisciplina : Nome da Disciplina.
	 * @return true ou false.
	 */
	public boolean aprovado(String nomeDisciplina) {
		int indice = achaDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).aprovado();
	}
	
	/**
	 * M�todo que vai detalhar uma determinada disciplina de um aluno.
	 * 
	 * @param nomeDisciplina : Nome da disciplina.
	 * @return EX: "Nome da disciplina: C�lculo 2, horas: 4, m�dia: 8.45, notas: [9.0, 8.6, 8, 8.2]"
	 */
	public String disciplinaToString(String nomeDisciplina) {
		int indice = achaDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).toString();
	}
	
	/**
	 * M�todo para cadastrar uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 */
	public void cadastraCantina(String nomeCantina) {
		ContaCantina cc = new ContaCantina(nomeCantina);
		this.contasCantinas.add(cc);
	}
	
	/**
	 * M�todo para cadastrar um lanche em uma cantina.
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
	 * M�todo para pagar a conta de uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 * @param valorCentavos : Valor(em centavos) que deseja pagar na cantina.
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int indice = acharContaCantina(nomeCantina);
		this.contasCantinas.get(indice).pagaConta(valorCentavos);
	}
	
	/**
	 * M�todo para imprimir os detalhes de uma conta na cantina.
	 * 
	 * @param nomeCantina : Nome da cantina.
	 * @return EX: "Nome: Rich, Itens: 3, Conta: 500".
	 */
	public String cantinaToString(String nomeCantina) {
		int indice = acharContaCantina(nomeCantina);
		return this.contasCantinas.get(indice).toString();
	}
	
	/**
	 * M�todo para definir a sa�de mental do aluno.
	 * 
	 * @param valor : Sa�de mental("boa" ou "fraca").
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * M�todo para definir a sa�de fisica do aluno.
	 * 
	 * @param valor : Sa�de fisica("boa" ou "fraca").
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * M�todo para imprimir o status da sa�de do meu aluno.
	 * 
	 * @return "boa", "fraca" ou "ok".
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
	
	/**
	 * M�todo privado para achar qual a conta da cantina que eu devo usar.
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
	 * M�todo privado para achar qual a disciplina que eu devo usar.
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
	 * M�todo privado para achar qual a conta do laborat�rio que eu devo usar.
	 * 
	 * @param nomeCantina : Nome do laborat�rio que eu vou modificar.
	 * @return o indice da conta do laborat�rio no meu ArrayList.
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