package GUI;

import main.Baralho;

public class VBaralho extends Baralho {
	private VCarta[] baralho = new VCarta[52];
	
	public VBaralho() {
		inicializarBaralho();
	}
	
	private void inicializarBaralho(){
		baralho[0] = new VCarta(1,"Paus","A","imagens/c01.bmp");
		baralho[1] = new VCarta(2,"Paus","2","imagens/c02.bmp");
		baralho[2] = new VCarta(3,"Paus","3","imagens/c03.bmp");
		baralho[3] = new VCarta(4,"Paus","4","imagens/c04.bmp");
		baralho[4] = new VCarta(5,"Paus","5","imagens/c05.bmp");
		baralho[5] = new VCarta(6,"Paus","6","imagens/c06.bmp");
		baralho[6] = new VCarta(7,"Paus","7","imagens/c07.bmp");
		baralho[7] = new VCarta(8,"Paus","8","imagens/c08.bmp");
		baralho[8] = new VCarta(9,"Paus","9","imagens/c09.bmp");
		baralho[9] = new VCarta(10,"Paus","10","imagens/c10.bmp");
		baralho[10] = new VCarta(11,"Paus","J","imagens/c11.bmp");
		baralho[11] = new VCarta(12,"Paus","Q","imagens/c12.bmp");
		baralho[12] = new VCarta(13,"Paus","K","imagens/c13.bmp");
		
		baralho[0] = new VCarta(1,"Ouro","A","imagens/d01.bmp");
		baralho[1] = new VCarta(2,"Ouro","2","imagens/d02.bmp");
		baralho[2] = new VCarta(3,"Ouro","3","imagens/d03.bmp");
		baralho[3] = new VCarta(4,"Ouro","4","imagens/d04.bmp");
		baralho[4] = new VCarta(5,"Ouro","5","imagens/d05.bmp");
		baralho[5] = new VCarta(6,"Ouro","6","imagens/d06.bmp");
		baralho[6] = new VCarta(7,"Ouro","7","imagens/d07.bmp");
		baralho[7] = new VCarta(8,"Ouro","8","imagens/d08.bmp");
		baralho[8] = new VCarta(9,"Ouro","9","imagens/d09.bmp");
		baralho[9] = new VCarta(10,"Ouro","10","imagens/d10.bmp");
		baralho[10] = new VCarta(11,"Ouro","J","imagens/d11.bmp");
		baralho[11] = new VCarta(12,"Ouro","Q","imagens/d12.bmp");
		baralho[12] = new VCarta(13,"Ouro","K","imagens/d13.bmp");
		
		baralho[0] = new VCarta(1,"Copas","A","imagens/h01.bmp");
		baralho[1] = new VCarta(2,"Copas","2","imagens/h02.bmp");
		baralho[2] = new VCarta(3,"Copas","3","imagens/h03.bmp");
		baralho[3] = new VCarta(4,"Copas","4","imagens/h04.bmp");
		baralho[4] = new VCarta(5,"Copas","5","imagens/h05.bmp");
		baralho[5] = new VCarta(6,"Copas","6","imagens/h06.bmp");
		baralho[6] = new VCarta(7,"Copas","7","imagens/h07.bmp");
		baralho[7] = new VCarta(8,"Copas","8","imagens/h08.bmp");
		baralho[8] = new VCarta(9,"Copas","9","imagens/h09.bmp");
		baralho[9] = new VCarta(10,"Copas","10","imagens/h10.bmp");
		baralho[10] = new VCarta(11,"Copas","J","imagens/h11.bmp");
		baralho[11] = new VCarta(12,"Copas","Q","imagens/h12.bmp");
		baralho[12] = new VCarta(13,"Copas","K","imagens/h13.bmp");
		
		baralho[0] = new VCarta(1,"Espadas","A","imagens/s01.bmp");
		baralho[1] = new VCarta(2,"Espadas","2","imagens/s02.bmp");
		baralho[2] = new VCarta(3,"Espadas","3","imagens/s03.bmp");
		baralho[3] = new VCarta(4,"Espadas","4","imagens/s04.bmp");
		baralho[4] = new VCarta(5,"Espadas","5","imagens/s05.bmp");
		baralho[5] = new VCarta(6,"Espadas","6","imagens/s06.bmp");
		baralho[6] = new VCarta(7,"Espadas","7","imagens/s07.bmp");
		baralho[7] = new VCarta(8,"Espadas","8","imagens/s08.bmp");
		baralho[8] = new VCarta(9,"Espadas","9","imagens/s09.bmp");
		baralho[9] = new VCarta(10,"Espadas","10","imagens/s10.bmp");
		baralho[10] = new VCarta(11,"Espadas","J","imagens/s11.bmp");
		baralho[11] = new VCarta(12,"Espadas","Q","imagens/s12.bmp");
		baralho[12] = new VCarta(13,"Espadas","K","imagens/s13.bmp");
		
	}
}
