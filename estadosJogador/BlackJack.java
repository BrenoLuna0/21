package estadosJogador;

import GUI.VBanca;
import main.Mao;
import main.Participante;

public class BlackJack implements PlayerState {
	
	private String nome;
	
	public BlackJack(){
		this.nome = "BlackJack";
	}
	
	public String getNome() {
		return nome;
	}

	public void parada(Participante p) {}
	
	public void jogavel(Participante p) {}


	public void estourada(Participante p) {}


	public void blackjack(Participante p) {}


	public void modificada(Mao m, Participante p) {}


	public void verificar(Mao m, Participante p) {	
	}
	
	public void play(VBanca b, Participante p) {
		b.blackJack(p);
	}

}
