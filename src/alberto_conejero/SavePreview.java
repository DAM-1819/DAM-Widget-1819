package alberto_conejero;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SavePreview extends JDialog {
	JPanel panel;
	JButton guardar;
	JTextField url;
	public SavePreview() {
		super();
		this.setBounds(100, 100, 400, 500);
		this.setLayout(new GridBagLayout());
		
		inicializaComp();

	}

	public void inicializaComp() {
		GridBagConstraints sett;
		/**
		 * Inicializo y añado el panel
		 */
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Preview"));
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy =0;
		sett.ipadx = 300;
		sett.ipady=300;
		sett.fill = GridBagConstraints.BOTH;
		this.add(panel, sett);
		/**
		 * Inicializo el textField
		 */
		url = new JTextField();
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 1;
		sett.fill = GridBagConstraints.BOTH;
		this.add(url, sett);
		/**
		 * Inicializo el boton y lo añado al panel
		 */
		guardar = new JButton("GUARDAR");
		sett = new GridBagConstraints();
		sett.gridx= 0;
		sett.gridy = 2;
		sett.fill = GridBagConstraints.BOTH;
		this.add(guardar, sett);
	}

}
