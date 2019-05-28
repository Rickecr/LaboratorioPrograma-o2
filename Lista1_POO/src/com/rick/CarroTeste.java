package com.rick;

public class CarroTeste {

	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		c1.setNome("Gol");
		c1.setPreco(2500);
		
		System.out.println(c1.precoPorXDias(5)); // 12500

	}

}
