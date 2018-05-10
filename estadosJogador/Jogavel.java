package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;

public class Jogavel implements PlayerState{

	private String nome;
	
	public Jogavel(){
		this.nome = "Jogavel";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void parada(Jogador j) {
		j.setEstadoAtual(new Parada());
	}
	
	public void jogavel(Jogador j) {
		j.setEstadoAtual(new Jogavel());
	}

	
	public void estourada(Jogador j) {
		j.setEstadoAtual(new Estouro());
		
	}
	
	public void blackjack(Jogador j) {
		j.setEstadoAtual(new BlackJack());
		
	}

	
	public void modificada(Mao m, Jogador j) {
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


	public void play(Banca b, Jogador j) {
		
		int entrada = b.escolhaJogador();
		
		if(entrada == 1) {
			b.darCarta(j);
		} else if (entrada == 2) {
			parada(j);
		}
		modificada(j.getMao(0),j);
		j.getEstado().play(b, j);
	}


	

}
