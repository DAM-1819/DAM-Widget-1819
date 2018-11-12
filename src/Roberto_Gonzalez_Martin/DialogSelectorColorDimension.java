package Roberto_Gonzalez_Martin;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogSelectorColorDimension extends JDialog {

	private static final long SerialVersionUID = 1L;
	private JPanel tamanoVentana;
	private JPanel colores;
	private JPanel colorLetra;
	private JPanel colorFondo;
	private JSlider rojoLetra;
	private JSlider verdeLetra;
	private JSlider azulLetra;
	private JSlider rojoFondo;
	private JSlider verdeFondo;
	private JSlider azulFondo;
	private JPanel color;
	private JButton aceptar;
	private Color rgb;

	public DialogSelectorColorDimension() {
		setModal(true);
		setBounds(0, 0, 400, 600);
		anadirElementos();
		anadirListeners();
		this.setVisible(true);
	}

	private void anadirElementos() {
		this.setLayout(new GridLayout(2,1));
		GridBagConstraints settingsObjeto = new GridBagConstraints();
		tamanoVentana = new JPanel();
		colores = new JPanel();
		rojoLetra = new JSlider(0, 255);
		verdeLetra = new JSlider(0, 255);
		azulLetra = new JSlider(0, 255);
		color = new JPanel();
		aceptar = new JButton("Aceptar");

		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 2;
		this.add(rojoLetra, settingsObjeto);

		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 4;
		this.add(verdeLetra, settingsObjeto);

		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 6;
		this.add(azulLetra, settingsObjeto);

		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 7;
		settingsObjeto.ipadx = 100;
		settingsObjeto.ipady = 30;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		this.add(color, settingsObjeto);

		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 8;
		settingsObjeto.ipadx = 10;
		settingsObjeto.ipady = 5;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		this.add(aceptar, settingsObjeto);
	}

	private void anadirListeners() {

		rojoLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				color.setBackground(rgb);
			}
		});

		verdeLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				color.setBackground(rgb);
			}
		});

		azulLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				color.setBackground(rgb);
			}
		});

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public Color getColor() {
		return rgb;
	}
}
