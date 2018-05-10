package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;
import main.Participante;

public interface PlayerState extends HandListener{
	public void play(Banca b, Participante p);
	public String getNome();
}
