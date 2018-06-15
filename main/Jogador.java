package main;
import java.util.ArrayList;
import java.util.Scanner;

import estadosJogador.Espera;
import estadosJogador.PlayerListener;
import estadosJogador.PlayerState;

public class Jogador extends Participante {
	

	public Jogador(String nome) {
		this.nome = nome;
		this.setEstadoAtual(new Espera());
		mao = new Mao(this);
		super.dinheiro = 300;
	}
	
	public void apostar() {
		int aposta;
		Scanner s = new Scanner(System.in);
		
		Exibicao.apostaJogador(this);
		aposta = s.nextInt();
		while(aposta < 25 || aposta > 75) {
			Exibicao.apostaInvalida();
			aposta = s.nextInt();
		}
		
		dinheiro = dinheiro - aposta;
		mao.setValorAposta(aposta);
	}
	
	public void apostar25() {
		dinheiro = dinheiro - 25;
		mao.setValorAposta(25);
	}
	
	public void apostar50() {
		dinheiro = dinheiro - 50;
		mao.setValorAposta(50);
	}
	
	public void apostar75() {
		dinheiro = dinheiro - 75;
		mao.setValorAposta(75);
	}
	
	
	
	
	
	// daqui p baixo tem q arrumar
	//.
	//.
	//.
	//.
	/*public void dobrarAposta(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getPontos()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getPontos()); // tira dinheiro do saldo do jogador
			this.getMao(i).setValorAposta(2 * this.getMao(i).getPontos()); // dobra o valor da aposta
			b.darCarta(c, (Jogador) this, i); // retira uma carta p a m�o q esta sendo jogada		
		} else {
			return; // n pode dobrar aposta
		}

	}

	public void dividirPar(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getPontos()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getPontos()); // tira dinheiro do saldo do jogador

			Mao novaMao = new Mao(this); // instancia nova m�o q sera formada
			this.getArrayMao().add(novaMao); // add no arraylist mao

			this.getMao(i + 1).getArrayMao().add(this.getMao(i).getCartaMao(1)); // insere a carta do par na nova m�o
			this.getMao(i).getArrayMao().remove(1); // remove a carta da m�o q ela foi tirada
			b.darCarta(c, (Jogador) this, i);
			b.darCarta(c, (Jogador) this, i + 1);
		}
	}*/
	
	
	
	
	/*public void jogada(Banca banca,RepositorioCartas rep){
		Scanner s = new Scanner(System.in);
		int entrada;
		
		Exibicao.mostrarCartaBanca(banca);

		Exibicao.escolhaJogada(this);
		
		for (int i = 0; i < this.getArrayMao().size(); i++) { // repete o processo p jogar todas as maos do jogador
			
			if (this.getMao(i).qntCartas() == 2  // se tiver s� duas cartas e as duas forem iguais
					&& this.getMao(i).getCartaMao(0).getValorFace() == this.getMao(i).getCartaMao(1).getValorFace()) {

				Exibicao.maoAtual(i);
				
				Exibicao.exibirCartasMao(this, i);  // exibe as cartas q o jogador tem na m�o

				Exibicao.pontuacaoMao(this, i); //  exibe pontuacao da m�o q est� sendo jogada

				Exibicao.menuJogadas1(); // exibe jogadas disponiveis

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						if(this.getMao(i).getPontos() > 21) {
							Exibicao.erroReceberCarta();
							return;
						} else {
							this.receberCarta(i,banca,rep.getRepositorio());
							
							if(this.getMao(i).getPontos() >= 21) {
								Exibicao.pontuacaoMao(this, i);
								Exibicao.erroReceberCarta();
								return;
							}
							
							Exibicao.exibirCartasMao(this, i);
							Exibicao.pontuacaoMao(this, i);
							Exibicao.menuJogadas2();
							entrada = s.nextInt();
						}
					}
				}
				if (entrada == 2) {
					this.dobrarAposta(i, banca, rep.getRepositorio());
				} else if (entrada == 3) {
					this.dividirPar(i, banca, rep.getRepositorio());
				} else if (entrada == 4) {
					Exibicao.jogadaFinalizada();
					return;
				}
			} else { // caso n seja possivel jogador fazer a jogada "dividir par"

				Exibicao.maoAtual(i);

				Exibicao.exibirCartasMao(this, i); // exibe as cartas q o jogador tem na m�o
				
				Exibicao.pontuacaoMao(this, i);

				Exibicao.menuJogadas2();

				entrada = s.nextInt();

				if (entrada == 1) {
					while (entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						if(this.getMao(i).getPontos() > 21) {
							Exibicao.erroReceberCarta();
							return;
						} else {
							this.receberCarta(i, banca, rep.getRepositorio());
							
							if(this.getMao(i).getPontos() >= 21) {
								return;
							}
							
							Exibicao.exibirCartasMao(this, i);
							Exibicao.pontuacaoMao(this, i);
							Exibicao.menuJogadas2();
							entrada = s.nextInt();
						}
					}
				}
				if (entrada == 2) {
					this.dobrarAposta(i, banca, rep.getRepositorio());
				} else if (entrada == 3) {
					Exibicao.jogadaFinalizada();
					return;
				}
			}
		}
	}*/
}