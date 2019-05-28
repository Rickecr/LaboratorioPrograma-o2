package com.rick;

public class HabilidadeTeste {

	public static void main(String[] args) {
		
		Habilidade hb1 = new Habilidade("Bola de fogo", 60, 5, "Fogo");
		Habilidade hb2 = new Habilidade("Raio de gelo", 20, 3, "Gelo");
		
		hb1.usaHabilidade();
		hb2.usaHabilidade();

	}

}
