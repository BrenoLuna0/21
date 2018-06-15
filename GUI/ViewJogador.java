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

public class ViewJogador extends JPanel implements PlayerListener{
	
	
	private TitledBorder border;
	private JPanel cartas = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	public ViewJogador(Jogador j) {
		super(new BorderLayout());
		
	}
	
	public void jogadorModificado(Jogador j){
		border.setTitle(j.getNome());
		cartas.removeAll();
		Mao mao = j.getMao();
		
		for(int i = 0; i<mao.getCartasMao().size();i++) {
			JLabel carta = new ViewCartas( (VCarta) mao.getCartaMao(i));
			cartas.add(carta);
		}
		revalidate();
		repaint();
	}

	
	public void jogadorEstourou(Jogador j) {
		border.setTitle(j.getNome() + "Estourou!");
		cartas.repaint();
	}

	
	public void jogadorBlackJack(Jogador j) {
		border.setTitle(j.getNome() + "BlackJack!");
		cartas.repaint();
	}

	
	public void jogadorEsperando(Jogador j) {
		border.setTitle(j.getNome() + "Esperando");
		cartas.repaint();
	}

	
	public void jogadorGanhou(Jogador j) {
		border.setTitle(j.getNome() + "Venceu!");
		cartas.repaint();
	}

	
	public void jogadorPerdeu(Jogador j) {
		border.setTitle(j.getNome() + "Perdeu");
		cartas.repaint();
	}

	
	public void jogadorParou(Jogador j) {
		border.setTitle(j.getNome() + "Parou");
		cartas.repaint();
	}
	
	private void buildUI(Jogador j) {
		add(cartas,BorderLayout.NORTH);
		border = new TitledBorder(j.getNome());
		cartas.setBorder(border);
		cartas.setBackground(new Color(35,142,35));
		border.setTitleColor(Color.black);
	}
	
}
