package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OptionView extends JPanel{
	public static final String NOVO_JOGO = "novo";
	public static final String SAIR = "sair";
	public static final String JOGAR = "jogar";
	public static final String ESPERAR = "esperar";
	public static final String APOSTAR_25 = "apostar_25";
	public static final String APOSTAR_50 = "apostar_50";
	public static final String APOSTAR_75 = "apostar_75";
	public static final String DOUBLE_DOWN = "dd";
	
	
	private JButton apostar_25 = new JButton("$25");
	private JButton apostar_50 = new JButton("$50");
	private JButton apostar_75 = new JButton("$75");
	private JButton novo_jogo = new JButton("$Novo Jogo");
	private JButton sair = new JButton("$Sair");
	private JButton jogar = new JButton("$Jogar");
	private JButton esperar = new JButton("$Esperar");
	private JButton ddown = new JButton("$Double Down");
	
	
	private VBanca banca;
	private GUIJogador jogador;
	
	private static final Color FOREST_GREEN = new Color(35,142,35);

	public OptionView(GUIJogador jogador, VBanca banca,ViewJogador vj) {
		super(new BorderLayout());
		this.jogador = jogador;
		this.banca = banca;
		attachController(makeController(vj));
		buildGUI();
	}
	
	public void attachController(OptionViewController controller) {
		sair.addActionListener(controller);
		jogar.addActionListener(controller);
		esperar.addActionListener(controller);
		apostar_25.addActionListener(controller);
		apostar_50.addActionListener(controller);
		apostar_75.addActionListener(controller);
	}
	
	public void enableDoubleDown(boolean b) {
		ddown.setEnabled(b);
	}
	
	public void enableBettingControls(boolean b) {
		apostar_25.setEnabled(b);
		apostar_50.setEnabled(b);
		apostar_75.setEnabled(b);
	}

	public void enablePlayerControls(boolean b) {
		jogar.setEnabled(b);
		esperar.setEnabled(b);
	}
	
	public void enableGameControls(boolean b) {
		sair.setEnabled(b);
	}
	
	protected OptionViewController makeController(ViewJogador vj) {
		return new OptionViewController(jogador,banca,this,vj);
	}

	private void buildGUI() {
		JPanel betting_controls = new JPanel();
		JPanel game_controls = new JPanel();
		add(betting_controls,BorderLayout.NORTH);
		add(game_controls,BorderLayout.SOUTH);
		betting_controls.setBackground(FOREST_GREEN);
		game_controls.setBackground(FOREST_GREEN);
		ddown.setActionCommand(DOUBLE_DOWN);
		sair.setActionCommand(SAIR);
		jogar.setActionCommand(JOGAR);
		esperar.setActionCommand(ESPERAR);
		apostar_25.setActionCommand(APOSTAR_25);
		apostar_50.setActionCommand(APOSTAR_50);
		apostar_75.setActionCommand(APOSTAR_75);
		betting_controls.add(apostar_25);
		betting_controls.add(apostar_50);
		betting_controls.add(apostar_75);
		game_controls.add(ddown);
		game_controls.add(sair);
		game_controls.add(jogar);
		game_controls.add(esperar);
		enableBettingControls(true);
		enablePlayerControls(false);
		enableDoubleDown(false);
	}








}
