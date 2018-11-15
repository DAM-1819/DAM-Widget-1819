package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
<<<<<<< HEAD
	JButton guardaTexto;
	JButton guardaImagen;
	JPanel panel;
	JTextArea textoPrueba;
	BufferedImage img;
	JLabel imagen;
=======
	JButton muestraPanel;
	Component prueba;
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
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
<<<<<<< HEAD
		guardaTexto.addActionListener(e -> {
			SavePreview panel = new SavePreview(textoPrueba, ".txt");
			panel.setVisible(true);
		});
		guardaImagen.addActionListener(e->{
			SavePreview panel = new SavePreview(imagen, ".jpg");
=======
		muestraPanel.addActionListener(e -> {
			SavePreview panel = new SavePreview(prueba);
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
			panel.setVisible(true);
		});
	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		
		guardaTexto = new JButton("Guardar texto");
		GridBagConstraints sett;
		sett = new GridBagConstraints();
<<<<<<< HEAD
		sett.gridx = 1;
		sett.gridy = 1;
		ventana.add(guardaTexto,sett);
		
		guardaImagen = new JButton("Guardar Imagen");
		sett = new GridBagConstraints();
		sett.gridx = 1;
		sett.gridy = 2;
		ventana.add(guardaImagen,sett);
		
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createTitledBorder("Prueba"));
		textoPrueba = new JTextArea(10, 10);
		textoPrueba.setLineWrap(true);
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		sett.ipadx = 200;
		sett.ipady= 200;
		panel.add(textoPrueba);
		ventana.add(panel,sett);
		img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		ImageIcon icon = new ImageIcon(img);
		imagen = new JLabel();
		imagen.setIcon(icon);
		panel.add(imagen, sett);
		
			
			
		
=======
		sett.gridx = 10;
		sett.gridy = 10;
		ventana.add(muestraPanel,sett);
		prueba = new JTextArea(10, 10);
		prueba.createImage(300, 300);
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		ventana.add(prueba,sett);
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
	}

}
