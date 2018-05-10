package estadosJogador;
import main.Banca;
import main.Jogador;
import main.Mao;
import main.Participante;

public class Jogavel implements PlayerState{

	private String nome;
	
	public Jogavel(){
		this.nome = "Jogavel";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void parada(Participante p) {
		p.setEstadoAtual(new Parada());
	}
	
	public void jogavel(Participante p) {
		p.setEstadoAtual(new Jogavel());
	}

	
	public void estourada(Participante p) {
		p.setEstadoAtual(new Estouro());
		
	}
	
	public void blackjack(Participante p) {
		p.setEstadoAtual(new BlackJack());
		
	}

	
	public void modificada(Mao m, Participante p) {
		if(m.blackJack()) {
			blackjack(p);
		}
		else if(m.estouro()) {
			estourada(p);
		}
		else {
			jogavel(p);
		}
	}


	public void play(Banca b, Participante p) {
		
		int entrada = b.escolhaJogador();
		
		if(entrada == 1) {
			b.darCarta(p);
		} else if (entrada == 2) {
			parada(p);
		}
		modificada(p.getMao(),p);
		p.getEstado().play(b, p);
	}


	

}
