package AdrianGomez;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal {
	JFrame ventana;
	LectorFicheros lf;
	public VentanaPrincipal(String title) {
		ventana=new JFrame(title);
		ventana.setBounds(0, 0, 200, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}
	public  void inicializarComponentes() {
		ventana.getContentPane().setLayout(new GridLayout(1, 1));
		lf=new LectorFicheros();
		ventana.getContentPane().add(lf);
	}
}
