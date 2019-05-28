package com.rick.testesunitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rick.controllers.CenarioController;

/**
 * Classe que realiza os teste no Controle de Cenario.
 * 
 * @author Rich Ramalho - 117210710
 *
 */
public class CenarioControllerTeste {

	private CenarioController controller;

	@Before
	public void testCenarioController() {
		this.controller = new CenarioController(2000, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioControllerErroCaixa() {
		this.controller = new CenarioController(-1, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioControllerErroTaxa() {
		this.controller = new CenarioController(1200, -0.01);
	}
	
	@Test
	public void testCadastrarCenario() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		assertEquals(this.controller.cadastrarCenario("Pagar fisica 2?"), 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioBonusErro() {
		this.controller.cadastrarCenario("Pagar fisica 1?", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarCenarioBonusErroDescricao() {
		this.controller.cadastrarCenario("  ", 15);
	}
	
	@Test
	public void testCadastrarCenarioBonus() {
		this.controller.cadastrarCenario("Pagar fisica 1?", 200);
		String res = "1 - Pagar fisica 1? - Nao finalizado - R$ 2,00";
		assertEquals(this.controller.exibirCenario(1), res);
	}
	
	@Test
	public void testCadastrarApostaSeguraTaxa() {
		this.controller.cadastrarCenario("Pagar fisica 1?", 200);
		assertTrue(this.controller.cadastrarApostaSeguraTaxa(1, "Rick", 200, "VAI ACONTECER", 0.5, 500) == 1);
	}
	
	@Test
	public void testCadastrarApostaSeguraValor() {
		this.controller.cadastrarCenario("Pagar fisica 1?", 200);
		assertTrue(this.controller.cadastrarApostaSeguraValor(1, "Rick", 200, "VAI ACONTECER", 100, 500) == 1);
	}
	
	@Test
	public void testExibirCenarios() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		String res = "1 - Pagar fisica 1? - Nao finalizado" + 
					 "2 - Pagar fisica 2? - Nao finalizado";
		assertEquals(this.controller.exibirCenarios(), res);
	}

	@Test
	public void testExibirCenarioCorreto() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		String res = "1 - Pagar fisica 1? - Nao finalizado";
		assertEquals(this.controller.exibirCenario(1), res);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExibirCenarioIdNaoExiste() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.exibirCenario(3);
	}
	
	@Test
	public void testAlterarOrdemNome() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		this.controller.cadastrarCenario("Pagar fisica 3?");
		this.controller.cadastrarCenario("Pagar fisica 4?");
		this.controller.alterarOrdem("nome");
		String res = "1 - Pagar fisica 1? - Nao finalizado";
		assertEquals(res, this.controller.exibirCenarioOrdenado(1));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemNomeInvalido() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		this.controller.cadastrarCenario("Pagar fisica 3?");
		this.controller.cadastrarCenario("Pagar fisica 4?");
		this.controller.alterarOrdem("  ");
	}
	
	@Test
	public void testAlterarOrdemAposta() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		this.controller.cadastrarCenario("Pagar fisica 3?");
		this.controller.cadastrarCenario("Pagar fisica 4?");
		this.controller.alterarOrdem("apostas");
		String res = "1 - Pagar fisica 1? - Nao finalizado";
		assertEquals(res, this.controller.exibirCenarioOrdenado(1));
	}

	@Test
	public void testAlterarOrdemCadastro() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		this.controller.cadastrarCenario("Pagar fisica 3?");
		this.controller.cadastrarCenario("Pagar fisica 4?");
		this.controller.alterarOrdem("cadastro");
		String res = "1 - Pagar fisica 1? - Nao finalizado";
		assertEquals(res, this.controller.exibirCenarioOrdenado(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlterarOrdemInvalido() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarCenario("Pagar fisica 2?");
		this.controller.cadastrarCenario("Pagar fisica 3?");
		this.controller.cadastrarCenario("Pagar fisica 4?");
		this.controller.alterarOrdem("VAI BRASIL");
	}
	
	@Test
	public void testCadastrarAposta() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		assertEquals(this.controller.totalDeApostas(1), 1);
	}
	
	@Test
	public void testCadastrarApostaAsseguradaValorCaixa() {
		this.controller.cadastrarCenario("Pagar calculo 2");
		this.controller.cadastrarApostaSeguraValor(1, "Rick", 2000, "VAI ACONTECER", 500, 150);
		assertEquals(2150, this.controller.getCaixa());
	}
	
	@Test
	public void testCadastrarApostaAsseguradaTaxaCaixa() {
		this.controller.cadastrarCenario("Pagar calculo 2");
		this.controller.cadastrarApostaSeguraTaxa(1, "Rick", 2000, "VAI ACONTECER", 0.5, 150);
		assertEquals(2150, this.controller.getCaixa());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarApostaIdCenarioNaoExiste() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(2, "Rick", 150, "VAI ACONTECER");
		assertEquals(this.controller.totalDeApostas(1), 0);
	}

	@Test
	public void testValorTotalDeApostas() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 150, "N VAI ACONTECER");
		assertEquals(this.controller.valorTotalDeApostas(1), 300);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorTotalDeApostasIdNaoExiste() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 150, "N VAI ACONTECER");
		assertEquals(this.controller.valorTotalDeApostas(2), 0);
	}

