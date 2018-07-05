package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import estadosJogador.Ganhou;
import estadosJogador.PlayerListener;
import main.Banca;
import main.Jogador;
import main.Mao;
import main.Participante;

public class VBanca extends Banca implements Mostravel {
	
	public ViewJogador view;
	public OptionView op;
	public JFrame j;
	
	public VBanca() {
		super();
	}
	
	public void initView(){
		
		
		j = new JFrame();
		
		j.setTitle("21");
		
		op = new OptionView(getJogador(0),this,viewJogadores.get(0));
		
		view = new ViewJogador(this);
		
		//op.add(viewJogadores.get(0),BorderLayout.LINE_END);
		op.add(viewJogadores.get(1),BorderLayout.LINE_END);
		op.add(view,BorderLayout.WEST);
		
		
		j.getContentPane().add(op);
		
		view.jogadorModificado(this);
		viewJogadores.get(0).jogadorModificado(getJogador(0));
		
		j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setVisible(true);
	}
	
	
	@Override
	public JComponent view() {
		if(view == null) {
			//view = new VisaoBanca((VMao) getMao(), getJogador(0));
			addOptionListener(view);
		}
		return view;
	}
	
	
	public class VisaoBanca extends JPanel implements PlayerListener {
		
		private TitledBorder borda;
		private JPanel cartas = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		public VisaoBanca(VMao mao, Participante p) {
			
			//super(new BorderLayout());
			super(new FlowLayout(FlowLayout.LEFT));
			String nome = VBanca.this.getNome(); // Talvez isso nao seja necessario
			borda = new TitledBorder(nome);
			setBorder(borda);
			setBackground(new Color(35,142,35));
			borda.setTitleColor(Color.black);
			/*buildUI(p);
			p.addListener(this);*/
			add(mao.view(),BorderLayout.SOUTH);
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
		
		private void buildUI(Participante j) {
			add(cartas,BorderLayout.NORTH);
			borda = new TitledBorder("Banca");
			cartas.setBorder(borda);
			cartas.setBackground(new Color(35,142,35));
			borda.setTitleColor(Color.black);
		}
		
		
		
	}
	
	
	

}
