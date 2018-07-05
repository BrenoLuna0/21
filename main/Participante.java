package main;

import GUI.VCarta;
import GUI.VMao;
import estadosJogador.PlayerListener;
import estadosJogador.PlayerState;

public abstract class Participante {

	private PlayerState estadoAtual;
	private PlayerListener OptionControllerlistener;
	private PlayerListener viewListener;
	protected VMao mao;
	protected String nome;
	protected double dinheiro;
	
	public void addOptionListener(PlayerListener l) {
		OptionControllerlistener = l;
	}
	
	public void addListener(PlayerListener l) {
		viewListener = l;
	}
	
	public void setEstadoAtual(PlayerState s) {
		this.estadoAtual = s;
		if(OptionControllerlistener != null) {
			switch(estadoAtual.getNome()) {
			
				case "Estouro":
					OptionControllerlistener.jogadorEstourou(this);
					viewListener.jogadorEstourou(this);
					break;
				case "BlackJack":
					OptionControllerlistener.jogadorBlackJack(this);
					viewListener.jogadorBlackJack(this);
					break;
				case "Espera":
					OptionControllerlistener.jogadorEsperando(this);
					viewListener.jogadorEsperando(this);
				case "Jogavel":
					OptionControllerlistener.jogadorModificado(this);
					viewListener.jogadorModificado(this);
					break;
				case "Parada":
					OptionControllerlistener.jogadorParou(this);
					viewListener.jogadorParou(this);
					break;
				case "Ganhou":
					OptionControllerlistener.jogadorGanhou(this);
					viewListener.jogadorGanhou(this);
					break;
				case "Perdeu":
					OptionControllerlistener.jogadorPerdeu(this);
					viewListener.jogadorPerdeu(this);
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