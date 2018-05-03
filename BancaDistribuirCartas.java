
public  class BancaDistribuirCartas implements PlayerState {

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
		
		b.distribuirCartas();
	}

}
