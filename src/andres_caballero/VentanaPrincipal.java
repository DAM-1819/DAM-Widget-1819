package andres_caballero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaPrincipal {
	JFrame ventana;
	JPanel panel;
	Reloj timeLabel;

	public VentanaPrincipal() {
		this.ventana = new JFrame("Reloj Digital");
		ventana.setBounds(250, 150, 250, 150);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		GridLayout gridLayout = new GridLayout();
		ventana.getContentPane().setLayout(gridLayout);

		panel = new JPanel();
		panel.setLayout(gridLayout);
		panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 20));
		
		ventana.add(panel);
		timeLabel = new Reloj(0, 0, 50, 0);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setOpaque(true);
		panel.add(timeLabel);

		
	}
}
