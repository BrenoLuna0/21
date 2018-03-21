

public class Main {

	public static void main(String[] args) {
		
		RepositorioCartas rep = new RepositorioCartas();
		Banca banca = new Banca();
		Jogo jogo = new Jogo(banca,rep,1);
	}

	

}
