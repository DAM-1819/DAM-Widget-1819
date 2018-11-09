package Ramos_Gil_Jorge;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainWindow {

	private JFrame jframe;
	
	public MainWindow() {
		jframe = new JFrame("Principal");
		jframe.setBounds(0, 0, 800, 600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes() {
		
		jframe.setLayout(new GridBagLayout());
	}
	
	public void inicializar() {
		jframe.setVisible(true);
		inicializarComponentes();
	}
}