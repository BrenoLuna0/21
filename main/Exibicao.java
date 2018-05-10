package main;

public class Exibicao {
	
	public static void inicio() {
		System.out.println("Início das jogadas");
	}
	
	public static void rodadaApostas() {
		System.out.println("Rodada de apostas!");
	}
	
	public static void apostaJogador(Jogador j) {
		System.out.println(j.getNome() + " qual a sua aposta?");
	}
	
	public static void apostaInvalida() {
		System.out.println("Aposta inválida. Digite o número novamente");
	}
	
	public static void jogadorEliminado(Jogador j) {
		System.out.println(j.getNome() +" não tem mais dinheiro para apostar, foi ELIMINADO");
	}
	
	public static void entradaInvalida() {
		System.out.println("Entrada inválida. Digite o número novamente");
	}
	public static void saidaJogador(Jogador j) {
		System.out.println(j.getNome() + " saiu do jogo");
	}
	
	public static void permanenciaJogador(Jogador j) {
		System.out.println(j.getNome() + " continua no jogo, aguarde a proxima rodada começar");
	}
	
	public static void confirmacaoAposta(Jogador j, int entrada) {
		System.out.println(j.getNome() + " apostou: " + entrada);
	}
	
	public static void maoAtual(int i) {
		i+=1;
		System.out.println("Mão atual: " + i);
	}
	
	public static void exibirCartasMao(Jogador j, int i) {
		for (int a = 0; a < j.getMao(i).getArrayMao().size(); a++) {
			System.out.println(
					j.getMao(i).getCartaMao(a).getValor() + " de " + j.getMao(i).getCartaMao(a).getNaipe());
		}
		
	}
	
	public static void pontuacaoMao(Jogador j, int i) {
		System.out.println("Você possui " + j.getMao(i).getPontos() + " pontos nessa mão");
	}
	
	public static void menuJogadas1() {
		System.out.println(" 1 - Receber Carta");
		System.out.println(" 2 - Dobrar Aposta");
		System.out.println(" 3 - Dividir Par");
		System.out.println(" 4 - Parar jogada");
	}
	
	public static void jogadaFinalizada() {
		System.out.println("Jogada finalizada para essa mão");
	}
	
	public static void menuJogadas2() {
		System.out.println(" 1 - Receber Carta");
		System.out.println(" 2 - Dobrar Aposta");
		System.out.println(" 3 - Parar jogada");
	}
	
	public static void escolhaJogada(Jogador j) {
		System.out.println(j.getNome() + " Escolha sua jogada:");
	}
	
	public static void msgVitoria1(Jogador j, int i) { // 
		System.out.println("A banca estourou 21 pontos!");
		System.out.println(j.getNome() + " você venceu");
		//System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgVitoria2(Jogador j, int i) { // 
		System.out.println(j.getNome() +" tem mais pontos!");
		System.out.println(j.getNome() + " você venceu");
		//System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgVitoria3(Jogador j, int i) { // 
		System.out.println(j.getNome() +" fez um vinte e um!!");
		System.out.println(j.getNome() + " você venceu");
		//System.out.println(j.getNome() + " recebe R$" + ((3 * j.getMao(i).getValorAposta()) / 2));
	}
	
	public static void msgDerrota1(Jogador j, int i) { // 
		System.out.println(j.getNome() + " estourou 21 pontos!");
		System.out.println(j.getNome() + " você perdeu");
		//System.out.println("A banca recebe R$" + j.getMao(i).getValorAposta());
	}
	
	public static void msgDerrota2(Jogador j, int i) { // 
		System.out.println("A banca tem mais pontos!");
		System.out.println(j.getNome() + " você perdeu");
		//System.out.println("A banca recebe R$" + j.getMao(i).getValorAposta());
	}
	
	public static void msgDerrota3(Jogador j, int i) { // 
		System.out.println("A banca fez um vinte e um!!");
		System.out.println(j.getNome() + " você perdeu");
		//System.out.println(" A banca recebe R$" + j.getMao(i).getValorAposta());
	}
	
	public static void msgEmpate(Jogador j) {
		System.out.println(j.getNome() +" e a Banca estouraram 21, o jogo empatou.");
	}
	
	public static void erroReceberCarta() {
		System.out.println("Voce não pode mais receber cartas");
	}
	
	
	public static void msgCartaRecebida() {
		System.out.println("Voce não pode mais receber cartas");
	}
	
	public static void recebimentoCarta(Participante p, Carta c) {
		System.out.println(p.getNome() + " recebeu um " + c.getValor() +" de "+ c.getNaipe());
	}
	
	public static void recebimentoCarta(Carta c) {
		System.out.println("A banca recebeu um " + c.getValor() +" de "+ c.getNaipe());
	}
	
	public static void iniciarJogadores() {
		System.out.println("Quantidade de jogadores na mesa");
	}
	
	public static void nomeJogador(int i) {
		i+=1;
		System.out.println("Qual o nome do jogador " + i);
	}
	
	public static void validaQtdJogadores() {
		System.out.println("Quantidade máxima de jogadores é 7");
	}
	
	
	public static void mostrarCartaBanca(Banca b) {
		System.out.println("A banca possui um " + b.getMao().getCartaMao(0).getValor() + " de " + b.getMao().getCartaMao(0).getNaipe());
		System.out.println();
		System.out.println();
	}
	
	
	public static void mostrarTodasCartasBanca(Banca b) {
		System.out.println("A banca possui um " + b.getMao().getCartaMao(0).getValor() + " de " + b.getMao().getCartaMao(0).getNaipe());
		System.out.println("A banca possui um " + b.getMao().getCartaMao(1).getValor() + " de " + b.getMao().getCartaMao(1).getNaipe());
	}
	
	public static void rodadaBanca() {
		System.out.println("Rodada da Banca");
		
	}
	
	public static void jogarNovamente(Jogador j) {
		System.out.println(j.getNome() + " Gostaria de jogar novamente?");		
	}
	
	public static void menuJogarNovamente() {
		System.out.println(" 1 - sim");	
		System.out.println(" 2 - não");	
	}
	
	public static void finalJogo() {
		System.out.println("Todos os jogadores Sairam, fim de jogo");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
