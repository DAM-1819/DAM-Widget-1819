package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal {

	JFrame ventana;
	JButton guarda;

	JPanel panel;
	JTextArea textoPrueba;
	BufferedImage img;
	JLabel imagen;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 600, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}

	public void inicializarListeners() {
		guarda.addActionListener(e -> {
			SavePreview panel = new SavePreview(this.panel);
			panel.setVisible(true);
		});

	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());

		guarda = new JButton("Guardar");
		GridBagConstraints sett;
		sett = new GridBagConstraints();
		sett.gridx = 1;
		sett.gridy = 1;
		ventana.add(guarda, sett);

		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createTitledBorder("Prueba"));
		textoPrueba = new JTextArea(10, 10);
		textoPrueba.setLineWrap(true);
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		sett.ipadx = 200;
		sett.ipady = 200;
		panel.add(textoPrueba);
		ventana.add(panel, sett);

	}

}
