package GUI;

import java.util.ArrayList;

public class VRepositorio {
	private VBaralho vbaralho1 = new VBaralho();
	private VBaralho vbaralho2 = new VBaralho();
	private VBaralho vbaralho3 = new VBaralho();
	private VBaralho vbaralho4 = new VBaralho();
	
	private ArrayList<VCarta> pilha = new ArrayList<VCarta>();
	
	public VRepositorio() {
		for(int i = 0; i < 52; i++) {
			pilha.add((VCarta) vbaralho1.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add((VCarta) vbaralho2.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add((VCarta) vbaralho3.getCarta(i));
		}
		
		for(int i = 0; i < 52; i++) {
			pilha.add((VCarta) vbaralho4.getCarta(i));
		}
	}

	public ArrayList<VCarta> getRepositorio() {
		return pilha;
	}
}
