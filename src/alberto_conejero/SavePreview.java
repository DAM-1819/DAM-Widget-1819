package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.xml.internal.stream.buffer.MutableXMLStreamBuffer;

public class SavePreview extends JDialog {
	/**
	 * Objetos necesarios para la interfaz de la ventana
	 */
	JPanel panel;
	JButton guardar;
	JTextField url;

	/**
	 * Objetos para visualizar en la preview lo que veamos
	 */
	JTextArea previewTexto;
	JLabel imagen;
	String textoArchivo;
	Component panelMuestra;
	ImageIcon image;

	public SavePreview(Component c) {
		super();
		this.setModal(true);
		this.setBounds(100, 100, 400, 500);
		this.setLayout(new GridBagLayout());
		panelMuestra = c;
		inicializaComp();
		compruebaEntrada();
		// inicializarListener();

	}

//	public void inicializarListener() {
//		guardar.addActionListener(e->{
//			if (url == url) {
//				
//			}
//		});
//	}

	public boolean compruebaEntrada() {
		if (panelMuestra.toString().equalsIgnoreCase("Javax.swing.JtextArea")) {
			textoArchivo = panelMuestra.toString();
			return true;
		}

		return false;
	}

	public void inicializaComp() {
		GridBagConstraints sett;
		/**
		 * Inicializo y lo añado la vetana
		 */
		panel = new JPanel(new GridLayout(1, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Preview"));
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 0;
		sett.ipadx = 300;
		sett.ipady = 300;
		sett.fill = GridBagConstraints.BOTH;
		this.add(panel, sett);
		/**
		 * Inicializo el textField y lo añado la vetana
		 */
		url = new JTextField();
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 1;
		sett.fill = GridBagConstraints.BOTH;
		this.add(url, sett);
		/**
		 * Inicializo el boton y lo añado la vetana
		 */
		guardar = new JButton("GUARDAR");
		sett = new GridBagConstraints();
		sett.gridx = 0;
		sett.gridy = 2;
		sett.fill = GridBagConstraints.BOTH;
		this.add(guardar, sett);

		/**
		 * Inicializo el textArea y lo añado al panel
		 */
		if (compruebaEntrada()) {
			previewTexto = new JTextArea();
			previewTexto.setEditable(false);
			previewTexto.setSize(300, 300);
			previewTexto.setText(textoArchivo);
			panel.add(previewTexto);
		} else {
			/**
			 * Inicializo el Label de la imagen y lo añado al panel
			 */
			imagen = new JLabel();
			panel.add(imagen);
		}

		
	}

}
