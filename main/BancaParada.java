package main;

import estadosJogador.PlayerState;

public class BancaParada implements PlayerState {
	
	private String nome;
	
	public BancaParada() {
		this.nome = "Banca parada";
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Banca b, Participante p) {
		
		for(int i = 0; i < b.getEsperando().size(); i++) {
			if(b.getEsperando().get(i).getMao().igualA(b.getMao())) {
				b.getEsperando().get(i);//.empatou();
			}else if(b.getEsperando().get(i).getMao().maiorQ(b.getMao())) {
				b.getEsperando().get(i);//.ganhou
			} else {
				b.getEsperando().get(i);//.perdeu
			}
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) {
			b.getBlackJack().get(i);//.ganhou
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) {
			b.getEstourados().get(i);//.perdeu
		}
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
