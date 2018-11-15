package Gonzalez_Duran_Luis;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.Icon;
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

		ventana.add(contenedor);

		// JLABEL FACEBOOK
		facebok = new JLabel();
		facebok.setLayout(new GridLayout(1, 4));
		facebok.setBorder(new LineBorder(Color.BLACK, 2));

		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.fill = GridBagConstraints.BOTH;

		Icon logoF = new ImageIcon(Principal.class.getResource("facebook.png"));
		facebok.setIcon(logoF);
		contenedor.add(facebok, settings);

		// JLABEL TWITTER
		twitter = new JLabel();
		twitter.setLayout(new GridLayout(1, 4));
		twitter.setBorder(new LineBorder(Color.BLACK, 2));

		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;

		Icon logoT = new ImageIcon(Principal.class.getResource("twitter.png"));
		twitter.setIcon(logoT);
		contenedor.add(twitter, settings);

		// JLABEL INSTAGRAM
		instagram = new JLabel("INSTAGRAM");
		instagram.setLayout(new GridLayout(1, 4));
		instagram.setBorder(new LineBorder(Color.BLACK, 2));

		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.fill = GridBagConstraints.BOTH;

		Icon logoI = new ImageIcon(Principal.class.getResource("Instagram.png"));
		instagram.setIcon(logoI);
		contenedor.add(instagram, settings);

		// JLABEL PODEMOS
		podemos = new JLabel("PODEMOS");
		podemos.setLayout(new GridLayout(1, 4));
		podemos.setBorder(new LineBorder(Color.BLACK, 2));

		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.fill = GridBagConstraints.BOTH;

		Icon logoP = new ImageIcon(Principal.class.getResource("Podemos.png"));
		podemos.setIcon(logoP);
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
