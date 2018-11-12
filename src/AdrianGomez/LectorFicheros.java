package AdrianGomez;

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

	JLabel eti;
	JTextField tf;
	JTextArea ta;
	JButton aceptar;

	public LectorFicheros() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBounds(0, 0, 250, 400);
		tf = new JTextField();
		ta = new JTextArea();
		eti = new JLabel("Introduce la ruta del fichero a leer");
		aceptar = new JButton("ACEPTAR");
		this.setVisible(true);
		añadirComponentes();
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
	}
	public String leerFichero(String ruta) {
		String aescribir="";
		try {
			File fich=new File(ruta);
			if(fich.isFile()) {
				FileReader reader=new FileReader(fich);
				BufferedReader br=new BufferedReader(reader);
				
				String linea;
				while((linea=br.readLine())!=null) {
					aescribir=aescribir+linea;
				}
				br.close();
				
			}else {
				JOptionPane.showMessageDialog(this, "La ruta introducida no es a un archivo");
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
