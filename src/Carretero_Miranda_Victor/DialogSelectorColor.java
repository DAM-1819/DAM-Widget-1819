package Carretero_Miranda_Victor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

public class DialogSelectorColor extends JDialog implements MouseListener{

	private static final long serialVersionUID = 1L;
	
	static Color color;
	
	static JPanel[] panelesColoresR = new JPanel[765];
	static JPanel[] panelesColoresG = new JPanel[765];
	static JPanel[] panelesColoresB = new JPanel[765];
	static JPanel[] panelesColoresRG = new JPanel[765];
	static JPanel[] panelesColoresRA = new JPanel[765];
	static JPanel[] panelesColoresAG = new JPanel[765];
	static JButton botonConfirmar = new JButton("Confirmar");
	
	static JPanel franjaColoresR = new JPanel();
	static JPanel franjaColoresG = new JPanel();
	static JPanel franjaColoresB = new JPanel();
	static JPanel franjaColoresRG = new JPanel();
	static JPanel franjaColoresRA = new JPanel();
	static JPanel franjaColoresAG = new JPanel();

	static JPanel cambioColor = new JPanel();
	static JPanel colorSeleccionado = new JPanel();
	static JButton botonColorAleatorio = new JButton("Generar color aleatorio");

	public void añadirFranjaRojo() {

		franjaColoresR.setLayout(new GridLayout(1, 765));
		
		boolean sumarR = true;
		boolean sumarG = false;
		boolean sumarB = false;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresR.length; i++) {
			int variable = i;
			panelesColoresR[i] = new JPanel();
			panelesColoresR[i].setLayout(new GridLayout(1, 1));
			if (sumarR) {
				r++;
			}
			if (r > 255) {
				r--;
				sumarR = false;
				sumarG = true;
			}
			if (sumarG) {
				g++;
				sumarR = true;
			}
			if (g > 255) {
				g--;
				sumarG = false;
				sumarB = true;
			}
			if (sumarB) {
				b++;
				sumarR = true;
			}
			if (b > 255) {
				b--;
				sumarB = false;
			}

			Color aux = new Color(r, g, b);
			panelesColoresR[i].setBackground(aux);

			panelesColoresR[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresR[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresR[variable].getBackground();
					colorSeleccionado.setBackground(color);
					color = aux;
				}
			});

