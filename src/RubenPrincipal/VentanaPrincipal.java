package RubenPrincipal;

import java.awt.GridLayout;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame ventana;
	JPanel panelCorazon;
	ImageIcon corazon;
	JLabel imagenLabel;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setLayout(new GridLayout(1, 3));
		ventana.setBounds(300, 300, 900, 500);
		ventana.setDefaultCloseOperation(1);

	}

	public void iniciar() {
		ventana.setVisible(true);
		inciarComponenetes();
		inicarListeners();

	}

	private void inciarComponenetes() {
		for (int i = 0; i < 3; i++) {
			corazon = new ImageIcon("src/RubenPrincipal/corazon.jpg");
			imagenLabel = new JLabel(corazon);
					ventana.add(imagenLabel);

		}

		ventana.setVisible(true);
		ventana.setSize(1000, 500);
		ventana.setResizable(false);

		// for (int i = 0; i < 3; i++) {
		// panelCorazon = new JPanel();
		// //panelCorazon.add(corazon);
		// }
		// ImageIcon imagenCorazon = new ImageIcon(
		// getClass().getResource("/DAM-Widget-1819/src/RubenPrincipal/corazon.jpg"));
		// imagenLabel.add(panelCorazon);
		// // ImageIO.read(new File("DAM-Widget-1819/src/RubenPrincipal/corazon.jpg"));
		// //
		// // devuelve imagen
		// // redimensionar la imagen para meter en icono

	}

	private void inicarListeners() {

	}

}
