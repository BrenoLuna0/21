package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantosJogadoresIro;
	private JButton btnNewButton;
	static int chave = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Banca b = new Banca();
		
		b.instanciarNovoBaralho();
		
		while(chave == -1) {
			if (chave != -1) {
				break;
			}
		}
		
		b.instanciarJogadores(chave);
		
		b.rodadaApostas(); // ok
		
		b.distribuirCartas(); // ok	
		
		b.visualizarjogadores();
		
		b.rodada(); //ok
	}

	/**
	 * Create the frame.
	 */
	public Main2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("21");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtQuantosJogadoresIro = new JTextField();
		txtQuantosJogadoresIro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantosJogadoresIro.setText("Quantos jogadores ir\u00E3o jogar?");
		GridBagConstraints gbc_txtQuantosJogadoresIro = new GridBagConstraints();
		gbc_txtQuantosJogadoresIro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantosJogadoresIro.insets = new Insets(0, 0, 0, 5);
		gbc_txtQuantosJogadoresIro.gridx = 1;
		gbc_txtQuantosJogadoresIro.gridy = 4;
		contentPane.add(txtQuantosJogadoresIro, gbc_txtQuantosJogadoresIro);
		txtQuantosJogadoresIro.setColumns(10);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chave = Integer.parseInt(txtQuantosJogadoresIro.getText());
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	
	

}
