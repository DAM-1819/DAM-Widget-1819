package Carretero_Miranda_Victor;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Pane;

public class VentanaPrincipal {
	
	JFrame ventanaPrincipal;
	JPanel panelPrincipal = new JPanel();
	MiBoton botonColores = new MiBoton(panelPrincipal, "Cambio Color");

	public VentanaPrincipal() {
		
	}

	public void inicializar() {
		ventanaPrincipal = new JFrame("Colorines");
		ventanaPrincipal.setSize(900, 500);
		ventanaPrincipal.setLocationRelativeTo(null);
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.setResizable(false);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		ventanaPrincipal.setLayout(new GridBagLayout());
		panelPrincipal.setLayout(new GridBagLayout());
		
		JPanel explicacion = new JPanel();
		explicacion.setLayout(new GridBagLayout());
		
		JLabel textoPrincipal = new JLabel("Pulsa el boton para cambiar el color de fondo");
		JLabel textoSecundario = new JLabel("Pulsa clic derecho para seleccionar el color");
		
		
		GridBagConstraints opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 0;
		explicacion.add(textoPrincipal, opcionesPanel);
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 1;
		explicacion.add(textoSecundario, opcionesPanel);
		
		explicacion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 0;
		opcionesPanel.insets = new Insets(0, 0, 440, 0);
		
		panelPrincipal.add(explicacion, opcionesPanel);
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 0;
		opcionesPanel.insets = new Insets(0, 0, 0, 0);
		panelPrincipal.add(botonColores, opcionesPanel);
		
		opcionesPanel = new GridBagConstraints();
		opcionesPanel.gridx = 0;
		opcionesPanel.gridy = 1;
		opcionesPanel.fill = GridBagConstraints.BOTH;
		opcionesPanel.insets = new Insets(0, 0, 0, 0);
		ventanaPrincipal.add(panelPrincipal, opcionesPanel);
		
		
	}
}
