package IvanHisado;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame frame = new JFrame("B-DAY");

	JButton botonInsertar;
	JPanel panelCumpleaņos;

	public VentanaPrincipal() {

		frame.setBounds(100, 100, 250, 250);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		GridBagConstraints gbPanel = new GridBagConstraints();
		panelCumpleaņos = new JPanel();
		gbPanel.gridx = 0;
		gbPanel.gridy = 0;
		gbPanel.weightx = 1;
		gbPanel.weighty = 1;
		gbPanel.fill = GridBagConstraints.BOTH;
		panelCumpleaņos.setBackground(Color.BLUE);
		frame.add(panelCumpleaņos,gbPanel);
	}

	public void inicializar() {

		frame.setVisible(true);
		inicializarComponentes();

	}
}
