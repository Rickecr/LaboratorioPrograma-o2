package com.rick.sistema;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		Facade f = new Facade();
		f.inicializa(2000, 0.01);
		f.cadastrarCenario("asda", 1000);
		f.cadastrarAposta(1, "rick", 2000, "N VAI ACONTECER");
		f.cadastrarAposta(1, "rick ELTON", 100, "VAI ACONTECER");
		f.fecharAposta(1, true);
		System.out.println(f.getCaixaCenario(1));
		
	}

}
