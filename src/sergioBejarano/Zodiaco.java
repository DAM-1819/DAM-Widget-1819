package sergioBejarano;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Zodiaco extends JPanel{
	JLabel titulo;
	JLabel subtitulo;
	JTextField entrada;
	JButton aceptar;
	Icon icono;

	public Zodiaco() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.CYAN);
		
		titulo = new JLabel("Encuentra tu signo del zodiaco");
		titulo.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		GridBagConstraints setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 0;
		setting.insets = new Insets(0, 0, 30, 0);
		this.add(titulo,setting);
		
		subtitulo = new JLabel("Introduce la fecha de nacimiento: 'DD/MM/YYYY'");
		subtitulo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 2;
		this.add(subtitulo,setting);
		
		entrada = new JTextField();
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 3;
		setting.fill = GridBagConstraints.BOTH;
		this.add(entrada, setting);
		
		aceptar = new JButton("Aceptar");
		setting = new GridBagConstraints();
		setting.gridx = 0;
		setting.gridy = 4;
		this.add(aceptar, setting);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarMensaje();
				
			}
		});
	}
	
	public void mostrarMensaje() {
		String resultado = comprobar();
		JOptionPane.showMessageDialog(null, resultado, "SIGNO ZODIACAL", JOptionPane.INFORMATION_MESSAGE, icono);

	}
	
	public String comprobar() {
		String[] fecha = entrada.getText().split("/");

		switch (Integer.parseInt(fecha[1])) {
			case 1:
				if(Integer.parseInt(fecha[0])<20) {
					//icono = new ImageIcon(getClass().getResource("img/capricornio.jpg"));
					return "Capricornio";
				} else {
					return "Acuario";
				}
			case 2:
				if(Integer.parseInt(fecha[0])<19) {
					return "Acuario";
				} else {
					return "Piscis";
				}
			case 3:
				if(Integer.parseInt(fecha[0])<21) {
					return "Piscis";
				} else {
					return "Aries";
				}
			case 4:
				if(Integer.parseInt(fecha[0])<20) {
					return "Aries";
				} else {
					return "Tauro";
				}
			case 5:
				if(Integer.parseInt(fecha[0])<21) {
					return "Tauro";
				} else {
					return "Géminis";
				}
			case 6:
				if(Integer.parseInt(fecha[0])<21) {
					return "Géminis";
				} else {
					return "Cáncer";
				}
			case 7:
				if(Integer.parseInt(fecha[0])<23) {
					return "Cáncer";
				} else {
					return "Leo";
				}
			case 8:
				if(Integer.parseInt(fecha[0])<23) {
					return "Leo";
				} else {
					return "Virgo";
				}
			case 9:
				if(Integer.parseInt(fecha[0])<23) {
					return "Virgo";
				} else {
					return "Libra";
				}
			case 10:
				if(Integer.parseInt(fecha[0])<23) {
					return "Libra";
				} else {
					return "Escorpio";
				}
			case 11:
				if(Integer.parseInt(fecha[0])<22) {
					return "Escorpio";
				} else {
					return "Sagitario";
				}
			case 12:
				if(Integer.parseInt(fecha[0])<22) {
					return "Sagitario";
				} else {
					return "Capricornio";
				}
				default:
					return "Fecha inválida";
		}
		
	}	
	
}
