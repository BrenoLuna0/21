import java.util.ArrayList;

public class Banca extends Participante {
	
	private Mao maob = new Mao(this);
	private ArrayList<Participante>estourados = new ArrayList<Participante>();
	private ArrayList<Participante>blackJack = new ArrayList<Participante>();
	private ArrayList<Participante>esperando = new ArrayList<Participante>();
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private RepositorioCartas rep;
	
	public void estourado(Participante p) {
		this.estourados.add(p);
		
	}
	
	public void blackJack(Participante p) {
		this.blackJack.add(p);
	}
	
	public void esperando(Participante p){
		this.esperando.add(p);
	}
	
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
		this.maob.addCarta(c.get(0));
		Exibicao.recebimentoCarta(c.get(0));
		c.remove(0);
	}
	
	public Mao getMao() { // retorna uma m�o especifica p fazer a jogada 
			return this.maob; 
	}
	
	public void removerMaos(ArrayList<Jogador> j) {
		for(int i = 0; i < j.size(); i++) {  // percorre todos os jogadores
			for(int a = 0 ; a < j.get(i).getArrayMao().size(); a++) { // percorre todas as m�os dos jogadores
				j.get(i).getArrayMao().remove(a); // remove todas as m�os para continuar a proxima rodada
			}
		}
	}


	public void distribuirCartas() {
		
		for (int i = 0; i < this.jogadores.size(); i++) { // distribui primeira carta p todos os jogadores
			this.darCarta(this.rep.getRepositorio(), this.jogadores.get(i), 0);
		}

		this.receberCarta(this.rep.getRepositorio()); // d� a primeira carta p banca

		for (int i = 0; i < this.jogadores.size(); i++) { // distribui a segunda carta p todos os jogadores
			this.darCarta(this.rep.getRepositorio(), this.jogadores.get(i), 0);
		}

		this.receberCarta(this.rep.getRepositorio()); // d� a segunda carta p banca
		
	}
	
	public void jogada(ArrayList<Jogador> jogadores, RepositorioCartas rep,int pontuacaoMaxima){
		Exibicao.rodadaBanca();
		Exibicao.mostrarTodasCartasBanca(this);
		int jogosGanhos = 0;
		
		for(int i = 0; i < jogadores.size(); i++) {
			if(this.getMao().getPontos() > jogadores.get(i).getMao(0).getPontos() || jogadores.get(i).getMao(0).getPontos() > pontuacaoMaxima) {
				jogosGanhos += 1;
			}
		}
		
		if(jogosGanhos > (jogadores.size())/2) { // se a banca estiver vencendo da maioria dos jogadores
			return; //nao faz nada
		}else {
			while(this.getMao().getPontos() < 16) { // sen�o ela pega mais cartas
				this.receberCarta(rep.getRepositorio());		
			}
			return;
		}
	}
	
	public ArrayList<Participante> getEstourados(){
		return this.estourados;
	}
	
	public ArrayList<Participante> getBlackJack(){
		return this.blackJack;
	}
	
	public ArrayList<Participante> getEsperando(){
		return this.esperando;
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
