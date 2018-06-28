package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import estadosJogador.PlayerListener;
import main.Banca;
import main.Jogador;

public class OptionViewController implements ActionListener, PlayerListener {
	
	private GUIJogador modelo;
	private OptionView view;
	private VBanca banca;
	
	public OptionViewController(GUIJogador modelo, VBanca banca, OptionView view) {
		
		this.modelo = modelo;
		//modelo.addListener(this);
		this.banca = banca;
		this.view = view;
		view.enablePlayerControls(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals(OptionView.SAIR)) {
			System.exit(0);
			
		} else if(evento.getActionCommand().equals(OptionView.JOGAR)) {
			view.enableDoubleDown(false);
			modelo.pegarCarta(banca);
			
		} else if(evento.getActionCommand().equals(OptionView.ESPERAR)) {
			view.enableDoubleDown(false);
			modelo.esperar();
			
		} else if(evento.getActionCommand().equals(OptionView.NOVO_JOGO)) {
			view.enableDoubleDown(false);
			view.enableGameControls(false);
			view.enablePlayerControls(false);
			view.enableBettingControls(true);
			//iniciar o jogo
			
		} else if(evento.getActionCommand().equals(OptionView.APOSTAR_25)) {
			view.enableBettingControls(false);
			view.enablePlayerControls(true);
			view.enableDoubleDown(true);
			modelo.apostar25();
			
		} else if(evento.getActionCommand().equals(OptionView.APOSTAR_50)) {
			view.enableBettingControls(false);
			view.enablePlayerControls(true);
			view.enableDoubleDown(true);
			modelo.apostar50();
			
		} else if(evento.getActionCommand().equals(OptionView.APOSTAR_75)) {
			view.enableBettingControls(false);
			view.enablePlayerControls(true);
			view.enableDoubleDown(true);
			modelo.apostar75();
		}
		
	}

	@Override
	public void jogadorModificado(Jogador j) {
		
	}

	@Override
	public void jogadorEstourou(Jogador j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);
		
	}

	@Override
	public void jogadorBlackJack(Jogador j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);
		
	}

	@Override
	public void jogadorEsperando(Jogador j) {
		view.enableGameControls(true);
		view.enablePlayerControls(false);
		
	}

	@Override
	public void jogadorGanhou(Jogador j) {
		view.enablePlayerControls(false);
		view.enableGameControls(true);
		
	}

	@Override
	public void jogadorPerdeu(Jogador j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);
		
	}

	@Override
	public void jogadorParou(Jogador j) {
		view.enablePlayerControls(false);
		view.enableGameControls(true);
		
	}

	

	
	

}
