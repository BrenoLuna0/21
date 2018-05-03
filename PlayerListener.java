
public interface PlayerListener {
	public void jogadorModificado(Jogador j);
	public void jogadorEstourou(Jogador j);
	public void jogadorBlackJack(Jogador j);
	public void jogadorEsperando(Jogador j);
	public void jogadorGanhou(Jogador j);
	public void jogadorPerdeu(Jogador j);
	public void jogadorParou(Jogador j);
}
