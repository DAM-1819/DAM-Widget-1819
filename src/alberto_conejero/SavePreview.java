package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
	JPanel panelMuestra;
	JScrollPane scroll;
	BufferedImage img;
	Component[] componentes;

	/**
	 * Constructor en el que instancio los tamaños y llamo al metodo inicializar
	 * 
	 * @param c : el constructor recibe como parametro un panel en el cual he
	 *          probado un texto
	 */
	public SavePreview(JPanel c) {
		super();
		this.setModal(true);
		this.setBounds(100, 100, 400, 500);
		this.setLayout(new GridBagLayout());

		panelMuestra = c;
		componentes = panelMuestra.getComponents();
		inicializaComp();
		inicializarListener();

	}

	/**
	 * Listener del boton guardar el cual detecta si es uina imagen guarda una
	 * imagen y si es un texto guarda un texto
	 */
	public void inicializarListener() {
		guardar.addActionListener(e -> {
			if (componentes[0].toString().toLowerCase().contains("jtextarea")) {
				File fichero = new File(url + "widgetDoc.txt");
				String formato = "txt";

			} else {
				File fichero = new File(url + "widgetImage.jpg");
				String formato = "jpg";
				Graphics g = panel.getGraphics();

				try {
					ImageIO.write(img, formato, fichero);
				} catch (IOException e1) {
					// TODO Auto-generated catch block

				}

			}
		});
	}

	/**
	 * Metodo para comprobar que lo que entra al preview es un texto o imagen
	 * 
	 * @return devuelve true si es un texto y false si es una imagen
	 */
	public boolean compruebaEntrada() {
		boolean check = false;

		for (int i = 0; i < componentes.length; i++) {
			if (componentes[i].toString().toLowerCase().contains("jtextarea")) {

				// check = true;
			} else {

				check = false;
			}

		}
		return check;

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
			previewTexto.setLineWrap(true);
			previewTexto.setText(textoArchivo);
			scroll = new JScrollPane(previewTexto);
			scroll.setBounds(0, 0, 300, 300);
			panel.add(scroll);
		} else {
			/**
			 * Inicializo el Label de la imagen y lo añado al panel
			 */
			imagen = new JLabel();
			img = new BufferedImage(300,300, BufferedImage.TYPE_INT_RGB);
			ImageIcon icon = new ImageIcon(img);
			sett = new GridBagConstraints();
			sett.ipadx = 0;
			sett.ipady = 0;
			sett.fill = GridBagConstraints.BOTH;
			this.add(panel, sett);
			imagen.setIcon(icon);
			
			panel.add(imagen);
		}

	}

}
