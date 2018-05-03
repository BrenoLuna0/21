
public class Espera implements PlayerState{

	
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
		if(m.blackJack()) {
			blackjack(p);
		}
		else if(m.estouro()) {
			estourada(p);
		}
		else {
			jogavel(p);
		}
	}

	public void verificar(Mao m, Participante p) {
		verificar(m,p);
	}
	
	public void play(Banca b, Participante p) {
		
	}
}