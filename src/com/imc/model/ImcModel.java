package com.imc.model;


public class ImcModel {
	private int idade;
	private double altura;
	private double peso;
	
	
	public double calcularImc(double altura,double peso) {
		double imc =  altura/(peso*peso);
		return imc;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
		
	
	
	

}
