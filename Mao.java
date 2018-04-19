	
import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private int pontos;
	private ArrayList<Carta> cartasMao = new ArrayList<Carta>();
	private static final int BLACKJACK = 21;
	private int numAcess;
	
	// acesso a pontuação da mão
	public int getPontos() {
		this.pontos = 0;
		for(int i = 0; i < cartasMao.size(); i++) {
			this.pontos += cartasMao.get(i).getValor();
		}
		
		return this.pontos;
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
	
	public void setCartaMao(Carta c) {
		this.cartasMao.add(c);
	}
	
	// apostas

	public int getValorAposta() {
		return this.valorAposta;
	}
	
	public void setValorAposta(int v) {
		this.valorAposta = v;
	}
	
	public void setPontos() {
		this.pontos = 21;
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
		this.numAcess = 0;
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
