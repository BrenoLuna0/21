package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;

public class Parada implements PlayerState{

	private String nome;
	
	public Parada(){
		this.nome = "Parada";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void parada(Jogador j) {}
	
	public void jogavel(Jogador j) {}


	public void estourada(Jogador j) {}


	public void blackjack(Jogador j) {}


	public void modificada(Mao m, Jogador j) {}


	public void verificar(Mao m, Jogador j) {}


	public void play(Banca b, Jogador j) {
		return;
	}

}
