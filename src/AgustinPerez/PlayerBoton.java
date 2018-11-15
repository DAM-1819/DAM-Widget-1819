package AgustinPerez;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayerBoton extends JButton implements ActionListener, Runnable {

	Player pl;
	String rutaMp3;
	Thread sonido;

	public PlayerBoton(String rutaMp3, String etiqueta) {
		super();
		this.setLabel(etiqueta);
		addActionListener(this);
		this.rutaMp3 = rutaMp3;
	}

	public PlayerBoton(String rutaMp3, String rutaFondoBoton, Border borde) {
		super();
		addActionListener(this);
		this.rutaMp3 = rutaMp3;
		this.setIcon(new ImageIcon(rutaFondoBoton));
		this.setBorder(borde);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sonido = new Thread(this);
		sonido.start();
	}

	@Override
	public void run() {
		try {

			pl = new Player(new FileInputStream(rutaMp3));
			pl.play();
		} catch (FileNotFoundException e1) {
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
