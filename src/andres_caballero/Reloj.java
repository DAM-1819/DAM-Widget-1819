package andres_caballero;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class Reloj extends JLabel implements Runnable {

	private String hora, minutos, segundos;
	private Calendar calendario = new GregorianCalendar();
	Thread hilo;

	public Reloj(int x, int y, int p, int p1) {
		setBounds(x, y, p, p1);
		setFont(new Font("Serif",14, 48));
		hilo = new Thread(this);
		hilo.start();
	}

	public void actualiza() {
		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();
				setText("" + hora + ":" + minutos + ":" + segundos);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
