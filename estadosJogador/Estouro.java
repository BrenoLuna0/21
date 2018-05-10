package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;
import main.Participante;

public class Estouro implements PlayerState{
	
	private String nome;
	
	public Estouro(){
		this.nome = "Estouro";
	}
	
	public String getNome() {
		return nome;
	}

	public void parada(Participante p) {}
	
	public void jogavel(Participante p) {}


	public void estourada(Participante p) {}


	public void blackjack(Participante p) {}


	public void modificada(Mao m, Participante p) {}


	public void verificar(Mao m, Participante p) {}


	public void play(Banca b, Participante p) {
		b.estourado(p);
	}
	


}
