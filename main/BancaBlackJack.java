package main;
import estadosJogador.PlayerState;

public  class BancaBlackJack implements PlayerState {
	
	private String nome;
	
	public BancaBlackJack() {
		this.nome = "Banca BlackJack";
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
			b.getEsperando().get(i);//.perdeu();
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) {
			b.getEstourados().get(i);//.perdeu();
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) {
			b.getBlackJack().get(i);//.empate();
		}
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}
	
}
