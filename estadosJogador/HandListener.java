package estadosJogador;
import main.Jogador;
import main.Mao;

public interface HandListener {
	public void jogavel(Jogador j);
	public void estourada(Jogador j);
	public void blackjack(Jogador j);
	public void modificada(Mao m, Jogador j);
}
