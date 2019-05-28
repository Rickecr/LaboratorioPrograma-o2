package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.models.SeguroTaxa;

public class SeguroTaxaTeste {

	private SeguroTaxa sTaxa;
	
	@Before
	public void testConstrutor() {
		this.sTaxa = new SeguroTaxa(100, 0.15);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSeguroTaxaInvalida() {
		this.sTaxa = new SeguroTaxa(100, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSeguroValorInvalida() {
		this.sTaxa = new SeguroTaxa(0, 0.5);
	}
	
	@Test
	public void testGetValorSeguro() {
		assertTrue(this.sTaxa.getValor() == 15);
	}

	@Test
	public void testToString() {
		String res = " - ASSEGURADA (TAXA) - 15%";
		assertEquals(this.sTaxa.toString(), res);
	}
}