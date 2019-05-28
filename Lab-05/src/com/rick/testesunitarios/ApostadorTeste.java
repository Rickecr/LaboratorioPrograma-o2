package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rick.models.*;

/**
 * Classe que realiza os testes na classe Apostador.
 * 
 * @author Rich Ramalho - 117210710
 *
 */
public class ApostadorTeste {

	@Test(expected = NullPointerException.class)
	public void testApostadorNomeNull() {
		Aposta a = new Aposta(null, 100, "N VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorPrevisaoNull() {
		Aposta a = new Aposta("Rick", 100, null);
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorNomeInvalido() {
		Aposta a = new Aposta("  ", 150, "N VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorValorInvalido() {
		Aposta a = new Aposta("Rick", -50, "N VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorPrevisaoInvalido() {
		Aposta a = new Aposta("Rick", 150, "N vAI ACONTECER");
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoValorNomeNull() {
		Aposta a = new Aposta(null, 100, "N VAI ACONTECER", 200);
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoValorPrevisaoNull() {
		Aposta a = new Aposta("Rick", 100, null, 200);
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoValorNomeInvalido() {
		Aposta a = new Aposta("  ", 150, "N VAI ACONTECER", 200);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorAsseguradoValorValorInvalido() {
		Aposta a = new Aposta("Rick", -50, "N VAI ACONTECER", 200);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorAsseguradoValorPrevisaoInvalido() {
		Aposta a = new Aposta("Rick", 150, "N vAI ACONTECER", 200);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaValorSeguroValorInva() {
		Aposta a = new Aposta("Rick", 150, "N VAI ACONTECER", 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoTaxaNomeNull() {
		Aposta a = new Aposta(null, 100, "N VAI ACONTECER", 0.01);
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoTaxaPrevisaoNull() {
		Aposta a = new Aposta("Rick", 100, null, 0.01);
	}

	@Test(expected = NullPointerException.class)
	public void testApostadorAsseguradoTaxaNomeInvalido() {
		Aposta a = new Aposta("  ", 150, "N VAI ACONTECER", 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorAsseguradoTaxaValorInvalido() {
		Aposta a = new Aposta("Rick", -50, "N VAI ACONTECER", 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostadorAsseguradoTaxaPrevisaoInvalido() {
		Aposta a = new Aposta("Rick", 150, "N vAI ACONTECER", 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaSeguroValorInva() {
		Aposta a = new Aposta("Rick", -150, "N vAI ACONTECER", 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaSeguroTaxaInva() {
		Aposta a = new Aposta("Rick", 150, "N VAI ACONTECER", 0);
	}

	@Test
	public void testApostadorSeguroValor() {
		Aposta a = new Aposta("Rick", 450, "N VAI ACONTECER", 500);
		assertFalse(a == null);
	}
	
	@Test
	public void testApostadorSeguroTaxa() {
		Aposta a = new Aposta("Rick", 450, "N VAI ACONTECER", 500.0);
		assertFalse(a == null);
	}
	
	@Test
	public void testApostAlteraParaValor() {
		Aposta a = new Aposta("Rick", 450, "N VAI ACONTECER", 0.5);
		a.alterarSeguroValor(400);
		assertTrue(a.getSeguro() == 400);
	}
	
	@Test
	public void testApostAlteraParaTaxa() {
		Aposta a = new Aposta("Rick", 400, "N VAI ACONTECER", 500);
		a.alterarSeguroTaxa(0.5);
		assertTrue(a.getSeguro() == 200);
	}
	
	/**
	 * Metodo que verifca o toString de uma aposta.
	 */
	@Test
	public void testToString() {
		Aposta a = new Aposta("Rick", 150, "VAI ACONTECER");
		String res = "Rick - R$150 - VAI ACONTECER";
		assertEquals(a.toString(), res);
	}
}