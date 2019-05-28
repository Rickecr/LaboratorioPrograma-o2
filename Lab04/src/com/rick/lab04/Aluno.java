package com.rick.lab04;

/**
 * Classe responsável pela lógica de um aluno. Na qual vai manipular os dados do
 * mesmo. Atributos: nome, matricula e curso.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Métodos:
 * <li>Construtor</li>
 * <li>toSTring</li>
 * <li>hashCode</li>
 * <li>equals</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 */
public class Aluno {

	/**
	 * Atributo para o nome do aluno.
	 */
	private String nome;
	/**
	 * Atributo para a matrícula do aluno.
	 */
	private String matricula;
	/**
	 * Âtributo para o nome do curso do aluno.
	 */
	private String curso;

	/**
	 * Construtor do aluno.
	 * 
	 * @param nome
	 *            Nome do aluno
	 * @param matricula
	 *            Matricula do aluno
	 * @param curso
	 *            Nome do curso do aluno.
	 */
	public Aluno(String nome, String matricula, String curso) {
		if ((nome == null) || (matricula == null) || (curso == null))
			throw new NullPointerException("Dado inválido!\n");
		if (nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido!\n");
		if (matricula.trim().isEmpty())
			throw new IllegalArgumentException("Matrícula inválida!\n");
		if (curso.trim().isEmpty())
			throw new IllegalArgumentException("Curso inválido!\n");
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	/**
	 * Método que retorna a representação textual do aluno.
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso + "\n";
	}

	/**
	 * Método que retorna o identificador único do aluno.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método que verifica se esse objeto é igual a outro.
	 * 
	 * @param obj
	 *            Outro objeto.
	 * @return True se forem iguais, se não retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}