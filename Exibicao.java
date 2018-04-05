
public class Exibicao {
	
	public static void inicio() {
		System.out.println("In�cio das jogadas");
	}
	
	public static void rodadaApostas() {
		System.out.println("Rodada de apostas!");
	}
	
	public static void apostaJogador(Jogador j) {
		System.out.println(j.getNome() + " qual a sua aposta?");
	}
	
	public static void apostaInvalida() {
		System.out.println("Aposta inv�lida. Digite o n�mero novamente");
	}
	
	public static void confirmacaoAposta(Jogador j, int entrada) {
		System.out.println(j.getNome() + " apostou: " + entrada);
	}
	
	public static void maoAtual(int i) {
		i+=1;
		System.out.println("M�o atual: " + i);
	}
	
	public static void exibirCartasMao(Jogador j, int i) {
		for (int a = 0; a < j.getMao(i).getArrayMao().size(); a++) {
			System.out.println(
					j.getMao(i).getCartaMao(a).getValor() + " de " + j.getMao(i).getCartaMao(a).getNaipe());
		}
		
	}
	
	public static void pontuacaoMao(Jogador j, int i) {
		System.out.println("Voc� possui " + j.getMao(i).getPontos() + " pontos nessa m�o");
	}
	
	public static void menuJogadas1() {
		System.out.println(" 1 - Receber Carta");
		System.out.println(" 2 - Dobrar Aposta");
		System.out.println(" 3 - Dividir Par");
		System.out.println(" 4 - Parar jogada");
	}
	
	public static void jogadaFinalizada() {
		System.out.println("Jogada finalizada para essa m�o");
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
		System.out.println(j.getNome() + " voc� venceu");
		System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgVitoria2(Jogador j, int i) { // 
		System.out.println(j.getNome() +" tem mais pontos!");
		System.out.println(j.getNome() + " voc� venceu");
		System.out.println(j.getNome() + " recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgVitoria3(Jogador j, int i) { // 
		System.out.println(j.getNome() +"fez um vinte e um!!");
		System.out.println(j.getNome() + " voc� venceu");
		System.out.println(j.getNome() + " recebe R$" + (3 * j.getMao(i).getValorAposta()) / 2);
	}
	
	public static void msgDerrota1(Jogador j, int i) { // 
		System.out.println(j.getNome() + " estourou 21 pontos!");
		System.out.println(j.getNome() + " voc� perdeu");
		System.out.println("A banca recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgDerrota2(Jogador j, int i) { // 
		System.out.println("A banca tem mais pontos!");
		System.out.println(j.getNome() + " voc� � perdeu");
		System.out.println("A banca recebe R$" + 2 * j.getMao(i).getValorAposta());
	}
	
	public static void msgDerrota3(Jogador j, int i) { // 
		System.out.println("A banca fez um vinte e um!!");
		System.out.println(j.getNome() + " voc� � perdeu");
		System.out.println(" A banca recebe R$" + (3 * j.getMao(i).getValorAposta()) / 2);
	}
	
	public static void erroReceberCarta() {
		System.out.println("Voce n�o pode mais receber cartas");
	}
	
	
	public static void msgCartaRecebida() {
		System.out.println("Voce n�o pode mais receber cartas");
	}
	
	public static void recebimentoCarta(Jogador j, Carta c) {
		System.out.println(j.getNome() + " recebeu um " + c.getValor() +" de "+ c.getNaipe());
	}
	
	public static void iniciarJogadores() {
		System.out.println("Quantidade de jogadores na mesa");
	}
	
	public static void nomeJogador(int i) {
		i+=1;
		System.out.println("Qual o nome do jogador " + i);
	}
	
	public static void validaQtdJogadores() {
		System.out.println("Quantidade m�xima de jogadores � 7");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
