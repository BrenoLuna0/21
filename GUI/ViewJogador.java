package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import estadosJogador.PlayerListener;
import main.Jogador;
import main.Mao;
import main.Participante;

public class ViewJogador extends JPanel implements PlayerListener{
	
	
	private TitledBorder border;
	private JPanel cartas = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	public ViewJogador(Participante j) {
		super(new BorderLayout());
		buildUI(j);
		j.addListener(this);
	}
	
	public void jogadorModificado(Participante j){
		cartas.removeAll();
		Mao mao = j.getMao();
		
		for(int i = 0; i<mao.getCartasMao().size();i++) {
			JLabel carta = new ViewCartas(mao.getCartaMao(i));
			cartas.add(carta);
			cartas.setVisible(true);
		}
		revalidate();
		repaint();
	}

	
	public void jogadorEstourou(Participante p) {
		border.setTitle(p.getNome() + " Estourou!");
		cartas.repaint();
	}

	
	public void jogadorBlackJack(Participante j) {
		border.setTitle(j.getNome() + " BlackJack!");
		cartas.repaint();
	}

	
	public void jogadorEsperando(Participante j) {
		border.setTitle(j.getNome() + " Esperando");
		cartas.repaint();
	}

	
	public void jogadorGanhou(Participante j) {
		border.setTitle(j.getNome() + " Venceu!");
		cartas.repaint();
	}

	
	public void jogadorPerdeu(Participante j) {
		border.setTitle(j.getNome() + " Perdeu");
		cartas.repaint();
	}

	
	public void jogadorParou(Participante j) {
		border.setTitle(j.getNome() + " Parou");
		cartas.repaint();
	}
	
	private void buildUI(Participante j) {
		add(cartas,BorderLayout.NORTH);
		border = new TitledBorder(j.getNome());
		cartas.setBorder(border);
		cartas.setBackground(new Color(35,142,35));
		border.setTitleColor(Color.black);
	}
	
}
