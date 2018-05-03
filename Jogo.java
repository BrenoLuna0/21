import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Banca banca;
	private RepositorioCartas rep;
	public static final int pontuacaoMaxima = 21;
	public static final int apostaMinima = 25;

	public Jogo(int q, Banca b) {
		this.banca = b;

		for (int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
			Exibicao.nomeJogador(i);
			String entrada = new Scanner(System.in).nextLine();
			jogadores.add(new Jogador(entrada));
		}
	}
	
	
	
	
	public void instanciarNovoBaralho() {
		this.rep = new RepositorioCartas();
		this.banca.embaralhar(this.rep.getRepositorio());
	}
	
	public void blackJack() {
		while(this.jogadores.size() > 0) {
			instanciarNovoBaralho();
			rodada();
			jogarNovamente();
		}
		Exibicao.finalJogo();
	}
	
	public void jogarNovamente() {
		Scanner s = new Scanner(System.in);
		int entrada;
		
		for(int i = 0; i < this.jogadores.size(); i++) {
			Exibicao.jogarNovamente(this.jogadores.get(i));	
			Exibicao.menuJogarNovamente();
			entrada = s.nextInt();
			while (entrada < 1 || entrada > 2) {
				Exibicao.entradaInvalida();
				entrada = s.nextInt();
			}
			if(entrada == 2) {
				Exibicao.saidaJogador(this.jogadores.get(i));
				this.jogadores.remove(i);
			} else {
				Exibicao.permanenciaJogador(this.jogadores.get(i));
			}
		}
		
	}

	public void rodada() {
		apostas();
		banca.distribuirCartas(jogadores,rep);

		Exibicao.inicio();
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getEstado().play(this.banca,jogadores.get(i));// realiza a jogada de todos os jogadores
		}
	}

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


	
	public void verificarDinheiroJogadores() {
		for(int i = 0; i < this.jogadores.size(); i++) {
			if(this.jogadores.get(i).getDinheiro() < apostaMinima) {
				Exibicao.jogadorEliminado(this.jogadores.get(i));
				this.jogadores.remove(i);
			}
		}
	}

	public void finalRodada(Jogador j, Banca b) {
		
		for (int i = 0; i < j.getArrayMao().size(); i++) {
			if (j.getMao(i).getPontos() < pontuacaoMaxima && b.getMao().getPontos() > pontuacaoMaxima) { // se a banca estourou 21
																							// pontos
				Exibicao.msgVitoria1(j, i);
				
				j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador recebe dinheiro
				b.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro da banca

			} else if (j.getMao(i).getPontos() > pontuacaoMaxima && b.getMao().getPontos() < pontuacaoMaxima) { // se jogador estourou 21 pontos

				Exibicao.msgDerrota1(j, i);

				j.retiraDinheiro(j.getMao(i).getValorAposta()); // banca recebe dinheiro
				b.recebeDinheiro(j.getMao(i).getValorAposta()); // retira o dinheiro do jogador

			} else if (j.getMao(i).getPontos() < pontuacaoMaxima && b.getMao().getPontos() < pontuacaoMaxima) { // se tanto jogador qnt a banca n estourara, 21 pontos
																									
				if (j.getMao(i).getPontos() > b.getMao().getPontos()) { // se jogador tem mais pontos q a banca
					
					Exibicao.msgVitoria2(j, i);
					
					j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador recebe dinheiro
					b.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro da banca

				} else if (j.getMao(i).getPontos() < b.getMao().getPontos()) { // se a banca tem mais pontos q o jogador
					
					Exibicao.msgDerrota2(j, i);
					
					j.retiraDinheiro(j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
					b.recebeDinheiro(j.getMao(i).getValorAposta()); // banca recebe dinheiro
				}
			} else if (j.getMao(i).getPontos() == pontuacaoMaxima && b.getMao().getPontos() != pontuacaoMaxima) { // se jogador tem 21 pontos e a banca n
				
				Exibicao.msgVitoria3(j, i);
				
				j.recebeDinheiro(((3 * j.getMao(i).getValorAposta()) / 2)); // jogador recebe aposta * 1,5
				b.retiraDinheiro(((3 * j.getMao(i).getValorAposta()) / 2)); // retira o dinheiro da banca
			} else if (j.getMao(i).getPontos() != pontuacaoMaxima && b.getMao().getPontos() == pontuacaoMaxima) { // se a banca tem 21 pontos e o jogador n
				
				Exibicao.msgDerrota3(j, i);

				j.retiraDinheiro(j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
				b.recebeDinheiro(j.getMao(i).getValorAposta()); // banca recebe dinheiro
			} else if (j.getMao(i).getPontos() > pontuacaoMaxima && b.getMao().getPontos() > pontuacaoMaxima ||j.getMao(i).getPontos() > pontuacaoMaxima && b.getMao().getPontos() > pontuacaoMaxima) {
				Exibicao.msgEmpate(j);
				j.recebeDinheiro(j.getMao(i).getValorAposta()); // jogador recebe aposta de volta

			}
		}
		verificarDinheiroJogadores();
		this.banca.removerMaos(this.jogadores);
	}
	
}
