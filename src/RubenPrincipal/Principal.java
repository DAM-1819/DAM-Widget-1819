package RubenPrincipal;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.iniciar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
