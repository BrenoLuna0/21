package main;
import estadosJogador.PlayerState;

public class BancaEstourada implements PlayerState {

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
	public void verificar(Mao m, Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Banca b, Participante p) {
		
		for(int i = 0; i < b.getEstourados().size(); i++){
			b.getEstourados().get(i);//.perdeu(); TEM Q IMPLEMENTAR ISSO DAQUI RÁPIDO
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i ++){
			b.getBlackJack().get(i);//.ganhou(); TEM Q IMPLEMENTAR ISSO DAQUI RÁPIDO
		}
		
		for(int i = 0; i < b.getEsperando().size(); i++){
			b.getEsperando().get(i);//.ganhou(); TEM Q IMPLEMENTAR ISSO MAIS Q URGENTE
		}
	}

}
