package main;
import java.util.ArrayList;

import GUI.VCarta;
import estadosJogador.PlayerListener;
import estadosJogador.PlayerState;

public abstract class Participante {

	private PlayerState estadoAtual;
	private PlayerListener Optionlistener;
	private PlayerListener listener;
	protected Mao mao;
	protected String nome;
	protected double dinheiro;
	
	public void addOptionListener(PlayerListener l) {
		Optionlistener = l;
	}
	
	public void addListener(PlayerListener l) {
		listener = l;
	}
	
	public void setEstadoAtual(PlayerState s) {
		this.estadoAtual = s;
		if(Optionlistener != null) {
			switch(estadoAtual.getNome()) {
			
				case "Estouro":
					Optionlistener.jogadorEstourou(this);
					listener.jogadorEstourou(this);
					break;
				case "BlackJack":
					Optionlistener.jogadorBlackJack(this);
					listener.jogadorBlackJack(this);
					break;
				case "Espera":
					Optionlistener.jogadorEsperando(this);
					listener.jogadorEsperando(this);
				case "Jogavel":
					Optionlistener.jogadorModificado(this);
					listener.jogadorModificado(this);
					break;
				case "Parada":
					Optionlistener.jogadorParou(this);
					listener.jogadorParou(this);
					break;
			
			}
		}
	}
	
	public PlayerState getEstado(){
		return this.estadoAtual;
	}
	
	public Mao getMao() {
		return mao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void receberCarta(VCarta c) {
		mao.addCarta(c);
	}
	
	public void visualizarInfo() { // depuração
		System.out.println("Nome: " + nome);
		System.out.println("Pontuação da mão: " + mao.getPontos());
		System.out.println("Estado Atual: " + this.getEstado().getNome());
	}
	
	public void visualizarMao() { // depuração
		System.out.println("Mao do "+ nome);
		for(int i = 0; i < mao.getCartasMao().size(); i++) {
				System.out.println(mao.getCartaMao(i).getValorFace() + " de " + mao.getCartaMao(i).getNaipe());
		}
		System.out.println("======================");
	}
	
	public void atualizarDinheiro(double d) {
		this.dinheiro = dinheiro + d;
		System.out.println("Seu novo saldo é de "+ dinheiro);
	}
	
	public double getDinheiro() {
		return this.dinheiro;
	}
	
}