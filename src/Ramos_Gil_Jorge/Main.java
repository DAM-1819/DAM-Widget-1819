package Ramos_Gil_Jorge;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow ventanaPrincipal = new MainWindow();
					ventanaPrincipal.inicializar();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}