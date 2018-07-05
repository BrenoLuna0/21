package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import estadosJogador.PlayerListener;
import main.Participante;

public class OptionViewController implements ActionListener, PlayerListener {
	
	private GUIJogador modelo;
	private ViewJogador viewJogador;
	private OptionView view;
	private VBanca banca;
	
	public OptionViewController(GUIJogador modelo, VBanca banca, OptionView view,ViewJogador vj) {
		
		this.modelo = modelo;
		viewJogador = vj;
		modelo.addOptionListener(this);
		banca.addOptionListener(this);
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
			viewJogador.jogadorModificado(modelo);
			
		} else if(evento.getActionCommand().equals(OptionView.ESPERAR)) {
			view.enableDoubleDown(false);
			view.enablePlayerControls(false);
			view.enableGameControls(true);
			
			modelo.esperar(banca);
			
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
	public void jogadorEstourou(Participante j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);
		j.getEstado().play(banca, j);
		banca.getEstado().play(banca, banca);
		banca.getMao().getCartaMao(1).setVisivel(true);
		banca.getEstado().play(banca, banca);
		viewJogador.repaint();
	}

	@Override
	public void jogadorBlackJack(Participante j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);
		j.getEstado().play(banca, j);
		banca.getEstado().play(banca, banca);
		banca.getMao().getCartaMao(1).setVisivel(true);
		viewJogador.repaint();
		
	}

	@Override
	public void jogadorEsperando(Participante j) {
		view.enableGameControls(true);
		view.enablePlayerControls(false);
	}

	@Override
	public void jogadorGanhou(Participante j) {
		view.enablePlayerControls(false);
		view.enableGameControls(true);		
	}

	@Override
	public void jogadorPerdeu(Participante j) {
		view.enablePlayerControls(false);
		view.enableDoubleDown(false);
		view.enableGameControls(true);		
	}

	@Override
	public void jogadorParou(Participante j) {
		view.enablePlayerControls(false);
		view.enableGameControls(true);
		j.getEstado().play(banca, j);
		banca.getEstado().play(banca, banca);
		banca.getMao().getCartaMao(1).setVisivel(true);
		viewJogador.repaint();
		
	}

	@Override
	public void jogadorModificado(Participante j) {
		view.enablePlayerControls(true);
		view.enableGameControls(true);
	}

	

	
	

}
