package AdrianGomez;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame ventana;
	LectorFicheros lf;
	Color color,color2;
	public VentanaPrincipal(String title) {
		ventana=new JFrame(title);
		ventana.setBounds(0, 0, 300, 250);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}
	public  void inicializarComponentes() {
		ventana.getContentPane().setLayout(new GridLayout(1, 1));
		color=Color.CYAN;
		color2=Color.LIGHT_GRAY;
		lf=new LectorFicheros(color,color2);
		ventana.getContentPane().add(lf);
	}
}
