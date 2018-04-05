import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		RepositorioCartas rep = new RepositorioCartas();
		Banca banca = new Banca();
		
		int entrada;
		Scanner s = new Scanner(System.in);
		Exibicao.iniciarJogadores();
		
		entrada = s.nextInt();
		
		while(entrada > 7) {
			Exibicao.validaQtdJogadores();
			entrada = s.nextInt();
		}
		
		
		Jogo jogo = new Jogo(entrada,banca,rep);
		
		jogo.rodada();
	}

	

}
