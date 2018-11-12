package Axier_Gonzalez;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Redondo_Garcia_Jesus.DialogSelectorColor;

public class Registrar extends JDialog implements ActionListener{
	
	JPanel panelTitulo;
	JLabel titulo;
	JLabel registro;
	
	JLabel nombre;
	JTextField intrUsuario;
	
	JLabel apellidos;
	JTextField intrApellidos;
	
	JLabel correo;
	JTextField intrCorreo;
	
	JLabel nombreUsuario;
	JTextField intrNombreUsuario;
	
	JLabel contrase�a;
	JPasswordField intrContrase�a;
	
	JButton aceptar;

	public Registrar() {
		super();
		setModal(true);
		this.setSize(350, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(28, 188, 137));
		a�adirComponentes();
		anadirListeners();
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
		add(panelTitulo, ajustes);
		
		registro = new JLabel("Registro de usuario:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 1;
		ajustes.insets = new Insets(-450, 0, 0, 0);
		add(registro, ajustes);
				
		nombre = new JLabel("Nombre:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 2;
		ajustes.insets = new Insets(-390, -280, 0, 0);
		add(nombre, ajustes);
		
		intrUsuario = new JTextField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 3;
		ajustes.ipadx = 100;
		intrUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-390, 0, 0, 0);
		add(intrUsuario, ajustes);
		
		apellidos = new JLabel("Apellidos:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 4;
		ajustes.insets = new Insets(-345, -274, 0, 0);
		add(apellidos, ajustes);
		
		intrApellidos = new JTextField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 5;
		ajustes.ipadx = 100;
		intrApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-345, 0, 0, 0);
		add(intrApellidos, ajustes);
		
		correo = new JLabel("Correo electronico:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 6;
		ajustes.insets = new Insets(-300, -220, 0, 0);
		add(correo, ajustes);
		
		intrCorreo = new JTextField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 7;
		ajustes.ipadx = 100;
		intrCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-300, 0, 0, 0);
		add(intrCorreo, ajustes);
		
		nombreUsuario = new JLabel("Usuario:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 8;
		ajustes.insets = new Insets(-255, -282, 0, 0);
		add(nombreUsuario, ajustes);
		
		intrNombreUsuario = new JTextField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 9;
		ajustes.ipadx = 100;
		intrNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-255, 0, 0, 0);
		add(intrNombreUsuario, ajustes);
		
		contrase�a = new JLabel("Contrase�a:");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 10;
		ajustes.insets = new Insets(-211, -258, 0, 0);
		add(contrase�a, ajustes);
		
		intrContrase�a = new JPasswordField();
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 11;
		ajustes.ipadx = 100;
		intrContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		ajustes.insets = new Insets(-211, 0, 0, 0);
		add(intrContrase�a, ajustes);
		
		aceptar = new JButton("Aceptar");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 12;
		ajustes.insets = new Insets(-100, 0, 0, 0);
		add(aceptar, ajustes);
	}

	public void anadirListeners(){
		
		aceptar.addActionListener(this);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
	

	
}
