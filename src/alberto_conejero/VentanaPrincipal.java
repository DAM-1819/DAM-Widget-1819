package alberto_conejero;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class VentanaPrincipal {

	
	
	JFrame ventana;
	JButton muestraPanel;

	
	
	
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 150, 150);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
	public void inicializarListeners(){
		muestraPanel.addActionListener(e->{
			SavePreview panel = new SavePreview();
		});
	}
	
	public void inicializarComponentes(){
		ventana.setLayout(new GridBagLayout());
		muestraPanel = new JButton("Prueba");
		ventana.add(muestraPanel);
		
		
		
		
	}
	
	
	

	
	
}
