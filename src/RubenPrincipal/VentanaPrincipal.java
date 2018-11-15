package RubenPrincipal;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame ventana;
	JPanel panelCorazon;

	Button quitarVida;
	JLabel[] imagenLabel;
	static int VIDAS = 3;
	ImageIcon corazonG = new ImageIcon(("src/RubenPrincipal/corazonG.jpg"));
	// Vidas vidas;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.getContentPane().setLayout(new GridBagLayout());
		ventana.setBounds(300, 300, 900, 500);
		ventana.setDefaultCloseOperation(1);
		ventana.getContentPane().setBackground(Color.WHITE);
	}

	public void iniciar() {
		ventana.setVisible(true);
		inciarComponenetes();
		inicarListeners();

	}

	private void inciarComponenetes() {

		ventana.setVisible(true);
		ventana.setSize(1000, 500);
		ventana.setResizable(true);
		int width = 60;
		int height = 60;
		quitarVida = new Button("Quitar vida");
		imagenLabel = new JLabel[3];
		ImageIcon corazon = new ImageIcon(("src/RubenPrincipal/corazon.jpg"));
		for (int i = 0; i < imagenLabel.length; i++) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.gridy = 0;
			gbc.weightx = 1;
			gbc.weighty = 1;
			imagenLabel[i] = new JLabel(corazon);
			ventana.add(imagenLabel[i], gbc);

		}
		// para poner el boton
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = gbc.BOTH;
		gbc.weightx = 3;
		gbc.weighty = 1;
		ventana.add(quitarVida, gbc);

	}

	private void inicarListeners() {

		quitarVida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				restarVida(true);
			}
		});

	}

	private void restarVida(boolean restar) {
		if (restar == true) {
			if (VIDAS == 3) {
				imagenLabel[0].setIcon(corazonG);

				VIDAS--;
				System.out.println(VIDAS);
			} else {
				if (VIDAS == 2) {
					imagenLabel[1].setIcon(corazonG);
					VIDAS--;
					System.out.println(VIDAS);

				} else {
					if (VIDAS == 1) {
						imagenLabel[2].setIcon(corazonG);
						VIDAS--;
						JOptionPane.showMessageDialog(null, "GAME OVER");
						System.exit(0);
					}
				}
			}
		} else {
			System.out.println("No restamos.");
		}

	}

}