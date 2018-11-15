package finiestab;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class VentanaPrincipal {

	
	//La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	JButton bDialogo;
	//Crear clase DialogHighScore,un nombre del jugador y la puntuaci�n
	DialogHighScore high;
	String nombre;
	int puntuacion=0;
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
		ventana.setLayout(new GridLayout(1,1));
		
		bDialogo = new JButton("Lanzar");
		ventana.add(bDialogo);	
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		bDialogo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Inicializaci�n del DialogHighScore
				high=new DialogHighScore(puntuacion,ventana,nombre);		
			}
		});;
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
