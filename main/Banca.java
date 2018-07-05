package main;
import java.util.ArrayList;
import java.util.Scanner;

import EstadosBanca.BancaEsperando;
import EstadosBanca.BancaModificada;
import GUI.GUIJogador;
import GUI.VBanca;
import GUI.VCarta;
import GUI.VMao;
import GUI.VRepositorio;
import GUI.ViewJogador;
import estadosJogador.Aposta;
import estadosJogador.Ganhou;
import estadosJogador.Parada;
import estadosJogador.Perdeu;

public class Banca extends Participante {
	
	private boolean ganhar;
	private boolean perder;
	private boolean ganharBlackJack;
	private boolean empatar;
	
	public static final int pontuacaoMaxima = 21;
	public static final int apostaMinima = 25;
	
	private ArrayList<Participante>estourados = new ArrayList<Participante>();
	private ArrayList<Participante>blackJack = new ArrayList<Participante>();
	private ArrayList<Participante>esperando = new ArrayList<Participante>();
	
	public ArrayList<GUIJogador> jogadores = new ArrayList<GUIJogador>();
	public ArrayList<ViewJogador>viewJogadores = new ArrayList<ViewJogador>();
	private VRepositorio rep;
	
	
	
	
	public Banca() {
		ganhar =  true;
		perder = true;
		ganharBlackJack = true;
		empatar = true;
		mao = new VMao(this);
		super.setEstadoAtual(new BancaEsperando());
		nome = "Banca";
	}
	
	public GUIJogador getJogador(int i) {
		return jogadores.get(i);
	}
	
	public void instanciarJogadores(int q) {
		for (int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
			Exibicao.nomeJogador(i);
			String entrada = new Scanner(System.in).nextLine();
			
			GUIJogador jogador = new GUIJogador(entrada);
			jogador.setEstadoAtual(new Aposta());
			jogadores.add(jogador);
			
			ViewJogador view = new ViewJogador(jogador);
			viewJogadores.add(view);
		}
	}
	
	public void visualizarjogadores() { // depuração
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).visualizarInfo();
			jogadores.get(i).visualizarMao();
		}
	}

	public void instanciarNovoBaralho() {
		this.rep = new VRepositorio();
		embaralhar(this.rep.getRepositorio());
		Utilidade.changeAce(this.rep.getRepositorio());
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
		if(this.getEstado().getNome() == "Banca BlackJack"){
			
			for(int i = 0; i < jogadores.size();i++){
				if(jogadores.get(i).getEstado().getNome() == "Jogavel"){
					jogadores.get(i).setEstadoAtual(new Parada());
				}
				
				jogadores.get(i).getEstado().play((VBanca)this, jogadores.get(i));
			}
			
			getEstado().play((VBanca)this, this);
			
			
		} else {
			
			Exibicao.inicio();
			
			
			for (int i = 0; i < jogadores.size(); i++) {
				Exibicao.inicioJogada(jogadores.get(i));
				Exibicao.opcoesJogada(jogadores.get(i));
				jogadores.get(i).getEstado().play((VBanca)this,jogadores.get(i));// realiza a jogada de todos os jogadores
			}
			
			getEstado().play((VBanca)this, this);
			
		}
		
		
	}
	
	public void darCarta(Participante p) {
		p.receberCarta(this.rep.getRepositorio().get(0)); // da a carta p o jogador passando cmo parametro apenas a carta
		Exibicao.recebimentoCarta(p,this.rep.getRepositorio().get(0));
		this.rep.getRepositorio().remove(0); // remove a carta entregue do repositorio
	}
	
	public ArrayList<VCarta> getRep() {
		return this.rep.getRepositorio();
	}
	
	public VRepositorio getRepositorio() { // depuração
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
		mao.getCartaMao(1).setVisivel(false);
		super.setEstadoAtual(new BancaModificada());
		super.getEstado().play((VBanca)this, this);
		
	}
	
	
	public void empatar(Participante p) {
		if(empatar = true) {
			p.atualizarDinheiro(p.getMao().getValorAposta());
			String novoNome = p.getNome() + " Empatou!";
			p.nome = novoNome;
			empatar = false;
		}
		
	}
	
	public void ganharBlackJack(Participante p) {
		if(ganharBlackJack == true) {
			p.atualizarDinheiro(p.getMao().getValorAposta()*2.5);
			p.setEstadoAtual(new Ganhou());
			String novoNome = p.getNome() + " Ganhou!";
			p.nome = novoNome;
			ganharBlackJack = false;
		}else {
			return;
		}
		
	}
	
	public void ganhar(Participante p) {
		if(ganhar == true) {
			p.atualizarDinheiro(p.getMao().getValorAposta()*2);
			p.setEstadoAtual(new Ganhou());
			String novoNome = p.getNome() + " Ganhou!";
			p.nome = novoNome;
			ganhar = false;
		}else {
			return;
		}
		
	}
	
	public void perder(Participante p) {
		if(perder == true) {
			System.out.println("Seu saldo é de " + p.getDinheiro());
			p.setEstadoAtual(new Perdeu());
			String novoNome = p.getNome() + " Perdeu!";
			p.nome = novoNome;
			perder = false;
		}
		
	}

	
	public ArrayList<VCarta> embaralhar(ArrayList<VCarta> c) {
		Utilidade.misturar(c);
		return c;
	}
	
	
	public void receberCarta() {
		super.mao.addCarta(rep.getRepositorio().get(0), this);
		rep.getRepositorio().remove(0);
	}

	public void rodadaApostas() {
		Exibicao.rodadaApostas();
		
		for(int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).apostar();
		}
	}
	
	public void setNome(String nome){
		super.nome = nome;
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
