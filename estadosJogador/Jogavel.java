package estadosJogador;
import main.Banca;
import main.Exibicao;
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
		Exibicao.infoParada(p);
	}
	
	public void jogavel(Participante p) {
		p.setEstadoAtual(new Jogavel());
		Exibicao.infoJogavel(p);
	}

	
	public void estourada(Participante p) {
		p.setEstadoAtual(new Estouro());
		Exibicao.infoEstourado(p);
		
	}
	
	public void blackjack(Participante p) {
		p.setEstadoAtual(new BlackJack());
		Exibicao.infoBlackJack(p);
		
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
		Exibicao.opcoesJogada(p);
		if(entrada == 1) {
			b.darCarta(p);
			p.visualizarInfo();
			p.visualizarMao();
		} else if (entrada == 2) {
			parada(p);
		}
		
		p.getEstado().play(b, p);
	}


	

}
