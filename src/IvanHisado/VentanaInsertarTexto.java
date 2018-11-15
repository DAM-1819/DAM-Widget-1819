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
import javax.swing.border.Border;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class VentanaInsertarTexto extends JDialog implements ActionListener{

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
		setBounds((int) comp.getLocationOnScreen().getX(), (int) comp.getLocationOnScreen().getY(), 350, 250);
		setResizable(false);
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
		// gbFecha.insets = new Insets(-40,0,20,0);
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
		
	//	botonInsertar.addActionListener(this);

	}

	public void aniadirListeners() {
		botonInsertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String fechaNacimiento = textFecha.getText();
				boolean insertar = true;

				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "HAS DE INTRODUCIR UN NOMBRE.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;
				} else if (nombre.length() > 20) {
					JOptionPane.showMessageDialog(null, "NOMBRE NO PUEDE CONTENER MAS DE 20 CARACATERES.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;

				}
				if (fechaNacimiento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "HAS DE INTRODUCIR UNA FECHA.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					insertar = false;
				} else if (!fechaNacimiento.matches("[0-3][0-9]\\/[0-1][0-9]\\/[0-2][0-9][0-9][0-9]")) {
					JOptionPane.showMessageDialog(null, "FECHA MAL FORMADA.", "ERROR", JOptionPane.ERROR_MESSAGE);
					insertar = false;
				}

				if (insertar) {
					ArrayList<Usuario> user = new ArrayList<>();
					user.add(new Usuario(nombre, fechaNacimiento));
					escribirFichero(user);
					try {
						this.finalize();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});
	}

	public void volcarListaFichero(ArrayList<Usuario> user, DataOutputStream dos) throws IOException {
		for (int j = 0; j < user.size(); j++) {
			dos.writeUTF(user.get(j).getNombre());
			dos.writeUTF(user.get(j).getFechaNacimiento());
		}
	}

	public void escribirFichero(ArrayList<Usuario> user) {
		File fichero = new File("fechas.txt");
		DataOutputStream dos = null;
		try {
			if (fichero.exists()) {
				dos = new MyObjectTunning(new FileOutputStream(fichero, true));
			} else {
				dos = new DataOutputStream(new FileOutputStream(fichero));
			}
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
		
	}

}
