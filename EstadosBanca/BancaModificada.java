package EstadosBanca;

import estadosJogador.PlayerState;
import main.Banca;
import main.Mao;
import main.Participante;

public class BancaModificada implements PlayerState {
	
	private String nome = "Banca Modificada";

	@Override
	public void jogavel(Participante p) {
		p.setEstadoAtual(new BancaEsperando());
		
	}

	@Override
	public void estourada(Participante p) {
		p.setEstadoAtual(new BancaEstourada());
		
	}

	@Override
	public void blackjack(Participante p) {
		p.setEstadoAtual(new BancaBlackJack());
		
	}

	@Override
	public void modificada(Mao m, Participante p) {
		if (m.blackJack()) {
			blackjack(p);
		} else if (m.estouro()) {
			estourada(p);
		} else {
			jogavel(p);
		}
		
	}

	@Override
	public void parada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Banca b, Participante p) {
		modificada(p.getMao(), p);
		//p.getEstado().play(b, p);
		
	}

	@Override
	public String getNome() {
		
		return this.nome;
	}

}
