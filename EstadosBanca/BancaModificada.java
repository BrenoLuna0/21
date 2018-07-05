package EstadosBanca;

import GUI.VBanca;
import estadosJogador.PlayerState;
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
	public void parada(Participante p) {}

	@Override
	public void play(VBanca b, Participante p) {
		modificada(p.getMao(), p);	
	}

	@Override
	public String getNome() {
		
		return this.nome;
	}

}
