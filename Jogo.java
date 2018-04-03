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

		if (q <= 7) { // quantidade maxima de jogadores é 7
			for (int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
				jogadores.add(new Jogador(""));
			}
		}
	}

	public void rodada() {
		apostas();
		distribuirCartas();

		System.out.println("Início das jogadas");
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
		System.out.println("Rodada de apostas!");
		for (int i = 0; i < jogadores.size(); i++) { // recebe as apostas de cada jogador
			System.out.println("Jogador " + i + " qual a sua aposta?");
			entrada = s.nextInt();

			while (entrada < 25 || entrada > 75) { // valida a entrada do jogador
				System.out.println("Aposta inválida. Digite o número novamente");
				entrada = s.nextInt();
			}

			jogadores.get(i).apostar(entrada); // realiza a aposta
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

		System.out.println(j.getNome() + " Escolha sua jogada:");
		// repete o processo p jogar todas as maos do jogador
		for (int i = 0; i < j.getArrayMao().size(); i++) {
			// se tiver só duas cartas e as duas forem iguais
			if (j.getMao(i).qntCartas() == 2
					&& j.getMao(i).getCartaMao(0).getValor() == j.getMao(i).getCartaMao(1).getValor()) {

				System.out.println("Mão atual: " + i);

				for (int a = 0; a < j.getMao(i).getArrayMao().size(); a++) { // exibe as cartas q o jogador tem na mão
					System.out.println(
							j.getMao(i).getCartaMao(a).getValor() + " de " + j.getMao(i).getCartaMao(a).getNaipe());
				}

				System.out.println("Você possui " + j.getMao(i).getPontos() + "pontos nessa mão");

				System.out.println(" 1 - Receber Carta");
				System.out.println(" 2 - Dobrar Aposta");
				System.out.println(" 3 - Dividir Par");
				System.out.println(" 4 - Parar jogada");

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						j.receberCarta(i, this.banca, this.rep.getRepositorio());
						entrada = s.nextInt();
					}
				}
				if (entrada == 2) {
					j.dobrarAposta(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 3) {
					j.dividirPar(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 4) {
					System.out.println("Jogada finalizada para essa mão");
					return;
				}
			} else { // caso n seja possivel jogador fazer a jogada "dividir par"

				System.out.println("Mão atual: " + i);

				for (int a = 0; a < j.getMao(i).getArrayMao().size(); a++) { // exibe as cartas q o jogador tem na mão
					System.out.println(
							j.getMao(i).getCartaMao(a).getValor() + " de " + j.getMao(i).getCartaMao(a).getNaipe());
				}

				System.out.println("Você possui " + j.getMao(i).getPontos() + "pontos nessa mão");

				System.out.println(" 1 - Receber Carta");
				System.out.println(" 2 - Dobrar Aposta");
				System.out.println(" 3 - Parar jogada");

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						j.receberCarta(i, this.banca, this.rep.getRepositorio());
						entrada = s.nextInt();
					}
				}
				if (entrada == 2) {
					j.dobrarAposta(i, this.banca, this.rep.getRepositorio());
				} else if (entrada == 3) {
					System.out.println("Jogada finalizada para essa mão");
					return;
				}
			}
		}
	}

	public void finalRodada(Jogador j, Banca b) {
		for (int i = 0; i < j.getArrayMao().size(); i++) {
			if (j.getMao(i).getPontos() < pontuacaoMaxima && b.getMao().getPontos() > pontuacaoMaxima) { // se a banca estourou 21
																							// pontos

				System.out.println("A banca estourou 21 pontos!");
				System.out.println(j.getNome() + " você é venceu");
				System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());

				j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador recebe dinheiro
				b.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro da banca

			} else if (j.getMao(i).getPontos() > pontuacaoMaxima && b.getMao().getPontos() < pontuacaoMaxima) { // se jogador

				System.out.println(j.getNome() + " estourou 21 pontos!");
				System.out.println(j.getNome() + " você é perdeu");
				System.out.println("A banca recebe R$" + 2 * j.getMao(i).getValorAposta());

				j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
				b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador

			} else if (j.getMao(i).getPontos() < pontuacaoMaxima && b.getMao().getPontos() > pontuacaoMaxima) { // se tanto jogador qnt a banca n estourara, 21 pontos
																									
				if (j.getMao(i).getPontos() > b.getMao().getPontos()) { // se jogador tem mais pontos q a banca
					
					System.out.println(j.getNome() +"tem mais pontos!");
					System.out.println(j.getNome() + " você é venceu");
					System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());
					
					j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador recebe dinheiro
					b.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro da banca

				} else if (j.getMao(i).getPontos() < b.getMao().getPontos()) { // se a banca tem mais pontos q o jogador
					
					System.out.println("A banca tem mais pontos!");
					System.out.println(j.getNome() + " você é perdeu");
					System.out.println("A banca recebe R$" + 2 * j.getMao(i).getValorAposta());
					
					j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
					b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
				}
			} else if (j.getMao(i).getPontos() == pontuacaoMaxima && b.getMao().getPontos() != pontuacaoMaxima) { // se jogador tem 21 pontos e a banca n
				
				System.out.println(j.getNome() +"fez um vinte e um!!");
				System.out.println(j.getNome() + " você é venceu");
				System.out.println(j.getNome() + " recebe R$" + (3 * j.getMao(i).getValorAposta()) / 2);
				
				
				j.recebeDinheiro((3 * j.getMao(i).getValorAposta()) / 2); // jogador recebe aposta * 1,5
				b.retiraDinheiro((3 * j.getMao(i).getValorAposta()) / 2); // retira o dinheiro da banca
			} else if (j.getMao(i).getPontos() != pontuacaoMaxima && b.getMao().getPontos() == pontuacaoMaxima) { // se a banca tem 21 pontos e o jogador n
				
				System.out.println("A banca fez um vinte e um!!");
				System.out.println(j.getNome() + " você é perdeu");
				System.out.println(" A banca recebe R$" + (3 * j.getMao(i).getValorAposta()) / 2);

				j.retiraDinheiro(2 * j.getMao(i).getValorAposta()); // retira o dinheiro do jogador
				b.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // banca recebe dinheiro
			}
		}
	}
}


/*private void calculoPontos() {

for (int i = 0; i < jogadores.size(); i++) { // calcula o ponto de cada jogador
	System.out.println("Jogador " + i + "possui:");

	for (int j = 0; j < jogadores.get(i).getMao().size(); j++) { // calcula os pontos de cada mao do jogador
		System.out.println(jogadores.get(i).getMao().get(j).getPontos() + "pontos na mao " + (j + 1));
	}

	System.out.println();
}

System.out.println("A Banca possui:");

for (int j = 0; j < banca.getMao().size(); j++) { // calcula os pontos de cada mao da banca
	System.out.println(banca.getMao().get(j).getPontos() + "pontos na mao " + (j + 1));
}
}*/
