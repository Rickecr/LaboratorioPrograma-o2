package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.sistema.Agenda;

public class AgendaTest {

	private Agenda agenda;
	
	/**
	 * Criação da minha agenda para testes.
	 */
	@Before
	public void testAgenda() {
		agenda = new Agenda();
	}

	/**
	 * Teste de cadastrar contato em posição inválida.
	 * Esperando uma exceção.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarContatoPosErroMin() {
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 0);
	}
	
	/**
	 * Teste de cadastrar contato em posição inválida.
	 * Esperando uma exceção.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarContatoPosErroMax() {
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 101);
	}
	
	/**
	 * Teste de cadastrar contato em posição mínima.
	 */
	@Test
	public void testCadastrarContatoPosMin() {
		boolean res = agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 1);
		assertTrue(res);
	}
	
	/**
	 * Teste de cadastrar contato em posição máxima.
	 */
	@Test
	public void testCadastrarContatoPosMax() {
		boolean res = agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 100);
		assertTrue(res);
	}

	/**
	 * Teste de cadastrar um telefone em um determinado contato.
	 */
	@Test
	public void testCadastrarTelefoneContato() {
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 1);
		boolean res = agenda.cadastrarTelefoneContato(1, "11", "21", "99841-3387", "CELULAR");
		assertEquals(agenda.detalhesContato(1), "Rick Elton, nível de amizade: colega - Total de telefone: 2\n" + 
				"Telefones: \n" + 
				"-> 55 (83) 99841-3386, Tipo: CASA\n" + 
				"-> 11 (21) 99841-3387, Tipo: CELULAR\n");
	}

	/**
	 * Teste para imprimir os detalhes de um contato.
	 */
	@Test
	public void testDetalhesContato() {
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 1);
		assertEquals(agenda.detalhesContato(1), "Rick Elton, nível de amizade: colega - Total de telefone: 1\n" + 
				"Telefones: \n" + 
				"-> 55 (83) 99841-3386, Tipo: CASA\n");
	}

	/**
	 * Teste de procurar contatos pelo nome.
	 */
	@Test
	public void testProcuraContatosPeloNome() {
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 1);
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CELULAR", 2, 20);
		agenda.cadastrarContato("Pedro", "Elton", "55", "83", "99841-3386", "TRABALHO", 2, 50);
		agenda.cadastrarContato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 2, 100);
		String res = "Rick Elton, nível de amizade: colega - Total de telefone: 1\n" + 
					 "Telefones: \n" + 
					 "-> 55 (83) 99841-3386, Tipo: CASA\n" + 
					 "Rick Elton, nível de amizade: colega - Total de telefone: 1\n" + 
					 "Telefones: \n" + 
					 "-> 55 (83) 99841-3386, Tipo: CELULAR\n" + 
					 "Rick Elton, nível de amizade: colega - Total de telefone: 1\n" + 
					 "Telefones: \n" + 
					 "-> 55 (83) 99841-3386, Tipo: CASA\n";
		assertEquals(agenda.procuraContatosPeloNome("Rick"), res);
	}

	/**
	 * Teste de procurar contatos pelo nível.
	 */
	@Test
	public void testProcuraContatosPeloNivel() {
		agenda.cadastrarContato("Mica", "asd", "11", "83", "99841-3396", "CASA", 1, 1);
		agenda.cadastrarContato("Jose", "ads", "52", "21", "99841-3986", "CELULAR", 2, 20);
		agenda.cadastrarContato("Pedro", "abc", "57", "85", "99841-4386", "TRABALHO", 1, 50);
		agenda.cadastrarContato("Rick", "mnb", "14", "47", "99841-2286", "CASA", 2, 100);
		String res = "Mica asd, nível de amizade: distante - Total de telefone: 1\n" + 
					 "Telefones: \n" + 
					 "-> 11 (83) 99841-3396, Tipo: CASA\n" + 
					 "Pedro abc, nível de amizade: distante - Total de telefone: 1\n" + 
					 "Telefones: \n" + 
					 "-> 57 (85) 99841-4386, Tipo: TRABALHO\n";
		assertEquals(agenda.procuraContatosPeloNivel(1), res);
		
	}

	/**
	 * Teste de imprimir a média de amizade da agenda.
	 */
	@Test
	public void testMediaAmizade() {
		agenda.cadastrarContato("Mica", "asd", "11", "83", "99841-3396", "CASA", 1, 1);
		agenda.cadastrarContato("Jose", "ads", "52", "21", "99841-3986", "CELULAR", 2, 20);
		agenda.cadastrarContato("Pedro", "abc", "57", "85", "99841-4386", "TRABALHO", 1, 50);
		agenda.cadastrarContato("Rick", "mnb", "14", "47", "99841-2286", "CASA", 2, 100);
		assertEquals(agenda.mediaAmizade(), 1,5);
	}
	
	/**
	 * Teste de média da amizade. Esperando que o teste der erro de divisão por zero.
	 */
	@Test(expected=NumberFormatException.class)
	public void testMediaAmizadeZero() {
		agenda.mediaAmizade();
	}

	/**
	 * Teste de exibir todos contatos da agenda.
	 */
	@Test
	public void testExibirContatos() {
		agenda.cadastrarContato("Mica", "asd", "11", "83", "99841-3396", "CASA", 1, 1);
		agenda.cadastrarContato("Jose", "ads", "52", "21", "99841-3986", "CELULAR", 2, 20);
		agenda.cadastrarContato("Pedro", "abc", "57", "85", "99841-4386", "TRABALHO", 1, 50);
		agenda.cadastrarContato("Rick", "mnb", "14", "47", "99841-2286", "CASA", 2, 100);
		String res = "1 - Mica asd\n" + 
				   	 "20 - Jose ads\n" + 
					 "50 - Pedro abc\n" + 
					 "100 - Rick mnb\n";
		assertEquals(agenda.exibirContatos(), res);
	}
}