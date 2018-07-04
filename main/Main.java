
package main;

import GUI.VBanca;
import estadosJogador.Ganhou;

public class Main {

	public static void main(String[] args) {
		
		VBanca b = new VBanca();
	
		b.instanciarNovoBaralho(); // ok  b.getRepositorio().visualizarBaralho();
		
		b.instanciarJogadores(1); // ok  
		
		b.distribuirCartas(); // ok	
		
		b.initView();
		
		b.rodada();
		
	}

}