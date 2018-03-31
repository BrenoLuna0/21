import java.util.ArrayList;


public class Jogador extends Participante {
	private ArrayList<Mao> mao = new ArrayList<Mao>();
	private String nome;
	private int dinheiro;
	

	public Jogador(String nome) {
		this.nome = nome;
		this.setDinheiro(1000);
		Mao m = new Mao();
		this.mao.add(m);

	}
	
	
	public void dobrarAposta(int i,Banca b, ArrayList<Carta> c) {
		if(this.getDinheiro() > this.getMao(i).getValorAposta()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getValorAposta());		// tira dinheiro do saldo do jogador
			this.getMao(i).setValorAposta(2 * this.getMao(i).getValorAposta()); 	// dobra o valor da aposta
			b.darCarta(c, (Jogador) this, i); // retira uma carta p a mão q esta sendo jogada
			this.getMao(i).setValorAposta(2*(this.getMao(i).getValorAposta())); // dobra a aposta minima
		}
		else {
			return; // n pode dobrar aposta
		}
		
	}


	public void dividirPar(int i, Banca b, ArrayList<Carta> c) {
		if(this.getDinheiro() > this.getMao(i).getValorAposta()) { // se tiver dinheiro
			this.retiraDinheiro(this.getMao(i).getValorAposta());		// tira dinheiro do saldo do jogador
			
			Mao novaMao = new Mao();		//instancia nova mão q sera formada
			this.getArrayMao().add(novaMao);		//add no arraylist mao
			
			this.getMao(i + 1).getArrayMao().add(this.getMao(i).getCartaMao(1)); // insere a carta do par na nova mão
			this.getMao(i).getArrayMao().remove(1); // remove a carta da mão q ela foi tirada
			b.darCarta(c, (Jogador) this, i);
			b.darCarta(c, (Jogador) this, i+1);
		}
	}
	
	
	
	public void apostar(int aposta) {
		Mao m = new Mao();
		this.mao.add(m);
		
		if(this.mao.get(1) == null) { // se ele nao tiver um segundo baralho.....
			this.mao.get(0).setValorAposta(aposta);// a aposta vai para a primeira mao, senao.....
		}else {
			this.mao.get(1).setValorAposta(aposta);// a aposta vai para a segunda
		}
	}	
}

































/*import java.util.ArrayList;
import java.util.Scanner;

public class Jogador extends Participante {
	
	private String nome;
	private ArrayList <Mao> mao = new ArrayList<Mao>(); 
	
	private int pontos;
	
	public Jogador() {
		Scanner s = new Scanner(System.in);
		
		super.recebeDinheiro(1000);
		Mao m = new Mao();
		this.mao.add(m); // sempre q iniciar um jogador, criar uma mão inicial
		
		System.out.println("Qual o seu nome, jogador?");
		this.nome = s.next();
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getDinheiro() {
		return super.getDinheiro();
	}


	
	
	
	public void retiraDinheiro(int i) {
		if(getDinheiro() > 0) {
			this.dinheiro -= i;
		}
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


	public void setMao(Mao m) {
		this.mao.add(m);
	}





	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	

}*/
