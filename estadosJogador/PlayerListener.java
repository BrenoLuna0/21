package estadosJogador;
import main.Jogador;
import main.Participante;

public interface PlayerListener {
	public void jogadorModificado(Participante p);
	public void jogadorEstourou(Participante p);
	public void jogadorBlackJack(Participante p);
	public void jogadorEsperando(Participante p);
	public void jogadorGanhou(Participante p);
	public void jogadorPerdeu(Participante p);
	public void jogadorParou(Participante p);
}
