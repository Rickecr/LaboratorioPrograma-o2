package com.rick;

import java.util.HashMap;
import java.util.Map;

public class Pessoa {
	
	private String nome;
	private int mes;
	private String elementoRegente;
	private Map<int[], String> elementos = new HashMap<int[], String>();
	
	public Pessoa(String nome, int mes) {
		this.nome = nome;
		this.mes = mes;
		
		this.elementos.put(new int[] {1, 5, 9}, "Terra");
		this.elementos.put(new int[] {2, 6, 10}, "Ar");
		this.elementos.put(new int[] {3, 7, 11}, "Água");
		this.elementos.put(new int[] {4, 8, 12}, "Fogo");

		for (int[] key : elementos.keySet()) {
			for (int i : key) {
				if (i == mes) {
					this.elementoRegente = elementos.get(key);
				}
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getElementoRegente() {
		return elementoRegente;
	}
	public void setElementoRegente(String elementoRegente) {
		this.elementoRegente = elementoRegente;
	}
	
	

}
