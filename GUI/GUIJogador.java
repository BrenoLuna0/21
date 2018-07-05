package GUI;

import estadosJogador.Parada;
import main.Banca;
import main.Jogador;

public class GUIJogador extends Jogador {

	public GUIJogador(String nome) {
		super(nome);
	}
	
	public void pegarCarta(Banca b) {
		b.darCarta(this);
	}
	
	public void esperar(VBanca b) {
		setEstadoAtual(new Parada());
	}

}
