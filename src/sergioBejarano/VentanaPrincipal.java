package sergioBejarano;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	
	JFrame ventana;
	Zodiaco zodiac;
	
	public VentanaPrincipal() {
		this.ventana = new JFrame();
		this.ventana.setBounds(450, 450, 350, 180);
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void inicializar() {
		inicializarComponentes();
		this.ventana.setVisible(true);
	}
	
	public void inicializarComponentes() {
		ventana.setLayout(new GridLayout());
		zodiac = new Zodiaco();
		ventana.add(zodiac);
	}
	
	
}
