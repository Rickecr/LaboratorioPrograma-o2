package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.models.SeguroTaxa;
import com.rick.models.SeguroValor;

public class SeguroValorTeste {

	private SeguroValor sValor;
	
	@Before
	public void testConstrutor() {
		this.sValor = new SeguroValor(100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSeguroValorInvalida() {
		this.sValor = new SeguroValor(0);
	}
	
	@Test
	public void testGetValorSeguro() {
		assertTrue(this.sValor.getValor() == 100);
	}

	@Test
	public void testToString() {
		String res = " - ASSEGURADA (VALOR) - R$ 1,00";
		assertEquals(this.sValor.toString(), res);
	}
}
