import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Banca banca;
	private RepositorioCartas rep;
	
	public Jogo(int q, Banca b, RepositorioCartas c) {
		this.banca = b;
		this.rep = c;
		
		if(q <= 7 ) { // quantidade maxima de jogadores � 7
			for(int i = 0; i < q; i++) { // instancia quantidade de jogadores pedida
				Jogador j = new Jogador("");
				jogadores.add(j);
			}
		}  
		
		rodadaApostas(); 
	}
	
	private void rodadaApostas() {
		Scanner s = new Scanner(System.in);
		int entrada;
		
		System.out.println("Rodada de apostas!!!!!!");
		
		
		for(int i = 0; i < jogadores.size(); i++) {
			System.out.println("Jogador " + i + "qual a sua aposta?");
			entrada = s.nextInt();
			
			while(entrada < 25 || entrada > 75) {
				System.out.println("Aposta inv�lida. Digite o n�mero novamente");
				entrada = s.nextInt();
			}
			
			jogadores.get(i).apostar(entrada);
		}
	}
	
	
	private void distribuirCartas() {
		for(int i = 0; i < jogadores.size(); i++) {
			banca.darCarta(rep.getRepositorio(), jogadores.get(i), 0);
		}
		
		banca.receberCarta(rep.getRepositorio());
		
		for(int i = 0; i < jogadores.size(); i++) {
			banca.darCarta(rep.getRepositorio(), jogadores.get(i), 0);
		}
		
		banca.receberCarta(rep.getRepositorio());
	}
	
	
	private void calculoPontos() {
		
		for(int i = 0; i < jogadores.size(); i++) {
			System.out.println("Jogador " + i + "possui:");
			
			for(int j = 0; j < jogadores.get(i).getMao().size(); j++) {
				System.out.println(jogadores.get(i).getMao().get(j).getPontos() + "pontos na mao " + (j + 1));
			}
			
			System.out.println();
		}
		
		
		System.out.println("A banca possui " + banca.getMao().getPontos() + "pontos");
	}

}


































