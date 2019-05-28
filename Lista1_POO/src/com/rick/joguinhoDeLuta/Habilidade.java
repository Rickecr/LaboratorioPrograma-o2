package com.rick.joguinhoDeLuta;

public class Habilidade {
	
	private String nome;
	private int dano;
	private int mana;
	private String tipoDano;
	
	public Habilidade(String nome, int dano, int mana, String tipoDano) {
		this.nome = nome;
		this.dano = dano;
		this.mana = mana;
		this.tipoDano = tipoDano;
	}
	
	public void usaHabilidade() {
		System.out.printf("Gastou %d de energia. %s causa %d de dano.\n", this.mana, this.nome, this.dano);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDano() {
		return dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public String getTipoDano() {
		return this.tipoDano;
	}
	
	public void setTipoDano(String tipoDano) {
		this.tipoDano = tipoDano;
	}
	
	
	

}
