package Gonzalez_Duran_Luis;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class VentanaPrincipal {

	JFrame ventana;
	JPanel contenedor;
	JLabel facebok, twitter, instagram, podemos;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(580, 30, 578, 115);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridLayout(1, 4));

		// JPANEL
		contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(1, 4));
		contenedor.setSize(578, 115);
		contenedor.setBackground(Color.ORANGE);

		ventana.add(contenedor);

		// JLABEL FACEBOOK
		facebok = new JLabel("FACEBOOK");
		facebok.setLayout(new GridLayout(1, 4));
		facebok.setBorder(new LineBorder(Color.BLACK, 2));
		GridBagConstraints settings = new GridBagConstraints();
		
		settings.gridx = 0;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;
		//facebok.setVisible(true);
		contenedor.add(facebok, settings);

		// JLABEL TWITTER
		twitter = new JLabel("TWITTER");
		twitter.setLayout(new GridLayout(1, 4));
		
		twitter.setBorder(new LineBorder(Color.BLACK, 2));
		ImageIcon imagen = new ImageIcon("imagenes/Twitter.ico");
		twitter.setIcon(imagen);
		
		settings = new GridBagConstraints();

		settings.gridx = 0;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		twitter.setVisible(true);
		contenedor.add(twitter, settings);

		// JLABEL INSTAGRAM
		instagram = new JLabel("INSTAGRAM");
		instagram.setLayout(new GridLayout(1, 4));
		instagram.setBorder(new LineBorder(Color.BLACK, 2));
		instagram.setIcon(new ImageIcon("imagenes/instagramico.ico"));
		settings = new GridBagConstraints();

		settings.gridx = 0;
		settings.gridy = 2;
		settings.fill = GridBagConstraints.BOTH;
		instagram.setVisible(true);
		contenedor.add(instagram, settings);

		// JLABEL PODEMOS
		podemos = new JLabel("PODEMOS");
		podemos.setLayout(new GridLayout(1, 4));
		podemos.setBorder(new LineBorder(Color.BLACK, 2));
		podemos.setIcon(new ImageIcon("imagenes/podemos.ico"));
		settings = new GridBagConstraints();

		settings.gridx = 0;
		settings.gridy = 3;
		settings.fill = GridBagConstraints.BOTH;
		podemos.setVisible(true);
		contenedor.add(podemos, settings);

	}

	public void inicializarListeners() {

	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		// inicializarListeners();

	}

}
