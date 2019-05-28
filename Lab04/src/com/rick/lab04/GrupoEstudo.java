package com.rick.lab04;

import java.util.*;

/**
 * Classe responsavel pela logica de um grupo. Na qual vai manipular os dados do
 * mesmo. Atributos: nome e participantes.
 * 
 * <font size="2" color="red" >
 * <ul>
 * Metodos:
 * <li>Construtor</li>
 * <li>adiciona Aluno</li>
 * <li>toString</li>
 * <li>hashCode</li>
 * <li>equals</li>
 * </ul>
 * 
 * @author Rich Ramalho - 117210710 </font>
 *
 */
public class GrupoEstudo {

	/**
	 * Atributo para o nome do grupo.
	 */
	private String nome;
	/**
	 * Atributo(Conjunto de alunos) que sao os participantes desse grupo.
	 */
	private Set<Aluno> participantes;

	/**
	 * Construtor do grupo.
	 * 
	 * @param nome
	 *            Nome do grupo
	 */
	public GrupoEstudo(String nome) {
		if (nome == null)
			throw new NullPointerException("Nome nulo!\n");
		if (nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome de grupo invalido");
		this.nome = nome;
		this.participantes = new HashSet<>();
	}

	/**
	 * Metodo que vai adicionar um aluno no grupo.
	 * 
	 * @param aluno
	 *            Objeto de Aluno.
	 * @return True se conseguir adicionar o aluno, false se nao conseguir.
	 */
	public boolean adicionarAluno(Aluno aluno) {
		return this.participantes.add(aluno);
	}

	/**
	 * Metodo que retorna uma representacao textual do grupo(Com os dados dos
	 * participantes).
	 * 
	 * @Return String
	 */
	@Override
	public String toString() {
		String res = "";
		if (!(this.participantes.size() == 0)) {
			res += "Alunos do grupo " + this.nome + "\n";
			for (Aluno aluno : participantes) {
				res += "* " + aluno.toString();
			}
		} else {
			res += "Grupo nao tem alunos.\n";
		}
		return res;
	}

	/**
	 * Metodo que retorna o identificador unico do grupo.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica se esse objeto eh igual a outro.
	 * 
	 * @param obj
	 *            Outro objeto.
	 * @return True se forem iguais, se nao retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}