package alberto_conejero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
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
	final static String PATH = "D:\\Users\\" + System.getProperty("user.name") + "\\Documents\\";

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
	Component[] componentes;
BufferedImage img;
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
			if (componentes[0] instanceof JTextArea) {
				File fichero = new File(PATH + url.getText() + "_widgetDoc.txt");
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(fichero), true);
					pw.write(textoArchivo);
					pw.close();
				} catch (IOException e1) {
					System.out.println("Error de escritura");
				}
				this.dispose();
			} else {
				File fichero = new File(PATH + url.getText() + "_widgetImage.jpg");
				String formato = "jpg";
				ImageIcon icon = (ImageIcon)imagen.getIcon();
				BufferedImage img  = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = img.createGraphics();
				g2d.drawImage(icon.getImage(), 0, 0, icon.getImageObserver());
				g2d.dispose();
				try {
					ImageIO.write(img, formato, fichero);
				} catch (IOException e1) {
					System.out.println("Error de escritura");

				}

			}
			this.dispose();
		});
		
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

		try {
			/**
			 * Inicializo el textArea y lo añado al panel
			 */
			if (componentes[0] instanceof JTextArea) {
				previewTexto = new JTextArea();
				previewTexto.setEditable(false);
				previewTexto.setLineWrap(true);
				textoArchivo = ((JTextArea) componentes[0]).getText();
				previewTexto.setText(textoArchivo);
				scroll = new JScrollPane(previewTexto);
				scroll.setBounds(0, 0, 300, 300);
				panel.add(scroll);
			} else {
				/**
				 * Inicializo el Label de la imagen y lo añado al panel
				 */
				imagen = ((JLabel) componentes[0]);
				sett = new GridBagConstraints();
				sett.ipadx = 0;
				sett.ipady = 0;
				sett.fill = GridBagConstraints.BOTH;
				this.add(panel, sett);
				panel.add(imagen);
			}
		} catch (Exception e) {
			System.out.println("No hay ningun dato para guardar");
		}

	}

}
