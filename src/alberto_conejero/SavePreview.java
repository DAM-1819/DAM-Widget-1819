package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
<<<<<<< HEAD
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
=======
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado

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
<<<<<<< HEAD
	Object muestra;
	JScrollPane scroll;
	String formato;
	BufferedImage img;
	/**
	 * Constructor en el que instancio los tamaños y llamo al metodo inicializar
	 * 
	 * @param c
	 *            : el constructor recibe como parametro un panel en el cual he
	 *            probado un texto
	 * @param string 
	 */
	public SavePreview(Object c, String string) {
=======
	Component panelMuestra;
	ImageIcon image;

	public SavePreview(Component c) {
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
		super();
		this.setModal(true);
		this.setBounds(100, 100, 400, 500);
		this.setLayout(new GridBagLayout());
<<<<<<< HEAD
		String user = System.getProperty("user.name");
		String path = "C:\\Users\\" + user + "\\Documents\\";
		muestra = c;
		formato = string;
		inicializaComp();
		inicializarListener(path, formato);

	}

	/**
	 * Listener del boton guardar el cual detecta si es uina imagen guarda una
	 * imagen y si es un texto guarda un texto
	 * 
	 * @param path
	 * @param formato 
	 */
	public void inicializarListener(String path, String formato) {
		String aux = path;
		guardar.addActionListener(e -> {
			
			File fichero = new File(aux + url.getText() + "_widget"+formato);
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(fichero), true);
				pw.print(textoArchivo);
				pw.close();
			} catch (IOException e1) {
				System.out.println("Error de escritura");
			}

			Graphics g = panel.getGraphics();

			try {
				ImageIO.write(img, formato, fichero);
			} catch (IOException e1) {
				System.out.println("Error de escritura de fichero");
			}
			this.dispose();

		});
=======
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
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
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
		// url = new JC
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
		if (muestra instanceof JTextArea) {
			previewTexto = new JTextArea();
			previewTexto.setEditable(false);
<<<<<<< HEAD
			previewTexto.setLineWrap(true);
			textoArchivo = ((JTextArea) muestra).getText();
=======
			previewTexto.setSize(300, 300);
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
			previewTexto.setText(textoArchivo);
			panel.add(previewTexto);
		} else {
			/**
			 * Inicializo el Label de la imagen y lo añado al panel
			 */
			imagen = new JLabel();
<<<<<<< HEAD
			
			sett = new GridBagConstraints();
			sett.ipadx = 0;
			sett.ipady = 0;
			sett.fill = GridBagConstraints.BOTH;
			this.add(panel, sett);
=======
>>>>>>> parent of 33b0d90... mostrar datos y imagenes en preview y guardado
			panel.add(imagen);
		}

		
	}

}
