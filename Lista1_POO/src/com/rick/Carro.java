package com.rick;

public class Carro {
	
	private String nome;
	private double preco;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double precoPorXDias(int dias) {
		return this.preco * dias;
	}
	
}
