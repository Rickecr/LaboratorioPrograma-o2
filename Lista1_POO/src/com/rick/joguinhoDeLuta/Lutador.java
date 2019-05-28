package com.rick.joguinhoDeLuta;
/*
 *  Classe Lutador --> Onde se encontra cada atributo e métodos de cada lutador
 *  criado.
 * 
 * 	@author Rich Elton
 * 
 */

public class Lutador {
	
	private String nome;
	private int HP;
	private int mana;
	private Habilidade habilidade;
	private String estado;
	
	// Construtor.
	public Lutador(String nome, int HP, int mana,
				   Habilidade habilidade) {
		this.nome = nome;
		this.HP = HP;
		this.mana = mana;
		this.habilidade = habilidade;
		this.estado = "normal";
	}
	
	// Método para o lutador atacar com sua habilidade.
	public void atacar(Lutador lutador) {
		
		// Verifica se ele não está com alguma magia inimiga o impedindo de atacar.
		if (this.getEstado().equals("normal")) {
			danoCritico(lutador);
		} else {
			System.out.printf("O lutador %s está congelado.\n", this.getNome());
			this.setEstado("normal");
		}
	}
	
	// Método para ver se o ataque vai ter dano critico.
	private void danoCritico(Lutador lutador) {
		double chanceDano = Math.random();
		int dano = habilidade.getDano();
		if (chanceDano > 0.5) {
			dano *= 2;
			System.out.printf("Dano critico de " + this.getNome() + ".\n");
		}
		verificaMana(lutador, dano);
	}
	
	// Verifica se o personagem tem mana suficiente, e então ataca.
	private void verificaMana(Lutador lutador, int dano) {
		if (this.mana >= habilidade.getMana()) {
			System.out.printf("Lutador %s atacou o lutador %s.\n", 
							   nome, lutador.getNome());
			lutador.recebeDano(dano);
			this.mana -= habilidade.getMana();
			if (habilidade.getTipoDano().equals("Gelo")) {
				lutador.setEstado("Congelado");
			}
		} else {
			System.out.printf("Mana insuficiente para usar a %s.\n", habilidade.getNome());
		}
	}
	
	// Método para fazer o lutador perder vida
	// private => Para que apenas a própria classe pode acessar.
	private void recebeDano(int dano) {
		this.setHP(this.getHP() - dano);
		if (this.getHP() <= 0) {
			System.out.printf("Lutador %s está desmaiado.\n", this.getNome());
			this.setHP(0);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHP() {
		return HP;
	}

	private void setHP(int hP) {
		HP = hP;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String detalhes() {
		return "Nome: " + nome + ", HP: " + HP + ", Mana: " + mana;
	}
}