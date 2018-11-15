package IvanHisado;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
*
* @author ivan hisado
*/

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
		labelEtiqueta.setBackground(Color.LIGHT_GRAY);
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

		// textCumplea�os
		textCumplea�os = new JTextArea();
		textCumplea�os.setEditable(false);
		textCumplea�os.setLineWrap(true);
		textCumplea�os.setBackground(Color.CYAN);
		GridBagConstraints gbCumple�os = new GridBagConstraints();
		gbCumple�os.gridx = 0;
		gbCumple�os.gridy = 1;
		gbCumple�os.gridwidth = 2;
		gbCumple�os.weighty = 1;
		gbCumple�os.fill = GridBagConstraints.BOTH;
		//textCumplea�os.setBackground(Color.LIGHT_GRAY);
		frame.add(textCumplea�os, gbCumple�os);

		// leemos el fichero desde el inicio parea que no aparezca la pantalla vacia al
		// abrirlo
		leerFichero();
	}

	// inicializa el listeiner del boton Insertar
	public void inicializarListeners() {
		botonInsertar.addActionListener(e -> {
			VentanaInsertarTexto dialog = new VentanaInsertarTexto(botonInsertar);
			dialog.setVisible(true);
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					//cuando se cierra la vetana, pone en blanco el textArea para que no aparezcan duplicados
					textCumplea�os.setText("");
					//y vuelve a leer el fichero
					leerFichero();
				}
			});
		});

	}

	// inserta en el textCumplea�os todo lo que haya en el fichero de texto
	public void mostrarFicheroFechas(BufferedReader br) throws IOException {
		String linea;
		while ((linea = br.readLine()) != null) {
			textCumplea�os.setText(textCumplea�os.getText() + linea);
			// textCumplea�os.setWrapStyleWord(true);
		}
	}

	//metodo que lee lo que hay en el fichero
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

	//inicializa todos los componentes de la ventana principal
	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
