package main;
import java.util.ArrayList;

import estadosJogador.PlayerListener;
import estadosJogador.PlayerState;

public abstract class Participante {

	private PlayerState estadoAtual;
	private PlayerListener listener;
	protected Mao mao;
	protected String nome;
	protected double dinheiro;
	
	public void setEstadoAtual(PlayerState s) {
		this.estadoAtual = s;
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
	
	public void receberCarta(Carta c) {
		mao.addCarta(c);
	}
	
	public void visualizarInfo() { // depura��o
		System.out.println("Nome: " + nome);
		System.out.println("Pontua��o da m�o: " + mao.getPontos());
		System.out.println("Estado Atual: " + this.getEstado().getNome());
	}
	
	public void visualizarMao() { // depura��o
		System.out.println("Mao do "+ nome);
		for(int i = 0; i < mao.getCartasMao().size(); i++) {
				System.out.println(mao.getCartaMao(i).getValorFace() + " de " + mao.getCartaMao(i).getNaipe());
		}
		System.out.println("======================");
	}
	
	public void atualizarDinheiro(double d) {
		this.dinheiro = dinheiro + d;
		System.out.println("Seu novo saldo � de "+ dinheiro);
	}
	
	public double getDinheiro() {
		return this.dinheiro;
	}
	
	// metodos antigos q precisam ser revisados
	//.
	//.
	//.
	//.
	//.
	//.
	//.

	/*public void retiraDinheiro(int i) {
		if (getDinheiro() > 0) {
			this.dinheiro -= i;
		}
	}

	public void recebeDinheiro(int i) {
		this.dinheiro += i;
	}

	// metodos de acesso a membros

	public void setCartaMao(Carta c, int n) { // da uma carta p a mao selecionada
	
		if (this.mao.size() == 0) { 
			Mao m = new Mao(this);
			this.mao.add(m);
			this.mao.get(n).addCarta(c);
		} else {
			this.mao.get(n).addCarta(c);
		}
		
	}

	public ArrayList<Mao> getArrayMao() { // retorna o array list c todas as m�os do jogador
		return this.mao; // usado p saber a quantidade de m�os
	}

	public Mao getMao(int i) { // retorna uma m�o especifica p fazer a jogada
		if (this.mao.size() > i) { // s� retorna a m�o desejada se o parametro passado estiver
			return this.mao.get(i); // dentro do tamanho do array
		} else {
			return null; // ver oq fazer depois c essa merda
		}
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}*/

}