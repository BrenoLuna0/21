import java.util.ArrayList;
import java.util.Random;

/*public class PreJogo {
	
	public void faseDistribuicao(Banca banca, ArrayList<Jogador> jogadores, int qtd, RepositorioCartas rep) {
		Random gerador = new Random();
		int carta;
		
		
		for(int i = 0; i < qtd; i++) {
			
			carta = gerador.nextInt(209);
			while(rep.repositorio[carta].isRetirado() == true) {
				carta = gerador.nextInt(209);
			}
			
			jogadores.get(i).setMao(rep.repositorio[carta]);
			rep.repositorio[carta].setRetirado(true);
		}
		
		carta = gerador.nextInt(209);
		while(rep.repositorio[carta].isRetirado() == true) {
			carta = gerador.nextInt(209);
		}
		
		banca.setCartaAberta(rep.repositorio[carta]);
		rep.repositorio[carta].setRetirado(true);
		
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		for(int i = 0; i < qtd; i++) {
			
			carta = gerador.nextInt(209);
			while(rep.repositorio[carta].isRetirado() == true) {
				carta = gerador.nextInt(209);
			}
			
			jogadores.get(i).setMao(rep.repositorio[carta]);
			rep.repositorio[carta].setRetirado(true);
		}
		
		
		carta = gerador.nextInt(209);
		while(rep.repositorio[carta].isRetirado() == true) {
			carta = gerador.nextInt(209);
		}
		
		banca.setCartaFechada(rep.repositorio[carta]);
		rep.repositorio[carta].setRetirado(true);
		
		
	}
	
	public void contagemPontosInicial(Banca banca, ArrayList<Jogador> jogadores, int qtd) {
		
		
		for (int i = 0; i < qtd; i++) {
			if(jogadores.get(i).getMao().get(0).getValor() == 1 ) {
				jogadores.get(i).setPontos(11 + jogadores.get(i).getMao().get(1).getValor());
			}else if(jogadores.get(i).getMao().get(1).getValor() == 1) {
				jogadores.get(i).setPontos(11 + jogadores.get(i).getMao().get(0).getValor());
			}else if(jogadores.get(i).getMao().get(0).getValor() == 1  && jogadores.get(i).getMao().get(1).getValor() == 1 ) {
				jogadores.get(i).setPontos(12);
			}else {
				jogadores.get(i).setPontos(jogadores.get(i).getMao().get(0).getValor() + jogadores.get(i).getMao().get(1).getValor());
			}
		}
			
			
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(banca.getCartaAberta().getValor() == 1) {
			banca.setPontos(11 + banca.getCartaFechada().getValor());
		}else if(banca.getCartaFechada().getValor() == 1) {
			banca.setPontos(11 + banca.getCartaAberta().getValor());
		}else if(banca.getCartaFechada().getValor() == 1 && banca.getCartaAberta().getValor() == 1) {
			banca.setPontos(12);
		}
		
		
	}

}

*/
