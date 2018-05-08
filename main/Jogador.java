package main;
import java.util.ArrayList;
import java.util.Scanner;

import estadosJogador.Espera;

public class Jogador extends Participante {
	
	private String nome;
	

	public Jogador(String nome) {
		this.nome = nome;
		this.setDinheiro(1000);
		this.setEstadoAtual(new Espera());
	}

	
	public void receberCarta(Carta c) {
		this.getArrayMao().get(0).addCarta(c);
	}
	
	
	
	
	
	
	// daqui p baixo tem q arrumar
	//.
	//.
	//.
	//.
	public void dobrarAposta(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getPontos()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getPontos()); // tira dinheiro do saldo do jogador
			this.getMao(i).setValorAposta(2 * this.getMao(i).getPontos()); // dobra o valor da aposta
			b.darCarta(c, (Jogador) this, i); // retira uma carta p a mão q esta sendo jogada		
		} else {
			return; // n pode dobrar aposta
		}

	}

	public void dividirPar(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getPontos()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getPontos()); // tira dinheiro do saldo do jogador

			Mao novaMao = new Mao(this); // instancia nova mão q sera formada
			this.getArrayMao().add(novaMao); // add no arraylist mao

			this.getMao(i + 1).getArrayMao().add(this.getMao(i).getCartaMao(1)); // insere a carta do par na nova mão
			this.getMao(i).getArrayMao().remove(1); // remove a carta da mão q ela foi tirada
			b.darCarta(c, (Jogador) this, i);
			b.darCarta(c, (Jogador) this, i + 1);
		}
	}

	public void apostar(int aposta) {
		Mao m = new Mao(this);
		this.mao.add(m);

		if (this.mao.size() == 0) { // se ele nao tiver um segundo baralho.....
			this.mao.get(0).setValorAposta(aposta);// a aposta vai para a primeira mao, senao.....
		} else {
			this.mao.get(this.mao.size() - 1).setValorAposta(aposta);// a aposta vai para ultima mao instanciada
		}
	}

	public String getNome() {
		return this.nome;
	}
	
	public void jogada(Banca banca,RepositorioCartas rep){
		Scanner s = new Scanner(System.in);
		int entrada;
		
		Exibicao.mostrarCartaBanca(banca);

		Exibicao.escolhaJogada(this);
		
		for (int i = 0; i < this.getArrayMao().size(); i++) { // repete o processo p jogar todas as maos do jogador
			
			if (this.getMao(i).qntCartas() == 2  // se tiver só duas cartas e as duas forem iguais
					&& this.getMao(i).getCartaMao(0).getValorFace() == this.getMao(i).getCartaMao(1).getValorFace()) {

				Exibicao.maoAtual(i);
				
				Exibicao.exibirCartasMao(this, i);  // exibe as cartas q o jogador tem na mão

				Exibicao.pontuacaoMao(this, i); //  exibe pontuacao da mão q está sendo jogada

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

				Exibicao.exibirCartasMao(this, i); // exibe as cartas q o jogador tem na mão
				
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
	}
}