package estadosJogador;
import main.Jogador;
import main.Mao;
import main.Participante;

public interface HandListener {
	public void jogavel(Participante p);
	public void estourada(Participante p);
	public void blackjack(Participante p);
	public void modificada(Mao m, Participante p);
	public void parada(Participante p);
}
