package main;
import java.util.ArrayList;
import java.util.Scanner;

import EstadosBanca.BancaEsperando;

public class Banca extends Participante {
	
	public static final int pontuacaoMaxima = 21;
	public static final int apostaMinima = 25;
	
	private ArrayList<Participante>estourados = new ArrayList<Participante>();
	private ArrayList<Participante>blackJack = new ArrayList<Participante>();
	private ArrayList<Participante>esperando = new ArrayList<Participante>();
	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private RepositorioCartas rep;
	
	public Banca() {
		mao = new Mao(this);
		super.setEstadoAtual(new BancaEsperando());
	}
	
	public void instanciarJogadores(int q) {
		for (int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
			Exibicao.nomeJogador(i);
			String entrada = new Scanner(System.in).nextLine();
			jogadores.add(new Jogador(entrada));
		}
	}
	
	public void visualizarjogadores() { // depuração
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).visualizarInfo();
			jogadores.get(i).visualizarMao();
		}
	}

	public void instanciarNovoBaralho() {
		this.rep = new RepositorioCartas();
		embaralhar(this.rep.getRepositorio());
	}
	
	public void estourado(Participante p) {
		this.estourados.add(p);	
	}
	
	public void blackJack(Participante p) {
		this.blackJack.add(p);
	}
	
	public void esperando(Participante p){
		this.esperando.add(p);
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
	
	public void rodada() {
		//this.distribuirCartas();

		Exibicao.inicio();
		
		for (int i = 0; i < jogadores.size(); i++) {
			Exibicao.inicioJogada(jogadores.get(i));
			Exibicao.opcoesJogada(jogadores.get(i));
			jogadores.get(i).getEstado().play(this,jogadores.get(i));// realiza a jogada de todos os jogadores
		}
		
		super.getEstado().play(this, this);
	}
	
	public void darCarta(Participante p) {
		p.receberCarta(this.rep.getRepositorio().get(0)); // da a carta p o jogador passando cmo parametro apenas a carta
		Exibicao.recebimentoCarta(p,this.rep.getRepositorio().get(0));
		this.rep.getRepositorio().remove(0); // remove a carta entregue do repositorio
	}
	
	public ArrayList<Carta> getRep() {
		return this.rep.getRepositorio();
	}
	
	public RepositorioCartas getRepositorio() { // depuração
		return this.rep;
	}
	
	public int escolhaJogador() {
		Scanner s = new Scanner(System.in);
		int entrada = s.nextInt();
		
		while (entrada < 1 || entrada > 2) { // valida a entrada do jogador
			entrada = s.nextInt();
			return entrada;
		}
		
		return entrada;
	}
	
	public void distribuirCartas() {
		
		for (int i = 0; i < this.jogadores.size(); i++) { // distribui primeira carta p todos os jogadores
			this.darCarta(this.jogadores.get(i));
		}

		this.receberCarta(); // dá a primeira carta p banca

		for (int i = 0; i < this.jogadores.size(); i++) { // distribui a segunda carta p todos os jogadores
			this.darCarta(this.jogadores.get(i));
		}

		this.receberCarta(); // dá a segunda carta p banca
		
	}
	
	
	// metodos antigos q precisam ser revisados
	//.
	//.
	//.
	//.
	//.
	
	private void apostas() {
		Scanner s = new Scanner(System.in);
		int entrada;
		Exibicao.rodadaApostas();
		for (int i = 0; i < jogadores.size(); i++) { // recebe as apostas de cada jogador
			Exibicao.apostaJogador(this.jogadores.get(i));
			entrada = s.nextInt();

			while (entrada < 25 || entrada > 75) { // valida a entrada do jogador
				Exibicao.apostaInvalida();
				entrada = s.nextInt();
			}

			jogadores.get(i).apostar(entrada); // realiza a aposta
			Exibicao.confirmacaoAposta(this.jogadores.get(i), entrada);
		}
	}
	
	public ArrayList<Carta> embaralhar(ArrayList<Carta> c) {
		Utilidade.misturar(c);
		return c;
	}
	
	
	public void receberCarta() {
		super.mao.addCarta(rep.getRepositorio().get(0), this);
		//Exibicao.recebimentoCarta(c.get(0));
		//rep.getRepositorio().remove(0);
	}
	
	/*public Mao getMao() { // retorna uma mão especifica p fazer a jogada 
			return this.maob; 
	}*/
	


	


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
