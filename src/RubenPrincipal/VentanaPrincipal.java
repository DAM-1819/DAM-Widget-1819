package RubenPrincipal;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame ventana;
	JPanel panelCorazon;

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

		panelCorazon= new JPanel();
		ImageIcon imagenCorazon = new ImageIcon(getClass().getResource("corazon.png")); 
		panelCorazon.add(imagenCorazon);
		
	}

	private void inicarListeners() {

	}

}
