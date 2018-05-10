package main;
import java.util.ArrayList;

import estadosJogador.PlayerListener;
import estadosJogador.PlayerState;

public abstract class Participante {

	
	
	
	
	// metodos antigos q precisam ser revisados
	//.
	//.
	//.
	//.
	//.
	//.
	//.

	public void retiraDinheiro(int i) {
		if (getDinheiro() > 0) {
			this.dinheiro -= i;
		}
	}

	public void recebeDinheiro(int i) {
		this.dinheiro += i;
	}

	// metodos de acesso a membros

	public void setCartaMao(Carta c, int n) { // da uma carta p a mao selecionada
	
		if (this.mao.size() == 0) { 
			Mao m = new Mao(this);
			this.mao.add(m);
			this.mao.get(n).addCarta(c);
		} else {
			this.mao.get(n).addCarta(c);
		}
		
	}

	public ArrayList<Mao> getArrayMao() { // retorna o array list c todas as mãos do jogador
		return this.mao; // usado p saber a quantidade de mãos
	}

	public Mao getMao(int i) { // retorna uma mão especifica p fazer a jogada
		if (this.mao.size() > i) { // só retorna a mão desejada se o parametro passado estiver
			return this.mao.get(i); // dentro do tamanho do array
		} else {
			return null; // ver oq fazer depois c essa merda
		}
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

}