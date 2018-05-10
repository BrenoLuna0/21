package main;

import estadosJogador.PlayerState;

public class BancaEsperando implements PlayerState {
	
	private String nome;
	
	public BancaEsperando() {
		this.nome = "Banca esperando";
	}

	@Override
	public void jogavel(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estourada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blackjack(Participante p) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Banca b, Participante p) {
		if(b.getMao().getPontos() < 17) {
			b.receberCarta();
			modificada(b.getMao(), p);
			b.getEstado().play(b,b);
		}
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
