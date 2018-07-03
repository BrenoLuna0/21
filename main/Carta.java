package main;

public class Carta {
	private int valor;
	private String naipe;
	private  String valorFace;
	private boolean visivel;
	
	public Carta(int valor, String naipe, String valorFace) { 
		this.valor = valor;
		this.naipe = naipe;
		this.valorFace = valorFace;
		this.visivel = true;
	}
	protected boolean faceVisivel() {
		return visivel;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	public void setValorFace(String c) {
		this.valorFace = c;
	}

	public int getValor(){
		return this.valor;
	}
	
	public String getNaipe() {
		return this.naipe;
	}
	
	public String getValorFace(){
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
