import java.util.ArrayList;

public class Jogador extends Participante {
	
	private String nome;


	public Jogador(String nome) {
		this.nome = nome;
		this.setDinheiro(1000);
	}

	public void dobrarAposta(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getValorAposta()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getValorAposta()); // tira dinheiro do saldo do jogador
			this.getMao(i).setValorAposta(2 * this.getMao(i).getValorAposta()); // dobra o valor da aposta
			b.darCarta(c, (Jogador) this, i); // retira uma carta p a mão q esta sendo jogada
			this.getMao(i).setValorAposta(2 * (this.getMao(i).getValorAposta())); // dobra a aposta minima
		} else {
			return; // n pode dobrar aposta
		}

	}

	public void dividirPar(int i, Banca b, ArrayList<Carta> c) {
		if (this.getDinheiro() > this.getMao(i).getValorAposta()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getValorAposta()); // tira dinheiro do saldo do jogador

			Mao novaMao = new Mao(); // instancia nova mão q sera formada
			this.getArrayMao().add(novaMao); // add no arraylist mao

			this.getMao(i + 1).getArrayMao().add(this.getMao(i).getCartaMao(1)); // insere a carta do par na nova mão
			this.getMao(i).getArrayMao().remove(1); // remove a carta da mão q ela foi tirada
			b.darCarta(c, (Jogador) this, i);
			b.darCarta(c, (Jogador) this, i + 1);
		}
	}

	public void apostar(int aposta) {
		Mao m = new Mao();
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
}
