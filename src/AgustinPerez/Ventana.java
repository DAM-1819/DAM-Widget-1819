package AgustinPerez;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Ventana {

	JFrame ventana;
	PlayerBoton botones[] = new PlayerBoton[8];
	String rutasS[] = { "tambor.mp3", "baseball.mp3", "bomba.mp3", "cucu.mp3", "ja-ja.mp3", "mario.mp3" };
	String rutasI[] = { "bateria.png", "baseball.png", "bomba.png", "cucu.png", "nelson.gif", "mario.gif", };
	Border bordes []= {BorderFactory.createDashedBorder(Color.ORANGE, 4, 2, 2, true),BorderFactory.createTitledBorder("Hon Round!"),BorderFactory.createLoweredSoftBevelBorder(), BorderFactory.createLineBorder(Color.RED, 2),BorderFactory.createBevelBorder(0, Color.GREEN, Color.BLACK),null};
	
	public Ventana() {
		ventana = new JFrame("Caja de Mezclas");
		ventana.setBounds(200, 200, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridLayout(4, 4));
		PlayerBoton botonCorrecto = new PlayerBoton("correcto.mp3", "Correcto");
		botonCorrecto .setBackground(Color.GREEN);
		PlayerBoton botonIncorrecto = new PlayerBoton("incorrecto.mp3", "Incorrecto");
		botonIncorrecto.setBackground(Color.RED);
		ventana.add(botonCorrecto);
		ventana.add(botonIncorrecto);
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new PlayerBoton(rutasS[i], rutasI[i],bordes [i] );
			ventana.add(botones[i]);
		}
	}

	public void inicializador() {

		ventana.setVisible(true);
		inicializarComponentes();

	}

}
