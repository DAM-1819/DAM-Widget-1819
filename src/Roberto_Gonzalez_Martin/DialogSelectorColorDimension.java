package Roberto_Gonzalez_Martin;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogSelectorColorDimension extends JDialog {

	private static final long SerialVersionUID = 1L;
	//private JFrame frame;
	private JPanel dimensionVentana;
	private JPanel seleccionarColor;
	private JPanel seleccionarColorFondo;
	private JPanel seleccionarColorLetra;
	private JPanel botonAceptar;
	private JTextField ancho;
	private JTextField numeroAncho;
	private JTextField alto;
	private JTextField numeroAlto;
	private JTextField fondo;
	private JSlider rojoFondo;
	private JSlider verdeFondo;
	private JSlider azulFondo;
	private JPanel colorFondo;
    private JTextField letra;
	private JSlider rojoLetra;
	private JSlider verdeLetra;
	private JSlider azulLetra;
	private JPanel colorLetra;
	private JButton aceptar;
	private Color rgb;

	public DialogSelectorColorDimension() {
		//this.frame = frame;
		setModal(true);
		setBounds(0, 0, 500, 500);
		anadirElementos();
		anadirListeners();
		this.setVisible(true);
	}

	private void anadirElementos() {
		this.setLayout(new GridLayout(3,1));
		
		dimensionVentana = new JPanel();
		dimensionVentana.setLayout(new GridLayout(2,2));
		ancho = new JTextField("Ancho de la ventana: ");
		ancho.setEditable(false);
		numeroAncho = new JTextField();
		alto = new JTextField("Alto de la ventana: ");
		alto.setEditable(false);
		numeroAlto = new JTextField();
		dimensionVentana.add(ancho);
		dimensionVentana.add(numeroAncho);
		dimensionVentana.add(alto);
		dimensionVentana.add(numeroAlto);
		
		seleccionarColor = new JPanel();
		seleccionarColor.setLayout(new GridLayout(1,2));
		
		GridBagConstraints settingsObjeto = new GridBagConstraints();
		seleccionarColorFondo = new JPanel();
		seleccionarColorFondo.setLayout(new GridBagLayout());
		fondo = new JTextField("Color fondo:");
		fondo.setEditable(false);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 0;
		seleccionarColorFondo.add(fondo,settingsObjeto);
		rojoFondo = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 1;
		seleccionarColorFondo.add(rojoFondo,settingsObjeto);
		verdeFondo = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 2;
		seleccionarColorFondo.add(verdeFondo,settingsObjeto);
		azulFondo = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 3;
		seleccionarColorFondo.add(azulFondo,settingsObjeto);
		colorFondo = new JPanel();
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 4;
		settingsObjeto.ipadx = 100;
		settingsObjeto.ipady = 30;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		seleccionarColorFondo.add(colorFondo, settingsObjeto);
		seleccionarColor.add(seleccionarColorFondo);
		
		settingsObjeto = new GridBagConstraints();
		seleccionarColorLetra = new JPanel();
		seleccionarColorLetra.setLayout(new GridBagLayout());
		letra = new JTextField("Color letra:");
		letra.setEditable(false);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 0;
		seleccionarColorLetra.add(letra,settingsObjeto);
		rojoLetra = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 1;
		seleccionarColorLetra.add(rojoLetra,settingsObjeto);
		verdeLetra = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 2;
		seleccionarColorLetra.add(verdeLetra,settingsObjeto);
		azulLetra = new JSlider(0, 255);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 3;
		seleccionarColorLetra.add(azulLetra,settingsObjeto);
		colorLetra = new JPanel();
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 4;
		settingsObjeto.ipadx = 100;
		settingsObjeto.ipady = 30;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		seleccionarColorLetra.add(colorLetra, settingsObjeto);
		seleccionarColor.add(seleccionarColorLetra);
		
		botonAceptar = new JPanel();
		botonAceptar.setLayout(new GridBagLayout());
		aceptar = new JButton("Aceptar");
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 8;
		settingsObjeto.ipadx = 10;
		settingsObjeto.ipady = 5;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		botonAceptar.add(aceptar, settingsObjeto);
		this.add(dimensionVentana);
		this.add(seleccionarColor);
		this.add(botonAceptar);
	}

	private void anadirListeners() {

		rojoFondo.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoFondo.getValue(), verdeFondo.getValue(), azulFondo.getValue());
				colorFondo.setBackground(rgb);
			}
		});

		verdeFondo.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoFondo.getValue(), verdeFondo.getValue(), azulFondo.getValue());
				colorFondo.setBackground(rgb);
			}
		});

		azulFondo.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoFondo.getValue(), verdeFondo.getValue(), azulFondo.getValue());
				colorFondo.setBackground(rgb);
			}
		});
		
		rojoLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				colorLetra.setBackground(rgb);
			}
		});
		
		verdeLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				colorLetra.setBackground(rgb);
			}
		});
		
		azulLetra.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				rgb = new Color(rojoLetra.getValue(), verdeLetra.getValue(), azulLetra.getValue());
				colorLetra.setBackground(rgb);
			}
		});

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setBounds(100, 100, Integer.parseInt(numeroAncho.getText()), Integer.parseInt(numeroAlto.getText()));
				//frame.setBackground(rgb);
			}
		});
	}
	
	public Color getColor() {
		return rgb;
	}
}
