package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rick.sistema.Telefone;
import com.rick.sistema.Telefone;

public class TelefoneTest {
	
	/**
	 * Teste do 'toString()'.
	 */
	@Test
	public void testToString() {
		Telefone tel = new Telefone("83", "1234", "55", "CASA");
		assertEquals(tel.toString(), "55 (83) 1234, Tipo: CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com ddd vazio.
	 * Esperando uma exce��o.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneDddVazio() {
		Telefone tel = new Telefone("", "1234", "55", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com Codigo do pa�s vazio.
	 * Esperando uma exce��o.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneCodVazio() {
		Telefone tel = new Telefone("83", "1234", "", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com n�mero vazio.
	 * Esperando uma exce��o.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneNumeroVazio() {
		Telefone tel = new Telefone("83", "", "55", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com tipo vazio.
	 * Esperando uma exce��o.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneTipoVazio() {
		Telefone tel = new Telefone("83", "1234", "55", "");
	}
	
	/**
	 * Teste de cadastrar telefone com Tipo inv�lido.
	 * Esperando uma exce��o.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraTelefoneTipoInvalido() {
		Telefone tel = new Telefone("83", "1234", "55", "OI");
	}
}