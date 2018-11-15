package RobertoSanAndres;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaPrincipal {

	
	//La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	

	JButton bDialogo;
	JPanel panelColor;
	JLabel label;
	//Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridLayout(1,2));
		panelColor = new JPanel();
		label = new JLabel();
		bDialogo = new CargarImagen(label);
		bDialogo.setText("Cargar Imagen");
		ventana.add(bDialogo);
	
		
		ventana.add(panelColor);	
		panelColor.add(label);
		
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
	
		
	}
	

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}
