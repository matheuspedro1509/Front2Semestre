package br.com.fiap.model;

public class Comida {

	private String nome;
	
	private double preco;
	
	private float peso;

	
	public Comida(String nome, double preco, float peso) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.peso = peso;
	}

	public Comida() {
		super();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
}
