	
import java.util.ArrayList;

public class Mao {
	
	private ArrayList<Carta> cartasMao;
	private static final int BLACKJACK = 21;
	private HandListener holder;
	private Participante participante;
	
	public Mao(Participante p) {
		this.cartasMao = new ArrayList<Carta>();
		this.participante = p;
	}
	
	public void addCarta(Carta c) {
		this.cartasMao.add(c);	
		this.holder.modificada(this,this.participante);
	}
	
	// acesso a pontuação da mão
	public int getPontos() {
		int pontos = 0;
		for(int i = 0; i < cartasMao.size(); i++) {
			pontos += cartasMao.get(i).getValor();
		}
		
		return pontos;
	}
	
	// acesso às cartas da mão
	
	public Carta getCartaMao(int i) { //  acesso a uma carta especifica
		return this.cartasMao.get(i);
	}
	
	public ArrayList<Carta> getArrayMao() { // acesso ao array c todas as cartas da mão
		return this.cartasMao;
	}

	public int qntCartas() {
		return this.cartasMao.size();
	}

	public boolean igualA (Mao m) {
		if(this.getPontos() == m.getPontos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean maiorQ (Mao m) {
		if(this.getPontos() > m.getPontos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean blackJack () {
		if(this.getPontos() == BLACKJACK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean estouro () {
		if(this.getPontos() > BLACKJACK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void limparMao() {
		this.getArrayMao().clear();
	}

	public void setValorAposta(int i) {
		// TODO Auto-generated method stub
		
	}
	

}

































/*import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private ArrayList <Carta> CartasMao = new ArrayList<Carta>();
	
	Mao(){
		
	}
	
	public ArrayList<Carta> getCartasMao (){
		return this.CartasMao;
	}
	
	public Carta getCartaUnica(int i) {
		return this.CartasMao.get(i);
	}
	
	public int qntCartas() {
		return this.CartasMao.size();
	}
	
	public int getValorAposta() {
		return valorAposta;
	}


	public void setValorAposta(int aposta) {
		this.valorAposta = aposta;
	}
	
	
	
}*/
