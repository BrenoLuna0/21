package EstadosBanca;

import GUI.VBanca;
import estadosJogador.Ganhou;
import estadosJogador.Perdeu;
import estadosJogador.PlayerState;
import main.Banca;
import main.Exibicao;
import main.Mao;
import main.Participante;

public class BancaParada implements PlayerState {
	
	private String nome;
	
	public BancaParada() {
		this.nome = "Parada";
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
	public void play(VBanca b, Participante p) {
		
		for(int i = 0; i < b.getEsperando().size(); i++) {
			if(b.getEsperando().get(i).getMao().igualA(b.getMao())) { // se o jogador e a banca tiverem a mesma pontuação
				
				Exibicao.msgEmpate2(b.getEsperando().get(i));
				b.empatar(b.getEsperando().get(i));
				
			}else if(b.getEsperando().get(i).getMao().maiorQ(b.getMao())) { // se o jogador tem mais pontos q a banca
				
				Exibicao.msgVitoria2(b.getEsperando().get(i), i);
				b.ganhar(b.getEsperando().get(i));
				
			} else { // se o jogador tiver menos pontos q a banca

				Exibicao.msgDerrota2(b.getEsperando().get(i), i);
				b.perder(b.getEsperando().get(i));
			}
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) { //para todos os jogadores que fizeram black Jack
			
			Exibicao.msgVitoria3(b.getBlackJack().get(i), i);
			b.ganharBlackJack(b.getBlackJack().get(i));
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) { //para todos os jogadores que estouraram
			
			Exibicao.msgDerrota1(b.getEstourados().get(i), i);
			b.perder(b.getEstourados().get(i));
		}
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
