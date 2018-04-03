public class Main {

	public static void main(String[] args) {
		RepositorioCartas rep = new RepositorioCartas();
		Banca banca = new Banca();
		Jogo jogo = new Jogo(1,banca,rep);
		jogo.rodada();
	}

	

}
