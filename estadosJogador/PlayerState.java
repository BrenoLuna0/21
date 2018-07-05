package estadosJogador;
import GUI.VBanca;
import main.Participante;

public interface PlayerState extends HandListener{
	public void play(VBanca b, Participante p);
	public String getNome();
}
