	
import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private int pontos;
	private ArrayList<Carta> cartasMao = new ArrayList<Carta>();
	
	
	public int getValorAposta() {
		return this.valorAposta;
	}
	
	public void setValorAposta(int v) {
		this.valorAposta = v;
	}
	
	public Carta getCartaMao(int i) {
		return this.cartasMao.get(i);
	}
	
	public void setCartaMao(Carta c) {
		this.cartasMao.add(c);
	}
	
	public int getPontos() {
		this.pontos = 0;
		for(int i = 0; i < cartasMao.size(); i++) {
			this.pontos += cartasMao.get(i).getValor();
		}
		
		return this.pontos;
	}
	
	public Carta getCartaUnica(int i) {
		return this.cartasMao.get(i);
	}
	
	public int qntCartas() {
		return this.cartasMao.size();
	}

	public ArrayList<Carta> getArrayMao() {
		return this.cartasMao;
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
