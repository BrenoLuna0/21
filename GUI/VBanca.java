package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import estadosJogador.PlayerListener;
import main.Banca;
import main.Jogador;
import main.Participante;

public class VBanca extends Banca implements Mostravel {
	
	public VisaoBanca view;
	
	public VBanca() {
		super();
	}
	
	
	@Override
	public JComponent view() {
		if(view == null) {
			view = new VisaoBanca((VMao) getMao());
			addOptionListener(view);
		}
		return view;
	}
	
	
	private class VisaoBanca extends JPanel implements PlayerListener {
		
		private TitledBorder borda;
		
		public VisaoBanca(VMao mao) {
			super(new FlowLayout(FlowLayout.LEFT));
			String nome = VBanca.this.getNome(); // Talvez isso nao seja necessario
			setBorder(borda);
			setBackground(new Color(35,142,35));
			borda.setTitleColor(Color.black);
			add(mao.view());
			repaint();
		}

		@Override
		public void jogadorModificado(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome);
			repaint();
		}

		@Override
		public void jogadorEstourou(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome+ " Estourado");
			repaint();
		}

		@Override
		public void jogadorBlackJack(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome + " BlackJack");
			repaint();
			
		}

		@Override
		public void jogadorEsperando(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome + " Esperando");
			repaint();
			
		}

		@Override
		public void jogadorGanhou(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome + " Venceu");
			repaint();
			
		}

		@Override
		public void jogadorPerdeu(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome + " Perdeu");
			repaint();
			
		}

		@Override
		public void jogadorParou(Participante j) {
			
			String nome = VBanca.this.getNome();
			borda.setTitle(nome + " Parado");
			repaint();
			
		}
		
		
		
	}
	
	
	

}
