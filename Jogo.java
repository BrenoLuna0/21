import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Banca banca;
	private RepositorioCartas rep;
	public static final int pontuacaoMaxima = 21;

	public Jogo(int q, Banca b, RepositorioCartas c) {
		this.banca = b;
		this.rep = c;

		for (int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
			Exibicao.nomeJogador(i);
			String entrada = new Scanner(System.in).nextLine();
			jogadores.add(new Jogador(entrada));
		}
	}

	public void rodada() {
		apostas();
		this.banca.embaralhar(this.rep.getRepositorio());
		distribuirCartas();

		Exibicao.inicio();
		for (int i = 0; i < jogadores.size(); i++) { // depois q o jogo estiver preparado
			jogada(this.jogadores.get(i)); // realiza a jogada de todos os jogadores
		}

		// fazer metodo da rodada da banca pq é diferente da jogada de um jogador comum

		for (int i = 0; i < jogadores.size(); i++) { // depois q todos jogarem
			finalRodada(this.jogadores.get(i), this.banca); // verifica os vencedores e distribui as apostas
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

	private void distribuirCartas() {
		for (int i = 0; i < jogadores.size(); i++) { // distribui primeira carta p todos os jogadores
			banca.darCarta(rep.getRepositorio(), jogadores.get(i), 0);
		}

		banca.receberCarta(rep.getRepositorio()); // dá a primeira carta p banca

		for (int i = 0; i < jogadores.size(); i++) { // distribui a segunda carta p todos os jogadores
			banca.darCarta(rep.getRepositorio(), jogadores.get(i), 0);
		}

		banca.receberCarta(rep.getRepositorio()); // dá a segunda carta p banca
	}

	public void jogada(Jogador j) {
		Scanner s = new Scanner(System.in);
		int entrada;

		Exibicao.escolhaJogada(j);
		
		for (int i = 0; i < j.getArrayMao().size(); i++) { // repete o processo p jogar todas as maos do jogador
			
			if (j.getMao(i).qntCartas() == 2  // se tiver só duas cartas e as duas forem iguais
					&& j.getMao(i).getCartaMao(0).getValor() == j.getMao(i).getCartaMao(1).getValor()) {

				Exibicao.maoAtual(i);
				
				Exibicao.exibirCartasMao(j, i);  // exibe as cartas q o jogador tem na mão

				Exibicao.pontuacaoMao(j, i); //  exibe pontuacao da mão q está sendo jogada

				Exibicao.menuJogadas1(); // exibe jogadas disponiveis

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						if(j.getMao(i).getPontos() > 21) {
							Exibicao.erroReceberCarta();
							return;
						} else {
							j.receberCarta(i, this.banca, this.rep.getRepositorio());
							
							if(j.getMao(i).getPontos() >= 21) {
								return;
							}
							
							Exibicao.exibirCartasMao(j, i);
							Exibicao.pontuacaoMao(j, i);
							Exibicao.menuJogadas2();
							entrada = s.nextInt();
						}
					}
				}
				if (entrada == 2) {
					j.dobrarAposta(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 3) {
					j.dividirPar(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 4) {
					Exibicao.jogadaFinalizada();
					return;
				}
			} else { // caso n seja possivel jogador fazer a jogada "dividir par"

				Exibicao.maoAtual(i);

				Exibicao.exibirCartasMao(j, i); // exibe as cartas q o jogador tem na mão
				
				Exibicao.pontuacaoMao(j, i);

				Exibicao.menuJogadas2();

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						if(j.getMao(i).getPontos() > 21) {
							Exibicao.erroReceberCarta();
							return;
						} else {
							j.receberCarta(i, this.banca, this.rep.getRepositorio());
							
							if(j.getMao(i).getPontos() >= 21) {
								return;
							}
							
							Exibicao.exibirCartasMao(j, i);
							Exibicao.pontuacaoMao(j, i);
							Exibicao.menuJogadas2();
							entrada = s.nextInt();
						}
					}
				}
				if (entrada == 2) {
					j.dobrarAposta(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 3) {
					Exibicao.jogadaFinalizada();
					return;
				}
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

				j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
				b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador

			} else if (j.getMao(i).getPontos() < pontuacaoMaxima && b.getMao().getPontos() < pontuacaoMaxima) { // se tanto jogador qnt a banca n estourara, 21 pontos
																									
				if (j.getMao(i).getPontos() > b.getMao().getPontos()) { // se jogador tem mais pontos q a banca
					
					Exibicao.msgVitoria2(j, i);
					
					j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador recebe dinheiro
					b.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro da banca

				} else if (j.getMao(i).getPontos() < b.getMao().getPontos()) { // se a banca tem mais pontos q o jogador
					
					Exibicao.msgDerrota2(j, i);
					
					j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
					b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
				}
			} else if (j.getMao(i).getPontos() == pontuacaoMaxima && b.getMao().getPontos() != pontuacaoMaxima) { // se jogador tem 21 pontos e a banca n
				
				Exibicao.msgVitoria3(j, i);
				
				j.recebeDinheiro((3 * j.getMao(i).getValorAposta()) / 2); // jogador recebe aposta * 1,5
				b.retiraDinheiro((3 * j.getMao(i).getValorAposta()) / 2); // retira o dinheiro da banca
			} else if (j.getMao(i).getPontos() != pontuacaoMaxima && b.getMao().getPontos() == pontuacaoMaxima) { // se a banca tem 21 pontos e o jogador n
				
				Exibicao.msgDerrota3(j, i);

				j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
				b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
			}
		}
	}
}


