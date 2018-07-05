package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import main.Banca;
import main.Jogador;
import main.Mao;

public class VMao extends Mao implements Mostravel {

	public VMao(Banca b) {
		super(b);
	}
	
	public VMao(Jogador j) {
		super(j);
	}
	
	private MaoVisivel view = new MaoVisivel();

	@Override
	public JComponent view() {
		return view;
	}
	
	public void addCarta(VCarta c) {
		super.addCarta(c);
		view.modificado();
	}
	
	public void addCarta(VCarta c, VBanca b) {
		super.addCarta(c, b);
		view.modificado();
	}
	
	private class MaoVisivel extends JPanel {
		public MaoVisivel() {
			super(new FlowLayout(FlowLayout.LEFT));
			setBackground(new Color(35,142,35));
		}
		
		public void modificado() {
			removeAll();
			for(int i = 0; i < getCartasMao().size(); i++) {
				VCarta carta = (VCarta) getCartaMao(i);
				add(carta.view());
			}
			revalidate();
		}
	}
	
	

}
