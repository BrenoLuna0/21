package main;

public class Carta {
	private int valor;
	private String naipe;
	private  char valorFace;
	
	public Carta(int valor, String naipe, char valorFace) { 
		this.valor = valor;
		this.naipe = naipe;
		this.valorFace = valorFace;
	}
	
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	public void setValorFace(char c) {
		this.valorFace = c;
	}

	public int getValor(){
		return this.valor;
	}
	
	public String getNaipe() {
		return this.naipe;
	}
	
	public char getValorFace(){
		return this.valorFace;
	}

}


































/*
public class Carta {
	
	private int valor;
	private String naipe;
	private boolean retirado;

	public int getValor(){
		return this.valor;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String getNaipe() {
		
		return this.naipe;
	}

	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
	
	public boolean getRetirado() {
		return this.retirado;
	}
	
	

}*/