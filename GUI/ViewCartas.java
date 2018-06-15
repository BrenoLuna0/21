package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewCartas extends JLabel {
	private ImageIcon icone;
	
	public ViewCartas(VCarta carta){
		getImagem(carta.getImagem());
		setIcon(icone);
		setBackground(Color.white);
		setOpaque(true);
	}
	
	private void getImagem(String arquivo){
		java.net.URL url = this.getClass().getResource(arquivo);
		icone = new ImageIcon(url);
	}
}
