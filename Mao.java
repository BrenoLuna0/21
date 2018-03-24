
import java.util.ArrayList;

public class Mao {
	private int valorAposta;
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	
	
	public int getValorAposta() {
		return this.valorAposta;
	}
	
	public void setValorAposta(int v) {
		this.valorAposta = v;
	}
	
	public Carta getCartaMao(int i) {
		return this.mao.get(i);
	}
	
	public void setCartaMao(Carta c) {
		this.mao.add(c);
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
