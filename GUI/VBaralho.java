package GUI;

import main.Baralho;

public class VBaralho extends Baralho {
	private VCarta[] baralho = new VCarta[52];
	
	public VBaralho() {
		inicializarVBaralho();
	}
	
	private void inicializarVBaralho(){
		baralho[0] = new VCarta(11,"Paus","A","/imagens/c01.png");
		baralho[1] = new VCarta(2,"Paus","2","/imagens/c02.png");
		baralho[2] = new VCarta(3,"Paus","3","/imagens/c03.png");
		baralho[3] = new VCarta(4,"Paus","4","/imagens/c04.png");
		baralho[4] = new VCarta(5,"Paus","5","/imagens/c05.png");
		baralho[5] = new VCarta(6,"Paus","6","/imagens/c06.png");
		baralho[6] = new VCarta(7,"Paus","7","/imagens/c07.png");
		baralho[7] = new VCarta(8,"Paus","8","/imagens/c08.png");
		baralho[8] = new VCarta(9,"Paus","9","/imagens/c09.png");
		baralho[9] = new VCarta(10,"Paus","10","/imagens/c010.png");
		baralho[10] = new VCarta(10,"Paus","J","/imagens/c011.png");
		baralho[11] = new VCarta(10,"Paus","Q","/imagens/c012.png");
		baralho[12] = new VCarta(10,"Paus","K","/imagens/c013.png");
		
		baralho[0] = new VCarta(11,"Ouro","A","/imagens/d01.png");
		baralho[1] = new VCarta(2,"Ouro","2","/imagens/d02.png");
		baralho[2] = new VCarta(3,"Ouro","3","/imagens/d03.png");
		baralho[3] = new VCarta(4,"Ouro","4","/imagens/d04.png");
		baralho[4] = new VCarta(5,"Ouro","5","/imagens/d05.png");
		baralho[5] = new VCarta(6,"Ouro","6","/imagens/d06.png");
		baralho[6] = new VCarta(7,"Ouro","7","/imagens/d07.png");
		baralho[7] = new VCarta(8,"Ouro","8","/imagens/d08.png");
		baralho[8] = new VCarta(9,"Ouro","9","/imagens/d09.png");
		baralho[9] = new VCarta(10,"Ouro","10","/imagens/d010.png");
		baralho[10] = new VCarta(10,"Ouro","J","/imagens/d011.png");
		baralho[11] = new VCarta(10,"Ouro","Q","/imagens/d012.png");
		baralho[12] = new VCarta(10,"Ouro","K","/imagens/d013.png");
		
		baralho[0] = new VCarta(11,"Copas","A","/imagens/h01.png");
		baralho[1] = new VCarta(2,"Copas","2","/imagens/h02.png");
		baralho[2] = new VCarta(3,"Copas","3","/imagens/h03.png");
		baralho[3] = new VCarta(4,"Copas","4","/imagens/h04.png");
		baralho[4] = new VCarta(5,"Copas","5","/imagens/h05.png");
		baralho[5] = new VCarta(6,"Copas","6","/imagens/h06.png");
		baralho[6] = new VCarta(7,"Copas","7","/imagens/h07.png");
		baralho[7] = new VCarta(8,"Copas","8","/imagens/h08.png");
		baralho[8] = new VCarta(9,"Copas","9","/imagens/h09.png");
		baralho[9] = new VCarta(10,"Copas","10","/imagens/h010.png");
		baralho[10] = new VCarta(10,"Copas","J","/imagens/h011.png");
		baralho[11] = new VCarta(10,"Copas","Q","/imagens/h012.png");
		baralho[12] = new VCarta(10,"Copas","K","/imagens/h013.png");
		
		baralho[0] = new VCarta(11,"Espadas","A","/imagens/s01.png");
		baralho[1] = new VCarta(2,"Espadas","2","/imagens/s02.png");
		baralho[2] = new VCarta(3,"Espadas","3","/imagens/s03.png");
		baralho[3] = new VCarta(4,"Espadas","4","/imagens/s04.png");
		baralho[4] = new VCarta(5,"Espadas","5","/imagens/s05.png");
		baralho[5] = new VCarta(6,"Espadas","6","/imagens/s06.png");
		baralho[6] = new VCarta(7,"Espadas","7","/imagens/s07.png");
		baralho[7] = new VCarta(8,"Espadas","8","/imagens/s08.png");
		baralho[8] = new VCarta(9,"Espadas","9","/imagens/s09.png");
		baralho[9] = new VCarta(10,"Espadas","10","/imagens/s010.png");
		baralho[10] = new VCarta(10,"Espadas","J","/imagens/s011.png");
		baralho[11] = new VCarta(10,"Espadas","Q","/imagens/s012.png");
		baralho[12] = new VCarta(10,"Espadas","K","/imagens/s013.png");
		
	}
}
