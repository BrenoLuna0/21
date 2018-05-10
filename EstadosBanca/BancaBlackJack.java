package EstadosBanca;
import estadosJogador.PlayerState;
import main.Banca;
import main.Exibicao;
import main.Mao;
import main.Participante;

public  class BancaBlackJack implements PlayerState {
	
	private String nome;
	
	public BancaBlackJack() {
		this.nome = "Banca BlackJack";
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
			
			Exibicao.msgDerrota3(b.getEsperando().get(i), i);
			
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) {
			
			Exibicao.msgDerrota1(b.getEstourados().get(i), i);
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) {
			
			Exibicao.msgEmpate2(b.getBlackJack().get(i));
			
		}
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}
	
}
