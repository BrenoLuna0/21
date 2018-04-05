	
import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private int pontos;
	private ArrayList<Carta> cartasMao = new ArrayList<Carta>();
	
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
