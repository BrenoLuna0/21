package EstadosBanca;

import estadosJogador.BlackJack;
import estadosJogador.Estouro;
import estadosJogador.Jogavel;
import estadosJogador.PlayerState;
import main.Banca;
import main.Mao;
import main.Participante;

public class BancaEsperando implements PlayerState {
	
	private String nome;
	
	public BancaEsperando() {
		this.nome = "Banca esperando";
	}

	@Override
	public void jogavel(Participante p) {
		p.setEstadoAtual(new BancaEsperando());
		
	}

	@Override
	public void estourada(Participante p) {
		p.setEstadoAtual(new BancaEstourada());
		
	}

	@Override
	public void blackjack(Participante p) {
		p.setEstadoAtual(new BancaBlackJack());
		
	}

	@Override
	public void modificada(Mao m, Participante p) {
		if (m.blackJack()) {
			blackjack(p);
		} else if (m.estouro()) {
			estourada(p);
		} else {
			jogavel(p);
		}
		
	}

	@Override
	public void parada(Participante p) {
		p.setEstadoAtual(new BancaParada());
		
	}

	@Override
	public void play(Banca b, Participante p) {
		if(b.getMao().getPontos() < 17) {
			b.receberCarta();
			modificada(b.getMao(), p);
		} else {
			parada(b);
		}
		
		b.getEstado().play(b,b);
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
