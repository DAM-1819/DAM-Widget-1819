package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal {

	JFrame ventana;
	JButton muestraPanel;
	JPanel panel;
	Component prueba;
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
		muestraPanel.addActionListener(e -> {
			SavePreview panel = new SavePreview(this.panel);
			panel.setVisible(true);
		});
	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		muestraPanel = new JButton("Guardar");
		GridBagConstraints sett;
		sett = new GridBagConstraints();
		sett.gridx = 10;
		sett.gridy = 10;
		ventana.add(muestraPanel,sett);
		panel = new JPanel();
		prueba = new JTextArea(10, 10);
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		panel.add(prueba);
		ventana.add(panel,sett);
		
	}

}
