package IvanHisado;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Redondo_Garcia_Jesus.DialogSelectorColor;

public class VentanaPrincipal {

	JFrame frame = new JFrame("B-Day");

	// boton para introducir las fechas de los cumplea�os al widget
	JButton botonInsertar;
	// panel donde se mostraran los datos introducidos
	JPanel panelCumplea�os;
	JTextArea textCumplea�os, textNuevo;
	// label que pondra que hay cumplea�os
	JLabel labelEtiqueta;

	public VentanaPrincipal() {
		frame.setResizable(false);
		frame.setBounds(100, 100, 390, 250);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		// label Etiqueta
		labelEtiqueta = new JLabel("PROXIMOS CUMPLEA�OS");
		GridBagConstraints gbLabel = new GridBagConstraints();
		gbLabel.gridx = 0;
		gbLabel.gridy = 0;
		gbLabel.weightx = 2;
		gbLabel.insets = new Insets(0, 45, 0, 0);
		gbLabel.fill = GridBagConstraints.BOTH;
		frame.add(labelEtiqueta, gbLabel);

		// boton Insertar nuevas fechas
		botonInsertar = new JButton("INTRODUCIR FECHAS");
		GridBagConstraints gbBoton = new GridBagConstraints();
		gbBoton.gridx = 1;
		gbBoton.gridy = 0;
		gbBoton.fill = GridBagConstraints.BOTH;
		frame.add(botonInsertar, gbBoton);

		// panel
		panelCumplea�os = new JPanel();
		GridBagConstraints gbPanel = new GridBagConstraints();
		gbPanel.gridx = 0;
		gbPanel.gridy = 1;
		gbPanel.gridwidth = 2;
		gbPanel.weighty = 1;
		gbPanel.fill = GridBagConstraints.BOTH;
		// panelCumplea�os.setBackground(Color.BLUE);
		// frame.add(panelCumplea�os, gbPanel);

		// textCumplea�os
		textCumplea�os = new JTextArea();
		textCumplea�os.setEditable(false);
		textCumplea�os.setLineWrap(true);
		//textCumplea�os.setFont(new Font("arial", Font.ITALIC, 12));
		GridBagConstraints gbCumple�os = new GridBagConstraints();
		gbCumple�os.gridx = 0;
		gbCumple�os.gridy = 1;
		gbCumple�os.gridwidth = 2;
		gbCumple�os.weighty = 1;
		gbCumple�os.fill = GridBagConstraints.BOTH;
		textCumplea�os.setBackground(Color.LIGHT_GRAY);
		frame.add(textCumplea�os, gbCumple�os);
		leerFichero();
	}

	public void nuevoTextArea() {
		textNuevo = new JTextArea();
		textNuevo.setEditable(false);
		textNuevo.setLineWrap(true);
		textNuevo.setFont(new Font("arial", Font.ITALIC, 12));
		GridBagConstraints gbNuevo = new GridBagConstraints();
		gbNuevo.gridx = 0;
		gbNuevo.gridy = 1;
		gbNuevo.gridwidth = 2;
		gbNuevo.weighty = 1;
		gbNuevo.fill = GridBagConstraints.BOTH;
		textNuevo.setBackground(Color.BLUE);
		frame.add(textNuevo, gbNuevo);
	}

	public void inicializarListeners() {
		botonInsertar.addActionListener(e -> {
			VentanaInsertarTexto dialog = new VentanaInsertarTexto(botonInsertar);
			dialog.setVisible(true);
			//nuevoTextArea();
			leerFichero();
			//frame.repaint();

			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					textCumplea�os.setBackground(Color.BLUE);

				}
			});
		});

	}

	public void mostrarFicheroFechas(BufferedReader br) throws IOException {
		String linea;
		int cont = 0;
		while ((linea = br.readLine()) != null) {
			cont++;

			textCumplea�os.setText(textCumplea�os.getText() + linea);
			// textCumplea�os.setWrapStyleWord(true);
		}
	}

	public void leerFichero() {
		File fichero = new File("fechas.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fichero));
			mostrarFicheroFechas(br);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "FICHERO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			// JOptionPane.showMessageDialog(null, "ERROR DE ENTRADA/SALIDA 55", "ERROR",
			// JOptionPane.ERROR_MESSAGE);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "ERROR DE ENTRADA/SALIDA 44", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
