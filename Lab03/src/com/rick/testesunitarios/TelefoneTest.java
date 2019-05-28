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
	 * Esperando uma exceção.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneDddVazio() {
		Telefone tel = new Telefone("", "1234", "55", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com Codigo do país vazio.
	 * Esperando uma exceção.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneCodVazio() {
		Telefone tel = new Telefone("83", "1234", "", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com número vazio.
	 * Esperando uma exceção.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneNumeroVazio() {
		Telefone tel = new Telefone("83", "", "55", "CASA");
	}
	
	/**
	 * Teste de cadastrar telefone com tipo vazio.
	 * Esperando uma exceção.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraTelefoneTipoVazio() {
		Telefone tel = new Telefone("83", "1234", "55", "");
	}
	
	/**
	 * Teste de cadastrar telefone com Tipo inválido.
	 * Esperando uma exceção.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraTelefoneTipoInvalido() {
		Telefone tel = new Telefone("83", "1234", "55", "OI");
	}
}