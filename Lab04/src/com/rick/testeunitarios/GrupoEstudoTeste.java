package com.rick.testeunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.rick.lab04.*;

/**
 * Classe que realiza os testes da classe GrupoEstudo.
 * 
 * @author Rich Ramalho - 117210710
 *
 */
public class GrupoEstudoTeste {

	/**
	 * Atributo que ira representa um dos alunos para os testes.
	 */
	private Aluno aluno1;
	/**
	 * Atributo que ira representa um dos alunos para os testes.
	 */
	private Aluno aluno2;
	/**
	 * Atributo que ira representa o GrupoEstudo para os testes.
	 */
	private GrupoEstudo grupo;
	
	/**
	 * Metodo que instancia o GrupoEstudo e os dois alunos para os testes(Chamado antes do que qualquer
	 * metodo @teste).
	 */
	@Before
	public void testGrupoEstudo() {
		this.grupo = new GrupoEstudo("Calculo");
		this.aluno1 = new Aluno("Rick", "123", "Computação");
		this.aluno2 = new Aluno("Elton", "1234", "Engenharia de Petróleo");
	}

	/**
	 * Metodo que espera uma excecao('Nome nulo.").
	 */
	@Test(expected=NullPointerException.class)
	public void testGrupoEstudoNomeNulo() {
		GrupoEstudo ge = new GrupoEstudo(null);
	}
	
	/**
	 * Metodo que espera uma excecao('Nome do curso invalido").
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGrupoEstudoNomeInvalido() {
		GrupoEstudo ge = new GrupoEstudo("");
	}
	
	/**
	 * Metodo que testa se eh possivel adicionar um aluno.
	 */
	@Test
	public void testAdicionarAluno() {
		assertTrue(this.grupo.adicionarAluno(aluno1));
	}

	/**
	 * Metodo que teste o 'toSTring' do meu Grupo de estudo.
	 */
	@Test
	public void testToString() {
		this.grupo.adicionarAluno(aluno1);
		String res = "Alunos do grupo Calculo\n* Aluno: 123 - Rick - Computação\n";
		assertEquals(this.grupo.toString(), res);
	}

	/**
	 * Metodo que verifica o 'equals' do grupo de estudo(Pelo nome).
	 * True.
	 */
	@Test
	public void testEqualsTrue() {
		GrupoEstudo ge = new GrupoEstudo("Calculo");
		assertTrue(this.grupo.equals(ge));
	}
	
	/**
	 * Metodo que verifica o 'equals' do grupo de estudo(Pelo nome).
	 * False.
	 */
	@Test
	public void testEqualsFalse() {
		GrupoEstudo ge = new GrupoEstudo("Calculo 1");
		assertFalse(this.grupo.equals(ge));
	}
	
	/**
	 * Metodo que verifica o 'equals' do grupo de estudo(Pelo nome).
	 * False.
	 */
	@Test
	public void testEqualsObjNull(){
		GrupoEstudo ge = null;
		assertFalse(this.grupo.equals(ge));
	}
	
	/**
	 * Metodo que verifica o 'equals' do grupo de estudo(Pelo nome).
	 * False.
	 */
	@Test
	public void testEqualsObjClasseDiferente(){
		assertFalse(this.grupo.equals(this.aluno1));
	}
}
