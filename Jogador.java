import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
	
	private String nome;
	private int dinheiro;
	private ArrayList <Mao> mao = new ArrayList<Mao>(); 
	
	private int pontos;
	
	public Jogador() {
		Scanner s = new Scanner(System.in);
		
		this.dinheiro = 1000;
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
		return dinheiro;
	}


	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public void recebeDinheiro(int valor) {
		this.dinheiro += valor;
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

	

}
