package GUI;

import main.Baralho;

public class VBaralho {
	private VCarta[] baralho = new VCarta[52];
	
	public VBaralho() {
		inicializarBaralho();
	}
	
	private void inicializarBaralho(){
		baralho[0] = new VCarta(1,"Paus","A","/imagens/c01.png");
		baralho[1] = new VCarta(2,"Paus","2","/imagens/c02.png");
		baralho[2] = new VCarta(3,"Paus","3","/imagens/c03.png");
		baralho[3] = new VCarta(4,"Paus","4","/imagens/c04.png");
		baralho[4] = new VCarta(5,"Paus","5","/imagens/c05.png");
		baralho[5] = new VCarta(6,"Paus","6","/imagens/c06.png");
		baralho[6] = new VCarta(7,"Paus","7","/imagens/c07.png");
		baralho[7] = new VCarta(8,"Paus","8","/imagens/c08.png");
		baralho[8] = new VCarta(9,"Paus","9","/imagens/c09.png");
		baralho[9] = new VCarta(10,"Paus","10","/imagens/c10.png");
		baralho[10] = new VCarta(11,"Paus","J","/imagens/c11.png");
		baralho[11] = new VCarta(12,"Paus","Q","/imagens/c12.png");
		baralho[12] = new VCarta(13,"Paus","K","/imagens/c13.png");
		
		baralho[13] = new VCarta(1,"Ouro","A","/imagens/d01.png");
		baralho[14] = new VCarta(2,"Ouro","2","/imagens/d02.png");
		baralho[15] = new VCarta(3,"Ouro","3","/imagens/d03.png");
		baralho[16] = new VCarta(4,"Ouro","4","/imagens/d04.png");
		baralho[17] = new VCarta(5,"Ouro","5","/imagens/d05.png");
		baralho[18] = new VCarta(6,"Ouro","6","/imagens/d06.png");
		baralho[19] = new VCarta(7,"Ouro","7","/imagens/d07.png");
		baralho[20] = new VCarta(8,"Ouro","8","/imagens/d08.png");
		baralho[21] = new VCarta(9,"Ouro","9","/imagens/d09.png");
		baralho[22] = new VCarta(10,"Ouro","10","/imagens/d10.png");
		baralho[23] = new VCarta(11,"Ouro","J","/imagens/d11.png");
		baralho[24] = new VCarta(12,"Ouro","Q","/imagens/d12.png");
		baralho[25] = new VCarta(13,"Ouro","K","/imagens/d13.png");
		
		baralho[26] = new VCarta(1,"Copas","A","/imagens/h01.png");
		baralho[27] = new VCarta(2,"Copas","2","/imagens/h02.png");
		baralho[28] = new VCarta(3,"Copas","3","/imagens/h03.png");
		baralho[29] = new VCarta(4,"Copas","4","/imagens/h04.png");
		baralho[30] = new VCarta(5,"Copas","5","/imagens/h05.png");
		baralho[31] = new VCarta(6,"Copas","6","/imagens/h06.png");
		baralho[32] = new VCarta(7,"Copas","7","/imagens/h07.png");
		baralho[33] = new VCarta(8,"Copas","8","/imagens/h08.png");
		baralho[34] = new VCarta(9,"Copas","9","/imagens/h09.png");
		baralho[35] = new VCarta(10,"Copas","10","/imagens/h10.png");
		baralho[36] = new VCarta(11,"Copas","J","/imagens/h11.png");
		baralho[37] = new VCarta(12,"Copas","Q","/imagens/h12.png");
		baralho[38] = new VCarta(13,"Copas","K","/imagens/h13.png");
		
		baralho[39] = new VCarta(1,"Espadas","A","/imagens/s01.png");
		baralho[40] = new VCarta(2,"Espadas","2","/imagens/s02.png");
		baralho[41] = new VCarta(3,"Espadas","3","/imagens/s03.png");
		baralho[42] = new VCarta(4,"Espadas","4","/imagens/s04.png");
		baralho[43] = new VCarta(5,"Espadas","5","/imagens/s05.png");
		baralho[44] = new VCarta(6,"Espadas","6","/imagens/s06.png");
		baralho[45] = new VCarta(7,"Espadas","7","/imagens/s07.png");
		baralho[46] = new VCarta(8,"Espadas","8","/imagens/s08.png");
		baralho[47] = new VCarta(9,"Espadas","9","/imagens/s09.png");
		baralho[48] = new VCarta(10,"Espadas","10","/imagens/s10.png");
		baralho[49] = new VCarta(11,"Espadas","J","/imagens/s11.png");
		baralho[50] = new VCarta(12,"Espadas","Q","/imagens/s12.png");
		baralho[51] = new VCarta(13,"Espadas","K","/imagens/s13.png");
		
	}

	public VCarta getCarta(int i) {
		return baralho[i];
	}
}