			franjaColoresR.add(panelesColoresR[i]);
		}
		franjaColoresR.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 1;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresR, opciones);

	}

	public void añadirFranjaVerde() {
		
		franjaColoresG.setLayout(new GridLayout(1, 765));
		boolean sumarR = false;
		boolean sumarG = true;
		boolean sumarB = false;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresG.length; i++) {
			int variable = i;
			panelesColoresG[i] = new JPanel();
			panelesColoresG[i].setLayout(new GridLayout(1, 1));
			if (sumarG) {
				g++;
			}
			if (g > 255) {
				g--;
				sumarG = false;
				sumarB = true;
			}
			if (sumarB) {
				b++;
			}
			if (b > 255) {
				b--;
				sumarB = false;
			}

			Color aux = new Color(r, g, b);
			panelesColoresG[i].setBackground(aux);

			panelesColoresG[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresG[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresG[variable].getBackground();
					colorSeleccionado.setBackground(aux);
					color = aux;
				}
			});

			franjaColoresG.add(panelesColoresG[i]);
		}
		franjaColoresG.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 3;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresG, opciones);

	}

	public void añadirFranjaAzul() {

		panelesColoresB = new JPanel[765];
		
		franjaColoresB.setLayout(new GridLayout(1, 765));
		boolean sumarR = false;
		boolean sumarG = false;
		boolean sumarB = true;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresB.length; i++) {
			int variable = i;
			panelesColoresB[i] = new JPanel();
			panelesColoresB[i].setLayout(new GridLayout(1, 1));
			if (sumarR) {
				r++;
			}
			if (r > 255) {
				r--;
				sumarR = false;
				sumarB = true;
			}
			if (sumarB) {
				b++;
			}
			if (b > 255) {
				b--;
				sumarB = false;
				sumarR = true;
			}

			Color aux = new Color(r, g, b);
			panelesColoresB[i].setBackground(aux);

			panelesColoresB[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresB[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresB[variable].getBackground();
					colorSeleccionado.setBackground(aux);
					color = aux;
				}
			});

			franjaColoresB.add(panelesColoresB[i]);

		}
		franjaColoresB.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 5;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresB, opciones);

	}

	public void añadirFranjaRojo_Verde() {

		
		franjaColoresRG.setLayout(new GridLayout(1, 765));
		boolean sumarR = false;
		boolean sumarG = true;
		boolean sumarB = false;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresRG.length; i++) {
			int variable = i;
			panelesColoresRG[i] = new JPanel();
			panelesColoresRG[i].setLayout(new GridLayout(1, 1));
			if (sumarR) {
				r++;
			}
			if (r > 255) {
				r--;
				sumarR = false;
				sumarG = true;
			}
			if (sumarG) {
				g++;
			}
			if (g > 255) {
				g--;
				sumarG = false;
				sumarR = true;
			}

			Color aux = new Color(r, g, b);
			panelesColoresRG[i].setBackground(aux);

			panelesColoresRG[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresRG[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresRG[variable].getBackground();
					colorSeleccionado.setBackground(aux);
					color = aux;
				}
			});

			franjaColoresRG.add(panelesColoresRG[i]);
		}
		franjaColoresRG.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 2;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresRG, opciones);

	}

	public void añadirFranjaAzul_Verde() {

		franjaColoresAG.setLayout(new GridLayout(1, 765));
		boolean sumarR = false;
		boolean sumarG = false;
		boolean sumarB = true;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresAG.length; i++) {
			int variable = i;
			panelesColoresAG[i] = new JPanel();
			panelesColoresAG[i].setLayout(new GridLayout(1, 1));
			if (sumarG) {
				g++;
			}
			if (g > 255) {
				g--;
				sumarG = false;
				sumarB = true;
			}
			if (sumarB) {
				b++;
			}
			if (b > 255) {
				b--;
				sumarB = false;
				sumarG = true;
			}

			Color aux = new Color(r, g, b);
			panelesColoresAG[i].setBackground(aux);

			panelesColoresAG[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresAG[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresAG[variable].getBackground();
					colorSeleccionado.setBackground(aux);
					color = aux;
				}
			});

			franjaColoresAG.add(panelesColoresAG[i]);
		}
		franjaColoresAG.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 4;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresAG, opciones);
	}

	public void añadirFranjaRojo_Azul() {
		
		franjaColoresRA.setLayout(new GridLayout(1, 765));
		boolean sumarR = true;
		boolean sumarG = false;
		boolean sumarB = false;

		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < panelesColoresRA.length; i++) {
			int variable = i;
			panelesColoresRA[i] = new JPanel();
			panelesColoresRA[i].setLayout(new GridLayout(1, 1));
			if (sumarR) {
				r++;
			}
			if (r > 255) {
				r--;
				sumarR = false;
				sumarB = true;
			}
			if (sumarB) {
				b++;
			}
			if (b > 255) {
				b--;
				sumarB = false;
				sumarG = true;
			}

			Color aux = new Color(r, g, b);
			panelesColoresRA[i].setBackground(aux);

			panelesColoresRA[i].addMouseListener(new MouseListener() {

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
					Color color = panelesColoresRA[variable].getBackground();
					cambioColor.setBackground(color);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Color aux = panelesColoresRA[variable].getBackground();
					colorSeleccionado.setBackground(aux);
					color = aux;
				}
			});

			franjaColoresRA.add(panelesColoresRA[i]);
		}
		franjaColoresRA.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		GridBagConstraints opciones = new GridBagConstraints();
		opciones.ipadx = 765;
		opciones.ipady = 20;
		opciones.gridx = 0;
		opciones.gridy = 6;
		opciones.fill = GridBagConstraints.BOTH;
		this.add(franjaColoresRA, opciones);

	}

	public void cerrar() {
		this.dispose();
	}
	
	public void añadirElementos() {

		this.setLayout(new GridBagLayout());
		this.setBackground(color);
		
		añadirFranjaRojo();
		añadirFranjaRojo_Verde();
		añadirFranjaVerde();
		añadirFranjaAzul_Verde();
		añadirFranjaAzul();
		añadirFranjaRojo_Azul();
		
		GridBagConstraints opcionesPanel = new GridBagConstraints();
		JLabel texto = new JLabel();
		texto.setText("Selecciona un color");
		texto.setFont(new Font("Verdana", Font.BOLD, 20));
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 0;
		opcionesPanel.insets = new Insets(0, 0, 20, 0);
		this.add(texto, opcionesPanel);
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.ipadx = 200;
		opcionesPanel.ipady = 50;
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 7;
		opcionesPanel.insets = new Insets(20, 0, 20, 0);
		cambioColor.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		this.add(cambioColor, opcionesPanel);

		opcionesPanel = new GridBagConstraints();
		opcionesPanel.ipadx = 200;
		opcionesPanel.ipady = 50;
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 7;
		opcionesPanel.insets = new Insets(30, 30, 0, 0);
		colorSeleccionado.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		
		this.add(colorSeleccionado, opcionesPanel);
		
		botonConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 9;
		opcionesPanel.insets = new Insets(20, 0, 0, 0);
		this.add(botonConfirmar, opcionesPanel);
		
		botonColorAleatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rd = new Random();
				int r = rd.nextInt(255);
				int g = rd.nextInt(255);
				int b = rd.nextInt(255);
				cambioColor.setBackground(new Color(r, g, b));
				colorSeleccionado.setBackground(new Color(r, g, b));
				color = new Color(r, g, b);
				
			}
		});
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 8;
		opcionesPanel.insets = new Insets(20, 0, 0, 0);
		this.add(botonColorAleatorio, opcionesPanel);
		
	}

	public void inicializar() {
		this.setTitle("Colores");
		this.setVisible(true);
		cambioColor.setBackground(Color.WHITE);
	}

	public DialogSelectorColor() {
		super();	
		añadirElementos();
		setModal(true);
		setBounds(350, 350, 900, 600);
	}

	public static Color getColor() {
		return color;
	}

	public static void setColor(Color color) {
		DialogSelectorColor.color = color;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
