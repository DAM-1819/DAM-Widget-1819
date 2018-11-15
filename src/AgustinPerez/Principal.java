package AgustinPerez;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana ventana = new Ventana();
					ventana.inicializador();
				} catch (Exception e) {

				}
			}
		});

	}

}
