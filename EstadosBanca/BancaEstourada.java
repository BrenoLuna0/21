package EstadosBanca;
import GUI.VBanca;
import estadosJogador.PlayerState;
import main.Exibicao;
import main.Mao;
import main.Participante;

public class BancaEstourada implements PlayerState {
	private String nome;
	
	public BancaEstourada() {
		this.nome = "Estouro";
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

	/*@Override
	public void verificar(Mao m, Jogador j) {
		// TODO Auto-generated method stub
		
	}*/
	
	

	@Override
	public void play(VBanca b, Participante p) {
		
		for(int i = 0; i < b.getEstourados().size(); i++){
			
				/*while(b.getEstourados().get(i).getNome() == b.getEstourados().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getEstourados().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgEmpate(b.getEstourados().get(i));
			b.empatar(b.getEstourados().get(i));
		}
		
		for(int i = 0; i < b.getBlackJack().size(); i ++){
			
			
				/*while(b.getBlackJack().get(i).getNome() == b.getBlackJack().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getBlackJack().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgVitoria1(b.getBlackJack().get(i), i);
			b.ganharBlackJack(b.getBlackJack().get(i));
		}
		
		for(int i = 0; i < b.getEsperando().size(); i++){
			
			
				/*while(b.getEsperando().get(i).getNome() == b.getEsperando().get(i+1).getNome()) {
					i+=1;
					if(i == (b.getEsperando().size()+1)) {
						break;
					}
				}*/
			
			
			Exibicao.msgVitoria1(b.getEsperando().get(i), i);
			b.ganhar(b.getEsperando().get(i));
		}
	}

	@Override
	public void parada(Participante p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
