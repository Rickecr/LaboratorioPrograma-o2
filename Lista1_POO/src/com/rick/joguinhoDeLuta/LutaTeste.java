package com.rick.joguinhoDeLuta;

public class LutaTeste {
	public static void main(String[] args) {
		
		Habilidade hb1 = new Habilidade("Bola de fogo", 40, 250, "Fogo");
		Habilidade hb2 = new Habilidade("Raio de gelo", 20, 3, "Gelo");
		
		Lutador l1 = new Lutador("Rick", 100, 500, hb1);
		Lutador l2 = new Lutador("Elton", 100, 500, hb2);
		
		System.out.printf("A luta é entre %s X %s.\n", l1.getNome(), l2.getNome());
		
		l2.atacar(l1);
		System.out.println("----");

		l1.atacar(l2);
		System.out.println("----");
		
		l1.atacar(l2);
		System.out.println("----");
		
		l1.atacar(l2);
		System.out.println("----");
		
		l1.atacar(l2);
		
		
		System.out.println(l1.detalhes());
		System.out.println(l2.detalhes());
		
	}

}
