package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;

public class Espera implements PlayerState{

	
	public void jogavel(Jogador j) {
		j.setEstadoAtual(new Jogavel());
	}


	public void estourada(Jogador j) {
		j.setEstadoAtual(new Estouro());
	}

	
	public void blackjack(Jogador j) {
		j.setEstadoAtual(new BlackJack());	
	}

	
	public void modificada(Mao m,Jogador j) {
		if(m.blackJack()) {
			blackjack(j);
		}
		else if(m.estouro()) {
			estourada(j);
		}
		else {
			jogavel(j);
		}
	}
	
	public void play(Banca b,Jogador j) {
		modificada(j.getArrayMao().get(0),j);
		j.getEstado().play(b, j);
	}


	public void parada(Jogador j) {}
	
}