	@Test
	public void testTotalDeApostas() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		assertEquals(this.controller.totalDeApostas(1), 1);
	}

	@Test
	public void testExibirApostas() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 100, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 50, "N VAI ACONTECER");
		String res = "Rick - R$150 - VAI ACONTECER" + 
					 "Elton - R$100 - VAI ACONTECER" + 
					 "Pedro - R$50 - N VAI ACONTECER";
		assertEquals(this.controller.exibirApostas(1), res);
	}
	
	@Test
	public void testExibirApostasIdNaoExiste() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 100, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 50, "N VAI ACONTECER");
		String res = "Cenario nao existe\n";
		assertEquals(this.controller.exibirApostas(2), res);
	}

	@Test
	public void testFecharCenario() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.fecharCenario(1, true);
		String res = "1 - Pagar fisica 1? - Finalizado (ocorreu)";
		assertEquals(this.controller.exibirCenario(1), res);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharCenarioJaFinalizado() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.fecharCenario(1, true);
		this.controller.fecharCenario(1, false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFecharCenarioIdNaoExiste() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.fecharCenario(2, true);
		String res = "Pagar fisica 1? - Nao Finalizado\n";
		assertEquals(this.controller.exibirCenario(1), res);
	}
	
	@Test
	public void testGetCaixaCenarioFinalizadoOcorre() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.fecharCenario(1, true);
		assertEquals(this.controller.getCaixaCenario(1), 2);
	}
	
	@Test
	public void testGetCaixaCenarioFinalizadoNaoOcorre() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.fecharCenario(1, false);
		assertEquals(this.controller.getCaixaCenario(1), 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCaixaCenarioNaoFinalizado() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.getCaixaCenario(1);
	}

	@Test
	public void testGetTotalRateioCenarioFinalizadoOcorre() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.fecharCenario(1, true);
		assertEquals(this.controller.getTotalRateioCenario(1), 198);
	}
	
	@Test
	public void testGetTotalRateioCenarioFinalizadoNaoOcorre() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.fecharCenario(1, false);
		assertEquals(this.controller.getTotalRateioCenario(1), 446);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNaoFinalizado() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.getTotalRateioCenario(1);
	}

	@Test
	public void testGetCaixa() {
		assertEquals(this.controller.getCaixa(), 2000);
	}
	
	@Test
	public void testGetCaixaAlterado() {
		this.controller.cadastrarCenario("Pagar fisica 1?");
		this.controller.cadastrarAposta(1, "Rick", 150, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Elton", 200, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Pedro", 300, "VAI ACONTECER");
		this.controller.fecharCenario(1, false);
		this.controller.getCaixaCenario(1);
		assertEquals(2004, this.controller.getCaixa());
	}
	
	@Test
	public void testAlterarApostaAsseguradaParaValor() {
		this.controller.cadastrarCenario("Pagar calculo 2", 200);
		int id = this.controller.cadastrarApostaSeguraTaxa(1, "Rick", 2000, "VAI ACONTECER", 0.2, 200);
		int res = this.controller.alterarSeguroValor(1, id, 150);
		assertEquals(res, 1);
	}
	
	@Test
	public void testAlterarApostaAsseguradaParaTaxa() {
		this.controller.cadastrarCenario("Pagar calculo 2", 200);
		int id = this.controller.cadastrarApostaSeguraValor(1, "Rick", 2000, "VAI ACONTECER", 150, 200);
		int res = this.controller.alterarSeguroTaxa(1, id, 0.02);
		assertEquals(res, 1);
	}
}