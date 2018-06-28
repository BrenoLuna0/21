package main;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.JFrame;

import GUI.OptionView;
import GUI.VBanca;
import GUI.ViewCartas;
import GUI.ViewJogador;

public class Main {

	public static void main(String[] args) {
		
		VBanca b = new VBanca();
		
		JFrame j = new JFrame();
		
		b.instanciarNovoBaralho(); // ok  b.getRepositorio().visualizarBaralho();
		
		b.instanciarJogadores(1); // ok  
		
		b.distribuirCartas(); // ok	
		
		ViewCartas v = new ViewCartas(b.getRepositorio().getRepositorio().get(0));
		OptionView op = new OptionView(b.getJogador(0),b);
		ViewJogador vj = new ViewJogador(b.getJogador(0));
		
		
		j.add(op);		
		vj.jogadorModificado(b.getJogador(0));
		j.add(vj);
		
		j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setVisible(true);
		
		
		
		System.out.println("ae");
			
		
	}

}