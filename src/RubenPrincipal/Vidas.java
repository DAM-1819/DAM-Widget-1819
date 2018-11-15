package RubenPrincipal;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vidas extends JPanel implements ActionListener {
	static int VIDAS = 3;
	JLabel[] imagenLabel = new JLabel[3];
	static VentanaPrincipal ventana;
	static ImageIcon corazon;
	ImageIcon corazonG;

	// Image img = corazon.getImage();
	Button quitarVida;

	public Vidas() {
		super();
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		corazon = new ImageIcon("src/RubenPrincipal/corazon.jpg");

		corazonG = new ImageIcon(("src/RubenPrincipal/corazonG.jpg"));
		for (int j = 0; j < imagenLabel.length; j++) {

			System.out.println("hola");
			gbc = new GridBagConstraints();
			gbc.gridx = j;
			gbc.gridy = 0;
			gbc.weightx = 1;
			gbc.weighty = 1;
			imagenLabel[j] = new JLabel(corazon);

			add(imagenLabel[j], gbc);

		}

		quitarVida = new Button("Quitar vida");

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = gbc.BOTH;
		gbc.weightx = 3;
		gbc.weighty = 1;
		add(quitarVida, gbc);
		quitarVida.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		restarVida(true);
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
