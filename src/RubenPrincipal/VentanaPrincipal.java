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
	Vidas vidas;

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
		ventana.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		// for (int i = 0; i < imagenLabel.length; i++) {
		vidas = new Vidas();
		ventana.add(vidas,gbc);
		// }

	}

	private void inicarListeners() {

	}

}