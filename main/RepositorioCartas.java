package main;
import java.util.ArrayList;

public class RepositorioCartas {
	private Baralho baralho1 = new Baralho();
	private Baralho baralho2 = new Baralho();
	private Baralho baralho3 = new Baralho();
	private Baralho baralho4 = new Baralho();
	
	private ArrayList<Carta> pilha = new ArrayList<Carta>();
	
	public RepositorioCartas() {
		for(int i = 0; i < 52; i++) {
			pilha.add(baralho1.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add(baralho2.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add(baralho3.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add(baralho4.getCarta(i));
		}
		
	}

	public ArrayList<Carta> getRepositorio() {
		return this.pilha;
	}

}
































/*
public class RepositorioCartas {
	
	private Baralho baralho1 = new Baralho();
	private Baralho baralho2 = new Baralho();
	private Baralho baralho3 = new Baralho();
	private Baralho baralho4 = new Baralho();
	
	public Carta[] repositorio = new Carta[208];
	
	RepositorioCartas(){
		int aux = 0;
		for(int i = 0; i < 52; i++){
			this.repositorio[i] = baralho1.getCarta(aux);
			aux++;
		}
		
		aux = 0;
		
		for(int i = 52; i < 104; i++){
			this.repositorio[i] = baralho2.getCarta(aux);
			aux++;
		}
		
		aux = 0;
		
		for(int i = 104; i < 156; i++){
			this.repositorio[i] = baralho3.getCarta(aux);
			aux++;
		}
		
		aux = 0;
		
		for(int i = 156; i < 208; i++){
			this.repositorio[i] = baralho4.getCarta(aux);
			aux++;
		}
	}
	
	public void visualizar(int i){
		System.out.println(this.repositorio[i].getValor() + " " + this.repositorio[i].getNaipe());
	}
	
	public Carta getCarta(int i) {
		return this.repositorio[i];
	}

}
*/