import java.util.ArrayList;

public abstract class Participante {
	
	private ArrayList<Mao> mao = new ArrayList<Mao>();
	private int dinheiro;
	
	
	// metodos da classe
	
	public void receberCarta(int i, Banca b, ArrayList<Carta> c) { // metodo chamado durante o jogo
		int pontuacao = 0;
		for(int a = 0; i < this.getMao(i).getArrayMao().size(); a++) { // pega a pontuacao de todas as cartas da mão q estao sendo jogadas
			pontuacao += this.getMao(i).getArrayMao().get(a).getValor(); // soma
		}
		
		if(pontuacao > 21) {
			return; // n pode mais receber cartas
		}
		else {
			b.darCarta(c, (Jogador) this, i); // add carta a mao q esta sendo jogada
		}
		
	}
	
	public void retiraDinheiro(int i) {
		if(getDinheiro() > 0) {
			this.dinheiro -= i;
		}
	}
	
	
	
	// metodos de acesso a membros
	
	public ArrayList<Mao> getMao(){ // retorna o array com as mãos do jogador
		return this.mao;
	}
	
	public void setCartaMao(Carta c, int n) { // da uma carta p a mao selecionada
		this.mao.get(n).setCartaMao(c);
	}
	
	public ArrayList<Mao> getArrayMao() { // retorna o array list c todas as mãos do jogador
		return this.mao;				// usado p saber a quantidade de mãos
	}
	
	public Mao getMao(int i) { // retorna uma mão especifica p fazer a jogada 
		if(this.mao.size() > i) { // só retorna a mão desejada se o parametro passado estiver
			return this.mao.get(i); // dentro do tamanho do array
		}
		else {
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

