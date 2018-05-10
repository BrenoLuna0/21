package EstadosBanca;

import estadosJogador.PlayerState;
import main.Banca;
import main.Exibicao;
import main.Mao;
import main.Participante;

public class BancaParada implements PlayerState {
	
	private String nome;
	
	public BancaParada() {
		this.nome = "Banca parada";
	}

	@Override
	public void jogavel(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estourada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blackjack(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificada(Mao m, Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Banca b, Participante p) {
		
		for(int i = 0; i < b.getEsperando().size(); i++) {
			if(b.getEsperando().get(i).getMao().igualA(b.getMao())) {
				
				Exibicao.msgEmpate2(b.getEsperando().get(i));
				
				
			}else if(b.getEsperando().get(i).getMao().maiorQ(b.getMao())) {
				
				Exibicao.msgVitoria2(b.getEsperando().get(i), i);
				
			} else {

				Exibicao.msgDerrota2(b.getEsperando().get(i), i);
			}
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) {
			
			Exibicao.msgVitoria3(b.getBlackJack().get(i), i);
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) {
			
			Exibicao.msgDerrota1(b.getEstourados().get(i), i);
		}
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
