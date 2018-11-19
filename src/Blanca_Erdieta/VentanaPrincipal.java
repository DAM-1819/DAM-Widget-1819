package Blanca_Erdieta;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal {
	JFrame ventana;
	JPanel principal;
	JTextField texto;
	JButton cambiar;
	ImageIcon img;
	JLabel jlabel;
	
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 900, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes(){
		principal = new JPanel();
		texto = new JTextField("Cambiar tamaño del pincel:");
		texto.setEditable(false);
		cambiar = new JButton("Cambiar");
		principal.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,40));
		jlabel = new JLabel();
		principal.setLayout( new GridLayout(1, 1));
	
	    principal.add(jlabel);
		ventana.setLayout( new GridBagLayout());
		GridBagConstraints settingObject = new GridBagConstraints();
		settingObject.gridx=0;
		settingObject.gridy=0;
		settingObject.weightx=1;
		settingObject.weighty=10;
		settingObject.fill=GridBagConstraints.BOTH;
		ventana.add(principal,settingObject);
		settingObject.gridx=0;
		settingObject.gridy=1;
		settingObject.weightx=0;
		settingObject.weighty=0;
		settingObject.fill=GridBagConstraints.CENTER;
		ventana.add(texto,settingObject);
		settingObject.gridx=0;
		settingObject.gridy=2;
		settingObject.weightx=0;
		settingObject.weighty=1;
		settingObject.fill=GridBagConstraints.CENTER;
		ventana.add(cambiar,settingObject);
		
		
	}
	public void inicializarListeners(){
	
		
		cambiar.addActionListener(e->{
				TamañoPincel tamaño = new TamañoPincel();
				tamaño.setVisible(true);
				
				tamaño.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					img = new ImageIcon(tamaño.getImagen().getImage());					
					jlabel.setIcon(img);
				   
				}
			});
				
			}
		);
		
		
		
		
	}
	public void inicializar(){
		inicializarComponentes();
		inicializarListeners();
		ventana.setVisible(true);
	}

}
