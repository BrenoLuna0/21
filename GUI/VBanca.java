package GUI;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import main.Banca;

public class VBanca extends Banca implements Mostravel {
	
	public ViewJogador view;
	public OptionView op;
	public JFrame j;
	
	public VBanca() {
		super();
	}
	
	public void initView(){
		
		
		j = new JFrame();
		
		j.setTitle("21");
		
		op = new OptionView(getJogador(0),this,viewJogadores.get(0));
		
		view = new ViewJogador(this);
		
		op.add(viewJogadores.get(0),BorderLayout.EAST);
		op.add(view,BorderLayout.WEST);
		
		
		j.getContentPane().add(op);
		
		view.jogadorModificado(this);
		viewJogadores.get(0).jogadorModificado(getJogador(0));
		
		j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setVisible(true);
	}
	
	
	@Override
	public JComponent view() {
		if(view == null) {
			//view = new VisaoBanca((VMao) getMao(), getJogador(0));
			addOptionListener(view);
		}
		return view;
	}
	
	
	
	
	

}
