package IvanHisado;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ivan hisado
 */
public class VentanaInsertarTexto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// etiquetas del diallogo
	JLabel labelTitulo, labelNombre, labelFecha;

	// donde meteremos los datos
	JTextArea textNombre, textFecha;
	// boton acepatar
	JButton botonInsertar;

	public VentanaInsertarTexto(JComponent comp) {
		super();
		setModal(true); // para hacerlo modal
		// donde empieza el Dialog y que tamanio tiene
		setBounds((int) comp.getLocationOnScreen().getX(), (int) comp.getLocationOnScreen().getY(), 350, 260);
		setResizable(false);
		this.setBackground(Color.BLACK);
		aniadirElementos();
		aniadirListeners();

	}

	// aniadimos los elemetos de este panel
	public void aniadirElementos() {
		this.setLayout(new GridBagLayout());

		// titulo
		labelTitulo = new JLabel("INTRODUCE EL NOMBRE Y LA FECHA");
		GridBagConstraints gbTitulo = new GridBagConstraints();
		gbTitulo.gridx = 0;
		gbTitulo.gridy = 0;
		gbTitulo.insets = new Insets(10, 0, 20, 0);
		add(labelTitulo, gbTitulo);

		// nombre
		labelNombre = new JLabel("NOMBRE:");
		GridBagConstraints gbNombre = new GridBagConstraints();
		gbNombre.gridx = 0;
		gbNombre.gridy = 1;
		add(labelNombre, gbNombre);

		textNombre = new JTextArea();
		textNombre.setFont(new Font("arial", Font.ITALIC, 20));
		textNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gbNombre = new GridBagConstraints();
		gbNombre.gridx = 0;
		gbNombre.gridy = 2;
		gbNombre.gridwidth = 2;
		gbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbNombre.insets = new Insets(10, 0, 20, 0);
		add(textNombre, gbNombre);

		// fecha
		labelFecha = new JLabel("FECHA (dd/mm/aaaa):");
		GridBagConstraints gbFecha = new GridBagConstraints();
		gbFecha.gridx = 0;
		gbFecha.gridy = 3;
		add(labelFecha, gbFecha);

		textFecha = new JTextArea();
		textFecha.setFont(new Font("arial", Font.ITALIC, 20));
		textFecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gbFecha = new GridBagConstraints();
		gbFecha.gridx = 0;
		gbFecha.gridy = 4;
		gbFecha.gridwidth = 2;
		gbFecha.fill = GridBagConstraints.HORIZONTAL;
		gbFecha.insets = new Insets(10, 0, 20, 0);
		add(textFecha, gbFecha);

		// boton insetar
		botonInsertar = new JButton("INSERTAR PERSONA");
		GridBagConstraints gbBoton = new GridBagConstraints();
		gbBoton.gridx = 0;
		gbBoton.gridy = 5;
		gbBoton.insets = new Insets(10, 0, 20, 0);
		add(botonInsertar, gbBoton);

	}

	// metodo en el que se realiaza el listener del boton
	public void aniadirListeners() {
		botonInsertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String fechaNacimiento = textFecha.getText();
				boolean insertar = true;

				// comprueba que nos meta el nombre y que no sea mas largo de 20 caracteres
				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "HAS DE INTRODUCIR UN NOMBRE.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;
				} else if (nombre.length() > 20) {
					JOptionPane.showMessageDialog(null, "NOMBRE NO PUEDE CONTENER MAS DE 20 CARACATERES.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;

				}
				// compureba que la fecha este introducida en el formato requerido
				if (fechaNacimiento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "HAS DE INTRODUCIR UNA FECHA.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;
				} else if (!fechaNacimiento.matches("[0-3][0-9]\\/[0-1][0-9]\\/[0-2][0-9][0-9][0-9]")) {
					JOptionPane.showMessageDialog(null, "FECHA MAL FORMADA.", "ERROR", JOptionPane.ERROR_MESSAGE);
					insertar = false;
				}

				// solo nos inserta en el fichero si los campos has sido rellenados
				// correctamente
				if (insertar) {
					ArrayList<Usuario> user = new ArrayList<>();
					user.add(new Usuario(nombre, fechaNacimiento));
					escribirFichero(user);
					// hace que se cierre la ventana automaticamente
					dispose();
				}

			}

		});
	}

	// guarda en el fichero lo que haya en los textAreas
	public void volcarListaFichero(ArrayList<Usuario> user, DataOutputStream dos) throws IOException {
		for (int j = 0; j < user.size(); j++) {
			dos.writeUTF(user.get(j).getNombre());
			dos.writeUTF(user.get(j).getFechaNacimiento());
		}
	}

	// crea el fichero
	public void escribirFichero(ArrayList<Usuario> user) {
		File fichero = new File("fechas.txt");
		DataOutputStream dos = null;
		try {
			if (fichero.exists()) {
				dos = new MyObjectTunning(new FileOutputStream(fichero, true));
			} else {
				dos = new DataOutputStream(new FileOutputStream(fichero));
			}
			//vulca los datos del arrayList en el fichero
			volcarListaFichero(user, dos);
			JOptionPane.showMessageDialog(null, "DATOS INTRODUCIDOS.", "FABULOSO", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "ERROR DE ENTRADA/SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "ERROR DE ENTRADA/SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

}
