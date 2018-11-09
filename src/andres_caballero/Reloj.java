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
		setBounds(x, y, p, p1);
		hilo = new Thread(this);
		hilo.start();
	}

	public void actualizar() {
		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			actualizar();
		}
		setText(hora + ":" + min + ":" + seg);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
