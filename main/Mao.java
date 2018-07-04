package main;
	
import java.util.ArrayList;

import GUI.VBanca;
import GUI.VCarta;
import estadosJogador.Espera;
import estadosJogador.HandListener;

public class Mao {
	
	private ArrayList<VCarta> cartasMao;
	private static final int BLACKJACK = 21;
	private HandListener holder;
	private Participante participante;
	private int aposta;
	
	public Mao(Jogador j) {
		this.cartasMao = new ArrayList<VCarta>();
		this.participante = j;
		
		setHolder(
				new HandListener() {
					public void jogavel(Participante p) {}
					public void estourada(Participante p) {}
					public void blackjack(Participante p) {}
					public void parada(Participante p) {}
					public void modificada(Mao m, Participante p) {
						new Espera().modificada(m, j);
					}
				}
			);
	}
	
	public Mao(Banca b) {
		this.cartasMao = new ArrayList<VCarta>();
		participante = b;
	}
	
	public void setHolder(HandListener h) {
		this.holder = h;
	}
	
	public void addCarta(VCarta c) {
		this.cartasMao.add(c);	
		this.holder.modificada(this,participante);
		
	}
	
	public void addCarta(VCarta c, Banca b) {
		this.cartasMao.add(c);
	}
	
	// acesso a pontuação da mão
	public int getPontos() {
		int pontos = 0;
		int aces = 0;
		for(int i = 0; i < cartasMao.size(); i++) {
			if(cartasMao.get(i).getValorFace() == "AS") {
				aces++;
			}
			pontos += cartasMao.get(i).getValor();
		}
		while(pontos > 21 && aces > 0) {
			pontos = pontos -10;
			aces = aces-1;
		}
		
		return pontos;
	}
	
	// acesso às cartas da mão
	
	public VCarta getCartaMao(int i) { //  acesso a uma carta especifica
		return this.cartasMao.get(i);
	}
	
	public ArrayList<VCarta> getCartasMao() { // acesso ao array c todas as cartas da mão
		return this.cartasMao;
	}

	public int qntCartas() {
		return this.cartasMao.size();
	}

	public boolean igualA (Mao m) {
		if(this.getPontos() == m.getPontos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean maiorQ (Mao m) {
		if(this.getPontos() > m.getPontos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean blackJack () {
		if(this.getPontos() == BLACKJACK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean estouro () {
		if(this.getPontos() > BLACKJACK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void limparMao() {
		getCartasMao().clear();;
	}

	public void setValorAposta(int i) {
		this.aposta = i;
		
	}
	
	public int getValorAposta() {
		return this.aposta;
	}
	
	

}

































/*import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private ArrayList <Carta> CartasMao = new ArrayList<Carta>();
	
	Mao(){
		
	}
	
	public ArrayList<Carta> getCartasMao (){
		return this.CartasMao;
	}
	
	public Carta getCartaUnica(int i) {
		return this.CartasMao.get(i);
	}
	
	public int qntCartas() {
		return this.CartasMao.size();
	}
	
	public int getValorAposta() {
		return valorAposta;
	}


	public void setValorAposta(int aposta) {
		this.valorAposta = aposta;
	}
	
	
	
}*/
