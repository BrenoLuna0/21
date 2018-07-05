package EstadosBanca;
import GUI.VBanca;
import estadosJogador.PlayerState;
import main.Exibicao;
import main.Mao;
import main.Participante;

public  class BancaBlackJack implements PlayerState {
	
	private String nome;
	
	public BancaBlackJack() {
		this.nome = "BlackJack";
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
			
			
				/*while(b.getEsperando().get(i).getNome() == b.getEsperando().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getEsperando().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgDerrota3(b.getEsperando().get(i), i);
			b.perder(b.getEsperando().get(i));
			
		}
		
		for(int i = 0; i < b.getEstourados().size(); i++) {
			
			
				/*while(b.getEstourados().get(i).getNome() == b.getEstourados().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getEstourados().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgDerrota1(b.getEstourados().get(i), i);
			b.perder(b.getEstourados().get(i));
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i++) {
			
			
				/*while(b.getBlackJack().get(i).getNome() == b.getBlackJack().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getBlackJack().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgEmpate2(b.getBlackJack().get(i));
			b.empatar(b.getBlackJack().get(i));
			
		}
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}
	
}
