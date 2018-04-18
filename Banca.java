import java.util.ArrayList;

public class Banca extends Participante {
	
	private Mao maob = new Mao();
	
	
	public ArrayList<Carta> embaralhar(ArrayList<Carta> c) {
		Utilidade.misturar(c);
		return c;
	}
	
	public void darCarta(ArrayList<Carta> c, Jogador j, int m) {
		j.setCartaMao(c.get(0), m);
		Exibicao.recebimentoCarta(j,c.get(0));
		c.remove(0);
	}
	
	public void receberCarta(ArrayList<Carta> c) {
		this.maob.setCartaMao(c.get(0));
		Exibicao.recebimentoCarta(c.get(0));
		c.remove(0);
	}
	
	public Mao getMao() { // retorna uma mão especifica p fazer a jogada 
			return this.maob; 
	}
	
public void removerMaos(ArrayList<Jogador> j) {
		for(int i = 0; i < j.size(); i++) {  // percorre todos os jogadores
			for(int a = 0 ; a < j.get(i).getArrayMao().size(); a++) { // percorre todas as mãos dos jogadores
				j.get(i).getArrayMao().remove(a); // remove todas as mãos para continuar a proxima rodada
			}
		}
	}

}





































/*public class Banca extends Participante {
	
	private Carta cartaAberta;
	private Carta cartaFechada;
	//private int pontos;
	
	
	
	public Carta getCartaAberta() {
		return cartaAberta;
	}
	public void setCartaAberta(Carta cartaAberta) {
		this.cartaAberta = cartaAberta;
	}
	public Carta getCartaFechada() {
		return cartaFechada;
	}
	public void setCartaFechada(Carta cartaFechada) {
		this.cartaFechada = cartaFechada;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	

}*/
