package Axier_Gonzalez;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JDialog implements ActionListener {
	JFrame ventana;

	JPanel panelTitulo;
	JLabel titulo;

	JLabel nombreUsuario;
	JTextField intrNombreUsuario;

	JLabel contrase�a;
	JPasswordField intrContrase�a;
	JButton aceptar;
	JButton registrar;

	String nombre;
	String apellidos;
	String correo;

	String usuarioIntroducido;
	String contrase�aIntroducida;

	public Login() {
		super();
		setModal(true);
		this.setSize(350, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(28, 188, 137));
		a�adirComponentes();
		a�adirListeners();
	}

	public void a�adirComponentes() {
		this.setLayout(new GridBagLayout());
		panelTitulo = new JPanel();
		titulo = new JLabel("WhatsLogin");
		titulo.setForeground(Color.WHITE);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.setLayout(new GridLayout());

		panelTitulo.setBackground(new Color(118, 36, 150));
		panelTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelTitulo.add(titulo);

		GridBagConstraints ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 0;
		ajustes.weightx = 2;
		ajustes.ipadx = 274;
		ajustes.insets = new Insets(-502, 0, 0, 0);
		this.add(panelTitulo, ajustes);

		nombreUsuario = new JLabel("Usuario:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 1;
		ajustes.insets = new Insets(-255, -282, 0, 0);
		this.add(nombreUsuario, ajustes);

		intrNombreUsuario = new JTextField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 2;
		ajustes.ipadx = 100;
		intrNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-255, 0, 0, 0);
		this.add(intrNombreUsuario, ajustes);

		contrase�a = new JLabel("Contrase�a:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 3;
		ajustes.insets = new Insets(-211, -258, 0, 0);
		this.add(contrase�a, ajustes);

		intrContrase�a = new JPasswordField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 4;
		ajustes.ipadx = 100;
		intrContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-211, 0, 0, 0);
		this.add(intrContrase�a, ajustes);

		registrar = new JButton("Registrar");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 5;
		ajustes.insets = new Insets(-100, 150, 0, 0);
		this.add(registrar, ajustes);

		aceptar = new JButton("Iniciar sesion");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 6;
		ajustes.insets = new Insets(-100, -150, 0, 0);
		this.add(aceptar, ajustes);

	}

	public void a�adirListeners() {		
		registrar.addActionListener(e -> {
			Registrar registrar = new Registrar();
			registrar.setVisible(true);
			registrar.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {

					nombre = registrar.intrUsuario.getText();
					apellidos = registrar.intrApellidos.getText();
					correo = registrar.intrCorreo.getText();
					usuarioIntroducido = registrar.intrNombreUsuario.getText();
					contrase�aIntroducida = registrar.intrContrase�a.getText();

					if (registrar.intrUsuario.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(ventana, "Debes introducir tu nombre", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}
					if (registrar.intrApellidos.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(ventana, "Debes introducir tus apellidos", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}
					if (registrar.intrCorreo.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(ventana, "Debes introducir tu correo electronico", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}

					if (registrar.intrNombreUsuario.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(ventana, "Debes introducir un nombre de usuario", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}

					if (registrar.intrContrase�a.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(ventana, "Debes introducir una contrase�a", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		});
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					if (intrNombreUsuario.getText().equalsIgnoreCase(usuarioIntroducido)
							&& (intrContrase�a.getText().equalsIgnoreCase(contrase�aIntroducida))) {
						JOptionPane.showMessageDialog(ventana, "Inicio de sesion correcto",
								"Bienvenido " + nombre + " " + apellidos, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(ventana, "Inicio de sesion incorrecto", "Mensaje",
								JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		aceptar.addActionListener(this);
	}
}
