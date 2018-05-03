
public class BlackJack implements PlayerState {

	public void jogavel(Participante p) {}


	public void estourada(Participante p) {}


	public void blackjack(Participante p) {}


	public void modificada(Mao m, Participante p) {}


	public void verificar(Mao m, Participante p) {	
	}
	
	public void play(Banca b, Participante p) {
		b.blackJack(p);
	}

}
