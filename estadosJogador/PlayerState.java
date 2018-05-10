package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;

public interface PlayerState extends HandListener{
	public void play(Banca b, Jogador j);
	public String getNome();
}
