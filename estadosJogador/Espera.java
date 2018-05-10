package estadosJogador;

import main.Banca;
import main.Jogador;
import main.Mao;
import main.Participante;

public class Espera implements PlayerState {

	private String nome;

	public Espera() {
		this.nome = "Espera";
	}

	public String getNome() {
		return nome;
	}

	public void jogavel(Participante p) {
		p.setEstadoAtual(new Jogavel());
	}

	public void estourada(Participante p) {
		p.setEstadoAtual(new Estouro());
	}

	public void blackjack(Participante p) {
		p.setEstadoAtual(new BlackJack());
	}

	public void modificada(Mao m, Participante p) {
		if (m.blackJack()) {
			blackjack(p);
		} else if (m.estouro()) {
			estourada(p);
		} else {
			jogavel(p);
		}
	}

	public void play(Banca b, Participante p) {
		modificada(p.getMao(), p);
		p.getEstado().play(b, p);
	}

	public void parada(Participante p) {
	}

}