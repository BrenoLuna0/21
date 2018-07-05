package main;
import java.util.Scanner;

import GUI.VMao;

public class Jogador extends Participante {
	

	public Jogador(String nome) {
		this.nome = nome;
		//this.setEstadoAtual(new Espera());
		mao = new VMao(this);
		super.dinheiro = 300;
	}
	
	public void apostar() {
		int aposta;
		Scanner s = new Scanner(System.in);
		
		Exibicao.apostaJogador(this);
		aposta = s.nextInt();
		while(aposta < 25 || aposta > 75) {
			Exibicao.apostaInvalida();
			aposta = s.nextInt();
		}
		
		dinheiro = dinheiro - aposta;
		mao.setValorAposta(aposta);
	}
	
	public void apostar25() {
		dinheiro = dinheiro - 25;
		mao.setValorAposta(25);
	}
	
	public void apostar50() {
		dinheiro = dinheiro - 50;
		mao.setValorAposta(50);
	}
	
	public void apostar75() {
		dinheiro = dinheiro - 75;
		mao.setValorAposta(75);
	}
	
}