package com.rick;

public class ContaTeste {

	public static void main(String[] args) {
		
		ContaBancaria cb = new ContaBancaria();
		cb.setNome("Rick");
		cb.setSaldo(2000);
		
		cb.depositar(1000);
		System.out.println(cb.getSaldo()); // 3000
		
		cb.sacar(2000); // Saque realizado.
		System.out.println(cb.getSaldo());
		
		cb.sacar(2000); // Saldo --> -1000
		
		cb.depositar(1200); // Saldo --> 80
		
		System.out.println(cb.detalhes());
		

	}

}
