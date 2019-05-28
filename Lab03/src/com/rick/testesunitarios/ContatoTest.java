package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.sistema.Contato;

public class ContatoTest {

	private Contato contato;
	
	/**
	 * Teste cadastrar contato com nome vazio.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraContatoNomeVazio() {
		contato = new Contato("", "Elton", "55", "83", "123456", "CASA", 1);
	}
	
	/**
	 * Teste cadastrar contato com sobrenome vazio.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraContatoSobrenomeVazio() {
		Contato c1 = new Contato("Rick", "", "55", "83", "123456", "CASA", 1);
	}
	
	/**
	 * Teste cadastrar contato com erro no nível mínimo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraContatoNivelErroMin() {
		Contato c1 = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 0);
	}
	
	/**
	 * Teste cadastrar contato com erro no nível máximo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraContatoNivelErroMax() {
		Contato c1 = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 6);
	}

	/**
	 * Teste de cadastrar telefones.
	 */
	@Test
	public void testCadastraTelefone() {
		contato = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 2);
		contato.cadastraTelefone("11", "99841-3387", "83", "CELULAR");
		String res = "Rick Elton, nível de amizade: colega - Total de telefone: 2\nTelefones: \n"
				+ "-> 55 (83) 123456, Tipo: CASA\n-> 83 (11) 99841-3387, Tipo: CELULAR\n";
		assertEquals(contato.toString(), res);
		
		contato.cadastraTelefone("12", "1234", "42", "CASA");
		String res1 = "Rick Elton, nível de amizade: colega - Total de telefone: 3\nTelefones: \n"
				+ "-> 55 (83) 123456, Tipo: CASA\n-> 83 (11) 99841-3387, Tipo: CELULAR\n"
				+ "-> 42 (12) 1234, Tipo: CASA\n";
		assertEquals(contato.toString(), res1);
	}
	
	/**
	 * Teste para erro de indice, caso a agenda esteja cheia(100 contatos).
	 */
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testCadastraTelefoneContatoCheio() {
		Contato c = new Contato("Rick", "Elton", "55", "83", "99841-3386", "CASA", 1);
		c.cadastraTelefone("21", "87", "123466789", "CASA");
		c.cadastraTelefone("11", "27", "987654321", "CELULAR");
		c.cadastraTelefone("23", "37", "987651341", "TRABALHO");
	}

	/**
	 * Teste de 'equals' de contato.
	 */
	@Test
	public void testEqualsObject() {
		contato = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 2);
		Contato c1 = new Contato("Rick", "Ramalho", "55", "83", "123456", "TRABALHO", 1);
		assertTrue(contato.equals(c1));
	}
	
	/**
	 * Teste de 'equals' com nomes diferentes.
	 */
	@Test
	public void testEqualsObjectErro() {
		contato = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 4);
		Contato c1 = new Contato("Ric", "Elton", "55", "83", "147852", "CELULAR", 4);
		assertFalse(contato.equals(c1));
	}

	/**
	 * Teste do 'toString()'.
	 */
	@Test
	public void testToString() {
		contato = new Contato("Rick", "Elton", "55", "83", "123456", "CASA", 4);
		String res = "Rick Elton, nível de amizade: amigão - Total de telefone: 1\nTelefones: \n"
				+ "-> 55 (83) 123456, Tipo: CASA\n";
		assertEquals(contato.toString(), res);
	}
}