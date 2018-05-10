package estadosJogador;

import main.Banca;
import main.Exibicao;
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
		Exibicao.infoJogavel(p);
	}

	public void estourada(Participante p) {
		p.setEstadoAtual(new Estouro());
		Exibicao.infoEstourado(p);
	}

	public void blackjack(Participante p) {
		p.setEstadoAtual(new BlackJack());
		Exibicao.infoBlackJack(p);
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

	public void parada(Participante p) {}

}