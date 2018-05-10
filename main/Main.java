package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Banca b = new Banca();
		
		b.instanciarNovoBaralho(); // ok  b.getRepositorio().visualizarBaralho();
		
		b.instanciarJogadores(1); // ok  
		
		b.rodadaApostas(); // ok
		
		b.distribuirCartas(); // ok	
		
		b.visualizarjogadores();
		
		b.rodada(); //ok
			
		
	}

}