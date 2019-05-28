package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.models.*;

/**
 * Classe que faz os testes na classe Cenario.
 * 
 * @author Rich Ramalho - 117210710
 *
 */
public class CenarioTeste {
	
	private Cenario cenario;
	
	@Before
	public void test() {
		this.cenario = new Cenario("Passar em calculo 3?");
	}
	
	@Test
	public void testCenario() {
		Cenario c = new Cenario("Passar em fisica?");
	}	

	@Test(expected=NullPointerException.class)
	public void testCenarioDescNull() {
		Cenario c = new Cenario(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioDescVazio() {
		Cenario c = new Cenario("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioDescSoComEspacos() {
		Cenario c = new Cenario("  ");
	}

	@Test
	public void testCadastrarAposta() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		assertEquals(this.cenario.totalDeApostas(), 2);
	}
	
	@Test
	public void testCadastrarApostaComSeguroValor() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER", 200);
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER", 300);
		assertEquals(this.cenario.totalDeApostas(), 2);
	}
	
	@Test
	public void testCadastrarApostaComSeguroTaxa() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER", 0.5);
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER", 0.03);
		assertEquals(this.cenario.totalDeApostas(), 2);
	}
	
	@Test
	public void testAlterarApostaParaSeguroValor() {
		int id = this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER", 0.5);
		this.cenario.alterarSeguroValor(id, 300);
		String res = "Rick - R$250 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$ 3,00";
		assertEquals(this.cenario.exibirApostas(), res);
	}
	
	@Test
	public void testAlterarApostaParaSeguroTaxa() {
		int id = this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER", 300);
		this.cenario.alterarSeguroTaxa(id, 0.03);
		String res = "Rick - R$250 - N VAI ACONTECER - ASSEGURADA (TAXA) - 3%";
		assertEquals(this.cenario.exibirApostas(), res);
	}

	@Test
	public void testValorTotalDeApostas() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		assertEquals(this.cenario.valorTotalDeApostas(), 750);
	}

	@Test
	public void testTotalDeApostas() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		assertEquals(this.cenario.totalDeApostas(), 3);
	}

	@Test
	public void testExibirApostas() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 250, "N VAI ACONTECER");
		String res = "Rick - R$250 - N VAI ACONTECER" + 
					 "Elton - R$250 - N VAI ACONTECER" + 
					 "Elton - R$250 - N VAI ACONTECER";
		assertEquals(this.cenario.exibirApostas(), res);
	}

	@Test
	public void testFecharCenarioOcorreu() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.fecharCenario(true);
		String res = "Passar em calculo 3? - Finalizado (ocorreu)";
		assertEquals(this.cenario.toString(), res);
	}
	
	@Test
	public void testFecharCenarioNaoOcorreu() {
		this.cenario.cadastrarAposta("Rick", 250, "N VAI ACONTECER");
		this.cenario.fecharCenario(false);
		String res = "Passar em calculo 3? - Finalizado (n ocorreu)";
		assertEquals(this.cenario.toString(), res);
	}

	@Test
	public void testGetCaixaCenarioJaFinalizadoNaoOcorreu() {
		this.cenario.cadastrarAposta("Rick", 200, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 100, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 250, "VAI ACONTECER");
		this.cenario.fecharCenario(false);
		String res = "Passar em calculo 3? - Finalizado (n ocorreu)\n";
		assertEquals(this.cenario.getCaixaCenario(), 250);
	}
	
	@Test
	public void testGetCaixaCenarioJaFinalizadoOcorreu() {
		this.cenario.cadastrarAposta("Rick", 200, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 100, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 250, "VAI ACONTECER");
		this.cenario.fecharCenario(true);
		String res = "Passar em calculo 3? - Finalizado (ocorreu)\n";
		assertEquals(this.cenario.getCaixaCenario(), 300);
	}
	
	@Test
	public void testGetCaixaCenarioNaoFinalizado() {
		this.cenario.cadastrarAposta("Rick", 200, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 100, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 250, "VAI ACONTECER");
		String res = "Passar em calculo 3? - Nao Finalizado\n";
		assertEquals(this.cenario.getCaixaCenario(), 0);
	}

	@Test
	public void testGetTotalRateioCenarioNaoOcorreu() {
		this.cenario.cadastrarAposta("Rick", 200, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 100, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 200, "VAI ACONTECER");
		this.cenario.fecharCenario(false);
		String res = "Passar em calculo 3? - Finalizado (n ocorreu)\n";
		assertEquals(this.cenario.getTotalRateioCenario(2), 198);
	}
	
	@Test
	public void testGetTotalRateioCenarioOcorreu() {
		this.cenario.cadastrarAposta("Rick", 200, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Elton", 100, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 200, "VAI ACONTECER");
		this.cenario.cadastrarAposta("Pedro", 200, "VAI ACONTECER");
		this.cenario.fecharCenario(true);
		String res = "Passar em calculo 3? - Finalizado (ocorreu)\n";
		assertEquals(this.cenario.getTotalRateioCenario(3), 297);
	}
	
	@Test
	public void testToStringNaoFinalizado() {
		String res = "Passar em calculo 3? - Nao finalizado";
		assertEquals(this.cenario.toString(), res);
	}
	
	@Test
	public void testToStringFinalizadoOcorreu() {
		this.cenario.fecharCenario(true);
		String res = "Passar em calculo 3? - Finalizado (ocorreu)";
		assertEquals(this.cenario.toString(), res);
	}
	
	@Test
	public void testToStringFinalizadoNaoOcorreu() {
		this.cenario.fecharCenario(false);
		String res = "Passar em calculo 3? - Finalizado (n ocorreu)";
		assertEquals(this.cenario.toString(), res);
	}
}