package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal {

	JFrame ventana;
	JButton muestraPanel;
	JPanel panel;
	/**
	 * Objetos de prueba para el widget
	 */
	JTextArea prueba;
	JScrollPane scroll;
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
		muestraPanel.addActionListener(e -> {
			SavePreview panel = new SavePreview(this.panel);
			panel.setVisible(true);
		});
	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());

		muestraPanel = new JButton("Guardar");
		GridBagConstraints sett;
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 1;
		ventana.add(muestraPanel, sett);

		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("PanelPrueba"));
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, 500, 500);
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		sett.ipadx = 450;
		sett.ipady = 450;
		ventana.add(panel, sett);
/**
 * Archivo de texto;
 */
//		prueba = new JTextArea(29, 38);
//		prueba.setLineWrap(true);
//		prueba.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		//panel.add(prueba);
/**
 * Archivo de imagen;
 */
		img = new BufferedImage(350, 350, BufferedImage.TYPE_INT_RGB);
		ImageIcon icon = new ImageIcon(img);
		imagen = new JLabel();
		imagen.setIcon(icon);
		sett.gridx = 0;
		sett.gridy = 0;
		sett.ipadx = 100;
		sett.ipady = 100;
		ventana.add(panel, sett);
		panel.add(imagen);
		
		
		
		
	}

}
