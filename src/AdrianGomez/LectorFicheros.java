package AdrianGomez;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LectorFicheros extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String user=System.getProperty("user.name");
	String ruta="C:\\Users\\"+user+"\\Desktop\\";
	JLabel eti;
	JTextField tf;
	JTextArea ta;
	JButton aceptar;
/**
 * Inicializa el Lector de ficheros
 * @param c Color de fondo del TextArea
 * @param r ColorFondo TextField
 */
	public LectorFicheros(Color c,Color r) {
		super();
		//Crear LAyout
		this.setLayout(new GridBagLayout());
		this.setBounds(0, 0, 300, 250);
		// Inicializamos elementos
		tf = new JTextField();
		ta = new JTextArea();
		eti = new JLabel("Introduce la ruta del fichero a leer");
		aceptar = new JButton("ACEPTAR");
		// Lo hacemos visible
		this.setVisible(true);
		añadirComponentes();
		ta.setBackground(c);
		ta.setForeground(Color.BLUE);
		tf.setBackground(r);
		tf.setForeground(Color.RED);
		aceptar.setBackground(Color.BLACK);
		aceptar.setForeground(Color.WHITE);
		tf.setText(ruta);
		inicializarListeners();
	}

	public void añadirComponentes() {
		GridBagConstraints opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 0;
		opc.weightx = 1;
		opc.weighty = 1;
		opc.fill = GridBagConstraints.BOTH;
		this.add(eti, opc);
		opc.gridx = 0;
		opc.gridy = 1;
		opc.weightx = 1;
		opc.weighty = 1;
		opc.fill = GridBagConstraints.BOTH;
		this.add(tf, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		opc.weightx = 1;
		opc.weighty = 10;
		opc.fill = GridBagConstraints.BOTH;
		this.add(ta, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.fill = GridBagConstraints.BOTH;
		this.add(aceptar, opc);
		//Le damos formato 
		
		
	}
	/**
	 * Metodo que intenta abrir un archivo en la ruta que recibe como parametro
	 * @param ruta
	 * @return
	 */
	public String leerFichero(String ruta) {
		String aescribir="";
		try {
			File fich=new File(ruta);
			if(fich.isFile()) {
				FileReader reader=new FileReader(fich);
				BufferedReader br=new BufferedReader(reader);
				this.tf.setForeground(Color.GREEN);
				String linea;
				while((linea=br.readLine())!=null) {
					aescribir=aescribir+linea;
				}
				br.close();
				
			}else {
				this.tf.setForeground(Color.RED);
				JOptionPane.showMessageDialog(this, "La ruta introducida no es a un archivo","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}catch (IOException e) {
			System.out.println("ERROR DE ENTRADA SALIDA");
		}
		return aescribir;
	}
	public void inicializarListeners() {
		aceptar.addActionListener((e) ->{
			ta.setText(leerFichero(tf.getText()));
			ta.setLineWrap(true);
			
		});
	}
}
