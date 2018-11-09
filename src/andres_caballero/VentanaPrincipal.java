package andres_caballero;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaPrincipal {
	JFrame ventana;
	JPanel panel;
	Reloj timeLabel;
	
	
	public VentanaPrincipal() {
		this.ventana = new JFrame("Ventana Principal");
		ventana.setBounds(250, 150, 250, 150);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		ventana.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints settings;
		
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		ventana.add(timeLabel, settings);
		
	}
}
