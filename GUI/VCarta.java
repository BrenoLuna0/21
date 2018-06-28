package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import main.Carta;

public class VCarta extends Carta implements Mostravel{

	String imagem;
	private CartaVisivel view;
	
	
	public VCarta(int valor, String naipe, String valorFace,String img) {
		super(valor, naipe, valorFace);
		imagem = img;
		view = new CartaVisivel(getImagem());
	}
	
	public String getImagem(){
		if(faceVisivel()){
			return imagem;
		}
		else {
			return "/imagens/ec.jpg";
		}
	}
	
	public JComponent view() {
		return view;
	}
	
	private class CartaVisivel extends JLabel{
		
		public CartaVisivel(String imagem) {
			setImagem(imagem);
			setBackground(Color.white);
			setOpaque(true);
		}
		
		private void setImagem(String imagem) {
			String url = imagem;
			ImageIcon icone = new ImageIcon(url);
			setIcon(icone);
		}
		
		public void Modificado() {
			setImagem(getImagem());
		}
		
	}



}