/*import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
	
	private Banca banca =  new Banca();
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private int qtd;
	private RepositorioCartas rep;


	
	public Jogo(Banca b, RepositorioCartas r, int qtd) {
		this.banca = b;
		this.rep = r;
		this.qtd = qtd;
		
		if(qtd <= 7 ) { // quantidade maxima de jogadores � 7
			for(int i = 0; i < qtd; i++) { // instancia quantidade de jogadores pedida
				Jogador j = new Jogador();
				jogadores.add(j);
			}
		} 
		else {
			return; // ver oq fazer c isso, n pode ter mais de 7
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Rodada de apostas~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		for(int i = 0; i < qtd; i++) {
			apostar(jogadores.get(i));
		}
		
		for(int i = 0; i < qtd; i++) { 
			distribuicaoInicalCartas(jogadores.get(i)); // distribui cartas p os jogadores
		}
		
		distribuicaoInicalCartas(banca); // distribui as cartas da banca
		
		
		for(int i = 0; i < jogadores.size(); i++) {
			jogada(jogadores.get(i));  // todos os jogadores jogam
		}
		
		jogada(banca); // rodada da banca (provavelmente vai precisar de um metodo especifico s� p jogada da banca
		
		for(int i = 0; i < jogadores.size(); i++) {
			finalrodada(jogadores.get(i),banca);  // finaliza a rodada verificando qm ganhou e distribui o dinheiro
		}
	}
	
	public void finalrodada(Jogador j, Banca b) {
		for(int i = 0; i < j.getArrayMao().size(); i++) { // verifica o resultado de todas as maos do jogador
			if(j.getPontuacao() < 21 && b.getPontuacao() > 21) { // se a banca estourou 21 pontos
				j.recebeDinheiro(2 * j.getMao(i).getValorAposta()); // jogador ganha
			} 
			else
				if(j.getPontuacao() < 21 && b.getPontuacao() < 21) { // se tanto jogador quanto banca n estouraram 21 pontos
					if(j.getPontuacao() > b.getPontuacao()) {		// se jogador tem mais pontos q a banca
						j.recebeDinheiro( 2 * j.getMao(i).getValorAposta());	// jogador ganha
					}else
						b.recebeDinheiro(j.getMao(i).getValorAposta());
				}
				else
					if(j.getPontuacao() == 21 && b.getPontuacao() < 21) { // se jogador tem 21 e banca menos
						j.recebeDinheiro( (((3 * j.getMao(i).getValorAposta())/2)+j.getMao(i).getValorAposta())); //  jogador ganha 150% da banca
					}
					else 
						if(j.getPontuacao() == 21 && b.getPontuacao() == 21) { // se os dois tem 21
							j.recebeDinheiro(j.getMao(i).getValorAposta());		// jogador recebe s� oq apostou
						}
						else {
							b.recebeDinheiro(j.getMao(i).getValorAposta()); // banca ganha
						}
		}	
	}
	
	public void distribuicaoInicalCartas(Jogador j) {
		//j.retiraDinheiro(j.getMao(0).getValorAposta());		// tira dinheiro do saldo do jogador
		j.getMao(0).getCartasMao().add(retiraCarta()); // da ao jogador suas duas primeiras cartas
		j.getMao(0).getCartasMao().add(retiraCarta());
	}
	
	public void jogada(Jogador j) {
		Scanner s = new Scanner(System.in);
		int entrada;
		
		System.out.println("Escolha a sua jogada");
		for(int i = 0; i < j.getArrayMao().size(); i++) { // repete o processo p jogar todas as maos do jogador
			if(j.getMao(i).qntCartas() == 2 && j.getMao(i).getCartaUnica(0).getValor() == j.getMao(i).getCartaUnica(1).getValor()){
				entrada = s.nextInt();  // se tiver s� duas cartas e as duas forem iguais
				
				// inserir aqui algum tratamento p a entrada do usuario
				
				if(entrada == 1) {
					while(entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						receberCarta(j,i);
						entrada = s.nextInt();
					}
				} 
				if (entrada == 2){
					dobrarAposta(j,i);
				}
				else
					if (entrada == 3) {
						dividirPar(j,i);
						i = 0;
					}
					else 
						if (entrada == 4) {
							return; // alguma mensagem d q encerrou a jogada
						}	
			}
			else {
				entrada = s.nextInt();  // se tiver s� duas cartas e as duas forem iguais
				
				// inserir aqui algum tratamento p a entrada do usuario
				
				if(entrada == 1) {
					while(entrada == 1) { // pode pedir carta qntas vezes quiser ate estourar mais d 21
						receberCarta(j,i);
						entrada = s.nextInt();
					}
				} 
				if (entrada == 2){
					dobrarAposta(j,i);
				}
				else
					if (entrada == 3) {
						return;
					}	
			}
		}
	}
	
	
	public void receberCarta(Jogador j, int i) {
		int pontuacao = 0;
		for(int a = 0; a < j.getMao(i).getCartasMao().size(); a++) { // pega a pontuacao de todas as cartas da m�o q esta sedo jogada
			pontuacao += j.getMao(i).getCartasMao().get(a).getValor(); // soma
		}
		
		if(pontuacao >= 21) {
			return; // n pode mais receber cartas
		}
		else {
			j.getMao(i).getCartasMao().add(retiraCarta()); // add carta a mao q esta sendo jogada
		}
		
		
	}
	
	private Carta retiraCarta() {
		int i = Utilidade.rand(0, 207); // escolhe uma carta aleatoria do baralho
		
		if(rep.getCarta(i).getRetirado() == true) { // se a carta ja tiver sido retirada
			while(rep.getCarta(i).getRetirado() == true) // procura uma q ainda n tenha sido
				i = Utilidade.rand(0, 207);
				rep.getCarta(i).setRetirado(true); // marca carta q vai ser retirada p n ser escolhida duas vezes
				return this.rep.getCarta(i); //retorna carta escolhida aleatoriamente
		} 
		else {
			rep.getCarta(i).setRetirado(true); // marca carta q vai ser retirada p n ser escolhida duas vezes
			return this.rep.getCarta(i); //retorna carta escolhida aleatoriamente
		}
	}

	public void dobrarAposta(Jogador j, int i) {
		if(j.getDinheiro() > j.getMao(i).getValorAposta()) { // se tiver dinheiro
			j.retiraDinheiro(j.getMao(i).getValorAposta());		// tira dinheiro do saldo do jogador
			j.getMao(i).setValorAposta(2 * j.getMao(i).getValorAposta()); 	// dobra o valor da aposta
			j.getMao(i).getCartasMao().add(retiraCarta()); // retira uma carta p a m�o q esta sendo jogada
			j.getMao(i).setValorAposta(2*(j.getMao(i).getValorAposta())); // dobra a aposta minima
		}
		else {
			return; // n pode dobrar aposta
		}		
	}
	
	public void dividirPar(Jogador j, int i) {
		if(j.getDinheiro() > j.getMao(i).getValorAposta()) { // se tiver dinheiro
			j.retiraDinheiro(j.getMao(i).getValorAposta());		// tira dinheiro do saldo do jogador
			
			Mao novaMao = new Mao();		//instancia nova m�o q sera formada
			j.getArrayMao().add(novaMao);		//add no arraylist mao
			
			j.getMao(i + 1).getCartasMao().add(j.getMao(i).getCartaUnica(1)); // insere a carta do par na nova m�o
			j.getMao(i).getCartasMao().remove(1); // remove a carta da m�o q ela foi tirada
			j.getMao(i).getCartasMao().add(retiraCarta());
			j.getMao(i+1).getCartasMao().add(retiraCarta());
		}
	}
	

	
	public void apostar(Jogador j) { 
		Scanner s = new Scanner(System.in);
		int entrada;
		
		System.out.println("Jogador " + j.getNome() + " quanto vc quer apostar? A aposta deve estar entre 25 e 60");
		entrada = s.nextInt();
		while(entrada < 25 || entrada > 60){
			System.out.println("Digite o valor da aposta novamente");
			entrada = s.nextInt();
		}
		j.getMao(0).setValorAposta(entrada);
		j.retiraDinheiro(entrada);
	}
	
	

}*/
