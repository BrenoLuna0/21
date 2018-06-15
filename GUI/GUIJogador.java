package GUI;

import estadosJogador.Jogavel;
import main.Banca;
import main.Jogador;

public class GUIJogador extends Jogador {

	public GUIJogador(String nome) {
		super(nome);
	}
	
	public void pegarCarta(Banca b) {
		b.darCarta(this);
	}
	
	public void esperar() {
		setEstadoAtual(new Jogavel());
	}

}
