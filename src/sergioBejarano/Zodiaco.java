package sergioBejarano;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	ImageIcon icono;

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
		
		subtitulo = new JLabel("Introduce la fecha de nacimiento: 'DD/MM/YYY'");
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
		if(entrada.getText().matches("[0-3][0-9]\\/[0-1][0-9]\\/[0-2][0-9][0-9][0-9]")) {
			String resultado = comprobar();
			int respuesta = JOptionPane.showConfirmDialog(null, resultado+"\n¿Quieres consultar otra fecha?", "SIGNO ZODIACAL",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,icono);
			if(respuesta == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if(respuesta == JOptionPane.YES_OPTION) {
				entrada.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto", "Error de formato", JOptionPane.CLOSED_OPTION);
		}
		
	}
	
	public String comprobar() {
			String[] fecha = entrada.getText().split("/");

			switch (Integer.parseInt(fecha[1])) {
				case 1:
					if(Integer.parseInt(fecha[0])<20) {
						icono = new ImageIcon("img/capricornio.jpg");
						return "Capricornio";
					} else {
						icono = new ImageIcon("img/acuario.jpg");
						return "Acuario";
					}
				case 2:
					if(Integer.parseInt(fecha[0])<19) {
						icono = new ImageIcon("img/acuario.jpg");
						return "Acuario";
					} else {
						icono = new ImageIcon("img/piscis.jpg");
						return "Piscis";
					}
				case 3:
					if(Integer.parseInt(fecha[0])<21) {
						icono = new ImageIcon("img/piscis.jpg");
						return "Piscis";
					} else {
						icono = new ImageIcon("img/aries.jpg");
						return "Aries";
					}
				case 4:
					if(Integer.parseInt(fecha[0])<20) {
						icono = new ImageIcon("img/aries.jpg");
						return "Aries";
					} else {
						icono = new ImageIcon("img/tauros.jpg");
						return "Tauro";
					}
				case 5:
					if(Integer.parseInt(fecha[0])<21) {
						icono = new ImageIcon("img/tauros.jpg");
						return "Tauro";
					} else {
						icono = new ImageIcon("img/geminis.jpg");
						return "Géminis";
					}
				case 6:
					if(Integer.parseInt(fecha[0])<21) {
						icono = new ImageIcon("img/geminis.jpg");
						return "Géminis";
					} else {
						icono = new ImageIcon("img/cancer.jpg");
						return "Cáncer";
					}
				case 7:
					if(Integer.parseInt(fecha[0])<23) {
						icono = new ImageIcon("img/cancer.jpg");
						return "Cáncer";
					} else {
						icono = new ImageIcon("img/leo.jpg");
						return "Leo";
					}
				case 8:
					if(Integer.parseInt(fecha[0])<23) {
						icono = new ImageIcon("img/leo.jpg");
						return "Leo";
					} else {
						icono = new ImageIcon("img/virgo.jpg");
						return "Virgo";
					}
				case 9:
					if(Integer.parseInt(fecha[0])<23) {
						icono = new ImageIcon("img/virgo.jpg");
						return "Virgo";
					} else {
						icono = new ImageIcon("img/libra.jpg");
						return "Libra";
					}
				case 10:
					if(Integer.parseInt(fecha[0])<23) {
						icono = new ImageIcon("img/libra.jpg");
						return "Libra";
					} else {
						icono = new ImageIcon("img/escorpio.jpg");
						return "Escorpio";
					}
				case 11:
					if(Integer.parseInt(fecha[0])<22) {
						icono = new ImageIcon("img/escorpio.jpg");
						return "Escorpio";
					} else {
						icono = new ImageIcon("img/sagitario.jpg");
						return "Sagitario";
					}
				case 12:
					if(Integer.parseInt(fecha[0])<22) {
						icono = new ImageIcon("img/sagitario.jpg");
						return "Sagitario";
					} else {
						icono = new ImageIcon("img/capricornio.jpg");
						return "Capricornio";
					}
					default:
						return "Fecha inválida";
			}
		
	}	
	
}
