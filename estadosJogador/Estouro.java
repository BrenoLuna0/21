package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;

public class Estouro implements PlayerState{


	public void jogavel(Jogador j) {}


	public void estourada(Jogador j) {}


	public void blackjack(Jogador j) {}


	public void modificada(Mao m, Jogador j) {}


	public void verificar(Mao m, Jogador j) {}


	public void play(Banca b, Jogador j) {
		b.estourado(j);
	}
	


}
