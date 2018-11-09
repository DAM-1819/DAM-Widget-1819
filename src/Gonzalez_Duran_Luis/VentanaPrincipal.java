package Gonzalez_Duran_Luis;



import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame ventana;
	JPanel contenedor;
	JLabel facebok, twitter, instagram, podemos;
	
	
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(580, 30, 578, 115);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ventana = ventana;
	}



	public void inicializarComponentes() {
		
		ventana.setLayout(null);
		
		//JPANEL
		contenedor = new JPanel(null);
		contenedor.setSize(578, 115);
		contenedor.setBackground(Color.ORANGE);
		
		ventana.add(contenedor);
	}
	
	
	
	public void inicializarListeners() {
		
		
	}


	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();	
		//inicializarListeners();	
		
	}

}
