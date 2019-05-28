package com.rick;

public class ContaBancaria {
	
	private String nome;
	private double saldo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		if (saldo < 0) {
			valor -= valor*10 / 100;
		}
		this.setSaldo(getSaldo() + valor);
	}
	
	public void sacar(double valor) {
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("Saque realizado com sucesso.");
	}

	public String detalhes() {
		return "ContaBancaria: nome=" + nome + ", saldo=" + saldo;
	}
	
	
	
}
