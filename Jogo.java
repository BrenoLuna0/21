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
		
		distribuirCartas();

		Exibicao.inicio();
		for (int i = 0; i < jogadores.size(); i++) { // depois q o jogo estiver preparado
			jogada(this.jogadores.get(i)); // realiza a jogada de todos os jogadores
		}

		// fazer metodo da rodada da banca pq é diferente da jogada de um jogador comum
		jogadaBanca();

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
		
		Exibicao.mostrarCartaBanca(banca);

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
								Exibicao.pontuacaoMao(j, i);
								Exibicao.erroReceberCarta();
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
	
	
	private void jogadaBanca() { //alterações finalizadas
		Exibicao.rodadaBanca();
		Exibicao.mostrarTodasCartasBanca(this.banca);
		int jogosGanhos = 0;
		
		for(int i = 0; i < this.jogadores.size(); i++) {
			if(this.banca.getMao().getPontos() > jogadores.get(i).getMao(0).getPontos() || jogadores.get(i).getMao(0).getPontos() > pontuacaoMaxima) {
				jogosGanhos += 1;
			}
		}
		
		if(jogosGanhos > (this.jogadores.size())/2) { // se a banca estiver vencendo da maioria dos jogadores
			return; //nao faz nada
		}else {
			while(this.banca.getMao().getPontos() < 16) { // senão ela pega mais cartas
				this.banca.receberCarta(rep.getRepositorio());		
			}
			return;
		}
	}
}
