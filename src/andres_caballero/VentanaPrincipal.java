package andres_caballero;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {
	JFrame ventana;
	JPanel panel;
	JLabel timeLabel;

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

		timeLabel = new JLabel();
		timeLabel.setBackground(Color.RED);
		timeLabel.setOpaque(true);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(timeLabel, settings);
	}
}
