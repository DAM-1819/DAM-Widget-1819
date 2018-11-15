package Gonzalez_Duran_Luis;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
		ventana.setResizable(false);

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
		facebok.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://www.facebook.com/"));
						}
					}
				}catch (IOException | URISyntaxException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		twitter.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://twitter.com/?lang=es"));
						}
					}
				}catch (IOException | URISyntaxException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		
		instagram.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://www.instagram.com/?hl=es"));
						}
					}
				}catch (IOException | URISyntaxException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		
		podemos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://podemos.info/"));
						}
					}
				}catch (IOException | URISyntaxException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});

	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();

	}

}
