package andres_caballero;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class Reloj extends JLabel implements Runnable {

	private String hora, min, seg;
	private Calendar calendario = new GregorianCalendar();
	Thread hilo;

	public Reloj(int x, int y, int p, int p1) {
		super();
		setBounds(x, y, p, p1);
		hilo = new Thread(this);
		//hilo.start();
	}

	public void actualizar() {
		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		hora = 
	}

	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		while (hiloActual == hilo) {
			actualizar();
		}
		this.setText(hora + ":" + min + ":" + seg);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
